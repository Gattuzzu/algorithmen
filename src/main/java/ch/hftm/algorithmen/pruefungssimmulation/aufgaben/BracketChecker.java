package ch.hftm.algorithmen.pruefungssimmulation.aufgaben;

import ch.hftm.algorithmen.pruefungssimmulation.MyStack;

public class BracketChecker {
  // Wähle eine der vorgegebenen Datenstrukturen
  MyStack stack = new MyStack();

  public boolean isValid(String expression) {
    // Implementiere die Klammerprüfung
    boolean balanced = true;
    for(char c : expression.toCharArray()){
      if(c == '(' || c == '[' || c == '{'){
        stack.push(String.valueOf(c));

      } else if(c == ')' || c == ']' || c == '}'){
        char sibling = stack.pop().charAt(0);
        if(c == ')' && sibling != '(' ||
           c == ']' && sibling != '[' ||
           c == '}' && sibling != '{'){

          balanced = false;
          break;
        }
      }
    }
    return balanced;
  }

  public static void main(String[] args){
    String s = "(adt + zx || [a] {[sowieso ]})";
    BracketChecker bc = new BracketChecker();
    System.out.println("isValid: " + bc.isValid(s));
  }
}
