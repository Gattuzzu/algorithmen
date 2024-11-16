package ch.hftm.algorithmen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import ch.hftm.algorithmen.algorithmen.BinarySearch;
import ch.hftm.algorithmen.algorithmen.BubbleSort;
import ch.hftm.algorithmen.algorithmen.LinearSearch;
import ch.hftm.algorithmen.algorithmen.LinearSort;
import ch.hftm.algorithmen.algorithmen.MergeSort;
import ch.hftm.algorithmen.algorithmen.SelectionSort;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Random random = new Random();

    public static void main(String[] args) {
        //launch();

        // testLinearSearch();
        // testBinarySearch();
        // testSelectionSort();
        // testLinearSort();
        // testBubbleSort();
        // zeitTest();

        // Rekursiv
        RekursivTest.test();
    }

    // Testmethoden
    public static void testLinearSearch(){
        System.out.println("\nLinearSearch Testen\n");
        List<Integer> list = randomList(20, 15);
        ausgabe(list);

        int zahl = 10;
        int index = LinearSearch.linearSearch(list, zahl);
        if (index != -1){
            System.out.println("\nZahl " + zahl + " ist in Index vorhanden: " + index);
        } else{
            System.out.println("\nZahl " + zahl + " ist nicht in der List.");
        }

        System.out.println("\nZahl " + zahl + " ist in folgenden Indexen vorhanden: ");
        List<Integer> matches = LinearSearch.linearSearchAllMatches(list, zahl);
        ausgabe(matches);

    }

    public static void testBinarySearch(){
        System.out.println("\nBinarySearch Testen\n");
        List<Integer> list = new ArrayList<>();
        int origListSize = 10;
        for(int i = 0; i < origListSize; i++){
            list.add(i);
        }
        
        for(int i = 0; i < origListSize; i++){
            int index = BinarySearch.binarySearch(list, i);
            if(index != -1){
                System.out.println(list.get(index));
            } else{
                System.out.println("Zahl " + i + " nicht gefunden.");
            }
        }

        System.out.println("\nNächste Zahl suchen:");
        list.remove(9); // Letzte Zahl
        list.remove(5); // zwei Zahlen zusammen
        list.remove(4); // zwei Zahlen zusammen
        list.remove(2); // einzelne Zahl
        list.remove(0); // erste Zahl
        for(int i = 0; i < origListSize; i++){
            int index = BinarySearch.binarySearchForClosestMatch(list, i);
            System.out.println("Die Nächste zahl zu " + i + " ist: " +list.get(index));
        }
    }

    public static void testSelectionSort(){
        System.out.println("\nSelectionSearch Testen\n");
        List<Integer> list = randomList(11, 20);
        ausgabe(list);

        System.out.println("\nSortierte Liste:");
        SelectionSort.selectionSort(list);
        ausgabe(list);

        System.out.println("\nRückwärtssortierte Liste:");
        SelectionSort.reverse(list);
        ausgabe(list);
    }

    public static void testLinearSort(){
        System.out.println("\nLinearSort Testen\n");
        List<Integer> list = randomList(10, 20);
        ausgabe(list);

        System.out.println("\nSortierte Liste:");
        LinearSort.linearSort(list);
        ausgabe(list);

        System.out.println("\nRückwärtssortierte Liste:");
        LinearSort.reverse(list);
        ausgabe(list);
    }

    public static void testBubbleSort(){
        System.out.println("\nBubbleSort Testen\n");
        List<Integer> list = randomList(10, 20);
        ausgabe(list);

        System.out.println("\nSortierte Liste:");
        BubbleSort.bubbleSort(list);
        ausgabe(list);
    }

    public static void zeitTest(){
        long startTime = 0;
        long endTime = 0;
        int[] origArray = IntStream.generate(() -> new Random().nextInt(100_000)).limit(10_000).toArray();
        int[] array;
        // ausgabe(origArray);

        array = origArray.clone();
        startTime = System.nanoTime();
        LinearSort.linearSort(array);
        endTime = System.nanoTime();
        System.out.println("LinearSort: " + ((endTime - startTime) / 1000_000.0) + "ms"); // Umgerechnet in Millisekunden
        // ausgabe(array);

        array = origArray.clone();
        startTime = System.nanoTime();
        SelectionSort.selectionSort(array);
        endTime = System.nanoTime();
        System.out.println("SelectionSort: " + ((endTime - startTime) / 1000_000.0) + "ms"); // Umgerechnet in Millisekunden
        // ausgabe(array);

        array = origArray.clone();
        startTime = System.nanoTime();
        BubbleSort.bubbleSort(array);
        endTime = System.nanoTime();
        System.out.println("BubbleSort: " + ((endTime - startTime) / 1000_000.0) + "ms"); // Umgerechnet in Millisekunden
        // ausgabe(array);

        array = origArray.clone();
        startTime = System.nanoTime();
        MergeSort.mergeSort(array);
        endTime = System.nanoTime();
        System.out.println("MergeSort: " + ((endTime - startTime) / 1000_000.0) + "ms"); // Umgerechnet in Millisekunden
        // ausgabe(array);

    }


    // Hielfs Methoden
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

    private static List<Integer> randomList(int anzZahlen, int maxRandomZahl){
        List<Integer> list = new ArrayList<>();
        Stream.generate(() -> random.nextInt(maxRandomZahl)).limit(anzZahlen).forEach(list::add); // Der Stream macht das selbe wie die Vorschleife
        // for(int i = 0; i < anzZahlen; i++){
        //     list.add(random.nextInt(maxRandomZahl));
        // }
        return list;
    }
















    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setSceneRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

}