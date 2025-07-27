import java.util.ArrayList;

public class NDigitsNumbers {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(increasingNumbers(1));
        System.out.println(increasingNumbers(2));
    }

    public static ArrayList<Integer> increasingNumbers(int n) {
        ans.clear();
        if(n ==1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }
            else {
            store(1, n, 0);
            return (ArrayList<Integer>) ans;
        }
    }


    public static void store(int last , int n , int num){
        if(n==0){
            ans.add(num);
            return;
        }

        for(int i=last;i<=9;i++){
            int a = num*10+i;
            store(i+1,n-1,a);
        }
    }
}
