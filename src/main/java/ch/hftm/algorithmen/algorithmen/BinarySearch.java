package ch.hftm.algorithmen.algorithmen;

import java.util.List;

public class BinarySearch {

    public static int binarySearch(List<Integer> list, int zielwert){
        return binarySearch(list, zielwert, false);
    }

    private static int binarySearch(List<Integer> list, int zielwert, boolean getClosestMatch){
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
                maxIndex = actIndex - 1;
            }

            if(getClosestMatch && minIndex == maxIndex){
                actIndex = (minIndex + maxIndex) / 2; // actIndex neu berechnen, da es zuvor eine anpassung der minIndex oder maxIndex gegeben haben könnte
                int deltaMin = Math.abs((actIndex != 0           ? list.get(actIndex - 1) : list.get(actIndex)) - zielwert);
                int deltaMax = Math.abs((actIndex == list.size() ? list.get(actIndex - 1) : list.get(actIndex)) - zielwert);
                return ((deltaMin - deltaMax) <= 0) && (actIndex != 0) ? (actIndex - 1) : actIndex;
            }
        }
        return -1;
    }

    public static int binarySearchForClosestMatch(List<Integer> list, int zielwert){
        return binarySearch(list, zielwert, true);
    }



    public static int binarySearch(int[] array, int zielwert){
        return binarySearch(array, zielwert, false);
    }

    private static int binarySearch(int[] array, int zielwert, boolean getClosestMatch){
        int minIndex = 0;
        int maxIndex = array.length;
        int actIndex;
        while(minIndex < maxIndex){
            actIndex = (minIndex + maxIndex) / 2;
            if(zielwert == array[actIndex]){
                return actIndex;
            } else if(zielwert > array[actIndex]){
                minIndex = actIndex + 1;
            } else{ // (zielwert < list[actIndex])
                maxIndex = actIndex - 1;
            }

            if(getClosestMatch && minIndex == maxIndex){
                actIndex = (minIndex + maxIndex) / 2; // actIndex neu berechnen, da es zuvor eine anpassung der minIndex oder maxIndex gegeben haben könnte
                int deltaMin = Math.abs((actIndex != 0           ? array[actIndex - 1] : array[actIndex]) - zielwert);
                int deltaMax = Math.abs((actIndex == array.length ? array[actIndex - 1] : array[actIndex]) - zielwert);
                return ((deltaMin - deltaMax) <= 0) && (actIndex != 0) ? (actIndex - 1) : actIndex;
            }
        }
        return -1;
    }

    public static int binarySearchForClosestMatch(int[] array, int zielwert){
        return binarySearch(array, zielwert, true);
    }
    
}
