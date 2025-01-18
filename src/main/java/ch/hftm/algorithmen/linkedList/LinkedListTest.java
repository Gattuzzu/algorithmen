package ch.hftm.algorithmen.linkedList;

public class LinkedListTest {
  public static void main(String[] args){
    LinkedListGeneric<Integer> list = new LinkedListGeneric<>();
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list.toString());

    list.reverse();
    System.out.println(list.toString());
  }
  
}
