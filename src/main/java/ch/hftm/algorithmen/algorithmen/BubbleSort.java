package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class BubbleSort {
    public static void bubbleSort(List<Integer> list){
        boolean listChanged;
        do{
            listChanged = false;
            for(int i = 0; i < (list.size() - 1); i++){
                if(list.get(i) > list.get(i + 1)){
                    SelectionSort.switchTwoPositon(list, i, (i + 1));
                    listChanged = true;
                }
            }
        }while(listChanged == true);
    }

    
}
