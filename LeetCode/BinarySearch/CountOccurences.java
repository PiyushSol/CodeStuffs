public class CountOccurences {
    public static void main(String[] args) {
        int nums[]= {0,0,1,1,1,2,2};
        System.out.println(countOccurrences(nums,1));
    }

    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr,target);
        int last = lastOccurrence(arr,target);
        return last-first+1;
    }

    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Find last occurrence of target
    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
