public class LetterCombinationOfPhoneNumbers {
    final static char[][] L = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y'}};// final keyword with variables , methods , classes states that they cann't be modified after their initial definition.

    public static void letter_combination(String D){
        int len = D.length();
        if(len == 0){
            System.out.println(" ");
            return ;
        }
        bfs(0,len,new StringBuilder() , D);
    }
    public static void bfs(int pos , int len , StringBuilder sb , String D){
        // base case
        if(pos == len){
            System.out.println(sb.toString());
            return;
        }
        char[] Letters = L[Character.getNumericValue(D.charAt(pos))];

        for(int i = 0;i<Letters.length;i++){
            // append letter to StringBuilder
            sb.append(Letters[i]);
            // Move to next Digit to make combination
            bfs(pos+1 , len , sb , D);
            // backTrack to make another combination
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        String D = "34";
        letter_combination(D);
    }
}
