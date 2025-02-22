package ch.hftm.algorithmen.pruefungssimmulation.aufgaben;

import ch.hftm.algorithmen.pruefungssimmulation.MyBinaryTree;

public class Phonebook {
  // Wähle eine der vorgegebenen Datenstrukturen
  MyBinaryTree tree = new MyBinaryTree();

  public void addContact(String name) {
      // Neuen Kontakt speichern
      tree.insert(name);
  }

  public boolean searchContact(String name) {
      // Prüfen, ob ein Kontakt existiert
      return tree.search(name);
  }

  public void print(){
    tree.inorderTraversal();
  }

  public static void main(String[] args){
    Phonebook p = new Phonebook();
    p.addContact("A Nummer");
    p.addContact("C Nummer");
    p.addContact("B Nummer");

    System.out.println("Search: B Nummer 3 | found: " + p.searchContact("B Nummer 3"));
    p.print();
  }
}