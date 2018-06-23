/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vijay
 */
import java.util.*;
import java.io.*;
public class heapstruct {
   //    BufferedReader br = null;
		//RoutingMapTree r = new RoutingMapTree();
// first we build up the tree...then we randomize things....
public static void heapmake(){	
    ArrayList <Integer>a = new ArrayList ();
			 try {//change file name
 FileInputStream fstream = new FileInputStream ("in3.txt");
 Scanner s = new Scanner (fstream);
 while (s.hasNext()){
     int t = s.nextInt();
     a.add(t);
 }
 //System . out . println (s. nextLine ());
 } catch ( FileNotFoundException e) {
 System . out . println (" File not found ");
 }
        ////////////                 ///////////
                         try {
 FileOutputStream fs = new FileOutputStream ("out.txt",true );
 PrintStream p = new PrintStream (fs );
 for(int i=0;i<a.size();i++)
 p. print (a.get(i) + ",");
 
 } catch ( FileNotFoundException e1) {
 System . out . println (" File not found ");
 }
 }

/*public static void main(String args[]){
    heapmake();
}*/
}
