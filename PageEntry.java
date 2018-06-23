import java.util.*;
import java.io.*;
public class PageEntry {
    public String pageName;
    PageIndex p ;//shayad initialise krna pade...via object
   // AvlTree at;
    
    public PageEntry(String str){///CONSTRUCTOR
      pageName = str;
              p= new PageIndex();
 
      try{
           FileInputStream fstream = new FileInputStream (pageName);
        Scanner s = new Scanner(fstream);
       int i = 1;
			while (s.hasNext()){
				String vsd = s.next();
                               
				if (vsd.contains(".")){
					vsd = vsd.replace(".", "");}
				if (vsd.contains(",")){
					vsd = vsd.replace(",", "");}
				if (vsd.contains("{")){
					vsd = vsd.replace("{", "");}
				if (vsd.contains("}")){
					vsd = vsd.replace("}", "");}
				if (vsd.contains("[")){
					vsd = vsd.replace("[", "");}
				if (vsd.contains("]")){
					vsd = vsd.replace("]", "");}
				if (vsd.contains("<")){
					vsd = vsd.replace("<", "");}
				if (vsd.contains(">")){
					vsd = vsd.replace(">", "");}
				if (vsd.contains("=")){
					vsd = vsd.replace("=", "");}
				if (vsd.contains("(")){
					vsd = vsd.replace("(", "");}
				if (vsd.contains(")")){
					vsd = vsd.replace(")", "");}
				if (vsd.contains(";")){
					vsd = vsd.replace(";", "");}
				if (vsd.contains("?")){
					vsd = vsd.replace("?", "");}
				if (vsd.contains("#")){
					vsd = vsd.replace("#", "");}
				if (vsd.contains("-")){
					vsd = vsd.replace("-", "");}
				if (vsd.contains(":")){
					vsd = vsd.replace(":", "");}
				if (vsd.contains("!")){
				vsd = vsd.replace("!", "");}
				if (vsd.contains("'")){
					vsd = vsd.replace("'", "");}
                                if (vsd.contains("\"") ){
				//	 vsd.charAt(0) = "";}
                             					vsd = vsd.replace("\"", "");}

				if (vsd.equalsIgnoreCase("a") || vsd.equalsIgnoreCase("an")
						|| vsd.equalsIgnoreCase("the") || vsd.equalsIgnoreCase("they")
						|| vsd.equalsIgnoreCase("these") || vsd.equalsIgnoreCase("for")
						|| vsd.equalsIgnoreCase("is") || vsd.equalsIgnoreCase("are")
						|| vsd.equalsIgnoreCase("of") || vsd.equalsIgnoreCase("or")
						|| vsd.equalsIgnoreCase("and") || vsd.equalsIgnoreCase("does")
						|| vsd.equalsIgnoreCase("will") || vsd.equalsIgnoreCase("whose")
						|| vsd.equalsIgnoreCase("was") || vsd.equalsIgnoreCase("this")) {

				} else {
					if (vsd.equalsIgnoreCase("stacks")){
						p.addPositionForWord("stack", new Position(this, i));
					}
                                        else{
                                            if (vsd.equalsIgnoreCase("stacks")){
						p.addPositionForWord("stack", new Position(this, i));
                                        }
					else{
						if (vsd.equalsIgnoreCase("applications")){
							p.addPositionForWord("application", new Position(this, i));
						}
						else{
							if (vsd.equalsIgnoreCase("structures")){
								p.addPositionForWord("structure", new Position(this, i));
							}
							else{
								p.addPositionForWord(vsd, new Position(this, i));
							}
						}
                                                }
					}
					
				}
			i++;
			}
			s.close();

///crucial step here...
       }catch (FileNotFoundException e){
          System.out.println("File not found xx");
      // e.printStackTrace();
       }
 ///how to create the page index here??
 //this.getPageIndex().allwords.add(.....some shit)

    }
    PageIndex getPageIndex(){
        return p;
    }
    ////////////
    public boolean compare(LinkedList<String> s,String[] st) {
       boolean flag = true;
        for (int x=0;x<st.length;x++){
            if(s.get(x).equals(st[x]))
                flag = true;
            else flag = false;
        }
        return flag;
    }
    ///////////////
  /*  float getRelevanceOfPage(String str[], boolean doTheseWordsRepresentAPhrase){
        /* Return the relevance of the webpage
for a group of words represented by the array str[ ]. If the 
ag
doTheseWordsRepresentAPhrase is true, it means that the words
represent a phrase; otherwise the words are part of a complex
query (AND/OR). */
      /*  float finalrel =0;
        if(doTheseWordsRepresentAPhrase == true){
            int t = str.length;
                     // String [] temp = new String[t];
                     /// LinkedList<String>  temp = new LinkedList();
      //h for (int i=0;i<allPages.size();i++){
          //  int k=0;
          
          ///PRINT INCLUDED HERE
         //h System.out.println(allPages.get(i).pageName +" ARBIT ");
           for(int j=0;j<this.getPageIndex().getWordEntries().size()-(t-1);j++){
         //   int n=0;
                               LinkedList<String>  temp = new LinkedList();
          //  int k=0;
               for (int v=j;v<j+t;v++){
                //  temp[n++] = allPages.get(i).getPageIndex().allwords.get(v).str;
                  temp.add(this.getPageIndex().getWordEntries().get(v).str);
                ///  this.getPageIndex().getWordEntries().get(v).
              }
              /* for(int car=0;car<temp.size();car++){
               System.out.print(temp.get(car)+ ",");
               }
                              System.out.println();*/

              /* if(compare(temp,str) == true){
                                        //  pl.add(allPages.get(i));
              // WordEntry hi = new WordEntry(temp.get(0));
              // hi = temp.get(0);
               
               }
        }
        else{
            
        }
        return finalrel;
    }*/
    
}    

