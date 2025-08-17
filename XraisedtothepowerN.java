public class XraisedtothepowerN {
    public static double cal_pow(double x , long n){
        // 1. using recursion , O(logn) ,O(logn)

        // base case
        // if( n== 0){
        //     return 1;
        // }

        // double halfPower = cal_pow(x, n/2);
        // double halfPowerSq = halfPower * halfPower;

        // if(n % 2 != 0){
        //     return x * halfPowerSq;
        // }else{
        //     return halfPowerSq;
        // }

        // 2. without recursion O(logn) ,O(1)

        if(n<0){
            x = 1/x;
            n = -n;
        }

        double result = 1;
        double current_product = x;

        while(n>0){
            if(n % 2 == 1){ // odd power case
                result = result * current_product;
            }
            current_product = current_product * current_product;
            n = n/2;
        }
        return result;
    }
    public static void main(String[] args) {
        double x = 2;
        long n = 10;

        System.out.println(x +" to the power " + n +" is : " +cal_pow(x,n));

    }
}
