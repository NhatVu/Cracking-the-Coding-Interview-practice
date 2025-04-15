package org.example.chap1ArrayString;

import org.junit.jupiter.api.Assertions;

public class Ex1_6_String_Compression{
    /*
        Implement a method to perform basic string compression using the counts
of repeated characters.

For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string.

You can assume the string has only uppercase and lowercase letters (a - z).
         */
    public static void main(String[] args) {
        Assertions.assertEquals("a2b1c5a3", compress("aabcccccaaa"));
        Assertions.assertEquals("a", compress("a"));
    }

    public static String compress(String origin){
        char[] arr = origin.toCharArray();
        StringBuilder sb = new StringBuilder();

        int l = 0, r = 0;
        int count = 0;
        while(r < origin.length()){
            if(origin.charAt(l) == origin.charAt(r)){
                count++;
                r++;
            }else{
                // move to another character
                sb.append(origin.charAt(l));
                sb.append(count);

                // reset count
                count = 0;
                l = r;
            }
        }

        sb.append(origin.charAt(l));
        sb.append(count);

        return sb.length() < origin.length() ? sb.toString() : origin;
    }
}
