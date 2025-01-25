package ch.hftm.algorithmen.datenbufferung;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack <T> implements InterfaceStackGeneric<T>{
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

  public boolean isEmpty(){
    return stack.isEmpty();
  }

  public boolean isFull(){
    // Eine ArrayListe ist niemals voll, da sie Dynamisch wächst
    return false;
  }

  @Override
  public T peek() {
    return stack.getLast();
  }

  @Override
  public int size() {
    return stack.size();
  }
  
}
