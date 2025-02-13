package ch.hftm.algorithmen.baum;

import java.util.NoSuchElementException;

/**
 * BinaryTree Die generische Klasse "BinaryTree" ist eine Containerklasse zur
 * Einlagerung von Objekten eines bestimmten Typs, welche auf der Grundlage
 * eines binären Suchbaumes konzipiert ist und die gängigsten Operationen über
 * Suchbäumen bereitstellt.
 */
public class BinaryTree<E extends Comparable<E>> {

  // Konstanten

  // Steuerung der Traversierung
  public static final int INORDER = 1;
  public static final int PREORDER = 2;
  public static final int POSTORDER = 3;

  // Instanzvariablen

  private TreeNode<E> root; // Baumwurzel

  // Konstruktor

  /**
   * Initialisiert den binären Suchbaum als leeren Baum.
   */
  public BinaryTree() {
    root = null;
  }

  // Instanzmethoden

  /**
   * Erzeugt aus den in einem Array angeordneten Elementen binären Suchbaum.
   * Dabei werden die Arrayelemente in aufsteigender Indexreihenfolge im
   * Suchbaum eingelagert. Wird der null-Array übergeben, dann wird der
   * Standard- suchbaum generiert.
   */
  public void array2BTree(E[] dataArr) {
    root = null; // allfällig bestehenden Baum löschen
    if (dataArr != null) {
      for (int i = 0; i < dataArr.length; i++)
        try {
          insert(dataArr[i]);
        } catch (IllegalArgumentException e) {
          // Duplikat darf nicht eingefügt werden --> ignorieren
        }
    }
  }

  /**
   * Durchläuft den Suchbaum auf der Grundlage der spezifizierten
   * Traversierungsstrategie und erzeugt eine Stringrepäsentation der
   * angetroffenen Nutzdatenelemente.
   */
  public String traverse(int strategy) {
    switch (strategy) {
    case INORDER:
      return toStringInorder(root);
    case PREORDER:
      return toStringPreorder(root);
    case POSTORDER:
      return toStringPostorder(root);
    default:
      return toStringInorder(root);
    }
  }

  /**
   * Traversiert den Suchbaum inorder und erzeugt eine Stringrepäsentation der
   * angetroffenen Nutzdatenelemente.
   */
  private String toStringInorder(TreeNode<E> node) {
    StringBuilder treeStrg = new StringBuilder();
    if(node.left != null){
      treeStrg.append(toStringInorder(node.left));
    }
    
    if(node.data != null){
      treeStrg.append(node.data.toString()).append(" ");
    } else{
      // Hier ist eine Node vorhanden, welche keine Daten hat.
      treeStrg.append("_").append(" ");
    }

    if(node.right != null){
      treeStrg.append(toStringInorder(node.right));
    }

    return treeStrg.toString();
  }

  /**
   * Traversiert den Suchbaum preorder und erzeugt eine Stringrepäsentation
   * der angetroffenen Nutzdatenelemente.
   */
  private String toStringPreorder(TreeNode<E> node) {
    StringBuilder treeStrg = new StringBuilder();
    if(node.data != null){
      treeStrg.append(node.data.toString()).append(" ");
    } else{
      // Hier ist eine Node vorhanden, welche keine Daten hat.
      treeStrg.append("_").append(" ");
    }

    if(node.left != null){
      treeStrg.append(toStringPreorder(node.left));
    }

    if(node.right != null){
      treeStrg.append(toStringPreorder(node.right));
    }

    return treeStrg.toString();
  }

  /**
   * Traversiert den Suchbaum postorder und erzeugt eine Stringrepäsentation
   * der angetroffenen Nutzdatenelemente.
   */
  private String toStringPostorder(TreeNode<E> node) {
    StringBuilder treeStrg = new StringBuilder();
    if(node.left != null){
      treeStrg.append(toStringPostorder(node.left));
    }

    if(node.right != null){
      treeStrg.append(toStringPostorder(node.right));
    }
    
    if(node.data != null){
      treeStrg.append(node.data.toString()).append(" ");
    } else{
      // Hier ist eine Node vorhanden, welche keine Daten hat.
      treeStrg.append("_").append(" ");
    }
    
    return treeStrg.toString();
  }

  /**
   * Prüft, ob das spezifizierte Datenelement im Suchbaum eingelagert ist
   * (=true) oder nicht (=false). (Iterative Version)
   */
  public boolean contains(E data) {
    // Iterativ durchsuchen
    TreeNode<E> node = root;
    while(node != null){
      if(node.data != null){
        int result = node.data.compareTo(data);
        if(result == 0){
          return true;
        } else {
          node = result > 0 ? node.left : node.right;
        }
      }
    }
    // Das Ende des Astes ist erreicht und die Daten wurden nicht gefunden
    return false;

    // Rekursiv durchsuchen
    // return contains(root, data);
  }

  // Rekurisv durchsuchen
  private boolean contains(TreeNode<E> node, E data){
    if(node != null){
      if(node.data != null){
        int result = node.data.compareTo(data);
        if(result == 0){
          return true;
        } else if(result > 0){
          return contains(node.left, data);
        } else{ // result < 0
          return contains(node.right, data);
        }
      }
    }
    // Das Ende des Astes ist erreicht und die Daten wurden nicht gefunden
    return false;
  }

  /**
   * Ermittelt das im binären Suchbaum eingelagerte Datenelement mit dem
   * grössten Wert.
   */
  public E maxElement() {
    if(root == null){
      return null;
    }
    return maxElement(root);
  }

  // Rekursiv das grösste Element suchen
  private E maxElement(TreeNode<E> node){
    if(node.right == null){
      return node.data;
    }
    return maxElement(node.right);
  }

  /**
   * Ermittelt das im binären Suchbaum eingelagerte Datenelement mit dem
   * grössten Wert.
   */
  public E minElement() {
    if(root == null){
      return null;
    }
    return minElement(root);
  }

  // Rekursiv das kleinste Element suchen
  private E minElement(TreeNode<E> node){
    if(node.left == null){
      return node.data;
    }
    return minElement(node.left);
  }

  /**
   * Fügt ein Datenelement an der korrekten Position im binären Suchbaum ein.
   */
  public void insert(E data) {
    TreeNode<E> parent = null;
    // Wird benötigt um durch den Baum zu wandern.
    TreeNode<E> node = root;
    int compareResult;
    while (node != null) {
      parent = node;
      compareResult = data.compareTo(node.data);
      // Da er links oder rechts durch geht, muss es ein Binärere Baum sein.
      if (compareResult < 0)
        node = node.left;
      else if (compareResult > 0)
        node = node.right;
      else
      // Wenn compareResult = 0 dann existiert es bereits.
        throw new IllegalArgumentException(
            "Datenelement bereits im Baum eingefügt!");
    }
    if (parent == null)
      // Wenn der Baum lehr ist, dann wird der erste Node erzeugt. 
      root = new TreeNode<E>((E) data);
    // Hier wird entschieden, ob das neue Element links oder rechts der letzten Node hinzugefügt werden muss.
    else if (data.compareTo(parent.data) < 0)
      parent.left = new TreeNode<E>((E) data);
    else
      parent.right = new TreeNode<E>((E) data);
  }

  /**
   * Entfernt das spezifizierte Datenelement unter Wahrung der Ordnung aus dem
   * binären Suchbaum, sofern es vorhanden ist.
   */
  public void remove(E data) {
    TreeNode<E> parent = null;
    TreeNode<E> node = root;
    TreeNode<E> child = null;
    TreeNode<E> temp = null;
    
    while (node != null && data.compareTo(node.data) != 0) {
      parent = node;
      // Hier sucht er den schnellsten weg zum Element ohne den ganzen Baum zu durchsuchen
      if (data.compareTo(node.data) < 0)
        node = node.left;
      else
        node = node.right;
    }

    // Wenn node null, dann wurde das Element nicht gefunden.
    // Es könnte auch sein, dass der Baum lehr ist.
    if (node == null)
      
      throw new NoSuchElementException(
          "Das zu entfernende Nutzdatum ist nicht im "
              + "Baum eingelagert!");
    
    // Der Baum hat nur ein Element bzw. der root Knoten ist der gesuchte Knoten
    if (parent == null) {
      // Ist eines der beiden Element null, dann wird die jeweils andere Element zum Root node.
      if (node.left == null)
        root = node.right;
      else if (node.right == null)
        root = node.left;
      else {
        // Links und rechts ist ein Element
        temp = node;
        child = node.right;
        while (child.left != null) {
          temp = child;
          child = child.left;
        }
        if (node != temp) {
          temp.left = child.right;
          child.right = root.right;
        }
        child.left = root.left;
        root = child;
      }
      // Nur rechts ist ein Element
    } else if (node.left == null)
      // Alles was unterhalb ist, wird entweder links oder rechts angefügt.
      if (parent.left == node)
        parent.left = node.right;
      else
        parent.right = node.right;
    // Das selbe, wenn nur ein linkes Element vorhanden ist.
    else if (node.right == null)
      if (parent.left == node)
        parent.left = node.left;
      else
        parent.right = node.left;
    // der gesuchte Knoten hat links und rechts ein Element
    else {
      temp = node;
      child = node.right;
      while (child.left != null) {
        temp = child;
        child = child.left;
      }
      child.left = node.left;
      if (node != temp) {
        temp.left = child.right;
        child.right = node.right;
      }
      if (parent.right == node)
        parent.right = child;
      else
        parent.left = child;
    }
  }

  /**
   * Erzeugt eine Stringrepräsentation des binären Suchbaumes.
   */
  public String toString() {
    int niveau = 0;
    return toBTreeString(root, niveau, "x");
  }

  // private Hilfsmethoden

  /**
   * Erstellt die Stringrepräsentation rekursiv in Gestalt eines horizontal
   * angeordneten Binärbaumes.
   */
  private String toBTreeString(TreeNode<E> node, int niveau, String indentExpr) {
    String btreeString = "\n";
    char nchar = Character.forDigit(niveau % 10, 10);
    if (indentExpr.indexOf('x') >= 0) {
      indentExpr = indentExpr.replace('x', nchar);
      btreeString += indentExpr;
      if (niveau == 0)
        indentExpr = indentExpr.replace(nchar, ' ');
      else
        indentExpr = indentExpr.replace(nchar, '|');
    } else if (indentExpr.indexOf('y') >= 0) {
      indentExpr = indentExpr.replace('y', nchar);
      btreeString += indentExpr;
      indentExpr = indentExpr.replace(nchar, ' ');
    }
    btreeString += "-- ";
    if (node != null) {
      btreeString += "Datenwert: " + node.data;
      niveau++;
      btreeString += toBTreeString(node.left, niveau, indentExpr
          + "       x");
      btreeString += toBTreeString(node.right, niveau, indentExpr
          + "       y");
    } else
      btreeString += "null";
    return btreeString;
  }

  /**
   * Die Klasse "TreeNode" ist eine generische innere Klasse, von der sich
   * Knotenobjekte für binäre Bäume generieren lassen. Bemerkung: Innere
   * Klassen besitzen u.a. die Eigenschaft, dass sie nur innerhalb der Klasse,
   * in der sie definiert sind (hier: BinaryTree), sichtbar sind.
   */
  class TreeNode<T> {

    // Instanzvariablen

    T data; // Nutzdatenobjekt
    TreeNode<T> left = null; // der Baumknoten wird als
    TreeNode<T> right = null; // Blatt initialisiert

    // Konstruktor

    TreeNode(T data) {
      this.data = data;
    }

    // Instanzmethoden

    public String toString() {
      return data.toString();
    }

  }

}
