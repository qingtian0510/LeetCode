package DataStruction.Array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tianbo on 2018/9/3.
 */
public class ArrayAlgorithm {

    public static void main(String[] args){
        ArrayAlgorithm arrayAlgorithm=new ArrayAlgorithm();
        int[] t={9,8,7,6,5,4,3,2,1,0};
        int[] b=arrayAlgorithm.plusOne(t);
        //int[] nums={0,0,0,0,3,12};
//        int array[] = {1,-2,3,10,-4,7,2,-5};
//        System.out.print(arrayAlgorithm.getMaxTotal(array));
        //arrayAlgorithm.moveZeroes(nums);
        //System.out.print(sortChars("bcabcacaa"));
       System.out.println(stringToInt("-123"));
    }


    //找出两个数组的交集
//    public static int[] intersect(int[] nums1, int[] nums2){
//        for(int i=0;i<nums1.length;i++){
//
//        }
//    }

    //加一
    public  int[] plusOne(int[] digits) {
        int[] res=new int[digits.length+1];

        int len=digits.length;
        int add=1;
        while(len>0){
            if(digits[len-1]+add==10){
                res[len]=0;
                add=1;
            }else{
                res[len]=digits[len-1]+add;
                add=0;
            }
            len--;
        }
        if(res[1]==0)res[0]=1;
        if(res[0]==0){
            for(int i=0;i<digits.length;i++){
                digits[i]=res[i+1];
            }
            return digits;
        }
        return res;

    }

    //移动零到最后
    public void moveZeroes(int[] nums) {

        for(int i=nums.length-1;i>0;i--){
            for(int j=nums.length-2;j>=0;j--){
                if(nums[j]==0){
                    exchangePosition(nums,j,j+1);
                }
            }
        }
    }

    public void exchangePosition(int[] nums,int p1,int p2){
        int temp=nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=temp;
    }

    //找到数组中 连续子数组的最大和
    //https://www.cnblogs.com/edisonchou/p/4804538.html
    //https://blog.csdn.net/m0_37925202/article/details/80816684
    public int getMaxTotal(int[] nums){
        int temp_max=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            temp_max=(temp_max+nums[i])>nums[i] ? temp_max+nums[i]:nums[i];
            max=temp_max>max ? temp_max:max;
        }
        return max;
    }

    public static int stringToInt(String str) {
        int result=0;
        char[] ch=str.toCharArray();
        int len=ch.length;
        int start=0;
        if(ch[0]=='-')start=1;
        for(int i=start;i<len;i++) {
            result+=(((int)ch[i]-'0')*Math.pow(10, len-1-i));
        }
        if(start==1)return 0-result;
        return result;
    }


    /*
    * 有一个数组里面只存储了’a’、’b’、’c’，求怎么排序让所有的’a’排在前面，所有的’b’排在中间，所有的’c’排在最后
    * */
    public static char[] sortChars(String str){
        char[] temp=str.toCharArray();
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp.length-1;j++){
                if((int)temp[j]>(int)temp[j+1]){
                    char t=temp[j];
                    temp[j]=temp[j+1];
                    temp[j+1]=t;
                }
            }
        }
        return temp;
    }

}

