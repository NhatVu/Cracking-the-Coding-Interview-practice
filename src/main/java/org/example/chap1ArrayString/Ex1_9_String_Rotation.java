package org.example.chap1ArrayString;

public class Ex1_9_String_Rotation  {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        Ex1_9_String_Rotation solution = new Ex1_9_String_Rotation();
        System.out.println(solution.isRotate(s1, s2));
    }

    /*
     Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").

In a rotation, we cut s1 into two parts, x and y.
s1 = xy, s2 = yx , s1 + s1 = xyxy = xs2y
     */
    public boolean isRotate(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        String concatStr = s1 + s1;
        return isSubString(s2, concatStr);
    }

    public boolean isSubString(String s1, String s2){
        if(s1.length() > s2.length()){
            return s1.indexOf(s2) >= 0;
        }else {
            return s2.indexOf(s1) >= 0;
        }
    }
}
