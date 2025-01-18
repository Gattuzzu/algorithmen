package ch.hftm.algorithmen.linkedList;

public class LinkedListTest {
  public static void main(String[] args){
    // SimpleLinkedList
    System.out.println("Simple Linked List");
    simpleTest1();

    // LinkedList
    System.out.println("\nLinked List");
    test1();
    test2();
  }

  public static void simpleTest1(){
    SimpleLinkedListGeneric<Integer> list = new SimpleLinkedListGeneric<>();
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list.toString());
  
    list.reverse();
    System.out.println(list.toString());
  }

  
  public static void test1(){
    LinkedListGeneric<Integer> list = new LinkedListGeneric<>();
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list.toString());
  
    list.reverse();
    System.out.println(list.toString());
  }

  public static void test2(){
    LinkedListGeneric<Integer> list1 = new LinkedListGeneric<>();
    list1.add(1);
    list1.add(3);
    list1.add(5);

    LinkedListGeneric<Integer> list2 = new LinkedListGeneric<>();
    list2.add(2);
    list2.add(4);
    list2.add(6);

    list1.merge(list2);
    System.out.println(list1.toString());
  }
  
}
