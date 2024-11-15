package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class Helper {
    protected static void switchTwoPositon(List<Integer> list, int indexPosA, int indexPosB){
        Integer value = list.get(indexPosA);
        list.set(indexPosA, list.get(indexPosB));
        list.set(indexPosB, value);
    }

    protected static void switchTwoPositon(int[] array, int indexPosA, int indexPosB){
        Integer value = array[indexPosA];
        array[indexPosA] = array[indexPosB];
        array[indexPosB] = value;
    }
}
