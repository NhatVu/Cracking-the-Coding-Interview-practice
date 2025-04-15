package org.example.chap1ArrayString;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class Ex1_6_String_Compression{
    /*
        Implement a method to perform basic string compression using the counts
of repeated characters.

For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string.

You can assume the string has only uppercase and lowercase letters (a - z).
         */

    /*
    https://leetcode.com/problems/string-compression/description/
     */
    public static void main(String[] args) {
        Assertions.assertEquals("a2b1c5a3", compress("aabcccccaaa"));
        Assertions.assertEquals("a", compress("a"));


        char[] input;
        int length;

//        input = new char[] {'a','a','b','b','c','c','c'};
//        length = compress_letcode_443(input);
//        System.out.println("Length: " + length);
//        System.out.println("output: " + Arrays.toString(input));
//        System.out.println("\n");

//        input = new char[] {'a'};
//        length = compress_letcode_443(input);
//        System.out.println("Length: " + length);
//        System.out.println("output: " + Arrays.toString(input));

        String[] strArr = {"a","b","b","b","b","b","b","b","b","b","b","b","b"};
        input = new char[strArr.length];
        for (int i = 0; i < strArr.length; i++){
            input[i] = strArr[i].charAt(0);
        }
        length = compress_letcode_443(input);
        System.out.println("Length: " + length);
        System.out.println("output: " + Arrays.toString(input)); // ab12


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

    // https://leetcode.com/problems/string-compression/description/
    public static int compress_letcode_443(char[] chars) {
        int read = 0; // possition to read from the array
        int write = 0; // possition to write to the array

        while(read < chars.length){
            char currChar = chars[read];
            int count = 0;

            // Count occurrences of the current character
            while(read < chars.length && chars[read] == currChar){
                count++;
                read++;
            }

            // Write the character
            chars[write++] = currChar;

            if(count > 1){
                for(char c: String.valueOf(count).toCharArray()){
                    chars[write++] = c;
                }
            }
        }
        return write;
    }

    // 3163. String Compression III
    public String compressedString_III(String word) {
        if(word.isEmpty()){
            return "";
        }

        int read = 0; // read possition from word
        int write = 0; // write possition from word
        StringBuilder sb = new StringBuilder();

        while(read < word.length()){
            char currChar = word.charAt(read);
            int count = 0;

            // count consecutive repeated letter
            while(read < word.length() && word.charAt(read) == currChar){
                count++;
                read++;
            }

            // build result string
            while(count > 0){
                int occurNum = Math.min(count, 9);
                sb.append(occurNum);
                sb.append(currChar);

                count -= occurNum;
            }
        }

        return sb.toString();

    }
}
