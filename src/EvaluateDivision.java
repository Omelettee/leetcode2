/**
 * LC 399 Union Find Graphy
 *
 *  Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 *
 */


import java.util.*;
public class EvaluateDivision {
    /**
     * First method is implemnted with DFS, for this question could be treated as a connected graph
     * Inspired by @ huahua's vedio from youtube
     * @param equations
     * @param values
     * @param queries :  if the input vertices is not in the graph or two vertices are not connected,  return -1.0
     * @return
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // create a graph
        Map<String, Map<String, Double>> edges  = new HashMap<>();
        Set<String> vertices = new HashSet<>();
        for (int i = 0; i < equations.length; i++){
            String from = equations[i][0];
            String to = equations[i][1];
            vertices.add(from);
            vertices.add(to);
            if (!edges.containsKey(from)) {
                Map<String, Double> edge = new HashMap<>();
                edges.put(from, edge);
            }
            if (!edges.containsKey(to)){
                Map<String, Double> edge = new HashMap<>();
                edges.put(to, edge);
            }
            edges.get(from).put(to, values[i]);
            edges.get(to).put(from, 1/values[i]);
        }

        // compute the answers of queries
        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i++){
            String from = queries[i][0];
            String to = queries[i][1];
            if (!vertices.contains(from) || !vertices.contains(to)) {
                ans[i] = -1.0;
            } else { // DO NOT FORGET TO WRITE "ELSE" CLAUSE AGAIN!!
                Set<String> visited = new HashSet<>();
                double tmp = dfs(edges, visited, from, to);
                ans[i] = tmp;
            }
        }
        return ans;
    }

    // This is the helper function for the first method : dfs
    public double dfs(Map<String, Map<String, Double>> edges,Set<String> visited, String start, String end){

        if (start.equals(end)) return 1.0;
        if (visited.contains(start)) return -1.0;
        Map<String,Double> neighbors = edges.get(start);
        visited.add(start); // only use this code here, not in the for loop.
        for (Map.Entry<String, Double> entry : neighbors.entrySet()){
            String newStart = entry.getKey();
            if (visited.contains(newStart)) continue; // this code could save a lot of computation
            //System.out.println("start:" + start + " | newStart:" + newStart);
            double d = dfs(edges, visited, newStart, end);
            if (d > 0) return d * entry.getValue();
        }
        return -1.0;
    }



    //The second method is find union
    class Node {
        public String parent;
        public double value;
        public Node (String parent, double value){ // s = value * parent
            this.parent = parent;
            this.value = value;
        }
    }

    public double[] calcEquation2(String[][] equations, double[] values, String[][] queries) {

        Map<String, Node> union = new HashMap<>();
        for (int i = 0; i < equations.length; i++){
            String from = equations[i][0];
            String to = equations[i][1];
            double k = values[i];
            unionFind(union, from, to, k);
        }

        /**
         for (Map.Entry<String, Node> entry : union.entrySet()){
         System.out.println (entry.getKey() +" "+  entry.getValue().parent + " "+ entry.getValue().value);
         }
         **/
        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i++){
            String from = queries[i][0];
            String to = queries[i][1];

            Node pFrom = union.containsKey(from)? find(union, from) : null;
            Node pTo = union.containsKey(to)? find(union, to) : null;

            if (pFrom == null || pTo == null || !pFrom.parent.equals(pTo.parent)){
                ans[i] = -1.0;
            } else {
                ans[i] = pFrom.value / pTo.value;
            }
        }
        return ans;
    }


    public void unionFind(Map<String, Node> union, String from, String to, double k){
        boolean hasFrom = union.containsKey(from);
        boolean hasTo = union.containsKey(to);
        if (!hasFrom && !hasTo){
            union.put(from, new Node(to, k));
            union.put(to, new Node(to, 1.0));
        } else if (!hasFrom){
            union.put(from, new Node(to, k));
        } else if (!hasTo){
            union.put(to, new Node(from, 1/k));
        } else {
            Node pFromNode = find(union, from);
            Node pToNode = find(union, to);
            pFromNode.parent = pToNode.parent;
            pFromNode.value = pToNode.value * k / pFromNode.value;
        }
    }

    public Node find (Map<String, Node> union, String s){
        //System.out.println(s);
        if (!union.containsKey(s)){
            union.put(s, new Node(s, 1.0));
        } else {
            Node node = union.get(s);
            //System.out.println("before loop:" + node.parent);

            if (node.parent.equals(s)){ // only return when s reach the root
                //System.out.println(s +  "equal");

                return node;
            } else {
                //System.out.println(s+  "not equal");
                Node root = find(union, node.parent); // path compression starting from here
                //System.out.println(root.parent);

                node.parent = root.parent;
                node.value *= root.value;
            }
        }
        return union.get(s);
    }

}
