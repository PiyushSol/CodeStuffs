
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class IndianCoins {
    //Give currency array find the the min no of coins/notes to give to complete the value given.
    public static void main(String[] args) {
        Integer curr[]={1,2,5,10,20,50,100,500,2000};
        Arrays.sort(curr , Comparator.reverseOrder());

        int notes = 0;
        int amount=1000;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<curr.length;i++){
            if(curr[i]<=amount){
                while(curr[i]<=amount){
                    notes++;
                    ans.add(curr[i]);
                    amount-=curr[i];
                }
            }
        }

       System.out.println("Total Minimum Notes used: "+ notes);
       for(int i=0;i<ans.size();i++){
        System.out.println(ans.get(i));
       } 
        
    }

}
