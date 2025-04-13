package org.example.chap1ArrayString;

import org.junit.jupiter.api.Assertions;

import java.util.SplittableRandom;

public class Ex1_3_URLEncode {
    public static void main(String[] args) {
        /*
        Input: "Mr John Smith " , 13
        Output: "Mr%20John%20Smith"
         */
        // using built in function
        Assertions.assertEquals(urlify_naturalMethod("Mr John Smith"), "Mr%20John%20Smith");
        Assertions.assertEquals(urlify_naturalMethod("Mr John Smith "), "Mr%20John%20Smith%20");
        Assertions.assertEquals(urlify_naturalMethod("Mr  John Smith "), "Mr%20%20John%20Smith%20");

        // using string builder
        Assertions.assertEquals(urlify_stringBuilder("Mr John Smith"), "Mr%20John%20Smith");
        Assertions.assertEquals(urlify_stringBuilder("Mr John Smith "), "Mr%20John%20Smith%20");
        Assertions.assertEquals(urlify_stringBuilder("Mr  John Smith "), "Mr%20%20John%20Smith%20");

        // inplace replacing
        String input = "Mr John Smith       "; // extra space for %20s
        int trueLength = 13;
        char[] charArray = input.toCharArray();

        urlify(charArray, trueLength);
        Assertions.assertEquals(new String(charArray).trim(), "Mr%20John%20Smith");
    }

    /*
    This is the method that the book wants us todo.
    It assumes that the char[] long enough to hold additional character after the replacement
    for final testing, just trim the result to remove redundant ending space.
     */
    public static void urlify(char[] str, int trueLength) {
        /*
        step 1: couting space
        step 2: calculate exactly length after replace
        step 3. from the end and moves backward is to avoid overwriting characters before they've been moved
         */
        int spaceCouting = 0;
        for(int i = 0; i < trueLength; i++){
            if(str[i] == ' '){
                spaceCouting++;
            }
        }

        int afterRepalceLength = trueLength + spaceCouting * 2;

        // If there is no space at the end of the array, return early
        if(afterRepalceLength > str.length)
            return;

        int index = afterRepalceLength - 1;
        for(int i = trueLength - 1; i >= 0; i--){
            if(str[i] == ' '){
                str[index--] = '0';
                str[index--] = '2';
                str[index--] = '%';
            }else{
                str[index--] = str[i];
            }
        }
    }

    public static String urlify_naturalMethod(String url){
        return url.replace(" ", "%20");
    }

    public static String urlify_stringBuilder(String url){
        StringBuilder sb = new StringBuilder();
        for(char c : url.toCharArray()){
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
