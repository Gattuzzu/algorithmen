package ch.hftm.algorithmen.linkedList;

public class SimpleLinkedListGeneric<T> {
  private SimpleNode<T> rootNode;
  private int size;

  public SimpleLinkedListGeneric(){
    rootNode = null;
    size = 0;
  }

  public void add(T object){
    SimpleNode<T> node = getLastNode();
    SimpleNode<T> newNode = new SimpleNode<>(object, null);
    if(node == null){
      rootNode = newNode;
    } else{
      node.setNextNode(newNode);
    }
    size++;
  }

  public void reverse(){
    SimpleNode<T> node = rootNode;
    SimpleNode<T> nextNode = null;
    SimpleNode<T> previusNode = null;
    while(node != null){
      nextNode = node.getNextNode();
      node.setNextNode(previusNode);
      previusNode = node;
      node = nextNode;
    }
    rootNode = previusNode;
  }

  // public void merge(LinkedListGeneric<T> list2){
  //   SimpleNode<T> firstNode1 = rootNode;
  //   SimpleNode<T> firstNode2 = list2.getFirstNode();
  //   LinkedListGeneric<T> newList = new LinkedListGeneric<>();
  //   while(firstNode1 != null || firstNode2 != null){
  //     if(firstNode1 != null){
  //       newList.add(firstNode1.getObject());
  //       firstNode1 = firstNode1.getNextNode();
  //     }
  //     if(firstNode2 != null){
  //       newList.add(firstNode2.getObject());
  //       firstNode2 = firstNode2.getNextNode();
  //     }
  //   }
  //   rootNode = newList.getFirstNode();
  //   lastNode = newList.getLastNode();
  //   size = newList.size;
  // }


  private SimpleNode<T> getFirstNode(){
    return rootNode;
  }

  private SimpleNode<T> getLastNode(){
    SimpleNode<T> actNode = rootNode;
    if(rootNode != null){
      while(actNode.getNextNode() != null){
        actNode = actNode.getNextNode();
      }
    }
    return actNode;
  }

  public T getFirst(){
    return rootNode.getObject();
  }

  public T getLast(){
    T object = null;
    SimpleNode<T> node = getLastNode();
    if(node != null){
      object = node.getObject();
    }
    return object;
  }

  public boolean isEmpty(){
    return rootNode == null ? true : false;
  }

  private int calcSize(){
    SimpleNode<T> node = null;
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
      SimpleNode<T> node = rootNode;
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
