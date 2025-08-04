import java.util.Arrays;

public class FindtheUnion {
    public static void main(String[] args) {
        int nums1[]= {1,2,3,4,5};
        int nums2[]={1,2,7};
        int res[] = unionArray(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] unionArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2=nums2.length;
        int k=0, i=0,j=0;
        int union[] = new int[n1+n2];
        while(i<n1 && j<n2){
            int val;
            if (nums1[i] < nums2[j]) {
                val = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                val = nums2[j++];
            } else {
                val = nums1[i];
                i++;
                j++;
            }

            if (k == 0 || union[k - 1] != val) {
                union[k++] = val;
            }
        }

        while (i < n1) {
            if (k == 0 || union[k - 1] != nums1[i]) {
                union[k++] = nums1[i];
            }
            i++;
        }

        while (j < n2) {
            if (k == 0 || union[k - 1] != nums2[j]) {
                union[k++] = nums2[j];
            }
            j++;
        }

        return Arrays.copyOf(union, k);
    }
}
