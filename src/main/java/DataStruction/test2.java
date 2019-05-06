package DataStruction;

import java.util.ArrayList;

/**
 * Created by tianbo on 2019/3/11.
 */
public class test2 {

    public static void main(String[] args){
        int[][] nums={{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        printMatrixClockwisely(nums);
    }

    public static void printMatrixClockwisely(int [][]nums){

        int rows = nums.length;
        int cols = nums[0].length;
        if(nums == null || cols <= 0 || rows <= 0){
            return;
        }
        int start = 0;
        while(cols > start*2 && rows > start*2){
            printMatrixInCircle( nums, cols, rows, start);
            ++start;
        }

    }

    public static void printMatrixInCircle( int[][] nums,
                                     int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; ++i) {
            int number = nums[start][i];
            System.out.print(number);
        }
        //从上到下打印一列
        if(start < endY){
            for (int i = start + 1; i <= endY; ++i) {
                int number = nums[i][endX];
                System.out.print(number);
            }
        }
        //从右向左打印一行
        if(start < endX && start < endY){
            for (int i = endX-1; i >= start; --i) {
                int number = nums[endY][i];
                System.out.print(number);
            }
        }
        //从下向上打印一列
        if(start < endX && start < endY - 1){
            for (int i = endY-1; i >= start + 1; --i) {
                int number = nums[i][start];
                System.out.print(number);
            }
        }
    }
}
