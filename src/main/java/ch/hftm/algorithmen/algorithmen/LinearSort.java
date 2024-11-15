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

    public static void linearSort(int[] array){
        int[] sortedArray = array.clone();
        for(int i = 0; i < array.length; i++){
            int index = LinearSearch.linearMinSearch(array, i);
            sortedArray[i] = array[index];
            System.arraycopy(array, i, sortedArray, i + 1, (index - i));

            // .clone erstellt ein neues Array. Dies hat das Problem, dass dann der übergabeparamter von der Methode nicht verändert wird, sondern nur Lokale.
            // Somit müsste man das sortierte Array als Rückgabewert wieder zurückgeben. 
            // Mit System.arraycopy wird der Inhalt in ein anderes Array kopiert. Somit wird das Array verändert, nicht aber die Speicheradresse.
            // array = sortedArray.clone(); 
            System.arraycopy(sortedArray, 0, array, 0, array.length);
        }
    }

    public static void reverse(int[] array){
        int[] sortedArray = new int[array.length];
        for(int i = 0; i < (array.length - 1); i++){
            sortedArray[array.length - 1 - i] = array[i]; 
        }
        array = sortedArray.clone();
    }
}
