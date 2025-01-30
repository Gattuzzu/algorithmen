package ch.hftm.algorithmen.linkedList;

public class LinkedListTest {
  public static void main(String[] args){
    // SimpleLinkedList
    System.out.println("Simple Linked List");
    simpleTest1();
    simpleTest2();
    simpleTest3();
    simpleTestAufgabe2();

    // SimpleLinkedList Queue
    System.out.println("\nSimple Linked List Queue");
    simpleTestQueue();

    // SimpleLinkedList Stack
    System.out.println("\nSimple Linked List Stack");
    simpleTestStack();

    System.out.println("\n ================================================ \n");

    // LinkedList
    System.out.println("Linked List");
    test1();
    test2();
    test3();
    testAufgabe2();

    // LinkedList Queue
    System.out.println("\nLinked List Queue");
    testQueue();

    // LinkedList Stack
    System.out.println("\nLinked List Stack");
    testStack();
  }

  public static void simpleTest1(){
    SimpleLinkedListGeneric<Integer> list = new SimpleLinkedListGeneric<>();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    System.out.println(list.toString());
  
    list.reverse();
    System.out.println(list.toString());
  }

  public static void simpleTest2(){
    SimpleLinkedListGeneric<Integer> list1 = new SimpleLinkedListGeneric<>();
    list1.addLast(1);
    list1.addLast(3);
    list1.addLast(5);

    SimpleLinkedListGeneric<Integer> list2 = new SimpleLinkedListGeneric<>();
    list2.addLast(2);
    list2.addLast(4);
    list2.addLast(6);

    list1.merge(list2);
    System.out.println(list1.toString());
  }

  public static void simpleTest3(){
    SimpleLinkedListGeneric<Integer> list = new SimpleLinkedListGeneric<>();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);
    list.addLast(50);
    System.out.println(list.findNthFromEnd(2));
  }

  public static void simpleTestAufgabe2(){
    System.out.println("TEIL 0: Konstruktor + isEmpty()");
    SimpleLinkedListGeneric<Integer> list = new SimpleLinkedListGeneric<>();
    System.out.println("Ist Liste lehr? " + list.isEmpty());

    System.out.println("TEIL 1: Erstelle eine Integer Liste mit 15, 30 & 45 mit addFirst()");
    list.addFirst(45);
    list.addFirst(30);
    list.addFirst(15);

    System.out.println("TEIL 2: Datenausgabe mit toString()");
    System.out.println("Inhalt: " + list.toString());

    System.out.println("TEIL 3: Prüfe mit contains()");
    System.out.println("Enthält Liste den Wert 15? " + list.contains(15));
    System.out.println("Enthält Liste den Wert 25? " + list.contains(25));

    System.out.println("TEIL 4: Entferne mit remove()");
    System.out.println("Entferne Wert 45: " + list.remove(45));

    System.out.println("TEIL 5: Füge 50 und 60 mit addLast() hinzu");
    list.addLast(50);
    list.addLast(60);
    System.out.println("Inhalt: " + list.toString());

    System.out.println("TEIL 6: Entferne erstes Objekt mit removeFirst()");
    list.removeFirst();
    System.out.println("Inhalt: " + list.toString());

    System.out.println("TEIL 7: Entferne letztes Objekt mit removeLast()");
    list.removeLast();
    System.out.println("Inhalt: " + list.toString());
  }

  public static void simpleTestQueue(){
    SimpleLinkedListGenericQueue<Integer> queue = new SimpleLinkedListGenericQueue<>();
    queue.insert(1);
    queue.insert(2);
    queue.insert(3);
    queue.insert(4);
    queue.insert(5);
    System.out.println("Full? " + queue.isFull());
    System.out.println("Remove " + queue.remove());
    System.out.println("Grösse " + queue.size());
    System.out.println("Remove " + queue.remove());
    System.out.println("Front "  + queue.front());
    System.out.println("Remove " + queue.remove());
    System.out.println("Remove " + queue.remove());
    System.out.println("Empty? " + queue.isEmpty());
    System.out.println("Remove " + queue.remove());
    System.out.println("Empty? " + queue.isEmpty());
  }

  public static void simpleTestStack(){
    SimpleLinkedListGenericStack<Integer> stack = new SimpleLinkedListGenericStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println("Full? " + stack.isFull());
    System.out.println("Pop " + stack.pop());
    System.out.println("Grösse " + stack.size());
    System.out.println("Pop " + stack.pop());
    System.out.println("Peek "  + stack.peek());
    System.out.println("Pop " + stack.pop());
    System.out.println("Pop " + stack.pop());
    System.out.println("Empty? " + stack.isEmpty());
    System.out.println("Pop " + stack.pop());
    System.out.println("Empty? " + stack.isEmpty());
  }
  

  /* ====================================================== */

  public static void test1(){
    LinkedListGeneric<Integer> list = new LinkedListGeneric<>();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    System.out.println(list.toString());
  
    list.reverse();
    System.out.println(list.toString());
  }

  public static void test2(){
    LinkedListGeneric<Integer> list1 = new LinkedListGeneric<>();
    list1.addLast(1);
    list1.addLast(3);
    list1.addLast(5);

    LinkedListGeneric<Integer> list2 = new LinkedListGeneric<>();
    list2.addLast(2);
    list2.addLast(4);
    list2.addLast(6);

    list1.merge(list2);
    System.out.println(list1.toString());
  }

  public static void test3(){
    LinkedListGeneric<Integer> list = new LinkedListGeneric<>();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);
    list.addLast(50);
    System.out.println(list.findNthFromEnd(2));
  }

  public static void testAufgabe2(){
    System.out.println("TEIL 0: Konstruktor + isEmpty()");
    LinkedListGeneric<Integer> list = new LinkedListGeneric<>();
    System.out.println("Ist Liste lehr? " + list.isEmpty());

    System.out.println("TEIL 1: Erstelle eine Integer Liste mit 15, 30 & 45 mit addFirst()");
    list.addFirst(45);
    list.addFirst(30);
    list.addFirst(15);

    System.out.println("TEIL 2: Datenausgabe mit toString()");
    System.out.println("Inhalt: " + list.toString());

    System.out.println("TEIL 3: Prüfe mit contains()");
    System.out.println("Enthält Liste den Wert 15? " + list.contains(15));
    System.out.println("Enthält Liste den Wert 25? " + list.contains(25));

    System.out.println("TEIL 4: Entferne mit remove()");
    System.out.println("Entferne Wert 45: " + list.remove(45));

    System.out.println("TEIL 5: Füge 50 und 60 mit addLast() hinzu");
    list.addLast(50);
    list.addLast(60);
    System.out.println("Inhalt: " + list.toString());

    System.out.println("TEIL 6: Entferne erstes Objekt mit removeFirst()");
    list.removeFirst();
    System.out.println("Inhalt: " + list.toString());

    System.out.println("TEIL 7: Entferne letztes Objekt mit removeLast()");
    list.removeLast();
    System.out.println("Inhalt: " + list.toString());
  }

  public static void testQueue(){
    LinkedListGenericQueue<Integer> queue = new LinkedListGenericQueue<>();
    queue.insert(1);
    queue.insert(2);
    queue.insert(3);
    queue.insert(4);
    queue.insert(5);
    System.out.println("Full? " + queue.isFull());
    System.out.println("Remove " + queue.remove());
    System.out.println("Grösse " + queue.size());
    System.out.println("Remove " + queue.remove());
    System.out.println("Front "  + queue.front());
    System.out.println("Remove " + queue.remove());
    System.out.println("Remove " + queue.remove());
    System.out.println("Empty? " + queue.isEmpty());
    System.out.println("Remove " + queue.remove());
    System.out.println("Empty? " + queue.isEmpty());
  }

  public static void testStack(){
    LinkedListGenericStack<Integer> stack = new LinkedListGenericStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println("Full? " + stack.isFull());
    System.out.println("Pop " + stack.pop());
    System.out.println("Grösse " + stack.size());
    System.out.println("Pop " + stack.pop());
    System.out.println("Peek "  + stack.peek());
    System.out.println("Pop " + stack.pop());
    System.out.println("Pop " + stack.pop());
    System.out.println("Empty? " + stack.isEmpty());
    System.out.println("Pop " + stack.pop());
    System.out.println("Empty? " + stack.isEmpty());
  }
  
}
