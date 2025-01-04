package ch.hftm.algorithmen.arbeitenMitDatenbufferung;

import ch.hftm.algorithmen.datenbufferung.ArrayStackGeneric;

public class StringRevers {
  public static String reverseString(String input){
    ArrayStackGeneric<Character> stack = new ArrayStackGeneric<>(input.length());

    // for(int i = 0; i < input.length(); i++){
    //   stack.push(input.charAt(i));
    // }
    for(char c : input.toCharArray()){
      stack.push(c);
    }

    StringBuilder stringBuilder = new StringBuilder();
    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }
    return stringBuilder.toString();
  }
  
}
