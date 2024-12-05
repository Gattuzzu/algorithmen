package ch.hftm.algorithmen.rekursiv;

import java.util.List;

public class MergeSort {
    public static void mergeSort(List<Integer> list){
        // muss noch gemacht werden
    }

    



// =====================================================================
// Von Stack Overflow (bootom-up) -> Grösste Zahl zuerst
    private static void merge(int[]a,int[] aux, int f, int m, int l) {

        for (int k = f; k <= l; k++) {
            aux[k] = a[k];
        }
    
        int i = f, j = m+1;
        for (int k = f; k <= l; k++) {
            if(i>m) a[k]=aux[j++];
            else if (j>l) a[k]=aux[i++];
            else if(aux[j] > aux[i]) a[k]=aux[j++];
            else a[k]=aux[i++];
        }       
    }

    private static void sort(int[]a,int[] aux, int f, int l) {
        if (l<=f) return;
        int m = f + (l-f)/2;
        sort(a, aux, f, m);
        sort(a, aux, m+1, l);
        merge(a, aux, f, m, l);
    }

    public static void mergeSort(int[]a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }
// =====================================================================

}
