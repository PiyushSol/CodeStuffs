import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr ={5,3,2,1,9,6,4,7,8};
//        selection(arr);
//        insertion(arr);
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Bubble Sorting
    public static void bubble(int []arr){
        boolean isSwapped;
        for(int i=0;i< arr.length;i++){
            isSwapped=false;
            //can also be written as j<arr.length-i
            for(int j=1;j<=arr.length-i-1;j++){
                //Swap only if element is smaller than previous element
                if(arr[j]<arr[j-1]){
                   swap(arr,j,j-1);
                    isSwapped=true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }

    //Selection Sorting
    public static void selection(int[] arr){
        for(int i=0 ; i<arr.length;i++){
            //We are sorting by finding max element and placing it in its correct position
            int lastIndex = arr.length-i-1;
            int maxIndex = getMaxIndex(arr,0 , lastIndex);
            swap(arr,maxIndex,lastIndex);
        }
    }

    //Insertion Sort
    public static void insertion(int []arr){
         for(int i=0 ; i<arr.length-1;i++){
             for(int j=i+1;j>0;j--){
                 if(arr[j]<arr[j-1]){
                     swap(arr,j,j-1);
                 }
                 else{
                     break;
                 }
             }
         }
    }

    //Cyclic Sort
    public static void cyclicSort(int []arr){
        int i=0;
        while(i<arr.length){
            int correct = arr[i] - 1;
            if(arr[correct]!=arr[i]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }
    public static void swap(int []arr , int first , int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    public static int getMaxIndex(int[] arr, int start, int end) {
        int max =start;
        for (int j = start; j<=end ; j++) {
            if(arr[max]<arr[j]){
               max=j;
            }
        }
        return max;
    }
}
