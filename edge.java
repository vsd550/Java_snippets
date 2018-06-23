import java.util.*;

public class edge{
     //String src;
     //String dest;
     public String [] endpoints;
     int time;
     
     public edge(String u, String v, int t ){
         time = t;
         endpoints = (String [])new String[]{u,v}; /////creates an array...nothing much
     }
     public int getTime(){
         return time;
     }
     public String[] getEndpoints(){
         return endpoints;
     }
     
 }