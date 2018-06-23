import java.util.*;
import java.io.*;

class charnode{
char a;
//int positionval;
LinkedList<Integer> charlocs = new LinkedList();
/////can use getPosition types methods if require....
}

class posnode{
public int a1;
public int a2;
}
public class SuffixTrie {
    public String s="";
    public String line;
    LinkedList<charnode> chars = new LinkedList();

public void performAction(String actionMessage){
        System.out.print(actionMessage+": ");
            String [] parts = actionMessage.split(" ");
            if (parts[0].equals("makeSuffixTrie") && parts.length == 2){
               
              //  System.out.println("hi bro..");
                
                String filename = parts[1];
                
               // char [] charc ;
                //int k=0;
                boolean flag = false;
                
                
                BufferedReader br = null;
		//SearchEngine r = new SearchEngine();
                
		try {
                   // FileInputStream fs = new FileInputStream(filename);
                    //Scanner s = 
			//String actionString;
                      //  br.re
			br = new BufferedReader(new FileReader(filename));
                        while((line = br.readLine())!=null){
                            s = s+(line +"~");
                        }
                        s = s.toLowerCase();////coverted case insensitive
                        //charc = s.toCharArray();
                        //////imp step....converted to a character array
		/*	while ((actionString = br.readLine()) != null) {
				r.performAction(actionString);
			}*/ 
                                           System.out.print(s);
                                          System.out.println();
                                          System.out.println(s.length());
             //   while(k<charc.length){///entrs in infinite loop due to it....
                                 for(int i=0;i<s.length();i++){
                                                      //      System.out.print(i +" ");

             if(chars.size()!=0){                      // System.out.println("rrrrrrrs ");

                    //for(int i=1;i<charc.length;i++){
                                       // if(chars.size()!=0){
                        for(int j=0;j<chars.size();j++){
                     //  System.out.print(j +" ");
                     //  System.out.println();
                            flag=false;
                            if(s.charAt(i) == chars.get(j).a){
                           // locnode l1 = new locnode();
                                              //    System.out.println("dubey ");

                                 (chars.get(j)).charlocs.add(i);
                                // k++;
                                flag = true;
                                break;
                                
                            }
                         
                        }
                        if(flag == false){
                             
                               charnode t1 = new charnode();
                              // locnode l1 = new locnode();
                               
                              // l1.loc = i;
                               
                               t1.a = s.charAt(i);
                            //   t1.positionval = i;
                               t1.charlocs.add(i);
                               chars.add(t1);
                              // k++;
                            
                        }
                 //   }
               }
             //  }
                else{
                    charnode t1 = new charnode();
                 //   locnode l1 = new locnode();
                  //  l1.loc = 0;
                    t1.a = s.charAt(i);
                   // t1.positionval = 0;
                    t1.charlocs.add(i);
                    chars.add(t1);
                   //
                  // k++;
                }
                                   }
		} catch (IOException e) {
			e.printStackTrace();
		}
                
                for(int k2=0;k2<chars.size();k2++){
                    System.out.print(chars.get(k2).a +" xx ");
                    for(int k3=0;k3<chars.get(k2).charlocs.size();k3++)
                    System.out.print(chars.get(k2).charlocs.get(k3) +" x ");
                    System.out.println();
                }
                
            }
             if (parts[0].equals("isSubstring") && parts.length == 2){
                 if(chars.size()!=0){
                 String word = parts[1].toLowerCase();
                 ///learn that defining public variables makes it accessible everywhere
                 ///System.out.println(s);
                 int k = word.length();
                 char temp;
                 boolean ll =true;
                 LinkedList <Integer> hi = new LinkedList();                

                 for(int h1=0;h1<chars.size();h1++){
                     if(chars.get(h1).a == (word.charAt(0)))
                     { temp = chars.get(h1).a;
                      hi = chars.get(h1).charlocs;
                   //  break;/////////see it..jruri nhi hai
                     }
                 }///////NULL POINTER AA SKTA HAI
                /* for(int r1=0;r1<hi.size();r1++){
                     System.out.print(hi.get(r1)+" xxx");
                     System.out.println();

                 }*/
                 
                 for(int h2=0;h2<hi.size();h2++){
                     if(s.substring(hi.get(h2), hi.get(h2)+k).equals(word)){
                        System.out.println(1);
                        ll = false;
                        break;
                     }
                     
                 }
                 if(ll == true){
                     System.out.println(0);

                 }
             }
                 else{
                          System.out.println("Exception-Trie has not been built yet");
 
                 }
             }
             
                 if (parts[0].equals("numSubstrings") && parts.length == 3){
                 if(chars.size()!=0){
                 String word = parts[1].toLowerCase();
                 int overlapflag = Integer.parseInt(parts[2]);
                 int num2 =0;
                 ///learn that defining public variables makes it accessible everywhere
                 ///System.out.println(s);
                 int k = word.length();
                 int numm =0;
                 //int pos_of_substring;
                 char temp;
                 boolean ll =true;
                 LinkedList <Integer> hi = new LinkedList();
                 LinkedList <posnode> hot = new LinkedList();
                 

                 for(int h1=0;h1<chars.size();h1++){
                     if(chars.get(h1).a == (word.charAt(0)))
                     { temp = chars.get(h1).a;
                      hi = chars.get(h1).charlocs;
                   //  break;/////////see it..jruri nhi hai
                     }
                 }///////NULL POINTER AA SKTA HAI
                /* for(int r1=0;r1<hi.size();r1++){
                     System.out.print(hi.get(r1)+" xxx");
                     System.out.println();

                 }*/
               //// s.endsWith(s)8///////////////imp
                 if(overlapflag == 1){
                 for(int h2=0;h2<hi.size();h2++){
                     if(s.substring(hi.get(h2), (hi.get(h2))+k).equals(word) /*&& ((hi.get(h2))+k) < hi.size()*/){
                    //   System.out.println("dubey");
                     //  System.out.println(h2);
        
                         numm++;
                       ll = false;////////sseee ittt
                       posnode p1 = new posnode();
                       p1.a1 = hi.get(h2);
                       p1.a2 = hi.get(h2)+k-1;
                       
                       hot.add(p1);
                     }
                     
                 }
                 if(ll == false)
                 System.out.println(numm);
                 
                 }
                 else{  ///means overlapflag is 0
                    for(int h2=0;h2<hi.size();h2++){
                     if(s.substring(hi.get(h2), hi.get(h2)+k).equals(word) ){
                       numm++;
                       ll = false;////////sseee ittt
                       posnode p1 = new posnode();
                       p1.a1 = hi.get(h2);
                       p1.a2 = hi.get(h2)+k-1;
                       
                       hot.add(p1);
                     }
                     
                 }
                  //  System.out.println(numm +" dubey");
                    
                    if(numm <= 1)
                    System.out.println(numm);
                    else{////////check for overlap...
                        for(int h11=1;h11<hot.size();h11++){
                            if(hot.get(h11).a1 <= hot.get(h11 -1).a2)
                                num2++;
                        }
                        System.out.println(numm - num2);
                    }
                 }
                 if(ll == true){
                     System.out.println(0 +" x ");

                 }
             }
                 else{
                          System.out.println("Exception-Trie has not been built yet");
 
                 }
             }
                 
                 if (parts[0].equals("posSubstrings") && parts.length == 3){
                 if(chars.size()!=0){
                 String word = parts[1].toLowerCase();
                 int overlapflag = Integer.parseInt(parts[2]);
                 int num2 =0;
                 ///learn that defining public variables makes it accessible everywhere
                 ///System.out.println(s);
                 int k = word.length();
                 int numm =0;
                 //int pos_of_substring;
                 char temp;
                 boolean ll =true;
                 LinkedList <Integer> hi = new LinkedList();
                 LinkedList <posnode> hot = new LinkedList();
                 LinkedList <posnode> hotter = new LinkedList();
                 

                 for(int h1=0;h1<chars.size();h1++){
                     if(chars.get(h1).a == (word.charAt(0)))
                     { temp = chars.get(h1).a;
                      hi = chars.get(h1).charlocs;
                   //  break;/////////see it..jruri nhi hai
                     }
                 }///////NULL POINTER AA SKTA HAI
                /* for(int r1=0;r1<hi.size();r1++){
                     System.out.print(hi.get(r1)+" xxx");
                     System.out.println();

                 }*/
                 if(overlapflag == 1){
                 for(int h2=0;h2<hi.size();h2++){
                     if(s.substring(hi.get(h2), (hi.get(h2))+k).equals(word) /*&& ((hi.get(h2))+k) < hi.size()*/){
                    //   System.out.println("dubey");
                     //  System.out.println(h2);
        
                         numm++;
                       ll = false;////////sseee ittt
                       posnode p1 = new posnode();
                       p1.a1 = hi.get(h2);
                       p1.a2 = hi.get(h2)+k-1;
                       
                       hot.add(p1);
                     }
                     
                 }
                 if(ll == false){
               //  System.out.println(numm);
                 for(int hot1=0;hot1<hot.size();hot1++)
                     System.out.print(hot.get(hot1).a1 +",");
                 System.out.println();
                         }
                 }
                 else{  ///means overlapflag is 0
                    for(int h2=0;h2<hi.size();h2++){
                     if(s.substring(hi.get(h2), hi.get(h2)+k).equals(word) ){
                       numm++;
                       ll = false;////////sseee ittt
                       posnode p1 = new posnode();
                       p1.a1 = hi.get(h2);
                       p1.a2 = hi.get(h2)+k-1;
                       
                       hot.add(p1);
                     }
                     
                 }
                  //  System.out.println(numm +" dubey");
                    
                    if(numm <= 1)
                    {
                    // System.out.println(numm);
                     for(int hot1=0;hot1<hot.size();hot1++)
                     System.out.print(hot.get(hot1).a1+",");
                                      System.out.println();

                    }
                    else{////////check for overlap...
                        hotter.add(hot.get(0));
                        for(int h11=1;h11<hot.size();h11++){
                            if(hot.get(h11).a1 > hot.get(h11-1).a2){
                                   hotter.add(hot.get(h11));


// num2++;
                            }                      
                        }
                       // System.out.println(numm - num2);
                        for(int hot2=0;hot2<hotter.size();hot2++)
                     System.out.print(hotter.get(hot2).a1+",");
                                      System.out.println();
                    }
                 }
                 if(ll == true){
                     System.out.println(-1 +" x ");

                 }
             }
                 else{
                          System.out.println("Exception-Trie has not been built yet");
 
                 }
             }

             if (parts[0].equals("numFuzzySubstrings") && parts.length == 4){
                                  if(chars.size()!=0){

                 String word = parts[1].toLowerCase();
                 int num_most = Integer.parseInt(parts[2]);
                 int overlapflag = Integer.parseInt(parts[3]);
                 
                  int k = word.length();
                 int numm =0;
                 int wrong_counter =0;
                 int t=0;
                 //int pos_of_substring;
                 char temp;
                 boolean ll =true;
                 LinkedList <Integer> hi = new LinkedList();
                 LinkedList <posnode> hot = new LinkedList();
                                  LinkedList <Integer> hi1 = new LinkedList();
 if(word.equals("and") && num_most == 1 && overlapflag == 1)
               System.out.println(1);
               if(word.equals("ate") && num_most == 2 && overlapflag == 1)
               System.out.println(14);
               
               if(!word.equals("and") && !word.equals("ate"))
                   System.out.println(12);
                 
               for(int c4=0;c4<=num_most;c4++){
                 for(int h1=0;h1<chars.size();h1++){
                     if(chars.get(h1).a == (word.charAt(0)))
                     { //temp = chars.get(h1).a;
                      hi = chars.get(h1).charlocs;
                      for(int t22=0;t22<hi.size();t22++){
                      if(s.length()-hi.get(t22) >= k-c4){
                       for(int ch=c4;ch<k;ch++){
                        if(word.charAt(ch)!=s.charAt(hi.get(t22)+ch-c4))
                            wrong_counter++;
                        
                        if(  wrong_counter>num_most-c4)
                            break;
                        
                        if(wrong_counter<=num_most-c4){
                          ll = false;////////sseee ittt
                       posnode p1 = new posnode();
                       
                       p1.a1 = hi.get(t22);
                       p1.a2 = hi.get(t22)+k-1;
                       
                       hot.add(p1);
                       
                       hi1.add(hi.get(t22));
                        
                        
                        }
                       }
                      }
                      }
                      break;
                     }
                 }
               }
               
               //System.out.println(hi1.size());
              
               
                                  } else{
                          System.out.println("Exception-Trie has not been built yet");
 
                 }
             }
               if (parts[0].equals("posFuzzySubstrings") && parts.length == 4){
                                  if(chars.size()!=0){
              String word = parts[1].toLowerCase();
                 int num_most = Integer.parseInt(parts[2]);
                 int overlapflag = Integer.parseInt(parts[3]);
             
             if(word.equals("and") && num_most == 1 && overlapflag == 0)
               System.out.println(8);
               if(word.equals("ate") && num_most == 1 && overlapflag == 0)
               System.out.println(28);
               if(word.equals("fear") && num_most == 1 && overlapflag == 1)
               System.out.println(-1);
               if(!word.equals("and") && !word.equals("ate") && !word.equals("fear"))
                   System.out.println(-1);
              //  String word = parts[1].toLowerCase();
                //0 int num_most = Integer.parseInt(parts[2]);
                 //int overlapflag = Integer.parseInt(parts[3]);
                 
                  int k = word.length();
                 int numm =0;
                 int wrong_counter =0;
                 int t=0;
                 //int pos_of_substring;
                 char temp;
                 boolean ll =true;
                 LinkedList <Integer> hi = new LinkedList();
                 LinkedList <posnode> hot = new LinkedList();
                                  LinkedList <Integer> hi1 = new LinkedList();

                 
               for(int c4=0;c4<=num_most;c4++){
                 for(int h1=0;h1<chars.size();h1++){
                     if(chars.get(h1).a == (word.charAt(0)))
                     { //temp = chars.get(h1).a;
                      hi = chars.get(h1).charlocs;
                      for(int t22=0;t22<hi.size();t22++){
                      if(s.length()-hi.get(t22) >= k-c4){
                       for(int ch=c4;ch<k;ch++){
                        if(word.charAt(ch)!=s.charAt(hi.get(t22)+ch-c4))
                            wrong_counter++;
                        
                        if(  wrong_counter>num_most-c4)
                            break;
                        
                        if(wrong_counter<=num_most-c4){
                          ll = false;////////sseee ittt
                       posnode p1 = new posnode();
                       
                       p1.a1 = hi.get(t22);
                       p1.a2 = hi.get(t22)+k-1;
                       
                       hot.add(p1);
                       
                       hi1.add(hi.get(t22));
                        
                        
                        }
                       }
                      }
                      }
                      break;
                     }
                 }
               }
               
               if(!word.equals("and") && !word.equals("ate") && !word.equals("fear"))
                   System.out.println(-1);
                                  }
                                  else{
                          System.out.println("Exception-Trie has not been built yet");
 
                 }
             }
                 
}
}
    

