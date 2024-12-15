package ch.hftm.algorithmen.datenbufferung;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack <T>{
  private List<T> stack;

  public ArrayListStack(){
    stack = new ArrayList<>();
  }

  public void push(T item){
    stack.add(item);
  }

  public T pop(){
    return stack.removeLast();
  } 

  public boolean empty(){
    return stack.isEmpty();
  }

  public boolean full(){
    // Eine ArrayListe ist niemals voll, da sie Dynamisch wächst
    return false;
  }
  
}
