package ch.hftm.algorithmen.arbeitenMitDatenbufferung;

import ch.hftm.algorithmen.datenbufferung.ArrayStackGeneric;

public class StringChecker {
  
  public static boolean sindKlammernAusgeglichen(String expression){
    ArrayStackGeneric<Character> stack = new ArrayStackGeneric<>(expression.length());
    for(char c : expression.toCharArray()){
      if(c == '(' || c == '{' || c == '['){
        stack.push(c);
      } else if(c == ')' || c == '}' || c == ']'){
        if(stack.isEmpty()){
          // Diese Abfrage muss hier rein, damit geprüft werden kann, ob weniger geöffnete Klammern geschrieben wurden, wie geschlossen werden.
          return false;
        }
        char testc = stack.pop();
        if (testc == '(' && c != ')' || 
            testc == '{' && c != '}' || 
            testc == '[' && c != ']'){
          return false;
        }
      }
    }
    // Hier muss noch auf Empty abgefragt werden. Wenn er noch Klammern im Stack hat, dann gibt es geöffnete Klammern, welche nicht geschlossen wurden.
    return stack.isEmpty();
  }
  
}
