
public class Taxi {
   public String taxiName;
   public String currentpos;
   public int time;
   
   public Taxi(String name ,String pos){
       taxiName = name;
       currentpos = pos;
      time =0;
   }
   public String getTaxiName(){
       return taxiName;
   }
   public String getPosition(){
       return currentpos;
   }
   public int getAvailability(){
     return time;
   }
   
}
