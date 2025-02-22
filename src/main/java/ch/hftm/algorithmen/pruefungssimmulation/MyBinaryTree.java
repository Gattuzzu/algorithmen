package ch.hftm.algorithmen.pruefungssimmulation;

public class MyBinaryTree {
  private TreeNode root;

  public void insert(String value) {
      root = insertRecursive(root, value);
  }

  private TreeNode insertRecursive(TreeNode node, String value) {
      if (node == null) {
          return new TreeNode(value);
      }
      if (value.compareTo(node.value) < 0) {
          node.left = insertRecursive(node.left, value);
      } else if (value.compareTo(node.value) > 0) {
          node.right = insertRecursive(node.right, value);
      }
      return node;
  }

  public boolean search(String value) {
      return searchRecursive(root, value);
  }

  private boolean searchRecursive(TreeNode node, String value) {
      if (node == null) {
          return false;
      }
      if (value.equals(node.value)) {
          return true;
      }
      return value.compareTo(node.value) < 0
              ? searchRecursive(node.left, value)
              : searchRecursive(node.right, value);
  }

  public void inorderTraversal() {
      inorderRecursive(root);
      System.out.println();
  }

  private void inorderRecursive(TreeNode node) {
      if (node != null) {
          inorderRecursive(node.left);
          System.out.print(node.value + " ");
          inorderRecursive(node.right);
      }
  }
}
