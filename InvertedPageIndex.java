import java.util.*;
public class InvertedPageIndex{
    LinkedList<PageEntry> allPages ;
  MyHashTable mht;
 // AvlTree at;
    public InvertedPageIndex(){
        ///CONSTRUCTOR
        allPages = new LinkedList<PageEntry>();
        mht = new MyHashTable();
     //   at = new AvlTree();
    
    }
    void addPage(PageEntry p){
       allPages.add(p) ; ///pta nhi...
       //once a page gets added its words must also be added in right position
       //that is done by going to its page index and adding the word entries in
       //the hash table
     //  p.getPageIndex().allwords
	 //try{
for(int i=0;i<p.getPageIndex().getWordEntries().size();i++){
    mht.addPositionsForWord(p.getPageIndex().getWordEntries().get(i));
}
	// }catch(NullPointerException e){
		 
	// }
               
               }
    
    public boolean compare(LinkedList<String> s,String[] st) {
       boolean flag = true;
        for (int x=0;x<st.length;x++){
            if(s.get(x).equals(st[x]))
                flag = true;
            else flag = false;
        }
        return flag;
    }
/////////////
   LinkedList<PageEntry> getPagesWhichContainWord(String str){
            LinkedList<PageEntry> allPagesthatcontain = new LinkedList();
           
            /*for(int i=0;i<allPages.size();i++){///ERROR possibilities
                if(allPages.get(i).p.allwords.contains(str))
                    allPagesthatcontain.add(allPages.get(i));
            }*/String s = str.toLowerCase();
			//WordEntry x = new WordEntry(s);
			for(int i=0;i<allPages.size();i++){
for(int i1 = 0;i1<allPages.get(i).getPageIndex().getWordEntries().size();i1++){///ERROR possibilities
                if(allPages.get(i).getPageIndex().getWordEntries().get(i1).str.equalsIgnoreCase(s))
					                    allPagesthatcontain.add(allPages.get(i));
			}   
                        }
   return allPagesthatcontain; 
   }
   /////////////
   LinkedList<PageEntry>getPagesWhichContainPhrase(String str[]){
       LinkedList<PageEntry> pl = new LinkedList();
       /////addd hereeeeeee
       /*Return a set of page-entries for webpages which contain a sequence
of non-connector words (str[0] str[1] ... str[str.len-1]). */
       int t = str.length;
                     // String [] temp = new String[t];
                     /// LinkedList<String>  temp = new LinkedList();
       for (int i=0;i<allPages.size();i++){
          //  int k=0;
          
          ///PRINT INCLUDED HERE
          System.out.println(allPages.get(i).pageName +" ARBIT ");
           for(int j=0;j<allPages.get(i).getPageIndex().getWordEntries().size()-(t-1);j++){
         //   int n=0;
                               LinkedList<String>  temp = new LinkedList();
          //  int k=0;
               for (int v=j;v<j+t;v++){
                //  temp[n++] = allPages.get(i).getPageIndex().allwords.get(v).str;
                  temp.add(allPages.get(i).getPageIndex().getWordEntries().get(v).str);
                  
              }
              /* for(int car=0;car<temp.size();car++){
               System.out.print(temp.get(car)+ ",");
               }
                              System.out.println();*/

               if(compare(temp,str) == true)
                                          pl.add(allPages.get(i));
              // for(int k=0;k<t;k++){
                //   if(compare(temp,str) == true)
                  //                        pl.add(allPages.get(i));

               //}
            /*   while(k<t){
                   if(temp.get(k).equals(str[k])){
                       k++;
                   }
                 //  else break;
               }*/
              // if(k == t-1){
                //   pl.add(allPages.get(i));
               //}
              // System.out.println(pl.get(0));
                       
           }
       }
       
       
       return pl;
   }
      // return pl;
}
///} ///extra added

