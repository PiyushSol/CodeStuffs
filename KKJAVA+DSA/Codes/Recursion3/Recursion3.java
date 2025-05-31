package Codes.Recursion3;

import java.util.Arrays;

public class Recursion3 {
    public static void main(String[] args) {
//        print(4,0);
        int a[] = {4,3,2,1,6,0,5};
//        bubbleSort(a,a.length-1,0);
        selectionSort(a, a.length ,0,0);
        System.out.println(Arrays.toString(a));
    }

    //Recursive Selection Sort
    public static void selectionSort(int a[],int r,int c , int max){
        if(r==0){
            return;
        }
        if(c<r){
            if(a[c]>a[max]){
                selectionSort(a,r,c+1,c);
            }else{
                selectionSort(a,r,c+1,max);
            }
        }
        else{
            int temp = a[max];
            a[max]=a[r-1];
            a[r-1]=temp;
            selectionSort(a,r-1,0,0);
        }
    }

    //Recursive Bubble Sort
    public static void bubbleSort(int a[],int r, int c){
          if(r==0){
              return;
          }
          if(c<r){
              if(a[c]>a[c+1]){
                  int temp = a[c];
                  a[c]=a[c+1];
                  a[c+1]=temp;
              }
              bubbleSort(a,r,c+1);
          }else{
              bubbleSort(a,r-1,0);
          }
    }

    //Pattern Question
    /*
    ****
    ***
    **
    *
     */
    public static void print(int row , int col){
        if(row ==0){
            return;
        }
        if(col<row){
            System.out.print("* ");
            print(row,col+1);
        }
        else{
            System.out.println();
            print(row-1,0);
        }
    }
}
