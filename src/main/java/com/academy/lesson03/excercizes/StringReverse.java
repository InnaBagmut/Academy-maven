package com.academy.lesson03.excercizes;

public class StringReverse {
    public static void main(String[] args) {
        String str1 = "abcd";
        String strReversed = reverse(str1);
        System.out.println(reverse(str1));

    }

    public static String reverse(String str1) {
/*        char[] array1 = str1.toCharArray();
        System.out.println(array1.toString());
        return array1;*/
        char[] tmp = new char[str1.length()];
       // tmp[0] = str1.charAt(str1.length() - 1);

        for (int i = 0, j = 1; i < tmp.length; i++, j++) {
            tmp[i] = str1.charAt(str1.length() - j);
        }
        String reversed = new String(tmp);
        return reversed;
    }
}
