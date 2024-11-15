package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class BubbleSort {
    public static void bubbleSort(List<Integer> list){
        boolean listChanged;
        do{
            listChanged = false;
            for(int i = 0; i < (list.size() - 1); i++){
                if(list.get(i) > list.get(i + 1)){
                    Helper.switchTwoPositon(list, i, (i + 1));
                    listChanged = true;
                }
            }
        }while(listChanged == true);
    }

    public static void bubbleSort(int[] array){
        boolean listChanged;
        do{
            listChanged = false;
            for(int i = 0; i < (array.length - 1); i++){
                if(array[i] > array[i + 1]){
                    int value    = array[i];
                    array[i]     = array[i + 1];
                    array[i + 1] = value;

                    listChanged = true;
                }
            }
        }while(listChanged == true);
    }

}
