package ch.hftm.algorithmen.pruefungssimmulation.aufgaben;

import ch.hftm.algorithmen.pruefungssimmulation.MyStack;

public class TextEditor {
  // Wähle eine der vorgegebenen Datenstrukturen
  MyStack stack = new MyStack();

  public void write(String text) {
    // Implementiere das Speichern der Änderungen
    stack.push(text);
  }

  public void undo() {
    // Implementiere das Rückgängigmachen der letzten Änderung
    stack.pop();
  }

}
