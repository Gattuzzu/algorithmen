package ch.hftm.algorithmen.linkedList;

public class LinkedListGeneric<T> implements InterfaceLinkedListGeneric<T> {
  private Node<T> rootNode;
  private Node<T> lastNode;
  private int size;

  public LinkedListGeneric(){
    rootNode = null;
    lastNode = null;
    size = 0;
  }

  public void addLast(T object){
    Node<T> newNode = new Node<T>(object, lastNode, null);
    if(lastNode != null){
      lastNode.setNextNode(newNode);
    } else{
      // Wenn keine lastNode besteht, dann geht man davon aus, dass auch keine rootNode besteht
      rootNode = newNode;
    }
    lastNode = newNode;
    size++;
  }

  public void addFirst(T object) {
    Node<T> newNode = new Node<>(object, null, rootNode);
    if(rootNode != null){
      rootNode.setPreviusNode(newNode);
    } else{
      // Wenn keine rootNode besteht, dann geht man davon aus, dass auch keine lastNode besteht
      lastNode = newNode;
    }
    rootNode = newNode;
    size++;
  }

  public boolean contains(T object) {
    return getNodeInternal(object, false) != null;
  }

  public boolean remove(T object) {
    return removeInternal(object, false);
  }

  private boolean removeInternal(T object, boolean backwards) {
    Node<T> node = getNodeInternal(object, backwards);

    if(node != null){
      Node<T> previusNode = node.getPreviusNode();
      Node<T> nextNode = node.getNextNode();
      if(previusNode != null){
        previusNode.setNextNode(nextNode);
      } else{
        // wenn die previusNode null ist, dann ist klar, dass das gesuchte Object im ersten Platz der LinkedListe ist
        rootNode = nextNode;
      }

      if(nextNode != null){
        nextNode.setPreviusNode(previusNode);
      } else{
        // wenn die nextNode null ist, dann ist klar, dass das gesuchte Object im letzten Platz der LinkedListe ist
        lastNode = previusNode;
      }

      size--;
      return true;
    }

    return false;
  }

  public T removeFirst() {
    T object = getFirst();
    removeInternal(object, false);
    return object;
  }

  public T removeLast() {
    T object = getLast();
    removeInternal(object, true);
    return object;
  }

  public void clear() {
    rootNode = null;
    lastNode = null;
    size = 0;
  }

  public void reverse(){
    Node<T> node = rootNode;
    while(node != null){
      Node<T> oldNextNode = node.getNextNode();
      node.setNextNode(node.getPreviusNode());
      node.setPreviusNode(oldNextNode);
      node = oldNextNode;
    }
    Node<T> oldRootNode = rootNode;
    rootNode = lastNode;
    lastNode = oldRootNode;
  }

  public void merge(InterfaceLinkedListGeneric<T> list2) {
    LinkedListGeneric<T> newList = new LinkedListGeneric<>();
    while(!isEmpty() || !list2.isEmpty()){
      if(!      isEmpty()){ newList.addLast(      removeFirst()); }
      if(!list2.isEmpty()){ newList.addLast(list2.removeFirst()); }
    }
    rootNode = newList.getFirstNode();
    size = newList.size();
  }

  private Node<T> getFirstNode(){
    return rootNode;
  }

  private Node<T> getLastNode(){
    return lastNode;
  }

  public T getFirst(){
    if(rootNode != null){
      return rootNode.getObject();
    }
    return null;
  }

  public T findNthFromEnd(int n) {
    Node<T> node = lastNode;
    int i = n - 1;
    while(node != null && i > 0){
      node = node.getPreviusNode();
      i--;
    }

    if(node == null){
      return null;
    }

    return node.getObject();
  }

  public T get(int index) {
    Node<T> node = rootNode;
    int i = index;
    while(node != null && i > 0){
      node = node.getNextNode();
      i--;
    }

    if(node == null){
      return null;
    }

    return node.getObject();
  }

  public T getLast(){
    if(lastNode != null){
      return lastNode.getObject();
    }
    return null;
  }
  
  
  public boolean isEmpty(){
    return rootNode == null ? true : false;
  }

  private int calcSize(){
    Node<T> node = rootNode;
    int size = 0;
    while(node != null){
      size++;
      node = node.getNextNode();
    }
    return size;
  }

  public int size(){
    return size;
  }

  private Node<T> getNodeInternal(T object, boolean backwards){
    Node<T> node = backwards ? getLastNode() : getFirstNode();
    while(node != null && object != node.getObject()){
      node = backwards ? node.getPreviusNode() : node.getNextNode();
    }
    return node;
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
