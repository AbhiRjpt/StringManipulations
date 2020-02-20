package com.ranag;

public class KMPAlgo {

    public static void main(String[] args) {
        String s1 = "hello, world";
        String s2 = "world";
        System.out.println(KMPAlgo.kmpMethod(s1,s2));
    }

    private static int kmpMethod(String text, String pattern) {
        return kmp(text.toCharArray(),pattern.toCharArray());
    }

    private static int kmp(char[] text, char[] pattern) {
        int i = 0,j=0;
        final int n = text.length;
        final int m = pattern.length;
        int[] shiftArray = new int[m+1];
        kmpPreProcess(pattern,shiftArray);
        while (i<n) {
            while (j > 0 && text[i] != pattern[j]) {
                j = shiftArray[j];
            }
            i++;
            j++;
            if(j==m){
                return (i-m);
            }
        }

        return -1;
    }

    private static void kmpPreProcess(char[] pattern, int[] shiftArray) {
        final int m = pattern.length;
        int i = 0,j = -1;
        shiftArray[i] = -1;
        while (i<m){
            while (j>=0 && pattern[i] != pattern[j]){
                j = shiftArray[j];
            }
            i++;
            j++;
            shiftArray[i] = j;
        }
    }
}
