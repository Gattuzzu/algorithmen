package ch.hftm.algorithmen.pruefungssimmulation;

public class MyLinkedList {
  private ListNode head;

  public void add(String value) {
      ListNode newNode = new ListNode(value);
      if (head == null) {
          head = newNode;
      } else {
          ListNode current = head;
          while (current.next != null) {
              current = current.next;
          }
          current.next = newNode;
      }
  }

  public void remove(String value) {
      if (head == null) return;

      if (head.value.equals(value)) {
          head = head.next;
          return;
      }

      ListNode current = head;
      while (current.next != null && !current.next.value.equals(value)) {
          current = current.next;
      }

      if (current.next != null) {
          current.next = current.next.next;
      }
  }

  public boolean contains(String value) {
      ListNode current = head;
      while (current != null) {
          if (current.value.equals(value)) {
              return true;
          }
          current = current.next;
      }
      return false;
  }

  public void printList() {
      ListNode current = head;
      while (current != null) {
          System.out.print(current.value + " -> ");
          current = current.next;
      }
      System.out.println("null");
  }
}
