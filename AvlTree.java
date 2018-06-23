/*class AVLNode 
 {    
     AVLNode left, right;
     
     int data;
     int height;
 
     Constructor 
     public AVLNode()
     {
         left = null;
         right = null;
         data = 0;
         height = 0;
     }
     /* Constructor 
     public AVLNode(int n)
     {
         left = null;
         right = null;
         data = n;
         height = 0;
     }     
 }
 */
 /* Class AVLTree */
import java.util.*;
import java.io.*;

 public class AvlTree
 {
     private Position root;
     PageEntry page;
 
     /* Constructor */
     public AvlTree()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         root = null;
     }
     /* Function to insert data */
     public void insert(int data)
     {
         root = insert(data, root);
     }
     ////adding a new function myself...
     public void insertList(LinkedList<Position> a){
         for (int i=0;i<a.size();i++){
             root = insert(a.get(i).getWordIndex(),root);
         }
     }
     /* Function to get height of node */
     private int height(Position t )
     {
         return t == null ? -1 : t.height;
     }
     /* Function to max of left/right node */
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     /* Function to insert data recursively */
     private Position insert(int x, Position t)
     {
         if (t == null)
             t = new Position(page, x);
         else if (x < t.getWordIndex())
         {
             t.left = insert( x, t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( x < t.left.getWordIndex() )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         }
         else if( x > t.getWordIndex() )
         {
             t.right = insert( x, t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( x > t.right.getWordIndex())
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         else
           ;  // Duplicate; do nothing
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     
     
     /* Rotate binary tree node with left child */     
     private Position rotateWithLeftChild(Position k2)
     {
         Position k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }
 
     /* Rotate binary tree node with right child */
     private Position rotateWithRightChild(Position k1)
     {
         Position k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
      private Position doubleWithLeftChild(Position k3)
     {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */      
     private Position doubleWithRightChild(Position k1)
     {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }  
     
     /////////////for the inorder traversal
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(Position r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.getWordIndex() +" ");
             inorder(r.right);
         }
     }
     ////searching a value in the avl tree....
      public boolean search(int val)
     {
         return search(root, val);
     }
     private boolean search(Position r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getWordIndex();
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
 }