import java.util.*;
public class TaxiService{
    graph1 g=new graph1();
    LinkedList<Taxi> listOfTaxies=new LinkedList<>();
    
    
    
    public void taxi(String taxiName,String taxiPosition){
				Taxi u = new Taxi(taxiName,taxiPosition);
				listOfTaxies.add(u);
			}
    public void printTaxiPosition(int t){
				 int i;
				 for (i=0;i<listOfTaxies.size();i++){
					 Taxi w =listOfTaxies.get(i); 
					 if(w.time <=t){
						 System.out.println(" Taxi "+w.getTaxiName()+" : "+w.getPosition());
					 }
				 }System.out.println("");
				}
      public LinkedList<VertexNode>  min_distance(VertexNode v,LinkedList<VertexNode> o ,LinkedList<VertexNode> nn){
				 
				
				 if(o.size()==0)
					 return nn;
				 else
				 {
					o.remove(v);
				   //o.Delete1(v);
				   if(v.distance==Integer.MAX_VALUE) {v.distance = 0;}
				   nn.addLast(v);
				   for (int i=0;i<o.size();i++){
					   VertexNode gk = o.get(i);
					   if(v.IsNeighbour(gk))
					   {
						   int z = v.distance + v.getDistance(gk);
						   if(z<gk.distance) {gk.distance = z;
						   gk.previous=v;}
					   }
				   }
				   VertexNode mn =o.get(0);
				   for(int k=0; k<o.size();k++){
					   VertexNode lm = o.get(k);
					   if(lm.distance<mn.distance)
					   {mn =lm;}
				   }
				   return min_distance(mn,o,nn);
				 }
				 
			 }  

    public void performAction(String actionMessage) {
        System.out.println(actionMessage);
        String[] parts=actionMessage.split(" ");
        if(parts[0].equals("edge")){
            String source = parts[1];
            String dest = parts[2];
            int time = Integer.parseInt(parts[3]);
            
            g.addEdge(source, dest, time);
            
         /*   for(int i=0;i<g.vertices.size();i++){
                System.out.print(g.vertices.get(i).label +" xx ");
                
            }
            System.out.println();*/
          /*  for(int i=0;i<g.edges.size();i++){
                System.out.print(g.edges.get(i).endpoints[0] +" xxx ");
                                System.out.print(g.edges.get(i).endpoints[1] +" xxx ");
                System.out.print(g.edges.get(i).time +" xxx ");

            }
            System.out.println();*/
                                                      }
        if(parts[0].equals("taxi")){
            String taxiname = parts[1];
            String taxiPos = parts[2];
         //   boolean flag = false;
           taxi(taxiname,taxiPos);
            //Taxi t =new Taxi(taxiname);
            
          /*  for(int i=0;i<g.vertices.size();i++){
                if(g.vertices.get(i).label.equals(taxiPos))
                {  flag = true;
                    t.currentpos = g.vertices.get(i);  
                }
            }*/
          /*  if(flag == false){
                System.out.println("error, the vertex doesnot exist");
            }*/
          //  t.status = true;
          //  listOfTaxies.add(t);
            
            for(int i=0;i<listOfTaxies.size();i++){
                System.out.print(listOfTaxies.get(i).currentpos +" x ");
                System.out.print(listOfTaxies.get(i).taxiName +" x ");
               // System.out.print(listOfTaxies.get(i).currentpos +" x ");
            }
            System.out.println();
                                            }
         if(parts[0].equals("customer")){
            String src = parts[1];
            String dest = parts[2];
            boolean flag = false;
        
        HashMap<VertexNode,Integer> gf = g.shortestpathlengths(src);
        
        while(!gf.isEmpty()){
            System.out.print(gf.values());
            
        }
    }
         if(parts[0].equals("printTaxiPosition")){
            int time = Integer.parseInt(parts[1]);
			
			printTaxiPosition(time);
		}
}
}