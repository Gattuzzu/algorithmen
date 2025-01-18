package ch.hftm.algorithmen.linkedList;

public class SimpleNode<T> {
  private T object;
  private SimpleNode<T> nextNode;

  public SimpleNode(T object, SimpleNode<T> nextNode){
    this.object = object;
    this.nextNode = nextNode;
  }

  public T getObject() {
    return object;
  }

  public void setObject(T object) {
    this.object = object;
  }

  public SimpleNode<T> getNextNode() {
    return nextNode;
  }

  public void setNextNode(SimpleNode<T> nextNode) {
    this.nextNode = nextNode;
  }

}

