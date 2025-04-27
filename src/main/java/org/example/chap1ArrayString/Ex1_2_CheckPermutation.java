package org.example.chap1ArrayString;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class Ex1_2_CheckPermutation {
    public static void main(String[] args) {
        /*
        Check Permutation: given 2 strings, write a method to decide if one is a permuatation of the other
         */
        Assertions.assertTrue(isPermutation("abc", "bca"));
        Assertions.assertTrue(isPermutation("abc", "bac"));
        Assertions.assertFalse(isPermutation("abd", "bca"));


        // assume using ascii
        Assertions.assertTrue(isPermutation_ascii("abc", "bca"));
        Assertions.assertTrue(isPermutation_ascii("abc", "bac"));
        Assertions.assertFalse(isPermutation_ascii("abd", "bca"));
    }

    public static boolean isPermutation(String a, String b){
        char[] a_char = a.toCharArray();
        Arrays.sort(a_char);

        char[] b_char = b.toCharArray();
        Arrays.sort(b_char);

        return Arrays.equals(a_char, b_char);
    }

    public static boolean isPermutation_ascii(String a, String b){
        // assume that string use ascii
        int MAX_CHARACTER = 256;
        int[] count = new int[MAX_CHARACTER];

        // count character of string a
        for(char c: a.toCharArray()){
            count[c] ++;
        }

        // for string b, minus character. If it < 0, return false
        for(char c: b.toCharArray()){
            count[c] --;
            if(count[c] < 0){
                return false;
            }
        }
        return true;
    }
}
