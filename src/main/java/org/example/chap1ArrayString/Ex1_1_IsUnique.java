package org.example.chap1ArrayString;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex1_1_IsUnique {
    /*
    IsUnique: Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structure.
     */
    public static void main(String[] args) {
        Assertions.assertTrue(isUnique_set("abc"));
        Assertions.assertFalse(isUnique_set("aabc"));

        // not using data structure
        Assertions.assertTrue(isUnique_sort("abc"));
        Assertions.assertFalse(isUnique_sort("aabc"));

        // using array of boolean
        Assertions.assertTrue(isUnique_ascii("abc"));
        Assertions.assertFalse(isUnique_ascii("aabc"));
    }

    public static boolean isUnique_ascii(String str){
        int MAX_CHARACTER = 128;
        if(str.length() > MAX_CHARACTER){
            return false;
        }

        boolean[] char_set = new boolean[MAX_CHARACTER];
        for(int i = 0; i < str.length(); i++){
            int c = str.charAt(i);
            if(char_set[c]){
                // this position is already set ==> duplicated
                return false;
            }
            char_set[c] = true;
        }
        return true;
    }

    public static boolean isUnique_sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        for(int i = 0; i < str.length() -1; i++){
            if(arr[i] == arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isUnique_set(String str){
        Set<Character> set = new HashSet<>();
        for(char c: str.toCharArray()){
            set.add(c);
        }
        return str.length() == set.size();
    }
}
