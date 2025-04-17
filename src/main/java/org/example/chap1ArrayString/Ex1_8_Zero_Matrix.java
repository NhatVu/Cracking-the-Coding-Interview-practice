package org.example.chap1ArrayString;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/set-matrix-zeroes/description/
public class Ex1_8_Zero_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        Ex1_8_Zero_Matrix solution = new Ex1_8_Zero_Matrix();
        solution.setZeroes(matrix);

        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    /*
    To solve this problem in-place, the idea is to use the first row and first column of the matrix as markers to remember which rows and columns need to be zeroed.
     */
    public void setZeroes(int[][] matrix){
        int nRow = matrix.length;
        int nCol = matrix[0].length;

        // Step 1: Check if first row or column has zero
        boolean isFirstRowHasZero = false;
        boolean isFirstColHasZero = false;

        for(int c = 0; c < nCol; c++){
            if(matrix[0][c] == 0){
                isFirstRowHasZero = true;
                break;
            }
        }

        for(int r = 0; r < nRow; r++){
            if(matrix[r][0] == 0){
                isFirstColHasZero = true;
                break;
            }
        }

        // Step 2: use first col and first row as marker. Go as index 1
        for(int r = 1; r < nRow; r++){
            for(int c = 1; c < nCol; c++){
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // step 3: fill up zero. Go from index 1
        for(int r = 1; r < nRow; r++){
            for(int c = 1; c < nCol; c++){
                if(matrix[r][0] == 0 || matrix[0][c] == 0){
                    matrix[r][c] = 0;
                }
            }
        }

        // step 4: check to fill up zero for first row and column
        if(isFirstRowHasZero){
            for(int c = 0; c < nCol; c++){
                matrix[0][c] = 0;
            }
        }

        if(isFirstColHasZero){
            for(int r = 0; r < nRow; r++){
                matrix[r][0] = 0;
            }
        }

    }

    public void setZeroes_notInPlace(int[][] matrix){
        int nRow = matrix.length;
        int nCol = matrix[0].length;

        // save zero position in matrix
        List<Point> zeroPositions = new ArrayList<>();
        for(int r = 0; r < nRow; r++){
            for(int c = 0; c < nCol; c++){
                if(matrix[r][c] == 0){
                    zeroPositions.add(new Point(r, c));
                }
            }
        }

        for(Point point : zeroPositions){
            // zero row
            for(int c = 0; c < nCol; c++){
                matrix[point.row][c] = 0;
            }
            // zero col
            for(int r = 0; r < nRow; r++){
                matrix[r][point.col] = 0;
            }
        }

    }

    class Point{
        public int row;
        public int col;

        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
