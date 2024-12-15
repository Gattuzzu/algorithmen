package ch.hftm.algorithmen.datenbufferung;

import java.io.IOException;
import java.util.Scanner;

/**
 * TestArrayQueue Die Klasse "TestArrayQueue" testet und illustriert die
 * Funktionalitäten einer mittels eines Object-Arrays realisierten Queue.
 */
public class TestArrayQueue {

  // Klassenmethoden

  /**
   * "menu" zeigt auf dem Bildschirm die möglichen Funktionalitäten einer Queue
   * an.
   */
  static void menu() {
    System.out.println("(1) Element einfuegen  (insert)");
    System.out.println("(2) Element entfernen  (remove)");
    System.out.println("(e) Programm beenden\n");
    System.out.print("    Deine Wahl: ");
  }

  /**
   * "main" testet und illustriert die Funktionalitäten einer auf einem Array
   * basierenden Queue.
   */
  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in); // Eingabestrom

    InterfaceQueue integerQueue = new ArrayQueueRingBuffer(); // Queue erzeugen
    Integer integerItem; // in Queue einge-
                // lagerte Elemente
    // Testen der Funktionalitäten

    System.out.println("\n\n");
    menu();
    String wahl = sc.nextLine();
    while (!wahl.equals("e")) { // Auswahlschleife
      System.out.println("\n");
      switch (wahl) {
      case "1":
        try {
          System.out.print("Eingabe eines Integerwertes: ");
          integerQueue.insert(Integer.parseInt(sc.nextLine()));
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("\nFehler: " + e.getMessage());
        }
        break;
      case "2":
        integerItem = (Integer) integerQueue.remove();
        if (integerItem == null)
          System.out.println("Aus der Queue " + "konnte kein Element entfernt " + "werden !");
        else
          System.out.println("Entferntes Element: " + integerItem.toString());
        break;
      default:
        System.out.println("Deine Menu-Wahl ist ungueltig !");

      }
      System.out.println("\n");
      System.out.println(integerQueue);
      System.out.print("Queuestatus:   ");
      System.out.print("die Queue ist ");
      if (!integerQueue.isEmpty())
        System.out.print("nicht ");
      System.out.println("leer!");
      System.out.println("\n\n");
      menu();
      wahl = sc.nextLine();
    }
    System.out.println("\n\nDas Programm wurde durch " + "den Benutzer beendet !\n");
    sc.close();
  }

}
