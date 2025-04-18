package Codes.src;

import java.util.ArrayList;

public class DSAMaths {
    public static void main(String[] args) {
//    int n=40;
//    boolean[] primes = new boolean[n+1];
//    sieve(n,primes);
//        int n=40 , p=3;
//        System.out.printf("%.3f",sqrt(n,p));
//        factors2(20);
//        System.out.println(gcd(8,4));
        System.out.println(lcm(2,7));
    }

    //lcm of two numbers
    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }

    //gcd of two numbers
    public  static int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }

    //factors of a number efficient force
    public static void factors2(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                if(n/i ==i){
                    System.out.print(i+" ");
                }
                else{
                    System.out.print(i+" ");
                    list.add(n/i);
                }
            }
            }
        for(int i= list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
    }


    //factors of a number brute force
    public static void factors1(int n){
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                System.out.print(i+" ");
            }
        }
    }

    //finding square root of number
    public static double sqrt(int n,int p){
        int s=0 , e=n;
        double root =0.0,inc=0.1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(m*m == n){
                root =m;
                return root;
            }
            if(m*m>n){
                e=m-1;
            }
            else{s=m+1;}
        }
        for(int i=0;i<p;i++){
            while(root*root<=n){
                root+=inc;
            }
            root-=inc;
            inc/=10;
        }
        return root;
    }


    //Sieve of Eratosthenes
    //Basically it is used to check the different prime numbers
   //false means number is prime
    public static void sieve(int n , boolean primes[]){
        for(int i=2;i*i<=n;i++){
            if(!primes[i]){
                for(int j=2*i;j<=n;j+=i){
                    primes[j]=true;
                }
            }
        }

        for(int i=2;i<=n;i++){
            if(!primes[i]){
                System.out.print(i+" ");
            }
        }
    }
}
