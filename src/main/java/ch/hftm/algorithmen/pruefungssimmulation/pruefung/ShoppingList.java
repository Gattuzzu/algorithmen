package ch.hftm.algorithmen.pruefungssimmulation.pruefung;

import ch.hftm.algorithmen.pruefungssimmulation.MyLinkedList;

public class ShoppingList {
  // Verwenden Sie eine verkettete Liste (z.B. MyLinkedList)
  MyLinkedList list = new MyLinkedList();

  public void addItem(String item) {
    // Artikel hinzufügen
    if(item != null){
      list.add(item);
    }
  }

  public void buyItem(String item) {
    // Gekauften Artikel entfernen
    if(item != null){
      list.remove(item);
    }
  }

  public void printAllItems() {
    // Ausgabe aller (noch) offenen Artikel
    list.printList();
  }

  public static void main(String[] args){
    ShoppingList shopList = new ShoppingList();
    shopList.addItem("A");
    shopList.addItem("B");
    shopList.addItem("C");

    shopList.buyItem("B");

    shopList.addItem("D");

    System.out.print("Aktuelle ShoppingList: ");
    shopList.printAllItems(); // Aktuelle ShoppingList: A -> C -> D -> null

    shopList.buyItem("A");
    shopList.buyItem("D");

    System.out.print("Aktuelle ShoppingList: ");
    shopList.printAllItems(); // Aktuelle ShoppingList: C -> null
  }
}
