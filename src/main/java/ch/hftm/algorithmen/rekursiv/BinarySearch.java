package ch.hftm.algorithmen.rekursiv;

public class BinarySearch {
    // Array muss aufsteigend sortiert sein für diese Methode.
    public static int binarySearch(int[] array, int ziel){
        return binarySearch(array, ziel, 0, array.length);
    }

    private static int binarySearch(int[] array, int ziel, int lowerIdx, int upperIdx){
        int middleIdx = (lowerIdx + upperIdx) / 2;
        if(ziel == array[middleIdx]){
            return middleIdx;

        }else if (lowerIdx == upperIdx){
            return -1;

        } else if(ziel > array[middleIdx]){
            return binarySearch(array, ziel, ++middleIdx, upperIdx);

        } else{ // (ziel < array[middleIdx])
            return binarySearch(array, ziel, lowerIdx, --middleIdx);
        }
    }
}
