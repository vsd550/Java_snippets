import java.util.*;
import java.io.*;


 ////////////////////////////////////////////
 
///////////////----------------------

public class graph1 {
    public LinkedList<VertexNode> vertices = new LinkedList(); 
    public LinkedList<edge> edges = new LinkedList();
    
    public edge getEdge(String s1 , String s2){
        VertexNode origin = new VertexNode(s1);
            VertexNode dest = new VertexNode(s2);
            
            return origin.getOutgoing().get(dest);

    }
    
     public void addVertex(String name){
        VertexNode v=new VertexNode(name);
        vertices.addLast(v);
    }
      public VertexNode opposite(VertexNode u , edge e){
          String c = null;
            for(int i=0;i<edges.size();i++){
                if(edges.get(i).equals(e)){
                    String [] ends = edges.get(i).getEndpoints();
                    if(ends[0].equals(u))
                        c = ends[1];
                    if(ends[1].equals(u))
                        c = ends[0];
                }
                    ///c = vertices.get(i);
                for(int j=0;j<vertices.size();j++){
                    if(vertices.get(j).label.equals(c))
                        return vertices.get(j);
                }
            }
            ///c.outgoing.
            
          return null;
            
        }
    public void addEdge(String u,String v,int t){
        edge e=new edge(u,v,t);
        boolean foundv1=false;
        boolean foundv2=false;
        edges.add(e);
        int i;
        for(i=0;i<vertices.size();i++){
            if(vertices.get(i).label.equals(u)){
                vertices.get(i).outgoing.put(v,e);////same as in the book....
                foundv1=true;
            }else if(vertices.get(i).label.equals(v)){
                vertices.get(i).outgoing.put(u,e);
                foundv2=true;
            }
        }
        if(!foundv1){
            addVertex(u);
            vertices.getLast().outgoing.put(v, e);
        }
        if(!foundv2){
            addVertex(v);
            vertices.getLast().outgoing.put(u, e);
        }
    }
    public Iterable<edge> outgoingEdges(VertexNode v) { 
       // InnerVertex<V> vert = validate(v);
       for(int i=0;i<vertices.size();i++){
           if(vertices.get(i).label.equals(v.label))
               return vertices.get(i).getOutgoing().values();
       }
           return null; // edges are the values in the adjacency map
 }
    
    public HashMap <VertexNode ,Integer> shortestpathlengths(String src){
        
        HashMap <VertexNode ,Integer> d = new HashMap(); //////////stores the upper bounds
    HashMap <VertexNode ,Integer> cloud = new HashMap();
    LinkedList<VertexNode> newList  = new LinkedList();///just to store the cloud vertices
    
    for(int i=0;i<vertices.size();i++){
        if(vertices.get(i).label.equals(src))
        {  d.put(vertices.get(i), 0);
        newList.add(vertices.get(i));  /////add it in the newList
        }
        else
            d.put(vertices.get(i), Integer.MAX_VALUE);
        ///////put d[src] =0 and rest as infinity....
   }
    ////now we need to pull out vertices from d into cloud and update d accordingly...  
    if(!newList.isEmpty()){
        VertexNode u = newList.remove();
        cloud.put(u, d.get(u));////properties of hashMaps
        
       // LinkedList<edge> outedges = outgoingEdges(u); 
        while(outgoingEdges(u).iterator().hasNext()){
            VertexNode v = opposite(u,outgoingEdges(u).iterator().next());
            if(cloud.get(v) == null){
                int wgt = outgoingEdges(u).iterator().next().time;
                if(d.get(u)+wgt < d.get(v)){
                    d.put(v, d.get(u)+wgt);
                    newList.add(v);
                }
            }
            
        }
        
    }
    return cloud;
    }
 
    ///****------
    
}
