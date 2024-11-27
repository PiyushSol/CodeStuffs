public class DivideandCon{
    //Printing our array
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //Merge Sort
    public static void mergeSort(int arr[], int si , int ei){
        if(si>=ei){
            return;
        }
 
        int mid = si + (ei-si)/2;
        mergeSort(arr, si,mid);
        mergeSort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
        }

    //Merge function
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]= new int[ei-si+1];
        int i=si;//iterator for left part
        int j=mid+1; //iterator for right part
        int k=0; //iterator for temp arr
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        //left part
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        //right part
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy temp into original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k]; 
        }
    }   

    //Quick Sort
     public static void quickSort(int arr[],int si, int ei){
        if(si>=ei){
            return;
        }
        
        //first step is to find pivot element and we choose last element as pivot.
       int pidx= partition(arr,si,ei);
       quickSort(arr, si, pidx-1);//left
       quickSort(arr,pidx+1, ei); // right

     }

     //Partition function
     public static int partition(int arr[],int si , int ei){
        int pivot= arr[ei];
        int i=si-1 ; //it makes place for smaller elements then pivot
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        //putting pivot at correct place
        i++;
        int temp = pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
     }

     //Problem - Search in a rotated array
     public static int search(int arr[],int target,int si,int ei){
        //base case
         if(si>ei){
            return -1;
         }

        //mid finding
        int mid = si +(ei-si)/2;
        //case found at mid
        if(arr[mid]==target){
            return mid;
        }

        //Mid lies on L1
        if(arr[si]<=arr[mid]){
            //case a : to search in left
            if(arr[si]<=target && target<=arr[mid]){
                return search(arr, target, si, mid-1);
            }
            else{
                //case b : searching in right
                return search(arr,target,mid+1,ei);
            }
        }

        //Mid lies on L2
        else{
            //case c : searching in right of L2
            if(arr[mid+1]<=target && target<=arr[ei]){
                return search(arr,target,mid+1,ei);
            }
            else{
                //case d: left search in l2
                return search(arr, target,si,mid-1);
            }
        }
     }
     
     
    public static void main(String[] args) {
        // int arr[]={6,3,9,5,2,8};
        // mergeSort(arr,0, arr.length-1);
        // quickSort(arr, 0, arr.length-1);
        int arr[]={4,5,6,7,0,1,2};
        int target=5;
        int tidx = search(arr, target,0, arr.length-1);
        System.out.println(tidx);
        // printArr(arr);
    }
}