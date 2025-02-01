package ch.hftm.algorithmen.baum;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * TestBinaryTree Die Klasse "TestBinaryTree" überprüft die Funktionalitäten der
 * Klasse "BinaryTree" im Hinblick auf ihre Korrektheit.
 */
public class TestBinaryTree {

  // Klassenmethoden

  /**
   * "menu" zeigt auf dem Bildschirm die möglichen Funktionalitäten eines
   * binären Baumes an, * welche implementiert worden sind.
   */
  static void menu() {
    System.out
        .println("(1) Illustrationsbaum erzeugen (array2BTree)\n"
            + "(2) Element suchen (contains)\n"
            + "(3) Element einfügen (insert)\n"
            + "(4) Element entfernen (remove)\n"
            + "(e) Programm beenden\n");
    System.out.print("    Ihre Wahl: ");
  }

  /**
   * "main" testet und illustriert die Funktionalitäten eines binären
   * Baumes.
   */
  public static void main(String[] args) throws IOException {

    // Eingabestrom
    Scanner in = new Scanner(System.in);

    // binären Baum erzeugen
    BinaryTree<Integer> container = new BinaryTree<Integer>();

    // Testen der Funktionalitäten
    System.out.println("\n\n");
    menu();
    String wahl = in.next().toUpperCase();
    while (!wahl.equals("E")) { // Auswahlschleife
      System.out.println("\n");
      switch (wahl) {
        // Illustrationsbaum erzeugen
        case "1":
          Integer[] data = { 15, 8, 25, 12, 13, 18, 17, 21, 30, 34, 32, 31, 33, 10, 9, 5 };
          container.array2BTree(data);
          break;
        // Element im Baum suchen
        case "2":
          System.out.print("Eingabe eines Integerwertes: ");
          if (container.contains(in.nextInt()))
            System.out.println("\nDas gesuchte Nutzdatum ist im "
                + "Baum enthalten!");
          else
            System.out.println("\nDas gesuchte Nutzdatum wurde im "
                + "Baum nicht gefunden!");
          break;
        // Element in den binären Baum einfügen
        case "3":
          try {
            System.out.print("Eingabe eines Integerwertes: ");
            container.insert(in.nextInt());
          } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
          }
          break;
        // Element aus dem binären Baum entfernen
        case "4":
          try {
            System.out
                .print("Eingabe des zu entfernenden Integerwertes: ");
            container.remove(in.nextInt());
          } catch (NoSuchElementException e) {
            System.out.println("\n" + e.getMessage());
          }
          break;
        default:
          System.out.println("Ihre Menu-Wahl ist ungueltig !");
      }
      System.out.println();
      System.out.println("\nAusgabe des binären Baumes");
      System.out.println("--------------------------");
      System.out.println(container);
      System.out.println("\nSpezielle Elemente:");
      System.out.println("------------------");
      try {
        System.out.println("Kleinstes Element: "
            + container.minElement());
      } catch (NoSuchElementException e) {
        System.out.println(e.getMessage());
      }
      try {
        System.out.println("Grösstes Element:  "
            + container.maxElement());
      } catch (NoSuchElementException e) {
        System.out.println(e.getMessage());
      }
      System.out.println("\nTraversierungen:");
      System.out.println("---------------");
      System.out.print("preorder:   ");
      System.out.println(container.traverse(BinaryTree.PREORDER));
      System.out.print("inorder:    ");
      System.out.println(container.traverse(BinaryTree.INORDER));
      System.out.print("postorder:  ");
      System.out.println(container.traverse(BinaryTree.POSTORDER));
      System.out.println("\n\n");

      menu();
      wahl = in.next().toUpperCase();
    }

    if (in != null) {
      in.close();
    }

    System.out.println("\n\nDas Programm wurde durch den Benutzer beendet !\n");
  }

}
