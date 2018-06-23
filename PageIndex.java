import java.util.*;
public class PageIndex{
    //stores one word-entry for each
//unique word in the document.
    WordEntry a ;//yha object bnana pad skta hai
    LinkedList<WordEntry> allwords = new LinkedList();//NULL POINTER ERROR

    public boolean findWordEntry2(String str){
    String s = str.toLowerCase();
        // int a = getHashIndex(s);
        for(int i=0;i<allwords.size();i++){
        if(allwords.get(i).str.equalsIgnoreCase(s)){
            return true;
        }
        }
       // else 
            return false;
  //  WordEntry b = new WordEntry(s);
   // return (hash[a].contains(b));

    
    }
    void addPositionForWord(String str, Position p){
   /*  a = new WordEntry(str);
    a.addPosition(p);*/
String s1 = str.toLowerCase();
if(findWordEntry2(s1)){
    for(int i=0;i<allwords.size();i++){
        if(allwords.get(i).str.equalsIgnoreCase(s1)){
            allwords.get(i).addPosition(p);
           // break;////////might be ERROR 
        }
    }
}
else{
   // for(int i=0;i<allwords.size();i++){
      //  if(allwords.get(i).str != str){
    a = new WordEntry(s1);
        allwords.add(a); // have to add it to the index too..

    a.addPosition(p);
   // allwords.add(a); // have to add it to the index too..
}
       // }
  //  }
}
LinkedList<WordEntry> getWordEntries(){
  // return a.getAllPositionsForThisWord();
  return allwords;
}
}   