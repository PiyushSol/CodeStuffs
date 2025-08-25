public class TrappingRainwater {
    public static void main(String[] args) {
        int []a ={0,1,0,2,1,0,1,3,2,1,2,1};
        int []b ={4,2,0,3,2,5};
        System.out.println(trap(a));
        System.out.println(trap(b));
    }
    public static int trap(int[] height) {
        int n = height.length;
        int lmax=0 , rmax =0, total =0;
        int leftP = 0 , rightP=n-1;
        while(leftP<rightP){
            if(height[leftP]<=height[rightP]){
                if(lmax > height[leftP]){
                    total+= lmax -height[leftP];
                }else {
                    lmax =height[leftP];
                }
                leftP++;
            }
            else{
                if(rmax > height[rightP]){
                    total+= rmax -height[rightP];
                }else {
                    rmax =height[rightP];
                }
                rightP--;
            }
        }
        return total;
    }

    public static int trapArray(int[] height) {
        int n = height.length;

        //To calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }
        //calculate right max boundary
        int rightMax[]= new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        //loop
        for(int i=0;i<n;i++){
            //waterlevel = min(leftmax , right max)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);

            //trapppedwater = waterlevel - height
            trappedWater += waterlevel -height[i];
        }

        return trappedWater;
    }
}
