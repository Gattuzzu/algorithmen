package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class LinearSort {
    public static void linearSort(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            int index = LinearSearch.linearMinSearch(list, i);
            list.add(i, list.get(index));
            list.remove(index + 1);
        }
    }

    public static void reverse(List<Integer> list){
        for(int i = 0; i < (list.size() - 1); i++){
            list.add(i, list.getLast());
            list.removeLast();
        }
    }
}
