package ch.hftm.algorithmen.algorithmen;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    
    public static int linearMinSearch(List<Integer> list, int startIndex){
        int minValue = list.get(startIndex);
        int minIndex = startIndex;
        for(int i = (startIndex + 1); i < list.size(); i++){
            if(minValue > list.get(i)){
                minValue = list.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int linearSearch(List<Integer> list, int zielwert){
        return linearSearch(list, zielwert, 0);
    }

    private static int linearSearch(List<Integer> list, int zielwert, int startIndex){
        for(int i = startIndex; i < list.size(); i++){
            if(list.get(i) == zielwert){
                return i;
            }
        }
        return -1;
    }

    public static List<Integer> linearSearchAllMatches(List<Integer> list, int zielwert){
        int foundIndex = 0;
        List<Integer> foundMatches = new ArrayList<>();
        while(true){
            foundIndex = linearSearch(list, zielwert, foundIndex);
            if(foundIndex != -1){
                foundMatches.add(foundIndex);
                foundIndex++;
            } else{
                return foundMatches;
            }
        }
    }



    public static int linearMinSearch(int[] array, int startIndex){
        int minValue = array[startIndex];
        int minIndex = startIndex;
        for(int i = (startIndex + 1); i < array.length; i++){
            if(minValue > array[i]){
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int linearSearch(int[] array, int zielwert){
        return linearSearch(array, zielwert, 0);
    }

    private static int linearSearch(int[] array, int zielwert, int startIndex){
        for(int i = startIndex; i < array.length; i++){
            if(array[i] == zielwert){
                return i;
            }
        }
        return -1;
    }

    public static int[] linearSearchAllMatches(int[] array, int zielwert){
        int foundIndex = 0;
        int[] foundMatches = new int[0];
        while(true){
            foundIndex = linearSearch(array, zielwert, foundIndex);
            if(foundIndex != -1){
                int[] newArray = new int[foundMatches.length + 1];
                System.arraycopy(foundMatches, 0, newArray, 0, foundMatches.length);
                newArray[newArray.length - 1] = foundIndex;
                foundMatches = newArray.clone();
                foundIndex++;
            } else{
                return foundMatches;
            }
        }
    }

}
