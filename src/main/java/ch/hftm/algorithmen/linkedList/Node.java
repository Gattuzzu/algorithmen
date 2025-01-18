package ch.hftm.algorithmen.linkedList;

public class Node<T> {
  private T object;
  private Node<T> previusNode;
  private Node<T> nextNode;

  public Node(T object, Node<T> previusNode, Node<T> nextNode){
    this.object = object;
    this.previusNode = previusNode;
    this.nextNode = nextNode;
  }

  public T getObject() {
    return object;
  }

  public void setObject(T object) {
    this.object = object;
  }

  public Node<T> getPreviusNode() {
    return previusNode;
  }

  public void setPreviusNode(Node<T> previusNode) {
    this.previusNode = previusNode;
  }

  public Node<T> getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node<T> nextNode) {
    this.nextNode = nextNode;
  }

}
