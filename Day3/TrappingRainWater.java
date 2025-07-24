
public class TrappingRainWater {
    public static int trappingWater(int height[]){
        // 1-Method: find leftMax boundary , rightMax boundary -> O(n) ,O(n)
        // int n = height.length;
        // int leftMax[] = new int[n];
        // leftMax[0] = height[0];
        // for(int i =1;i<leftMax.length;i++){ // O(n)
        //     leftMax[i] = Math.max(leftMax[i-1] , height[i]);
        // }
        // int rightMax [] = new int[n];
        // rightMax[n-1] = height[n-1];
        // for(int i =n-2;i>=0;i--){ // O(n)
        //     rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        // }

        // int trapping_water = 0;
        // for(int i =0;i<n;i++){
        //     int waterLevel = Math.min(leftMax[i] , rightMax[i]);
        //     trapping_water += waterLevel-height[i];
        // }
        // return trapping_water;
        
        // 2. Two-Pointer Approach => O(n) ,O(1)
        int n = height.length;
        int left = 0 , right = n-1;
        int leftMax = height[0] , rightMax = height[n-1];
        int water = 0;

        while(left < right){
            if(leftMax < rightMax){
                left++;
                if(leftMax < height[left]){
                    leftMax = height[left];
                }else{
                    water += leftMax - height[left];
                }
            }
            else{
                right--;
                if(rightMax < height[right]){
                    rightMax = height[right];
                }
                else{
                    water += rightMax - height[right];
                }
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,3,2,5};
        int trapped_water = trappingWater(height);
        System.out.println(trapped_water);

    }
}
