public class LongestSubstringWithAtMostTwoDistinctCharacters {


    // most clear writting :
    public int lengthOfLongestSubstringTwoDistinct(String s) {


        if (s == null) return 0;

        char a = '+', b = '-';
        int posA = 0, posB = 0;
        int max = 0, tmp = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == a || chars[i] == b) {
                tmp++;
                //if (chars[i] == b) continue;
                if (chars[i] == a) {
                    posA = posB;
                    a = b;
                    b = chars[i];
                    posB = i;
                }
            }
            else {
                posA = posB;
                a = b;
                b = chars[i];
                posB = i;
                tmp = i - posA + 1;
            }
            //System.out.println("a: " + a + " posA: " + posA +  " | b: " + b + " posB : " + posB + " | max:" + max + " | tmp: " + tmp);
            max = Math.max(max, tmp);
        }
        return max;
    }
}
