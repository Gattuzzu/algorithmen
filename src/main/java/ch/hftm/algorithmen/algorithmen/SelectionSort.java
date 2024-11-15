package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class SelectionSort {
    
    public static void selectionSort(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            int index = LinearSearch.linearMinSearch(list, i);
            Helper.switchTwoPositon(list, i, index);
        }
    }

    public static void reverse(List<Integer> list){
        int index = 0;
        while(index < ((list.size() - 1) / 2)){
            Helper.switchTwoPositon(list, index, (list.size() - 1 - index));
            index++;
        }
    }


    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int minValue = array[i];
            int minIndex = i;
            for(int j = i; j < array.length; j++){
                if(minValue > array[j]){
                    minValue = array[j];
                    minIndex = j;
                }
            }
            Helper.switchTwoPositon(array, i, minIndex);
        }
    }

    public static void reverse(int[] array){
        int index = 0;
        while(index < ((array.length - 1) / 2)){
            Helper.switchTwoPositon(array, index, (array.length - 1 - index));
            index++;
        }
    }

}
