package ch.hftm.algorithmen.datenbufferung;

import java.io.IOException;
import java.util.Scanner;

/**
 * TestArrayStack Die Klasse "TestArrayStack" testet und illustriert die
 * Funktionalitäten eines mittels eines Object-Arrays realisierten Stapels.
 */
public class TestArrayStack {

  // Klassenmethoden

  /**
   * "menu" zeigt auf dem Bildschirm die möglichen Funktionalitäten eines Stacks
   * an.
   */
  static void menu() {
    System.out.println("(1) Element einfuegen  (push)");
    System.out.println("(2) Element entfernen  (pop)");
    System.out.println("(e) Programm beenden\n");
    System.out.print("    Deine Wahl: ");
  }

  /**
   * "main" testet und illustriert die Funktionalitäten eines auf einem Array
   * basierenden Stacks.
   */
  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in); // Eingabestrom

    ArrayStack integerStack = new ArrayStack(); // Stack erzeugen
    Integer integerItem; // im Stack einge-
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
          integerStack.push(Integer.parseInt(sc.nextLine()));
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("\nFehler: " + e.getMessage());
        }
        break;
      case "2":
        integerItem = (Integer) integerStack.pop();
        if (integerItem == null)
          System.out.println("Aus dem Stack konnte kein Element " + "entfernt werden !");
        else
          System.out.println("Entferntes Element: " + integerItem.toString());
        break;
      default:
        System.out.println("Deine Menu-Wahl ist ungueltig !");
      }
      System.out.println("\n");
      System.out.println(integerStack);
      System.out.print("Stackstatus:   ");
      System.out.print("der Stack ist ");
      if (!integerStack.isEmpty())
        System.out.print("nicht ");
      System.out.println("leer!");
      System.out.println("\n\n");
      menu();
      wahl = sc.nextLine();
    }
    System.out.println("\n\nDas Programm wurde durch den Benutzer beendet !\n");
    sc.close();
  }

}
