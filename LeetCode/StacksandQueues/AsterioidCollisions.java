import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsterioidCollisions {
    public static void main(String[] args) {
        int[] asteriods ={8,-8};
        System.out.println(Arrays.toString(asteroidCollision(asteriods)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans = new ArrayList<>();
        int n= asteroids.length;
        for(int i=0;i<n;i++){
            if(asteroids[i]>0 ){
                ans.addLast(asteroids[i]);
            }
            else{
                while(!ans.isEmpty() && ans.getLast()>0 && ans.getLast()<Math.abs(asteroids[i])){
                    ans.removeLast();
                }
                if(!ans.isEmpty() && ans.getLast() ==Math.abs(asteroids[i])){
                    ans.removeLast();
                }
               else if(ans.isEmpty() || ans.getLast()<0){
                   ans.addLast(asteroids[i]);
                }
            }
        }
        int[] arr = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            arr[i] =ans.get(i);
        }
        return arr;
    }
}
