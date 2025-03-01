package ch.hftm.algorithmen.pruefungssimmulation.pruefung;

import ch.hftm.algorithmen.pruefungssimmulation.MyBinaryTree;

public class FileManager {
  // Verwenden Sie einen Binärsuchbaum (z.B. MyBinaryTree)
  MyBinaryTree tree = new MyBinaryTree();

  public void addFile(String filename) {
    // Datei in den Baum einfügen
    tree.insert(filename);
  }

  public boolean findFile(String filename) {
    // Datei suchen
    return tree.search(filename);
  }

  public void printAllFiles() {
    // Ausgabe aller Dateinamen (alphabetisch)
    tree.inorderTraversal();
  }

  public static void main(String[] args){
    FileManager fileManager = new FileManager();
    fileManager.addFile("Office");
    fileManager.addFile("Workload");
    fileManager.addFile("Zahlen");
    fileManager.addFile("Ausdrucke");
    fileManager.addFile("PowerPoint");
    fileManager.addFile("Excel");

    System.out.print("Files in Order: ");
    fileManager.printAllFiles();
    // Ausgabe:
    // Files in Order: Ausdrucke Excel Office PowerPoint Workload Zahlen

    System.out.println("File \"Workload\" in Tree: " + fileManager.findFile("Workload")); // True
    System.out.println("File \"Word\" in Tree: " + fileManager.findFile("Word")); // False
    System.out.println("File \"Haus\" in Tree: " + fileManager.findFile("Haus")); // False
    System.out.println("File \"PowerPoint\" in Tree: " + fileManager.findFile("PowerPoint")); // True
  }
}
