









public class Strings{

    public static void printLetters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i));
        }
        System.out.println("");
    }

    //check Pallindrome
   public static boolean isPalindrome(String str){
     for(int i=0;i<(str.length()/2);i++){
        if(str.charAt(i) != str.charAt(str.length()-1-i)){
            return false;
        }
     }
     return true;
   } 

   //Shortest Path between destination and source
   public static float  getShortestPath(String path){
    int x=0 , y=0;
    for(int i=0;i<path.length();i++){
        char dir = path.charAt(i);
        //South
        if(dir == 'S'){
            y--;
        }
        //North
        else if(dir == 'N'){
            y++;
        }
        //East
        else if(dir == 'E'){
            x++;
        }
        //West
        else{
            x--;
        }
    }
    int X2 = x*x;
    int Y2 = y*y;
    return ((float)Math.sqrt(X2+Y2));
   }

   //function to return a substring of a given string
   public static String subString(String str , int si, int ei){
    String substr="";
    for(int i=si; i<ei;i++){
        substr+=str.charAt(i);
    }
    return substr;
   }

   //function to capitalise each word's first letter
   public static String toUpperCase(String str){
    StringBuilder sb = new StringBuilder("");
    char ch = Character.toUpperCase(str.charAt(0));
    sb.append(ch);
    for(int i=1;i<str.length();i++){
        if(str.charAt(i)==' ' && i<str.length()-1){
            sb.append(str.charAt(i));
            i++;
            sb.append(Character.toUpperCase(str.charAt(i)));
        }else{
            sb.append(str.charAt(i));
        }
    }
return sb.toString();
   }


   //String compression
   //I/p = "aaabbcccdd" O/p="a3b2c3d2"
   public static String compressString(String str){
    String newStr="";
    for(int i=0;i<str.length();i++){
        Integer count =1;
        while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
            count++;
            i++;
        }
        newStr +=str.charAt(i);
        if(count>1){
            newStr+=count.toString();
        }
    }
    return newStr;
   }

    public static void main(String args[]){
        // char arr[]={'a','b','c','d'};
        // String str= "abcd";
        // String str2 = new String("xyz");

        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // System.out.println(name);      
        // String fullName = "Tony Stark";
        // System.out.println(fullName.length());

        // String fname="Piyush";
        // String lname="Solanki";
        // String full = fname +" "+lname;
        // printLetters(full);

        // String str = "noon";
        // System.out.println(isPalindrome(str));

        // String path ="NS";
        // System.out.println(getShortestPath(path));

        // String str = "HelloWorld";
        // System.out.println(subString(str, 0, 5));

        // String fruits []={"apple","mango","banana"};
        // String largest = fruits[0];
        // for(int i=1;i<fruits.length;i++){
        //    if (largest.compareToIgnoreCase(fruits[i])<0){
        //         largest = fruits[i];
        //    }
        // }
        // System.out.println(largest);

        // StringBuilder sb = new StringBuilder("");
        // for(char ch='a';ch<='z';ch++){
        //     sb.append(ch);
        // }
        //     System.out.println(sb);

        // String str="hi , i am piyush";
        // System.out.println(toUpperCase(str));

        String str ="abcd";
        System.out.println(compressString(str));
    }
}