/***
 * LC 709
 */
public class ToLowerCase {

    public String toLowercase(String str){
        char[] chars = str.toCharArray();
        int cast = 'a' - 'A';
        for (int i = 0; i < chars.length; i++){
            if ('A' <= chars[i] && chars[i] <= 'Z'){
                chars[i] = (char) (chars[i] + cast);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args){
        String str = "AFEWFfjwoe123";

        ToLowerCase test = new ToLowerCase();
        String ans = test.toLowercase(str);
        System.out.println(ans);


    }
}
