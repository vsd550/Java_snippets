/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages;

/**
 *
 * @author Vijay
 */
public class BinaryTree {
    Node root;
    public BinaryTree(){
        root = null;
}
    
    int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
    
    void printlevel(Node r,int level){
        if(r == null)
                return;
        
        if(level == 1)
                System.out.println(r.val);
        else if(level > 1){
            printlevel(r.left,level-1);
            printlevel(r.right,level-1);
        }
        
    }
    void getlevelorder(Node r){
        for(int i=1;i<height(r);i++){
            printlevel(r,i);
        }
    }
    public static void main(String [] args){
        BinaryTree bt = new BinaryTree();
        
        System.out.println(bt.cat(4));
        
    }
    
    int cat(int n){
        if(n == 0 || n==1) return 1;
        int [] catalan = new int[n+1];
        catalan[0] = catalan[1] = 1;
        for(int i =2;i<=n;i++){
            catalan[i] = 0;
            for(int j=0;j<i;j++)
            catalan[i] = catalan[i] + catalan[j]*catalan[i-j-1];
        }
        return catalan[n];
    }
    
}
