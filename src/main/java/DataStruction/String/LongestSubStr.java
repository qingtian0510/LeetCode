package DataStruction.String;

import java.util.Stack;

/**
 * Created by tianbo on 2019/3/2.
 *
 * 寻找两个字符串的最长子串
 *
 * https://www.jianshu.com/p/4b5d7deef7fe?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation
 */
public class LongestSubStr {
    public static void main(String[] args){
        char[] str1="abcde".toCharArray();
        char[] str2="bbcdfbcde".toCharArray();
        getSubStr(str1,str2);

    }
    public static void getSubStr(char[] str1,char[] str2){
        int m= str1.length;
        int n=str2.length;
        int max=0;
        int index=0;
        int[][] mat=new int[m][n];
        for(int i=0;i<m;i++){
            if(str1[i]==str2[0])mat[i][0]=1;
            else mat[i][0]=0;
        }
        for(int i=1;i<n;i++){
            if(str1[0]==str2[i])mat[0][i]=1;
            else mat[0][1]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(str1[i]==str2[j]){
                    mat[i][j]=mat[i-1][j-1]+1;
                }
                else mat[i][j]=0;
                if(mat[i][j]>max){
                    max=mat[i][j];
                    index=i;
                }
            }
        }
        Stack<String> stack=new Stack<String>();
        for(int i=index;i>0;i--){
            stack.push(str1[i]+"");
        }
        while(stack.size()!=0){
            System.out.print(stack.pop());
        }
    }
}
