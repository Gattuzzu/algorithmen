package ch.hftm.algorithmen.pruefungssimmulation.aufgaben;

public class MysteryLinkedList {
  static class Node {
      int value;
      Node next;
      Node(int value) { this.value = value; this.next = null; }
  }

  public static int f(Node head, int x) {
      int c = 0;
      Node cur = head;
      while (cur != null) {
          if (cur.value == x) { c++; }
          cur = cur.next;
      }
      return c;
  }

  public static Node g(Node head, int x) {
      while (head != null && head.value == x) {
          head = head.next;
      }
      Node cur = head;
      while (cur != null && cur.next != null) {
          if (cur.next.value == x) {
              cur.next = cur.next.next;
          } else {
              cur = cur.next;
          }
      }
      return head;
  }

  public static void h(Node head) {
      Node cur = head;
      while (cur != null) {
          System.out.print(cur.value + " -> ");
          cur = cur.next;
      }
      System.out.println("null");
  }

  public static void main(String[] args) {
      Node head = new Node(3);
      head.next = new Node(1);
      head.next.next = new Node(3);
      head.next.next.next = new Node(2);
      head.next.next.next.next = new Node(3);
      head.next.next.next.next.next = new Node(4);
      
      h(head);
      // 3 -> 1 -> 3 -> 2 -> 3 -> 4 -> null

      int a = f(head, 3);
      System.out.println("Ausgabe: " + a);
      // Ausgabe: 3

      head = g(head, 3);
      h(head);
      // 1 -> 2 -> 4 -> null
  }
}
