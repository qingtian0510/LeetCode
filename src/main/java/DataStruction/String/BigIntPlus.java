package DataStruction.String;

/**
 * Created by tianbo on 2019/3/2.
 */
public class BigIntPlus {
    public static void main(String[] args){
        String str1="123123123123";
        String str2="456789789788";
        plus(str1,str2);
    }
    public static void plus(String str1,String str2){
        char[] chars1=str1.toCharArray();
        char[] chars2=str2.toCharArray();
        int max=chars1.length>chars2.length ? chars1.length+1:chars2.length+1;
        int[] ch_int1=getInts(str1.toCharArray(),max);
        int[] ch_int2=getInts(str2.toCharArray(),max);
        int[] result= new int[max];
        for(int i=max-1;i>0;i--){
            int temp=ch_int1[i]+ch_int2[i]+result[i];
            if(temp>10){
                result[i]=temp%10;
                result[i-1]+=1;
            }else result[i]=temp;
        }
        System.out.print(result.toString());
    }

    public static int[] getInts(char[] nums,int max){
        int[] res=new int[max];
        int gap=max-nums.length;
        for(int i=0;i<nums.length;i++){
            char ch=nums[i];
            int ch_int=Integer.parseInt(String.valueOf(ch));
            res[i+gap]=ch_int;

        }
        return res;
    }

}
