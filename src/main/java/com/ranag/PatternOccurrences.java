package com.ranag;

import java.util.LinkedList;
import java.util.List;

public class PatternOccurrences {
    public static void main(String[] args) {
        String s1 = "hello, world whats up worldworld";
        String s2 = "world";
        System.out.println(PatternOccurrences.kmpFindCount(s1.toCharArray(),s2.toCharArray()));
    }

    private static int kmpFindCount(char[] text, char[] pattern) {
        int i =0,j=0,count =0;
        final int t = text.length;
        final int p = pattern.length;
        int[] shiftArray = new int[p+1];
        kmpPreProcess(pattern,shiftArray);
        while (i<t){
            while (j >= 0 && text[i] != pattern[j]){
                j = shiftArray[j];
//                System.out.println("j is : "+j);
            }
            i++;
            j++;
            if(j == p){
//                posList.add(j);
                count++;
                j = shiftArray[j];
            }
        }
//        System.out.println("posList: "+posList);
        return count;
    }

    private static void kmpPreProcess(char[] pattern, int[] shiftArray) {
        List<Integer> posList = new LinkedList<Integer>();
        int i =0,j= -1;
        final int p = pattern.length;
        shiftArray[i] = -1;
        while (i<p){
//            System.out.println("i: "+i);
//            System.out.println("j: "+j);

            while (j>=0 && pattern[i] != pattern[j]){
//                System.out.println("patternValues: "+pattern[i]+" "+pattern[j]);
                j = shiftArray[j];
//                System.out.println("j: "+j);
            }
            i++;
            j++;
            shiftArray[i] = j;
//            System.out.println("i: "+i);
//            System.out.println("j: "+j);
//            System.out.println("ShiftArrayValAt i : " +shiftArray[i]);
        }
    }


}
