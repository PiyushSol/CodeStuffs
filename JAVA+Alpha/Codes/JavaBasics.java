import java.util.*;
public class JavaBasics{

public static void main(String args[]){
    //  System.out.println("Hello World");
    //  System.out.println("Hello Piyush");

    // System.out.println("****");
    // System.out.println("***");
    // System.out.println("**");
    // System.out.println("*");

    // int a =10;
    // int b=5;
    // System.out.println("a is "+ a);
    // System.out.println("b is "+ b);

    // byte b = 8;
    // System.out.println(b);
    // char ch = 'a';
    // System.out.println(ch);
    // boolean var =true;
    // System.out.println(var); 

    // int a=10 ;
    // int b=5;
    // int sum =a+b;
    // System.out.println(sum);
    Scanner sc = new Scanner(System.in);
    // String input = sc.next();
    //  System.out.println("Hello "+ input);
    // int a = sc.nextInt();
    // int b = sc.nextInt();
    // int sum =a+b;
    // int proud = a*b;
    // System.out.println("The Product is : "+ proud);
    // char ch ='z';
    // int num = ch;
    // System.out.println(num);
    int a = sc.nextInt();
    int b = sc.nextInt();
    char operation = sc.next().charAt(0);
    switch (operation) {
        case '+':System.out.println(a+b);
            break;
        case '-':System.out.println(a-b);
            break;
        case '*': System.out.println(a*b);
            break;
        case '/': System.out.println(a/b);
        break;
        case '%': System.out.println(a%b);
        default:
            System.out.println("Error Enter a correct operator."); 
    }

}

}