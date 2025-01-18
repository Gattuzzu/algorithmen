package ch.hftm.algorithmen.linkedList;

public class LinkedListTest {
  public static void main(String[] args){
    // SimpleLinkedList
    System.out.println("Simple Linked List");
    simpleTest1();
    simpleTest2();
    simpleTest3();

    // LinkedList
    System.out.println("\nLinked List");
    test1();
    test2();
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
