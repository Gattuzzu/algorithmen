package ch.hftm.algorithmen.pruefungssimmulation.pruefung;

import ch.hftm.algorithmen.pruefungssimmulation.MyBinaryTree;
import ch.hftm.algorithmen.pruefungssimmulation.TreeNode;

public class MysteryBinaryTree {
  public static int countNodes(TreeNode node) {
    // TODO: Gibt die Anzahl aller Knoten im Teilbaum zurück
    int anzahl = 0;
    if (node != null) {
      anzahl = 1;
      anzahl += countNodes(node.left);
      anzahl += countNodes(node.right);
    }
    return anzahl;
  }

  public static int countLeaves(TreeNode node) {
    // TODO: Gibt die Anzahl aller Blätter (Knoten ohne Kinder) zurück
    int anzahl = 0;
    if(node != null){
      if(node.left == null && node.right == null){
        anzahl = 1;
      } else{
        anzahl += countLeaves(node.left);
        anzahl += countLeaves(node.right);
      }
    }
    return anzahl;
  }

  public static void main(String[] args) {
    MyBinaryTree tree = new MyBinaryTree();
    tree.insert("M");
    tree.insert("A");
    tree.insert("Z");
    tree.insert("B");
    tree.insert("Y");
    
    System.out.print("Inorder-Ausgabe: ");
    tree.inorderTraversal(); // z.B. A B M Y Z
    // Ausgabe
    // Inorder-Ausgabe: A B M Y Z

    // Angenommen, wir hätten eine Methode getRoot():
    TreeNode root = tree.getRoot();
    int totalNodes = countNodes(root);
    int leafNodes = countLeaves(root);
    System.out.println("Knoten insgesamt: " + totalNodes);
    // Ausgabe
    // Knoten insgesamt: 5
    System.out.println("Blätter: " + leafNodes);
    // Ausgabe
    // Blätter: 2
  }
}