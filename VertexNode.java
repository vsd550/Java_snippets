import java.util.*;


public class VertexNode {
    public String label;
    public  HashMap<String , edge> outgoing , incoming;////the opposite vertex is being mapped to the edge
    int distance;
    public VertexNode(String s1){
        label = s1;
        outgoing = new HashMap();
        incoming = outgoing;
        distance = Integer.MAX_VALUE;
    }
    
    public String getVertexName(){
        return label;
    }
    public HashMap<String, edge> getOutgoing(){
        return outgoing;
    }
    public HashMap<String, edge> getIncoming(){
        return incoming;
    }
    public boolean IsNeighbour(VertexNode v){
       // String [] neighbours = outgoing.keySet().add(0);
      return outgoing.containsKey(v.label);
      /* if(outgoing.keySet().contains(v.label)){
           return true;
       }
       return false;*/
    }
    public int getDistance(VertexNode v){
		 int k=0;
		 if(IsNeighbour(v)){
			 
			 while( (v.label.equals(outgoing.)) == false){
				 k = k+1;
			 }
			 return get2(k);
		 }
		 return Integer.MAX_VALUE;
	 }
 }