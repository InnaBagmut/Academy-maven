//2) Слово "Constructor" => превратить в char[] => отсортировать => снова в String => Ccnoorrsttu

package com.academy.lesson08.stringoperations;

public class CharAndSort {
    public static void toCharAndSort() {
        String word1 = "Constructor";
/*        word1.toCharArray();
        System.out.println(word1.toCharArray());*/
        for (int i = 0; i < word1.length(); i++) {
            System.out.println(word1.charAt(i));
        }

        char[] word2 = word1.toCharArray();
        System.out.println(word2);
        System.out.println("There are chars: " + new String(word2));
        System.out.println(word2[2]);
        System.out.println("There is one char element: " + word2[2]);

        System.out.println();
        //char min = 0;
        for (int i = 0; i < word2.length; i++) {
            for (int j = 0; j < word2.length - 1; j++) {
                if (word2[j] > word2[j + 1]) {
                    char temp = word2[j];
                    word2[j] = word2[j + 1];
                    word2[j + 1] = temp;
                }
            }
            //System.out.print(word2[i]);
        }
        System.out.print("Sorted char: ");
        System.out.println(word2);
        String word = new String(word2);
        System.out.println("Sorted string: " + word);
    }
}
