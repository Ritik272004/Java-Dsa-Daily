
public class RecursionQuestions {
    // public static int factorial_of_n(int n){
    //     if(n == 1) return 1;
    //     return n*factorial_of_n(n-1);
    // }
    // public static int sum_of_n_numbers(int n){
    //     if(n<=1) return n; 
    //     return n + sum_of_n_numbers(n-1);
    // }
    // public static int fibonaccio_of_n(int n){
    //     if( n== 0 || n == 1){
    //         return n;
    //     }
    //     return fibonaccio_of_n(n-1) + fibonaccio_of_n(n-2);
    // }
    // public static int power(int x , int n){ //O(logn)
    //     if(n == 0){
    //         return 1;
    //     }
    //     int halfPower = power(x , n/2);
    //     int halfPowerSq = halfPower * halfPower;
    //     if((n%2) != 0){
    //         return x * halfPowerSq;
    //     }
    //     else{
    //         return  halfPowerSq;     
    //     }
    // }

    // public static int tiling_problem(int n){
    //     // No. of ways to tile a floor  , here n is the width of floor
    //     if(n == 0 || n == 1) return 1;
    //     int fnm1 = tiling_problem(n-1); // vertical choice
    //     int fnm2 = tiling_problem(n-2); // horizontal choice
    //     int totalWays = fnm1+fnm2;
    //     return totalWays;
    // }

    // public static String removeDuplicates(String str){
    //     HashMap<Character, Integer> count = new HashMap<>();
    //     for(int i =0;i<str.length();i++){
    //         if(count.containsKey(str.charAt(i))){
    //             continue;
    //         }
    //         count.put(str.charAt(i) , i);
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     for(Character ch : count.keySet()){
    //         sb.append(ch);
    //     }
    //     return sb.toString();
    // }
    // public static void remove_duplicates_from_string(String str , int idx , StringBuilder newStr , boolean map[]){
    //     // Base case
    //     if(idx == str.length()){ // O(n) , where n is length of String
    //         System.out.println(newStr);
    //         return;
    //     }
    //     char currChar = str.charAt(idx);
    //     if(map[currChar - 'a'] == true){
    //         remove_duplicates_from_string(str, idx+1, newStr, map);
    //     }else{
    //         map[currChar-'a'] = true;
    //         remove_duplicates_from_string(str, idx+1, newStr.append(currChar), map);
    //     }
    // }

    // // public static int friendsPairing(int n){
    // //     if(n == 1 || n == 2){
    // //         return n;
    // //     }
    // //     return friendsPairing(n-1) + (n-1) * friendsPairing(n-2); // beacuse if friend want to remain single then we have to find no. of ways for (n-1) friends and if one friend paired up then he have n-1 choices after one choice we have to arrange no. of ways for n-2 friends
    // // }

    // public static void printBinaryString(int n , String currStr){
    //     if(currStr.length() == n ){
    //         System.out.println(currStr);
    //         return;
    //     }
    //     printBinaryString(n, currStr + "0");
    //     if(currStr.isEmpty() || currStr.charAt(currStr.length()-1) != '1' ){
    //         printBinaryString(n, currStr + "1");
    //     }
    // }
    // // Tower Of Hanoi
    // public static void Tower_Of_Hanoi(int n , String src , String helper , String des){
    //     // base case
    //     if(n==1){  // O(2^n)
    //         System.out.println(" Move Disk "+ n + " from " + src + " to " + des );
    //         return;
    //     }
    //     // Move (n-1) discs from src to helper using dest as temporary rod
    //     Tower_Of_Hanoi(n-1, src, des, helper);
    //     // Move nth disc from source to destibatipn
    //     System.out.println(" Move disc " + n + " from " + src + " to " + des );
    //     // Move (n-1) discs from helper to des using src as temporary rod
    //     Tower_Of_Hanoi(n-1, helper, src, des);
    // }
    // Prime number 
    public static boolean isPrime(int n){
        if(n<=1){// ! is neither prime nor composit number
            return false;
        }
        for(int i =2;i<=Math.sqrt(n);i++){
            if( n % i == 0){
                return false;
            }
        }
        return true;
    }
    // Binary to Decimal
    public static int binary_to_decimal(int binary){
        int decimal = 0;
        int n = 0;
        while(binary > 0){
            decimal += binary%10 * Math.pow(2,n);
            binary /= 10;
            n++;
        }
        return decimal;
    }
    // Decimal to Binary
    public static void decimal_to_binary(int decimal){
        int binary = 0;
        int binaryNumber[] = new int[20];
        int i =0;
        while(decimal > 0){
            int r = decimal % 2;
            binaryNumber[i++] = r;
            decimal /= 2;
        }
        for(int j = i-1 ;j>=0 ;j--){
            System.out.print(binaryNumber[j]);
        }
    }
    // leap year
    public static void leap_year_or_not(int year){
        if(year % 400 == 0){
            System.out.println(year + " is Leap year");
        }
        else if(year % 4 == 0 && year % 100 != 0){
            System.out.println(year + "is Leap year");
        }else{
            System.out.println(year + " is not Leap year");
        }
    }
    // find gcd or H.C.F or Greatest Common Divisor
    public static int gcd(int a , int b){
        // base case
        if(b == 0){
            return a;
        }
        return gcd(b , a%b);
    }

    // public static int count_substring_start_and_end_with_same_character(String str , int i , int j , int n ){
    //     // base case
    //     if( n == 1){
    //         return 1;
    //     }
    //     if(n<=0){
    //         return 0;
    //     }
    //     int res = count_substring_start_and_end_with_same_character(str, i+1, j, n-1) 
    //     + count_substring_start_and_end_with_same_character(str, i, j-1, n-1)
    //     - count_substring_start_and_end_with_same_character(str, i+1, j-1, n-2);

    //     if(str.charAt(i) == str.charAt(j)){ // compare first and last character , if they are same or not.
    //         res++;
    //     }
    //     return res;
    // }

    // Merge Sort
    // public static void merge_sort(int arr[] , int start , int end){
    //     // base case
    //     if(start >= end){
    //         return;
    //     }
    //     int mid = start + (end-start)/2;
    //     merge_sort(arr , start , mid);
    //     merge_sort(arr , mid+1 , end);
    //     merge(arr, start , mid , end);
    // }
    // public static void merge(int arr[] , int st , int mid , int end){
    //     int i = st;
    //     int j = mid +1;
    //     int k = 0;
    //     int temp[] = new int [end-st+1];
    //     while(i<= mid && j<= end){
    //         if(arr[i] < arr[j]){
    //             temp[k++] = arr[i++];
    //         }else{
    //             temp[k++] = arr[j++];
    //         }
    //     }
    //     while(i<=mid){
    //         temp[k++] = arr[i++];
    //     }
    //     while(j<=end){
    //         temp[k++] = arr[j++];
    //     }

    //     for(k = 0, i = st ; k<temp.length ; k++ , i++){
    //         arr[i] = temp[k];
    //     }

    // }

    // Quick Sort
    // public static void quick_sort(int arr[] , int st , int end){
    //     if(st >= end){
    //         return;
    //     }
    //     int pIdx = partitioning(arr, st , end);
    //     quick_sort(arr, st, pIdx-1);
    //     quick_sort(arr, pIdx+1, end);
    // }
    // public static int partitioning(int arr[] , int st , int end){
    //     int pivot = arr[end];
    //     int i = st-1;
    //     for(int j = st;j<end;j++){
    //         if(arr[j] <= pivot){
    //             i++;
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //         }
    //     }
    //     i++;
    //     int temp = pivot;
    //     arr[end] = arr[i];
    //     arr[i] = temp;

    //     return i;
    // }
    
    // public static void print_Array(int arr[]){
    //     for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println();
    // }

    // public static int search_in_rotated_sorted_array(int arr[] , int si , int ei , int target){
    //     while(si <= ei){
    //         int mid = si + (ei-si)/2;
    //         if(arr[mid] == target){
    //             return mid;
    //         }
    //         // check which half is sorted
    //         // for left half sorted
    //         if(arr[si] <= arr[mid]){
    //             if(arr[si] <= target && target < arr[mid]){
    //                 ei = mid -1;
    //             }else{
    //                 si = mid + 1;
    //             }
    //         }
    //         // for right half sorted
    //         else{
    //             if(target <= arr[ei] && arr[mid] < target){
    //                 si = mid+1;
    //             }else{
    //                 ei = mid-1;
    //             }
    //         }
    //     }
    //     return -1;
    // }
    // Majority Element => O(nlogn) , element that appears more than n/2 times
        // public static int majority_element(int arr[] , int si , int ei){
        //     // base case
        //     if(si == ei){
        //         return arr[si];
        //     }
        //     int mid = si + (ei-si) / 2;
        //     int leftMajority = majority_element(arr, si, mid);
        //     int rightMajority = majority_element(arr, mid+1, ei);
        //     if(leftMajority == rightMajority){
        //         return leftMajority;
        //     }
        //     int leftCount = count_majority(arr , si , ei , leftMajority);
        //     int rightCount = count_majority(arr , si , ei , rightMajority);
        //     return leftCount > rightCount ? leftCount : rightCount;
        // }
        // private static int count_majority(int arr[] , int si , int ei , int num){
        //     int count = 0;
        //     for(int j = si ;j<=ei;j++){
        //         if(arr[j] == num){
        //             count++;
        //         }
        //     }
        //     return count;
        // }

        // Inversion count => O(nlogn)
        // Inversion means if in pair (i,j) , i<j then arr[i] > arr[j] or how the array is being from sorted
        // If array is dorted in descending order then inversion count is maximum
        public static int inversion_count(int arr[] , int si , int ei){
            int count = 0;
            if(si < ei){
                int mid = si + (ei-si) /2;
                count += inversion_count(arr, si, mid);
                count += inversion_count(arr, mid+1, ei);
                count += merge_inversion_count(arr , si , mid , ei);
            }
            return count;
        }
        public static int merge_inversion_count(int arr[] , int si , int mid , int ei){
            int i = si;
            int j = mid+1;
            int k = 0;
            int count = 0;
            int temp [] = new int[ei-si+1];
            while(i<=mid && j<=ei){
                if(arr[i] < arr[j]){
                    temp[k++] = arr[i++];
                }else{
                    temp[k++] = arr[j++];
                    count += mid - i + 1;
                }
            }
            while(i <= mid){
                temp[k++] = arr[i++];            
            }
            while(j <= ei){
                temp[k++] = arr[j++];
            }
            return count;
        }

    public static void main(String[] args) {
        // System.out.println(factorial_of_n(5));
        // System.out.println(sum_of_n_numbers(100));
        // System.out.println(fibonaccio_of_n(5));
        // System.out.println(power(3,5));
        // System.out.println(tiling_problem(4));
        // String str = "aaabbbcc";
        // String res = removeDuplicates(str);
        // System.out.println(res); 
        // remove_duplicates_from_string(str, 0, new StringBuilder(), new boolean[26]);
        // System.out.println(friendsPairing(3));
        // printBinaryString(3, "");
        // Tower_Of_Hanoi(3,"A","B","C");
        // System.out.println(isPrime(2));
        // System.out.println(binary_to_decimal(1001));
        // decimal_to_binary(8);
        // leap_year_or_not(2024);
        //  System.out.println(gcd(98,56));
        // int HCF = gcd(12,24);
        // // find LCM or Least Common Multiple
        // System.out.println((12*24 )/HCF);
        // String str = "abacdea";
        // System.out.println(count_substring_start_and_end_with_same_character(str, 0, str.length()-1, str.length()));
        // int arr[] = {5,81,24,7,3,9};
        // // merge_sort(arr, 0, arr.length-1);
        // // print_Array(arr);
        // quick_sort(arr, 0, arr.length-1);
        // print_Array(arr);

        // int nums[] = {4,5,6,7,0,1,2};
        // System.out.println(search_in_rotated_sorted_array(nums, 0, nums.length, 2));
        // int arr[] = {2,2,1,1,2,2,1};
        // System.out.println(majority_element(arr, 0, arr.length-1));
        int arr[] = {5,4,3,2,1};
        System.out.println(inversion_count(arr, 0, arr.length-1));    
        
    }
}
