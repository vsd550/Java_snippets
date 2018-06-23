import java.util.*;
import java.io.*;

public class SearchEngine{
  InvertedPageIndex ip;
 // int y =0;
    SearchEngine(){
        ip = new InvertedPageIndex();
      //  ip.allPages.size() ;
      ///how to ensure THt this INVERTED PAGE INDEX IS EMPTY????????
    //  ip.allPages.
    }
    void performAction(String actionMessage){
        String [] parts = actionMessage.split(" ");
                if(parts[0].equals("addPage")){
                    //next part is a string only...
                    //G:\study 2016-17\DS\my assign files\assignment4\webpages
                    String fileName = parts[1];
                    PageEntry x = new PageEntry(fileName);
                    ip.addPage(x);

// ip.addPage();
//////System.out.print(ip.allPages.size());
/*for(int k=0;k<ip.allPages.size();k++)
{ System.out.println(ip.allPages.get(k).pageName);
System.out.println();
//for(int j=0;j<ip.allPages.get(k).getPageIndex().allwords.size();j++)
//System.out.println(ip.allPages.get(k).getPageIndex().allwords.get(j).str);
}*/
//System.out.println();

//for(int i1=0;i1<3;i1++){
  //  ip.allPages.get(0).getPageIndex().getWordEntries().get(i1).getAllPositionsForThisWord()
//for(int i2=0;i2<ip.allPages.get(0).getPageIndex().getWordEntries().get(i1).getAllPositionsForThisWord().size();i2++){
  //  System.out.print(ip.allPages.get(0).getPageIndex().getWordEntries().get(i1).getAllPositionsForThisWord().get(i2).getWordIndex() + " , ");
//}System.out.println();

            
         //   }
                }
                ///////////
                                if(parts[0].equals("queryFindPagesWhichContainWord")){
                                String wordName = parts[1].toLowerCase();
                                
                              /*  for(for(int i=0;i<ip.allPages.size();i++){
                                    if(ip.allPages.get(i).p.allwords.contains(wordName)){
                                        System.out.print(ip.allPages.get(i)+" ");
                                    }*/
                             // LinkedList<PageEntry> l = ip.getPagesWhichContainWord(wordName);
                            //     try{  if(l.size()!=0){ 
                            ///		NULL POINYER HERE
                            if(ip.getPagesWhichContainWord(wordName).size()!=0){
                            for(int i=0;i<ip.getPagesWhichContainWord(wordName).size()-1;i++){
                                       System.out.print(ip.getPagesWhichContainWord(wordName).get(i).pageName + ",");
                                   } 
                             System.out.print(ip.getPagesWhichContainWord(wordName).get(ip.getPagesWhichContainWord(wordName).size()-1).pageName );
                                   System.out.println();
                                   }
                                  //else
                                  //  System.out.println("No Webpage contains word "+wordName);
								// }catch(NullPointerException e){
							else
                                                                System.out.println("No Webpage contains word "+wordName);

								// }
                                   
                                }
                    if(parts[0].equals("queryFindPositionsOfWordInAPage")){
                        String wordName = parts[1].toLowerCase();
                        String pagename = parts[2];
                        boolean foundPage = false;
                        
                        for(int t=0;t<ip.allPages.size();t++){
                                if(ip.allPages.get(t).pageName.equals(pagename))
                                  foundPage = true;
                               // else
                                 //   foundPage = false;
                                    }
                       //  PageEntry p = new PageEntry("fff");
                       if(foundPage == true){
                       if(ip.getPagesWhichContainWord(wordName).size()!=0){
                         for(int t1=0;t1<ip.getPagesWhichContainWord(wordName).size();t1++){
                            // System.out.println(ip.getPagesWhichContainWord(wordName).get(t1).pageName + ", ");
                             if(ip.getPagesWhichContainWord(wordName).get(t1).pageName.equals(pagename)){
                               //  p = ip.getPagesWhichContainWord(wordName).get(t1);
                               // System.out.println(ip.getPagesWhichContainWord(wordName).get(t1).pageName + ", xxx");
                             //ip.getPagesWhichContainWord(wordName).get(t1).getPageIndex().getWordEntries()
                                     for(int t2=0;t2<ip.getPagesWhichContainWord(wordName).get(t1).getPageIndex().getWordEntries().size();t2++){
                                         if(ip.getPagesWhichContainWord(wordName).get(t1).getPageIndex().getWordEntries().get(t2).str.equalsIgnoreCase(wordName)){
                                         //   ip.getPagesWhichContainWord(wordName).get(t1).getPageIndex().getWordEntries().get(t2).
                                        for(int t3=0;t3<ip.getPagesWhichContainWord(wordName).get(t1).getPageIndex().getWordEntries().get(t2).getAllPositionsForThisWord().size()-1;t3++){
                                        System.out.print(ip.getPagesWhichContainWord(wordName).get(t1).getPageIndex().getWordEntries().get(t2).getAllPositionsForThisWord().get(t3).getWordIndex()+", ");
                                        }
                                                                                System.out.print(ip.getPagesWhichContainWord(wordName).get(t1).getPageIndex().getWordEntries().get(t2).getAllPositionsForThisWord().get(ip.getPagesWhichContainWord(wordName).get(t1).getPageIndex().getWordEntries().get(t2).getAllPositionsForThisWord().size()-1).getWordIndex());

                                        System.out.println();
                                                    }
                                        
                                     }
                             }
                         }
                       }
                       else{
                           System.out.println("Webpage  " +pagename +" does not contain word " +wordName); 
                       }
                       }
                       else{
                       System.out.println("the given Webpage is not contained in the search engine database "); 

                       }
                    
                      }   
                            if(parts[0].equals("queryFindPagesWhichContainPhrase")){
                                ArrayList<String> str = new ArrayList();
                               // int i=1;
                               // while(parts[i].length()!=0){
                               for(int t1=0;t1<parts.length;t1++){
                                   str.add(parts[t1]);
                               }
                               // str.add(parts[1]);
                               //str.add(parts[2]); ///ABHIJUGAAD PR CHAL RHA HAI
                                //i++;
                                  //      }
                                 
                               String [] s = new String[str.size()];
                              
                              for(int t4=0;t4<str.size();t4++){
                                  s[t4] = str.get(t4);
                              }
                                LinkedList<PageEntry> x = ip.getPagesWhichContainPhrase(s);
                                if(x!=null && x.size()!=0){
                             // System.out.println(x.size());///remove null pointer error here..
                              for(int c4=0;c4<x.size();c4++){
                                    System.out.print(x.get(c4).pageName +" xx");
                                    System.out.println();
                               //System.out.print(x.get(0).pageName +" xx");
                                }
                                }
                                else{
                                    System.out.print("no webpage contain the given phrase");
                                }
                             
                           // }
                            }
                                                   /*     if(parts[0].equals("queryFindPagesWhichContainPhrase")){
                                                            
                                                            
                                                            
                                                            
                                                        }*/
    
}
}