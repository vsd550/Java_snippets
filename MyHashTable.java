import java.util.*;

public class MyHashTable {
            LinkedList<WordEntry> [] hash ;
            public MyHashTable(){
                hash = new LinkedList[10];
                for(int i=0;i<10;i++){
                    hash[i] = new LinkedList<WordEntry>();}//supportss chaining
            }
    
    private int getHashIndex(String str){
                
                int t = (str.length())%10 ;
              /*  for(int i=0;i<101;i++){
                    hash[i] = new LinkedList<WordEntry>();*/ 
//supportss chaining
              //  }
                return t;
    }
     public boolean findWordEntry1(String str){
    String s = str.toLowerCase();
         int a = getHashIndex(s);////doubt whether this works correctly or not
    WordEntry b = new WordEntry(s);
    return (hash[a].contains(b));

     }
//////////
    /*   public WordEntry findWordEntry(String str){
     WordEntry x = null;
           int i = getHashIndex(str);
	 try{ 
	 int t = hash[i].size();
	 }catch(NullPointerException e){
		 		// System.out.println("fuckkkk");
 WordEntry nu = new WordEntry(str);
	  return nu;
	 }
         int t=hash[i].size();
	 //if(t!=0){
		  for(int i1 =0;i1<t;i1++){
			  if(hash[i].get(i1).str == str)
				 x = hash[i].get(i1);
		  }
	 // }
	 /* WordEntry nu = new WordEntry(str);
	  return nu;*/
	/*  return x;
    }*/
       void addPositionsForWord(WordEntry w){
     String s = w.str.toLowerCase();
     
     if(findWordEntry1(s)){
         int t1 = getHashIndex(s);
         for(int j=0;j<hash[t1].size();j++){
             if(hash[t1].get(j).str.equalsIgnoreCase(s))
                 hash[t1].get(j).addPositions(w.getAllPositionsForThisWord());
         }
     }
     else{
          WordEntry c = new WordEntry(s);
       int t = getHashIndex(c.str);

       hash[t].addLast(c);
       hash[t].peekLast().addPositions(c.getAllPositionsForThisWord());
     }
	// try{
       // WordEntry a = findWordEntry(s);
	// }catch(NullPointerException e){
		// System.out.println("fuckkkk");
               // if(a.str.equalsIgnoreCase(s)){
                 //            a.addPositions(w.getAllPositionsForThisWord());

                //}
                //else{
                
                
		 
	 
	 
     // if(a!=null){
//         a.addPositions(w.getAllPositionsForThisWord());
     // }
     // else{
           

     /*  WordEntry c = new WordEntry(w.str);
       int t = getHashIndex(c.str);

       hash[t].addLast(c);  */
      }
    //}
    
}
