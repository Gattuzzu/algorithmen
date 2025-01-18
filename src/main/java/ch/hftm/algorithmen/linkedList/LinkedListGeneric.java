package ch.hftm.algorithmen.linkedList;

public class LinkedListGeneric<T> {
  private Node<T> rootNode;
  private Node<T> lastNode;
  private int size;

  public LinkedListGeneric(){
    rootNode = null;
    lastNode = null;
  }

  public void add(T object){
    Node<T> node = getLastNode();
    Node<T> newNode = new Node<T>(object, node, null);
    if(node == null){
      rootNode = newNode;
    } else{
      node.setNextNode(newNode);
    }
    lastNode = newNode;
  }

  public void reverse(){
    Node<T> node = rootNode;
    while(node != null){
      Node<T> nextNode = node.getNextNode();
      node.setNextNode(node.getPreviusNode());
      node.setPreviusNode(nextNode);
      node = nextNode;
    }
    Node<T> newLastNode = rootNode;
    rootNode = lastNode;
    lastNode = newLastNode;
  }

  private Node<T> getFirstNode(){
    return rootNode;
  }

  private Node<T> getLastNode(){
    return lastNode;
  }

  private Node<T> calcLastNode(){
    Node<T> node = null;
    if(rootNode != null){
      node = rootNode;
      while(node.getNextNode() != null){
        node = node.getNextNode();
      }
    }
    return node;
  }

  public T getFirst(){
    return rootNode.getObject();
  }

  public T getLast(){
    T object = null;
    Node<T> node = getLastNode();
    if(node != null){
      object = node.getObject();
    }
    return object;
  }

  public boolean isEmpty(){
    return rootNode == null ? true : false;
  }

  private int calcSize(){
    Node<T> node = null;
    int size = 0;
    if(rootNode != null){
      node = rootNode;
      size++;
      while(node.getNextNode() != null){
        node = node.getNextNode();
        size++;
      }
    }
    return size;
  }

  public int size(){
    return size;
  }

  public String toString(){
    StringBuilder s = new StringBuilder();
    if(rootNode != null){
      Node<T> node = rootNode;
      s.append(node.getObject().toString());
      while(node.getNextNode() != null){
        node = node.getNextNode();
        s.append(" -> ");
        s.append(node.getObject().toString());
      }
    }
    return s.toString();
  }
}
