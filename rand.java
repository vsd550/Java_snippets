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

public class rand {
    public static void main ( String args [])
	{
		BufferedReader br = null;
              //  print p = new print();
                
		RoutingMapTree r = new RoutingMapTree();

		try {
			String actionString;
			br = new BufferedReader(new FileReader("actions.txt"));

			while ((actionString = br.readLine()) != null) {
				r.performAction(actionString);
                        
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
