public class MultiplyStringsRepresentingLargeNumbers {
    /*How to Multiply Strings Representing Large Numbers.

Multiplying two numbers is a straightforward operation, but what if the numbers are represented as strings? And what if their lengths are large enough to cause overflow when using conventional methods?

In this article, we’ll explore an efficient approach to solve the problem of multiplying strings representing non-negative integers without relying on built-in conversion functions. */

    public static String find_string_product(String num1  , String num2 ){ // O(n1*n2) , O(n1+n2)
        int n1 = num1.length();
        int n2 = num2.length();
        int result[] = new int[n1+n2];

        for(int i = n1-1 ; i>=0;i--){
            for(int j = n2-1 ;j>=0;j--){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int product = a*b;
                int posLow = i + j + 1; // where unit place of product will store
                int posHigh = i + j ; // where carry will store

                product += result[posLow]; // add existing value to posLow
                result[posLow] = product % 10; // keep the unit place
                result[posHigh] = product / 10 ; // add carry to higher place
            }
        }
       
        StringBuilder sb = new StringBuilder();

        for(int num : result){
            if(!(sb.length() == 0 && num == 0)){
                sb.append(num);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String num1 = "15";
        String num2 = "16";
        System.out.println("Product of two number is : " + find_string_product(num1,num2));
    }
}
