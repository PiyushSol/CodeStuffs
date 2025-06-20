import java.util.*;
public class StackTest{
    public static void main(String[] args){
     int arr[]= {2,1,5,6,2,3};
     maxArea(arr);
    }

    //Max Area of Historgram
    public static void maxArea(int arr[]){
      int maxArea = 0;
      int nsr[] =  new int[arr.length];
      int nsl[] = new int[arr.length];

      //we finding next smaller right
      Stack<Integer> s = new Stack<>();
      for(int i=arr.length-1;i>=0;i--){
        while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
          s.pop();
        }
        if(s.isEmpty()){
          nsr[i]=arr.length;
        }else{
nsr[i]=s.peek();
        }
        s.push(i);
      }

      //we finding next smaller left
       s = new Stack<>();
      for(int i=0;i<arr.length;i++){
        while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
          s.pop();
        }
        if(s.isEmpty()){
          nsl[i]=-1;
        }else{
nsl[i]=s.peek();
        }
        s.push(i);
      }

      //calculate area
      for(int i=0;i<arr.length;i++){
        int height  =arr[i];
        int width = nsr[i]-nsl[i]-1;
        int currArea = width*height;
        maxArea=Math.max(maxArea, currArea);
      }
      System.out.println(maxArea);
    }
 

    //Duplicate Paranthesis
   public static boolean dupPara(String str){
    Stack<Character> s = new Stack<>();
    for(int i=0;i<str.length();i++){
      char ch = str.charAt(i);
      if(ch==')'){
        int count=0;
        while( s.peek() !='(' ){
            s.pop();  
            count++;
        }
        if(count<1){
          return true;
        }else{
          s.pop();
        }
      }
      else{
        s.push(ch);
      }
    }
    return false;
   }    

    //Valid Parantheis
    public static boolean validPara(String str){
      Stack<Character> s = new Stack<>();
      for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(ch=='('||ch=='{'||ch=='['){
          s.push(ch);
        }else{
          if(s.isEmpty()){
            return false;
          }
          if((s.peek()=='(' && ch==')')||(s.peek()=='{' && ch=='}')||(s.peek()=='[' && ch==']')){
            s.pop();
          }else{
            return false;
          }
        }
      }
      if(s.isEmpty()){
        return true;
      }
      else{
        return false;
      }
    }

    //NextGreater Element
    public static void nextGreat(){
      int arr[] = {6,8,0,1,3};
      Stack<Integer> s = new Stack<>();
      int nextGreater[] = new int[arr.length];
      for(int i=arr.length-1;i>=0;i--){
        while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
          nextGreater[i]=-1;
        }else{
          nextGreater[i]=arr[s.peek()];
        }
        s.push(i);
      }
      
//      System.out.println(Arrays.toString(nextGreater));
    }
  

    //Reverse the stack
    public static void reverseStack(java.util.Stack<Integer> s){
      if(s.isEmpty()){
        return;
      }
      int top = s.pop();
      reverseStack(s);
      pushBottom(s, top);
      return;
    }

    //Reverse String using Stack
    public static String reverseString(java.util.Stack<Character> s , String str){
        StringBuilder s1 = new StringBuilder();
        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }
        while(!s.isEmpty()){
            s1.append(s.pop());
        }
        return s1.toString();
    }


    //Stack push in the bottom
    public static void pushBottom(java.util.Stack<Integer> s , int el){
        if(s.isEmpty()){
            s.push(el);
            return;
        }
        int p = s.pop();
        pushBottom(s, el);
        s.push(p);
        return;
    }

}