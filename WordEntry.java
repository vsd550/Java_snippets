import java.util.*;
public class WordEntry {
    String str;
    LinkedList<Position> ll = new LinkedList();
    //AvlTree at;
 ///see     THE DIFF. IN USING IT HERE AND INITIATING THE LL INSIDE CONSTRUCTOR..  
    public WordEntry(String Word){///CONSTRUCTOR
        str = Word;
       /* at = new AvlTree();
        for(int c=0;c<ll.size();c++){
            at.insert(ll.get(c).getWordIndex());
        }*/ //at.page = this ; ///shayad ERROR aa skte hain...yha pr...
/*for (int j=0;j<this.getPageIndex().getWordEntries().size();j++){   
 at.insertList(this.getPageIndex().getWordEntries().get(j).getAllPositionsForThisWord());
}
at.page = 2*/
    }
    ////
    void addPosition(Position position){
        ll.add(position);
    }
    /////////////
          void addPositions(LinkedList<Position> positions){
ll.addAll(positions);//Might ERROr here
   } 
    //////
  // MyLinkedList<Position> getAllPositionsForThisWord(){
         LinkedList<Position> getAllPositionsForThisWord(){
 return ll;////////might be a null pointer ERROR here...
   }
   /////////////
}