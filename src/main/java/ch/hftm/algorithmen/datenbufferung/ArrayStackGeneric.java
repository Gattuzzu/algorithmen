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
    T item = peek(); // actIndex wird in der Methode nicht verändert.
    stack[--actIndex] = null;
    return item;
  } 

  public T peek(){
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArrayStack lehr!");
      // return null;
    }
    T item = stack[actIndex - 1];
    return item;
  }

  public boolean isEmpty(){
    return (actIndex == 0);
  }

  public boolean isFull(){
    return (stack.length == actIndex);
  }

  public int size(){
    // Act Index ist immer auf dem nächst höheren Index um ein Objekt direkt hinzuzufügen. Deshalb stimmt der actIndex mit der Size überein
    return actIndex; 
  }
}
