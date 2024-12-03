package ch.hftm.algorithmen.rekursiv;

public class SummArray {
    public static int summArray(int[] array){
        return summArray(array, 0);
    }

    private static int summArray(int[] array, int i){
        if(i < (array.length - 1)){
            return array[i] + summArray(array, ++i);
        } else{
            return array[i];
        }
    }
}
