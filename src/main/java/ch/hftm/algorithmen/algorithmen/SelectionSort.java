package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class SelectionSort {
    
    public static void selectionSort(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            int index = LinearSearch.linearMinSearch(list, i);
            switchTwoPositon(list, i, index);
        }
    }

    private static void switchTwoPositon(List<Integer> list, int indexPosA, int indexPosB){
        Integer value = list.get(indexPosA);
        list.set(indexPosA, list.get(indexPosB));
        list.set(indexPosB, value);
    }

    public static void reverse(List<Integer> list){
        int indexA = 0;
        int indexB = list.size() - 1;
        while(indexA != indexB && indexA < indexB){
            switchTwoPositon(list, indexA++, indexB--);
        }
    }
}
