package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class BinarySearch {

    public static int binarySearch(List<Integer> list, int zielwert){
        int minIndex = 0;
        int maxIndex = list.size();
        int actIndex;
        while(minIndex < maxIndex){
            actIndex = (minIndex + maxIndex) / 2;
            if(zielwert == list.get(actIndex)){
                return actIndex;
            } else if(zielwert > list.get(actIndex)){
                minIndex = actIndex + 1;
            } else{ // (zielwert < list.get(actIndex))
                maxIndex = actIndex;
            }
        }
        return -1;
    }
    
}
