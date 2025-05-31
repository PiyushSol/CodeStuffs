package Codes.Recursion4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion4 {
    public static void main(String[] args) {
//        System.out.println(skipString("baccdah"));
//       ArrayList<String> list =  subseqRet("","abc");
//       System.out.println(list);
//        subseqASCII("","abc");
//        int arr[] = {1,2,2};
//        List<List<Integer>> ans = subsetDup(arr);
//        for (List<Integer> list : ans){
//            System.out.println(list);
//        }
        System.out.println(permutationsList("","abc"));
    }

    //Permutations

    public static ArrayList<String>  permutationsList(String p ,String up){
        if (up.isEmpty()){
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
            return list;
        }
        char ch =up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String a = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutationsList(a+ch+s,up.substring(1)));
        }
        return  ans;
    }
    public static void permutations(String p ,String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch =up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String a = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutations(a+ch+s,up.substring(1));
        }
    }


    //Using arrays creating subsets
    public static List<List<Integer>> subsetDup(int arr[]){
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(arr);
        outer.add(new ArrayList<>());
        int start =0;
        int end =0;
        for(int i=0;i<arr.length;i++){
            start=0;
            if (i>0 &&arr[i]==arr[i-1]){
                start = end+1;
            }
            end = outer.size()-1;
            int n = outer.size();
            for(int j=start;j<n;j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
    public static List<List<Integer>> subset(int arr[]){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : arr){
            int n = outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }


    //Creating Subsets in given list.
    public static void subseqASCII(String p ,String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch =up.charAt(0);
        subseqASCII(p+ch,up.substring(1));
        subseqASCII(p,up.substring(1));
        subseqASCII(p+(ch+0),up.substring(1));
    }
    public static ArrayList<String> subseqRet(String p , String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch =up.charAt(0);
        ArrayList<String>le =subseqRet(p+ch,up.substring(1));
        ArrayList<String>right=subseqRet(p,up.substring(1));
        le.addAll(right);
        return le;
    }
    public static void subseq(String p ,String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch =up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }

     //Removing a character in a string and getting resultant string
     public static String skipString(String up){
         if (up.isEmpty()){
             return "";
         }
         char ch = up.charAt(0);
         if (ch == 'a'){
            return skipString(up.substring(1));
         }else {
             return ch+skipString(up.substring(1));
         }
     }

    public static void skipString(String p , String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a'){
            skipString(p,up.substring(1));
        }else {
            skipString(p+ch,up.substring(1));
        }
    }
}
