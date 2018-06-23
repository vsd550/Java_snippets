import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
 class Node{
     int data;
     Node left , right;
     
     Node(int d){
         data = d;
         left = right = null;
     }
 }
     
 class BinaryTree{
     Node root;
     
     int toSumTree(Node root){
         if(root == null)
             return 0;
         
         int old_root = root.data;
         root.data = toSumTree(root.left) + toSumTree(root.right);
         
         return (root.data + old_root);
     }
     
     void inorder(Node root){
         if (root == null)
             return;
         
         inorder(root.left);
         System.out.print(root.data + " ");
         inorder(root.right);
     }
 
 public static void main(String [] args){
     BinaryTree tree = new BinaryTree();
     
     tree.root = new Node(10);
      tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);
 
 
 
 }
 }
}