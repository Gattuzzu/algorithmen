package ch.hftm.algorithmen.linkedList;

import java.util.Iterator;

public class SimpleLinkedListGeneric<T> implements InterfaceLinkedListGeneric<T>, Iterable<T>{
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

  /* ======================================================
   * Innere Klasse für das Interface Iterable
  ====================================================== */
  public class NodeIterator implements Iterator<T>{
    private int iteratorIndex = 0;

    @Override
    public boolean hasNext() {
      return iteratorIndex < size;
    }

    @Override
    public T next() {
      return get(iteratorIndex++);
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
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      // return null;

    } else{
      SimpleNode node = rootNode;
      rootNode = rootNode.getNextNode();
      size--;
      return node.getObject();
    }
  }

  public T removeLast(){
    return removeInternal(getLast());
  }

  public void clear(){
    rootNode = null;
    size = 0;
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

  public void merge(InterfaceLinkedListGeneric<T> list2) {
    SimpleLinkedListGeneric<T> newList = new SimpleLinkedListGeneric<>();
    while(!isEmpty() || !list2.isEmpty()){
      if(!      isEmpty()){ newList.addLast(      removeFirst()); }
      if(!list2.isEmpty()){ newList.addLast(list2.removeFirst()); }
    }
    rootNode = newList.getFirstNode();
    size = newList.size();
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
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      // return null;
    }
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
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      // return null;

    } else{
      SimpleNode node = getLastNode();
      return node.getObject();
    }
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
    Iterator<T> iterator = iterator();
    while(iterator.hasNext()){
      s.append(iterator.next());
      if(iterator.hasNext()){
        s.append(" -> ");
      }
    }
    return s.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new NodeIterator();
  }


}
