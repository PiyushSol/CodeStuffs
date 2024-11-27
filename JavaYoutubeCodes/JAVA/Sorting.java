 public class Sorting{

    //Bubble Sorting 
    public static void bubbleSort(int arr[]){
        for(int turn=0; turn<arr.length-1;turn++){
            for(int j=0; j<arr.length-1-turn;j++ ){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //Selection Sort
    public static void selectionSort(int arr[]){
        for(int turn=0 ; turn<arr.length-1;turn++){
            int smallest = turn;
            for(int j=turn+1;j<arr.length;j++){
                if(arr[smallest]>arr[j]){
                    smallest = j;
                }
            }
            //Swap
            int temp = arr[smallest];
            arr[smallest]= arr[turn];
            arr[turn]= temp;
        }
    }

    //Insertion Sort
    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev = i-1;
            //finding out the correct pos to insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            } 
            
            //insertion
            arr[prev+1]=curr;
        }
    }

    //Count Sort
    public static void countingSort(int arr[]){
         int largest = Integer.MIN_VALUE;
         for(int i=0;i<arr.length;i++){
            largest = Math.max(largest,arr[i]);
         }

         //count array
         int count[] = new  int[largest+1];
         for(int i=0;i<arr.length;i++){
            count[arr[i]]++;

         }

         //Sorting
         int j=0;
         for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
         }
    }


    //Function to print array
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[]={1,4,1,3,2,4,3,7};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // printArray(arr);
        // java.util.Arrays.sort(arr);
        // countingSort(arr);
        // printArray(arr);     
    }
}