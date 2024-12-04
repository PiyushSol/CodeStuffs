package com.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrays {
    public static void main(String[] args) {
//        int [] res1 = buildArray(new int[]{0, 2, 1, 5, 3, 4});
//        int [] res2 = buildArray(new int[]{5,0,1,2,3,4});
//        System.out.println(java.util.Arrays.toString(res1));
//        System.out.println(java.util.Arrays.toString(res2));
//        List<List<String>> mylist = new ArrayList<>();
//        mylist.add(List.of("phone","blue","pixel"));
//        mylist.add(List.of("computer","silver","lenevo"));
//        mylist.add(List.of("phone","gold","iphone"));

//        mylist.add(List.of(1,2,3));
//        mylist.add(List.of(4,5,6));
//        for(int i=0;i< mylist.size();i++){
//            for(int j=0;j<mylist.get(i).size();j++){
//                System.out.print(mylist.get(i).get(j)+" ");
//            }
//            System.out.println();
//        }

//        System.out.println(countMatches(mylist,"type","phone"));
//        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
//        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
//        System.out.println(largestAltitude(new int[]{52,-91,72}));

        /*int [][] image = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int[][] res = flipAndInvertImage(image);
        print(res);*/

//        int[][] mat = new int[][]{{2,4,-1},{-10,5,11},{18,-7,6}};
//        int sum =diagonalSum(mat);
//        print(transpose(mat));
//        System.out.println();
        List<Integer> mylist = new ArrayList<>();
        mylist = addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9},1);
        System.out.println(mylist);

    }

    //Array-Form of Integer
    public static List<Integer> addToArrayForm(int [] num ,int k){

//        int lastDigit =0 , currDigit=0;
//        for(int i=0;i<num.length;i++){
//            currDigit = num[i];
//            lastDigit = lastDigit*10+currDigit;
//        }
//        int number = lastDigit+k;
//        List<Integer> myList = new ArrayList<>();
//        while(number>0){
//            int lastD= number%10;
//            myList.add(lastD);
//            number/=10;
//        }
//        Collections.reverse(myList);
//        return myList;

        List<Integer> result = new ArrayList<>();
        int carry = k;  // Initialize carry with k value

        // Process from the last digit of the array
        for (int i = num.length - 1; i >= 0; i--) {
            carry += num[i];          // Add current digit and carry
            result.add(carry % 10);   // Add the last digit of carry to result
            carry /= 10;              // Update carry for next digit
        }

        // Handle remaining carry if k has more digits
        while (carry > 0) {
            result.add(carry % 10);
            carry /= 10;
        }

        // Reverse to get the correct order
        Collections.reverse(result);
        return result;
    }

    //Reverse a number
    public static int reverseNum(int num){
        int rev=0;
        while(num>0){
            int lastD= num%10;
            rev = rev*10+lastD;
            num/=10;
        }
        return rev;
    }

    //Transpose of 2D matrix
    public static int[][] transpose(int [][] matrix){
        int res[][]= new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
              res[i][j]=matrix[j][i];
            }
        }
        return res;
    }
    public static int[] buildArray(int[] nums){
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=nums[nums[i]];
        }
        return ans;
    }

    public static int countMatches(List<List<String>> items , String ruleKey , String ruleValue){
        int count =0 ;
        for(List list : items){
           for(int i=0;i< list.size();i++){
               if (ruleKey == "type"){
                   if(list.get(i) == ruleValue){
                       count+=1;
                   }
               }
               else if(ruleKey =="color"){
                   if(list.get(i) == ruleValue){
                       count+=1;
                   }
               }
               else{
                   if(list.get(i)==ruleValue){
                       count+=1;
                   }
               }
           }
        }
        return count;
    }

    //Display an Array
    public static void print(int [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


    //Net gain in altitude
    public static int largestAltitude(int[] gain){
        int highestAltitude =0;
        for(int i=1;i< gain.length;i++){
            gain[i]= gain[i]+gain[i-1];
            highestAltitude = Math.max(gain[i],highestAltitude);
        }
        return Math.max(gain[0],highestAltitude);
    }

    //Flipping an image
    public static int[][] flipAndInvertImage(int[][] image){
        int n = image.length;
        int[][] res = new int[n][n];

        //Flipping the array first
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                res[row][col] = image[row][n-1-col];
            }
        }

        //Inverting the array
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(res[row][col]==0){
                    res[row][col]=1;
                }
                else{
                    res[row][col]=0;
                }
            }
        }
        return  res;
    }

    //Cell with odd values
    public static int oddCells(int m , int n, int[][] indices){
        int res[][] = new int[n][m];
        int count =0;



        return count;
    }

    //Diagonal Sum
    public static int diagonalSum(int[][] mat){
//        int sum=0;
//        for(int i=0;i<mat.length;i++){
//            for(int j=0;j<mat[i].length;j++){
//                if(i==j ||(i+j)== (mat.length-1)) {
//                    sum += mat[i][j];
//                }
//            }
//        }
//
//        return  sum;

        //Efficient solution
        int sum=0;
        int n= mat[0].length;
        for(int i=0;i<n;i++){
            sum+=mat[i][i];
            if(i!= (n-i-1)){
                sum+=mat[i][n-i-1];
            }
        }
        return  sum;
    }

}
