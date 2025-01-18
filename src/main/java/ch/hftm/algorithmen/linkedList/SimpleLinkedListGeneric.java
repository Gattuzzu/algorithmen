package ch.hftm.algorithmen.linkedList;

public class SimpleLinkedListGeneric<T> {
  /* ======================================================
   * Innere Klasse
  ====================================================== */ 
  public class SimpleNode { // Die Generic muss nicht definiert werden, wenn es eine Innere Klasse ist. Dafür kann man die Generic aus der äusseren Klasse verwenden.
    private T object;
    private SimpleNode nextNode;
  
    private SimpleNode(T object, SimpleNode nextNode){
      this.object = object;
      this.nextNode = nextNode;
    }
  
    // Getter und Setter sind bei einer Inneren Klasse nicht notwendig, da man direkt auf die Variablen zugreiffen könnte. -> deshalb sind alle Methoden auch als Private deklariert
    private T getObject() {
      return object;
    }
  
    private void setObject(T object) {
      this.object = object;
    }
  
    private SimpleNode getNextNode() {
      return nextNode;
    }
  
    private void setNextNode(SimpleNode nextNode) {
      this.nextNode = nextNode;
    }
  
  }
  /* =================================================== */ 

  private SimpleNode rootNode;
  private int size;

  public SimpleLinkedListGeneric(){
    rootNode = null;
    size = 0;
  }

  public void addLast(T object){
    SimpleNode node = getLastNode();
    SimpleNode newNode = new SimpleNode(object, null);
    if(node == null){
      rootNode = newNode;
    } else{
      node.setNextNode(newNode);
    }
    size++;
  }
  
  public void addFirst(T object){
    SimpleNode newNode = new SimpleNode(object, rootNode);
    rootNode = newNode;
    size++;
  }

  public boolean contains(T object){
    return getIndex(object) >= 0 ? true : false;
  }

  private int getIndex(T object){
    SimpleNode node = rootNode;
    int i = 0;
    while(node != null){
      if(node.getObject() == object){
        return i;
      }
      node = node.getNextNode();
      i++;
    }
    return -1;
  }

  private T remove(int index){
    return removeInternal(get(index));
  }

  public boolean remove(T object){
    return removeInternal(object) == null ? false : true;
  }

  private T removeInternal(T object){
    SimpleNode node = rootNode;
    SimpleNode previusNode = null;
    while(node != null){
      if(node.getObject() == object){
        if(previusNode == null){
          rootNode = node.getNextNode();
        } else{
          previusNode.setNextNode(node.getNextNode());
        }
        size--;
        return node.getObject();
      }
      previusNode = node;
      node = node.getNextNode();
    }
    return null;
  }

  public T removeFirst(){
    SimpleNode node = rootNode;
    if(rootNode != null){
      rootNode = rootNode.getNextNode();
      size--;
    }
    return node.getObject();
  }

  public T removeLast(){
    return removeInternal(getLast());
  }

  public void reverse(){
    SimpleNode node = rootNode;
    SimpleNode nextNode = null;
    SimpleNode previusNode = null;
    while(node != null){
      nextNode = node.getNextNode();
      node.setNextNode(previusNode);
      previusNode = node;
      node = nextNode;
    }
    rootNode = previusNode;
  }

  public void merge(SimpleLinkedListGeneric<T> list2){
    SimpleNode firstNode1 = rootNode;
    SimpleNode firstNode2 = list2.getFirstNode();
    SimpleLinkedListGeneric<T> newList = new SimpleLinkedListGeneric<>();
    while(firstNode1 != null || firstNode2 != null){
      if(firstNode1 != null){
        newList.addLast(firstNode1.getObject());
        firstNode1 = firstNode1.getNextNode();
      }
      if(firstNode2 != null){
        newList.addLast(firstNode2.getObject());
        firstNode2 = firstNode2.getNextNode();
      }
    }
    rootNode = newList.getFirstNode();
    size = newList.size;
  }
  
  private SimpleNode getFirstNode(){
    return rootNode;
  }
  
  private SimpleNode getLastNode(){
    SimpleNode actNode = rootNode;
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
  
  public T findNthFromEnd(int n){
    return get(size - n);
  }

  public T get(int index){
    SimpleNode node = rootNode;
    int i = index;
    while(i > 0){
      if(node != null){
        node = node.getNextNode();
        i--;
      } else{
        break;
      }
    }
    if(node == null){
      return null;
    }
    return node.getObject();
  }

  public T getLast(){
    SimpleNode node = getLastNode();
    if(node != null){
      return node.getObject();
    }
    return null;
  }

  public boolean isEmpty(){
    return rootNode == null ? true : false;
  }

  private int calcSize(){
    SimpleNode node = null;
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
      SimpleNode node = rootNode;
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
