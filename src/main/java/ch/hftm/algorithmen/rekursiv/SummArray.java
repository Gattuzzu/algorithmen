package ch.hftm.algorithmen.rekursiv;

public class SummArray {
    public static int summArray(int[] array){
        return summArray(array, 0);
    }

    private static int summArray(int[] array, int i){
        int z;
        if(i < (array.length - 1)){
            z = array[i] + summArray(array, ++i);
        } else{
            z = array[i];
        }
        return z;

    }
}
