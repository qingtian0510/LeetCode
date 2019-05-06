package DataStruction.Array;

/**
 * Created by tianbo on 2019/3/2.
 */
public class CommonSorts {
    public static void main(String[] args){

        int[] nums={3,5,2,1,7,3,8,4,2};
        quickSort(nums,0,nums.length-1);
        System.out.print(nums);
    }


    //快速排序
    public static void quickSort(int[] nums,int low,int high){
        if(low>=high)return;
        int temp=nums[low];
        int left=low;
        int right=high;
        while(left<right){
            while(left<right&&nums[right]>=temp){
                right--;
            }
            nums[left]=nums[right];
            while(left<right&&nums[left]<=temp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=temp;
        quickSort(nums,low,left-1);
        quickSort(nums,left+1,high);


    }
}
