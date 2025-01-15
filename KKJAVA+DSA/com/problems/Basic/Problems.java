package com.problems.Basic;

import java.util.Scanner;

public class Problems {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        isEvenOdd();
//        greet("Piyush");
    }

    public static void getSI(int P ,int R,int T){
        double SI=0;
        SI=(P*R*T)/100;
        System.out.println("The SI: "+SI);
    }

    public static void greet(String name){
        System.out.println("Hello "+name+" welcome !");
    }
    public static void isEvenOdd(){
        System.out.println("Enter the number is to check : ");
        int num = sc.nextInt();
        if(num%2==0){
            System.out.println("The Number is Even.");
        }
        else{
            System.out.println("The Number is Odd.");
        }
    }

}
