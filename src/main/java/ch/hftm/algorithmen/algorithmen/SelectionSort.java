package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class SelectionSort {
    
    public static void selectionSort(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            int index = LinearSearch.linearMinSearch(list, i);
            Integer value = list.get(i);
            list.set(i, list.get(index));
            list.set(index, value);
        }
    }
}
