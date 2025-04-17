package org.example.chap1ArrayString;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-image/description/
public class Ex1_7_Rotate_Matrix {
    public static void main(String[] args) {
        int n = 6;
        int count = 1;
        int[][] matrix = new int[n][n];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                matrix[r][c] = count;
                count++;
            }
        }
        rotate(matrix);

        for(int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    /*

     */
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while(left < right){
            int i = 0;
            while(left + i < right){
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
                i++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}
