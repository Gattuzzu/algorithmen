package ch.hftm.algorithmen;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import ch.hftm.algorithmen.algorithmen.SelectionSort;
import ch.hftm.algorithmen.rekursiv.BinarySearch;
import ch.hftm.algorithmen.rekursiv.CountChar;
import ch.hftm.algorithmen.rekursiv.CreateDivider;
import ch.hftm.algorithmen.rekursiv.Fakultaet;
import ch.hftm.algorithmen.rekursiv.Fibonacci;
import ch.hftm.algorithmen.rekursiv.Reverse;
import ch.hftm.algorithmen.rekursiv.SummArray;
import ch.hftm.algorithmen.rekursiv.Zaehler;

public class RekursivTest {
    public static void test(){
        // testZaehler();
        // testFakultaet();
        // testFibonacci();
        // testBinarySearch();
        // testReverse();
        // testCreateDivider();
        // testCountIntChar();
        // testSummArray();
        testCountChar();
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

    public static void testReverse(){
        // Über ein String / Char Array gelöst
        int i = 12345;
        System.out.println("Vor umkehrung: " + i);
        i = Reverse.reverse(i);
        System.out.println("Nach umkehrung: " + i);

        // Mathematisch gelöst
        i = 12345;
        System.out.println("Vor umkehrung: " + i);
        i = Reverse.reverseSelfmade(i);
        System.out.println("Nach umkehrung: " + i);
    }

    public static void testCreateDivider(){
        System.out.println(CreateDivider.createLine("=", 5));
        System.out.println(CreateDivider.createQuader("*", 5));
    }

    public static void testCountIntChar(){
        int i = 54135515;
        System.out.println("Die Zahl " + i + " hat " + CountChar.countChar(i) + " stellen.");
        System.out.println("Selfmade: Die Zahl " + i + " hat " + CountChar.countIntCharSelfmade(i) + " stellen.");
    }

    public static void testSummArray(){
        int[] array = {1, 2, 3, 4, 5};
        int summe = SummArray.summArray(array);
        System.out.println("Summe vom Array ist: " + summe);
    }

    public static void testCountChar(){
        String s = "hello world ";
        System.out.println("Die Zeichenkette \"" + s + "\" hat " + CountChar.countChar(s) + " stellen.");
        System.out.println("Selfmade: Die Zeichenkette \"" + s + "\" hat ohne Lehrzeichen " + CountChar.countCharWithoutWhitespaceSelfmade(s) + " stellen.");
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
