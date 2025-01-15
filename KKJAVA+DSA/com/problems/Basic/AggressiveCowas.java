package com.problems.Basic;

import java.util.Arrays;

public class AggressiveCowas {
    public static void main(String[] args) {

    }

    public static boolean canWePlace(int[] stalls , int dist, int cows){
        int cntCow=1;
        int last=stalls[0];
        for(int i=0;i< stalls.length;i++){
            if(stalls[i]-last >=dist){
                cntCow++;
                last=stalls[i];
            }
            if(cntCow>=cows){
                return true;
            }
        }
        return false;
    }

    public static int aggressiveCows(int []stalls , int k){
        Arrays.sort(stalls);
        int n= stalls.length;
        int low=1; int high=stalls[n-1]-stalls[0];
        while (low<=high){
            int mid= low+(high-low)/2;
            if(canWePlace(stalls,mid,k)==true){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
}
