/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
 */

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h=8;
        System.out.println(minEatingSpeed(piles,h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMax(piles);
        while(low<=high){
            int mid = low+(high-low)/2;
            if(getHours(piles,mid)<=h){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    //Maximum in array
    public static int getMax(int []a){
        int mx = Integer.MIN_VALUE;
        for(int el : a){
            if(el>mx){
                mx=el;
            }
        }
        return mx;
    }

    //Computes total hours to eat piles of bananas
    public static int getHours(int[] piles, int hour){
        int totalHours =0;
        for(int i=0;i<piles.length;i++){
            totalHours+= (int) Math.ceil((double) piles[i]/hour);
        }
        return totalHours;
    }

}

