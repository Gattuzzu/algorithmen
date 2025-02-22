package ch.hftm.algorithmen.pruefungssimmulation.aufgaben;

import ch.hftm.algorithmen.pruefungssimmulation.MyQueue;

public class SupermarketQueue {
  // Wähle eine der vorgegebenen Datenstrukturen
  MyQueue queue = new MyQueue();

  public void addCustomer(String name) {
    queue.enqueue(name);
  }

  public String serveCustomer() {
    // Kunde aus der Warteschlange entfernen und zurückgeben
    return queue.dequeue();
  }

  public static void main(String[] args){
    SupermarketQueue q = new SupermarketQueue();
    q.addCustomer("Customer 1");
    q.addCustomer("Customer 2");
    q.addCustomer("Customer 3");

    System.out.println("Nächster Kunde: " + q.serveCustomer());
    System.out.println("Nächster Kunde: " + q.serveCustomer());
    System.out.println("Nächster Kunde: " + q.serveCustomer());
    
  }
}
