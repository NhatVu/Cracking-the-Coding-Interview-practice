package org.example.chap1ArrayString;

import org.junit.jupiter.api.Assertions;

public class Ex1_5_One_Away {
    /*
    One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.

pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
     */
    public static void main(String[] args) {
        Assertions.assertTrue(isOneWay("pale", "ple"));
        Assertions.assertTrue(isOneWay("pales", "pale"));
        Assertions.assertTrue(isOneWay("pale", "bale"));
        Assertions.assertFalse(isOneWay("pale", "bake"));
    }

    public static boolean isOneWay(String s1, String s2){
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        // Make sure s1 is the shorter string
        if (s1.length() > s2.length()) {
            return isOneWay(s2, s1);
        }

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;

                // If lengths are equal, move both pointers (replace case)
                if (s1.length() == s2.length()) {
                    index1++;
                }
                // If lengths are not equal, move only the longer string pointer (insert/remove case)
            } else {
                index1++; // Move shorter string pointer if characters match
            }
            index2++; // Always move longer string pointer
        }

        return true;

    }
}
