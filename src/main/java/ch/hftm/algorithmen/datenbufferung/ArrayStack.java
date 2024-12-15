package ch.hftm.algorithmen.datenbufferung;

public class ArrayStack extends ArrayStackGeneric<Object>{

  public ArrayStack(int size){
    super(size);
  }

  public ArrayStack(){
    this(5);
  }

}
