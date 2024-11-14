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
import java.util.stream.Stream;

import ch.hftm.algorithmen.algorithmen.BinarySearch;
import ch.hftm.algorithmen.algorithmen.LinearSearch;
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
        testSelectionSort();
    }

    // Testmethoden
    public static void testLinearSearch(){
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
        List<Integer> list = randomList(11, 20);
        ausgabe(list);

        System.out.println("\nSortierte Liste:");
        SelectionSort.selectionSort(list);
        ausgabe(list);

        System.out.println("\nRückwärtssortierte Liste:");
        SelectionSort.reverse(list);
        ausgabe(list);
    }


    // Hielfs Methoden
    private static void ausgabe(List<Integer> list){
        for(Integer i : list){
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