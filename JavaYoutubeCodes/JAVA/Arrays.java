





public class Arrays{

    //finding largest element in arrays
    public static int largestNum(int numbers[]){
        int largest = Integer.MIN_VALUE; //Minimum value of integer
        for(int i=0 ;i<numbers.length;i++){
            if(numbers[i]>largest){
                largest = numbers[i];
            }
        }
        return largest;
    }

    //Binary search
    public static int binarySearch(int arr[], int key){
      int start = 0;
      int end = arr.length-1;

       while(start <=end){
        int mid = (start+end) /2;
        //comparisons
        if(arr[mid]==key){
            return mid;
        }
        if(arr[mid]<key){
            start = mid+1;
        }
        else{
            end=mid-1;
        }
       } 
       return -1;
    }

    //Reverse array
    public static void reverse_array(int num[]){
        int first = 0 , last = num.length-1;
        while(first<last){
            //Swap
            int temp = num[last];
            num[last]=num[first];
            num[first]= temp;
            first++;
            last--;
        }
    }

      //Linear Search
      public static int LinearSearch(int numbers[], int key){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }

    //Updating Arrays
    public static void update(int marks[]){
        for (int i = 0; i <marks.length; i++) {
            marks[i]+=1;   
        }
    }

    //Pairs in an array
    public static void printPairs(int nums[]){
        int tp=0;
        for(int i=0 ; i<nums.length;i++){
            int curr = nums[i];
            for(int j=i+1;j<nums.length;j++){
                System.out.print("( "+ curr + ","+nums[j]+" )");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs = "+tp);
    }

    //Printing Subarrays and Sums
    public static void printSubarrays(int nums[]){
        // int ts=0;
        int currSum=0 , maxSum =Integer.MIN_VALUE;
        int prefix[]=new int[nums.length];

        prefix[0]=nums[0];
        //Calculate the prefix array
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }

        for(int i=0;i<nums.length;i++){
            int start = i;
            // int max_sum = Integer.MIN_VALUE;
            // int min_sum = Integer.MAX_VALUE;
            for(int j=i;j<nums.length;j++){
                 //Optimised version of subarrays sum
                int end = j;
                currSum=start==0? prefix[end] : prefix[end]-prefix[start-1];
                
                //  System.out.print("[");
                // for(int k=start;k<=end;k++){
                //     // System.out.print(nums[k]+" ");
                //     currSum+= nums[k];
                // }
                if(currSum > maxSum){
                    maxSum =currSum;
                }
                // if(sum < min_sum){
                //     min_sum =sum;
                // }
                // ts++;
                // System.out.print("]");
                System.out.println();
                System.out.println("The Sum is : "+ currSum);
                
            }
            // System.out.println("The Min Sum is : "+ min_sum +" and The Max Sum is : "+max_sum);
            System.out.println();
        }
        // System.out.println("Total Subarrays are: "+ts);
        System.out.println("Maximum Sum is : "+maxSum);
    }


    //More Optimised version of Max Subarray Sum 
    public static void kadanes(int nums[]){
        int ms=Integer.MIN_VALUE;
        int cs=0;

        for(int i=0;i<nums.length;i++){
            cs +=nums[i];
            if(cs<0){
                cs=0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("Our Max Subarray sum is : "+ ms);
    }

    //Trapped Rainwater Problem
    public static int trappedRainwater(int height[]){
        int n = height.length;

        //To calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }
        //calculate right max boundary
        int rightMax[]= new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        //loop
        for(int i=0;i<n;i++){
              //waterlevel = min(leftmax , right max)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);
             
        //trapppedwater = waterlevel - height
            trappedWater += waterlevel -height[i];
        }

        return trappedWater;

        //Algo runs in )=O(n) complexity
    }
    

    // Question - Maximising our Stock profit
    public static int buyAndSellStocks(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit =0;
        for(int i=0;i<prices.length;i++){
            //Profit calculation
            if(buyPrice<prices[i]){
                int profit = prices[i]-buyPrice; //todays profit
                maxProfit = Math.max(maxProfit,profit);
            }
            else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        // update(marks);
        // for (int i = 0; i <marks.length; i++) {
        //     System.out.println(marks[i]+" "); 
        // }
        // Scanner sc = new Scanner(System.in);
        // marks[0]=sc.nextInt();
        // marks[1]=sc.nextInt();
        // marks[2]=sc.nextInt();
        // System.out.println("Physics  : "+ marks[0]);
        // System.out.println("Chemistry  : "+ marks[1]);
        // System.out.println("Maths  : "+ marks[2]);

        // int numbers[]={-2,-3,4,-1,-2,1,5,-3};
        // int largest = largestNum(numbers);
        // System.out.println("Largest value is : "+ largest);
        // int index = LinearSearch(numbers, key);
        // System.out.println("The index for given key is : "+ index);
        // System.out.println(binarySearch(numbers, key));
        // reverse_array(numbers);
        // for(int i=0 ;i<numbers.length;i++){
        //     System.out.print(numbers[i]+" ");
        // }
        // printPairs(numbers);
        // printSubarrays(numbers);
        // kadanes(numbers);
        // int height[] ={4,2,0,6,3,2,5};
        // System.out.println(trappedRainwater(height));
        int prices[]={7,1,5,3,6,4};
        System.out.println("The Profit is : "+ buyAndSellStocks(prices));
    }

    static boolean toString(int[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
}