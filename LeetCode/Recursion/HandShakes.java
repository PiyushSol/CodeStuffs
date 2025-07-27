public class HandShakes {
    public static void main(String[] args) {
        System.out.println(count(6/2));
    }

    public static int count(int n){
        if(n==0)return 1;
        int total =0;
        for(int i=0;i<n;i++){
            total += count(i)*count(n-1-i);
        }
        return total;
    }
}
