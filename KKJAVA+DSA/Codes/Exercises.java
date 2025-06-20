package Codes;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
//        System.out.println(isSorted(new int[]{10,20,30,40,50,0},6));
//        String s="[()]{}{[()()]()}"
//        String s ="[(])";
//        System.out.println(isMatching(s));
    }

    //Checking matching paranthesis using recursion
    static boolean isMatching(String s){
          char expr[] = s.toCharArray();
          return check(expr,expr.length);
    }

    static  boolean check(char [] expr , int n){
        if(n==0)return true;
        if(n==1)return false;
        if (expr[0] == ')' || expr[0] == '}' || expr[0] == ']') return false;

        char closing = getClosing(expr[0]);
        int i, count = 0;
        for (i = 1; i < n; i++) {
            if (expr[i] == expr[0])
                count++;
            if (expr[i] == closing) {
                if (count == 0)
                    break;
                count--;
            }
        }

        if (i == n)
            return false;

        if (i == 1)
            return check(Arrays.copyOfRange(expr, i + 1, n), n - 2);
        return check(Arrays.copyOfRange(expr, 1, i), i-1) && check(Arrays.copyOfRange(expr,(i+1),n),n-i-1);

    }


    static char getClosing(char ch){
        if(ch == '(')return ')';
        if(ch =='{')return '}';
        if(ch =='[')return ']';
        return Character.MIN_VALUE;
    }

    //Check if array is sorted or not
    static boolean isSorted(int arr[], int n){
        if(n==0 || n==1){
            return true;
        }
        return (arr[n-1]>arr[n-2]) && isSorted(arr,n-1);
    }

    //IsPowerof3
    static boolean isPowerOfThree(int n) {
        if(n==0)return false;
        if(n==1)return true;
        return (n%3==0) && isPowerOfThree(n/3);
    }

    //IsPowerof2
    static boolean isPowerOf2(int n){
        if(n<=0)return false;
        if(n==1)return true;
        return (n%2==0) && isPowerOf2(n/2);
    }


    //Sum of first N natural numbers
    static  int sumN(int n){
        if(n==1){
            return 1;
        }
        return n+sumN(n-1);
    }

    //Recursive Product
    static int product(int x ,int y){
        if(x<y){
            return product(y,x);
        }
        if(y!=0){
            return (x + product(x,y-1));
        }
        else return 0;
    }

    //Recursive digit sum
    static int recSum (int n ){
        if(n<1){
            return 0;
        }
       return (n%10 + recSum(n/10));
    }

    //Recursive Insertion Sort
    static void recInsertionSort(int a[], int idx , int n){
        if(n==idx){
            return;
        }
        int j=idx;
        while(j>0 && a[j-1]>a[j]){
            int temp  =a[j-1];
            a[j-1]=a[j];
            a[j]=temp;
            j--;
        }
        recInsertionSort(a,idx+1,n);
    }

    //Recursive Bubble Sort
    static void recBubbleSort(int a[], int n){
        boolean isSwap = false;
        if(n==1){
            return;
        }
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1]){
                int temp = a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
                isSwap=true;
            }
        }
        if(!isSwap){
            return;
        }
        recBubbleSort(a,n-1);
    }

    //return String length
    static int length(String s){
        if(s.isEmpty()){
            return 0;
        }
        return length(s.substring(1))+1;
    }

    //Reverse String
    static void reverseString(char[] s , int l , int h) {
        if(l>h){
            return;
        }
        char temp = s[l];
        s[l] = s[h];
        s[h]=temp;
        reverseString(s,l+1,h-1);
        return;
    }


    //Give a string return the first uppercase in the string
    static char firstUpper(String s , int i){
            if( i>s.length()-1||s.charAt(i)=='\0'){
                return '\0';
            }
            if(Character.isUpperCase(s.charAt(i))){
                return s.charAt((i));
            }
            return firstUpper(s,i+1);
    }


    /*
    Input: arr = {1, 4, 3, -5, -4, 8, 6};
Output: min = -5, max = 8
     */

static int Max(int a[] , int n){
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    if(n==1){
       return a[0];
    }
    return Math.max(a[n-1], Max(a,n-1));
//    min = Math.min(min ,minMax(a,n-1));
}








    /*
    Input : A = {1, 2, 3, 4, 5}
Output : [48]
         [20, 28]
         [8, 12, 16]
         [3, 5, 7, 9]
         [1, 2, 3, 4, 5]
     */

    static void TriangleArray(int a[]){
        if(a.length <1){
            return;
        }
        int temp[]= new int[a.length-1];
        for(int i=0;i< temp.length;i++) {
            temp[i] = a[i] + a[i + 1];
        }
        TriangleArray(temp);
        System.out.println(Arrays.toString(a));
        return;
    }
}
