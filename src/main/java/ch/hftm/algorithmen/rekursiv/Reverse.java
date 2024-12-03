package ch.hftm.algorithmen.rekursiv;


public class Reverse {
    public static String reverse(String s){
        char[] array = s.toCharArray();
        reverse(array);
        return new String(array);
    }

    public static int reverse(int zahl){
        String s = String.valueOf(zahl);
        s = reverse(s);
        return Integer.parseInt(s);
    }

    private static void reverse(char[] array){
        char[] sortedArray = reverse(array, 0);
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }
    
    private static char[] reverse(char[] array, int i){
        char[] sortedArray;
        if(i >= (array.length - 1)){
            sortedArray = new char[array.length];
        } else{
            sortedArray = reverse(array, (i + 1));
        }
        sortedArray[(array.length - 1) - i] = array[i];
        return sortedArray;
    }
    
    
    public static int reverseSelfmade(int zahl){
        return reverseSelfmade(zahl, 0);
    }

    private static int reverseSelfmade(int zahl, int gespiegelteZahl){
        if(zahl == 0){
            return gespiegelteZahl;
        } else{
            return reverseSelfmade(zahl / 10, gespiegelteZahl * 10 + zahl % 10);
        }
    }
}
