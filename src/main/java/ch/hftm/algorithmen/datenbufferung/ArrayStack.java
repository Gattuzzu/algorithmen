package ch.hftm.algorithmen.datenbufferung;

public class ArrayStack{
  private Object[] stack;
  private int actIndex;

  public ArrayStack(int size){
    stack = new Object[size];
    actIndex = 0;
  }

  public ArrayStack(){
    this(5);
  }

  public void push(Object item){
    if (isFull()){
      throw new ArrayIndexOutOfBoundsException("ArrayStack voll!");
    }
    stack[actIndex++] = item;
  }

  public Object pop(){
    if (isEmpty()){
      // throw new ArrayIndexOutOfBoundsException("ArrayStack lehr!");
      return null;
    }
    Object item = stack[--actIndex];
    stack[actIndex] = null;
    return item;
  } 

  public boolean isEmpty(){
    return (actIndex == 0);
  }

  public boolean isFull(){
    return (actIndex == stack.length);
  }
}
