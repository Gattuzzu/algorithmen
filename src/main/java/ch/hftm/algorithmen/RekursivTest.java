package ch.hftm.algorithmen;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import ch.hftm.algorithmen.algorithmen.SelectionSort;
import ch.hftm.algorithmen.rekursiv.BinarySearch;
import ch.hftm.algorithmen.rekursiv.Fakultaet;
import ch.hftm.algorithmen.rekursiv.Fibonacci;
import ch.hftm.algorithmen.rekursiv.Zaehler;

public class RekursivTest {
    public static void test(){
        // testZaehler();
        // testFakultaet();
        // testFibonacci();
        testBinarySearch();
    }

    public static void testZaehler(){
        System.out.println(Zaehler.countDown(10));
        System.out.println(Zaehler.countUp(10));
        System.out.println(Zaehler.countUp(0,10));
    }

    public static void testFakultaet(){
        for(int i = 0; i <= 9; i++){
            System.out.println("fak(" + i + ") = " + Fakultaet.fak(i));
        }
    }

    public static void testFibonacci(){
        for(int i = 0; i <= 20; i++){
            System.out.println("fibonacci(" + i + ") = " + Fibonacci.fibonacci(i));
        }
    }

    public static void testBinarySearch(){
        int[] array = {-15, -2, 0, 3, 7, 9, 10, 17, 21, 29};
        int ziel = 10;
        System.out.println("Das Element " + ziel + " befindet sich im betrachtetden int-Array an Position " + BinarySearch.binarySearch(array, ziel) + "!");
        
        for(int i = 0; i < 10; i++){
            array = createRandomArray(10, 20);
            SelectionSort.selectionSort(array); 
            ausgabe(array);
            System.out.println("Das Element " + ziel + " befindet sich im betrachtetden int-Array an Position " + BinarySearch.binarySearch(array, ziel) + "!");
        }

    }


    // Hielfs Methoden
    private static int[] createRandomArray(int anzZahlen, int range){
        return IntStream.generate(() -> new Random().nextInt(range)).limit(anzZahlen).toArray();
    }

    private static void ausgabe(List<Integer> list){
        for(Integer i : list){
            System.out.println(i);
        }
    }

    private static void ausgabe(int[] array){
        for(int i : array){
            System.out.println(i);
        }
    }

}
