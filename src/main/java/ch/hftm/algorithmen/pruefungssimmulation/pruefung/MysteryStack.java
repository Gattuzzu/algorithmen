package ch.hftm.algorithmen.pruefungssimmulation.pruefung;

import ch.hftm.algorithmen.pruefungssimmulation.MyStack;

public class MysteryStack {
  public static int countOccurrences(MyStack stack, String value) {
    // TODO: Zählt, wie oft 'value' im Stack vorkommt
    // Achtung: pop() entfernt Elemente!
    int anzahl = 0;
    MyStack tempStack = new MyStack();

    String s = stack.pop();
    while (s != null){
      if(s.equals(value)){
        anzahl++;
      }
      tempStack.push(s);
      s = stack.pop();
    }

    s = tempStack.pop();
    while(s != null){
      stack.push(s);
      s = tempStack.pop();
    }
    return anzahl;
  }

  public static void printStack(MyStack stack) {
    // TODO: Gibt den Inhalt des Stacks von oben nach unten aus,
    // ohne ihn zu verändern.
    MyStack tempStack = new MyStack();
    
    String s = stack.pop();
    while (s != null){
      tempStack.push(s);
      System.out.print(s + " -> ");
      s = stack.pop();
    }
    System.out.println("null");

    s = tempStack.pop();
    while(s != null){
      stack.push(s);
      s = tempStack.pop();
    }
  }

  public static void main(String[] args) {
      MyStack myStack = new MyStack();
      myStack.push("A");
      myStack.push("B");
      myStack.push("A");
      myStack.push("C");
      
      System.out.print("Stack-Inhalt: ");
      printStack(myStack);
      // Ausgabe:
      // Stack-Inhalt: C -> A -> B -> A -> null
      
      int countA = countOccurrences(myStack, "A");
      System.out.println("Anzahl 'A': " + countA);
      // Ausgabe:
      // Anzahl 'A': 2
      
      myStack.pop();
      
      System.out.print("Neuer Stack-Inhalt: ");
      printStack(myStack);
      // Ausgabe:
      // A -> B -> A -> null
  }
}