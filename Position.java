import java.util.*;
import java.io.*;

public class Position {
    Position left , right;
    public PageEntry p;
   public int wordPosition;
   int height;
   //wordPosition is the key via get word index...
    public Position(PageEntry P , int WordIndex){
        p = P;
        wordPosition = WordIndex;
        left = null;
         right = null;
         height = 0;
    }
    PageEntry getPageEntry(){
        return p;
    }
    int getWordIndex(){
        return wordPosition;
    }
    Position getLeft(){
        return left;
    }
  Position getRight(){
        return right;
    }
  
///////*******-------------
}
