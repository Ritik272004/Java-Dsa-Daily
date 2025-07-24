public class ContainerWithMostWater {
    public static int container_with_most_water(int height[]){
        int l = 0 , r = height.length-1 , maxWater = 0;

        while(l<r){
            int length = Math.min(height[l] , height[r]);
            int breadth = r-l;
            int water = length * breadth;
            maxWater = Math.max(maxWater , water);
            if(height[l] <= height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int height[] = {1,7,2,5,4,7,3,6};
        int res = container_with_most_water(height);
        System.out.println(res);

    }
}
