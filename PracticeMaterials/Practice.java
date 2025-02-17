
import java.util.Arrays;

public  class Practice{
    public static void main(String[] args) {
      char []ch = new char[]{'1','2','3'};
      Arrays.sort(ch);
      for(int i=0;i<ch.length;i++){
        String s="";
        s+=ch[i];
        for(int j=0;j<ch.length;j++){
            if(i!=j){
            s+=ch[j];
            
        }
        System.out.print(s);
System.out.print(" ");
    }
      }

    }

    
}