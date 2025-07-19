
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack{
    public static void main(String[] args) {
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int w=50;

        double[][] ratio = new double[val.length][2];
        //0th column stores index , 1st column stores items ratio
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        } 

       //we have sorted in ascending order but we need descending order so we will loop from back.
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capactiy =w;

        int finalValue=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capactiy>=weight[idx]){ // we can include full item.
                finalValue+=val[idx];
                capactiy -= weight[idx];
            }else{
                //we need to add fractional value
                finalValue += ratio[i][1]*capactiy;
                capactiy=0;
                break;
            }
        }
 
 System.out.println("Final Value is  :  "+finalValue  );

    }
}