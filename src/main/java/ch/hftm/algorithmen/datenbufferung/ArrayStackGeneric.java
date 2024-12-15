package ch.hftm.algorithmen.datenbufferung;

public class ArrayStackGeneric<T>{
  private T[] stack;
  private int actIndex;

  public ArrayStackGeneric(int size){
    // Ein Generisches Objekt kann nicht instanziert werden.
    // Deshalb wird ein Array vom Typ Object instanziert und dann in ein Arry vom Typ T gecastet
    stack = (T[]) new Object[size];
    actIndex = 0;
  }

  public void push(T item){
    if (isFull()){
      throw new ArrayIndexOutOfBoundsException("ArrayStack voll!");
    }
    stack[actIndex++] = item;
  }

  public T pop(){
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArrayStack lehr!");
      // return null;
    }
    T item = stack[--actIndex];
    stack[actIndex] = null;
    return item;
  } 

  public boolean isEmpty(){
    return (actIndex == 0);
  }

  public boolean isFull(){
    return (stack.length == actIndex);
  }
}
