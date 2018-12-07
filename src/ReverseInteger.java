public class ReverseInteger {

    private static int reverse(int x) {

        int sign = x < 0? -1:1;
        x *= sign; // make x > 0;

        int ans = 0;
        while (x > 0){
            int digit = x % 10;
            if (ans < (Integer.MAX_VALUE - digit)/10.0) {
                ans = ans * 10 + digit;
            } else {
                return 0;
            }
            x  /= 10;
        }
        return ans * sign;
    }

    public static void  main(String[] args){
        int x =  Integer.MAX_VALUE;
        System.out.println(reverse(x));
    }
}
