package org.example.chap1ArrayString;

public class Ex1_4_Palindrome_Permutation {
    public static void main(String[] args) {
        String str = "Tact Coa.";
        System.out.println(isPalindromePermutation(str));
    }

    // assume belong to ascii
    // (ignoring spaces, punctuation, and capitalization)
    public static boolean isPalindromePermutation(String str){
        str = str.toLowerCase();

        int MAX_CHAR = 256;
        int[] count = new int[MAX_CHAR];
        for(char c: str.toCharArray()){
            if(c == ' ' || c == '.'){
                continue;
            }
            count[c] ++;
        }

        int countOdd = 0;
        for(int i = 0; i < MAX_CHAR; i++){
            if(count[i] % 2 != 0){
                countOdd++;
            }
        }
        return countOdd <= 1;
    }
}
