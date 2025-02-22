package ch.hftm.algorithmen.pruefungssimmulation.aufgaben;

import ch.hftm.algorithmen.pruefungssimmulation.MyStack;

public class BrowserHistory {
  // Wähle eine der vorgegebenen Datenstrukturen
  MyStack forward = new MyStack();
  MyStack backward = new MyStack();
  String currentPage = "";

  public void visit(String url) {
    // Neue Seite hinzufügen
    backward.push(currentPage);
    forward = new MyStack(); // Stack lehren
    currentPage = url;
  }

  public void back() {
    // Zur vorherigen Seite wechseln
    forward.push(currentPage);
    currentPage = backward.pop();
  }

  public void forward() {
    // Zur nächsten Seite wechseln
    backward.push(currentPage);
    currentPage = forward.pop();
  }

  public String getCurrentPage() {
    return currentPage;
  }

  public static void main(String[] args) {
    BrowserHistory history = new BrowserHistory();
    history.visit("google.com");
    history.visit("github.com");
    history.visit("stackoverflow.com");
   
    System.out.println("Aktuelle Seite: " + history.getCurrentPage()); // stackoverflow.com
    history.back();
    System.out.println("Zurück: " + history.getCurrentPage()); // github.com
    history.back();
    System.out.println("Zurück: " + history.getCurrentPage()); // google.com
    history.forward();
    System.out.println("Vorwärts: " + history.getCurrentPage()); // github.com
    history.forward();
    System.out.println("Vorwärts: " + history.getCurrentPage()); // stackoverflow.com
  }
}
