import java.util.*;
import java.io.*;

public class rmtthread extends Thread{
/* public void run(){
     
 }  */ 
 ////////////--------------------------
 public class RoutingMapTree {///have todefine some variables initially
            public Exchange root ;
                  public RoutingMapTree rmt;
                  Stack st = new Stack();
    public RoutingMapTree(){
        root = new Exchange(0);//constructor things,root created
         root.parent = null;
             }
           /////////
        public void switchOnMobile2(/*MobilePhone*/int a, Exchange b){//stud sa hai..see if it works
        Exchange c = findExchange(b.number);
        MobilePhone d = findPhone(a);//was givingan error here beacuse u were passing mobile phone a...analyse why so???
               if(c!=null){
        if(d!=null && c==d.basestn){
            d.switchOn();
             //e.basestn = c;
                Exchange t = c;
            while(t!=null){
                            t.set.hi.list.add(d);
                            t = t.parent;
            }
        }    
        else{
            MobilePhone e = new MobilePhone(a);
           e.switchOn();
            e.basestn = c;
                Exchange f = c;
            while(f!=null){
                            f.set.hi.list.add(e);
                            f = f.parent;
            }
        }  
        }
        else{
            System.out.println("exchange does not exist");
        }
           }
     public void switchOnMobile(MobilePhone a, Exchange b,Exchange c){//stud sa hai..see if it works
        if(b.number == c.number){
                              if(b.set.hi.list.contains(a)){
                                  a.switchOn();
                              }
                              else{
                                    MobilePhone d = new MobilePhone(a.num);
                                         d.basestn = b;
                          while(b!=null){
            a.status=true;
            b.set.hi.list.add(a);
            b = b.parent;
        }
                              }
        }
        else{
            for(int i=0;i<b.numChildren();i++){
                switchOnMobile(a,b.child(i),c);
            }
        }
    }
    //////////////////
                public void switchOffMobile2( MobilePhone a ){
                MobilePhone b = findPhone(a.num);
                Exchange c = b.basestn;
                if(b != null){
                    b.switchOff();
                    Exchange d = c;
                    while(d!=null){
                        d.set.hi.list.remove(b);
                        d= d.parent;
                    }
                }
                else{
                    System.out.println("phone does not exist");
                } 
                }
                ////////////////
            public void switchOffMobile1(MobilePhone a,Exchange c  ){
       if(c.set.hi.list.contains(a))
       {
           for(int i=0;i<c.set.hi.list.size();i++){
            if(a.num == c.set.hi.list.get(i).num)
                c = c.set.hi.list.get(i).basestn;
                int t =c.set.hi.list.size();
               for(int j=0;j<c.set.hi.list.size();j++){
        if(c.set.hi.list.get(j).num == a.num)
        {
            c.set.hi.list.get(j).switchOff();
            MobilePhone s = c.set.hi.list.get(j);
            c.set.hi.list.remove(s);
            Exchange d = c;
            while(d!=null){
        d.set.hi.list.remove(a);
        d= d.parent;
        }
    }
    }
           }
       }
       else{
                      System.out.println("Error: the phone does not exist,how  will it be switched off");

       }
            }
    ////////////
        public void switchOffMobile(int a){
      MobilePhone f = new MobilePhone(a);
       Exchange c =null;
              for(int i=0;i<root.set.hi.list.size();i++){
           if(root.set.hi.list.get(i).num==a)
       { 
               c = root.set.hi.list.get(i).basestn;
          MobilePhone s = root.set.hi.list.get(i);
  s.switchOff();
c.set.hi.list.remove(s);
       Exchange d = c.parent;
    while(d!=null){
        d.set.hi.list.remove(s);
        d= d.parent;
    }
      }
       }   
        }
        /////////////
  public void addExchng(Exchange a , int i){
      Exchange b = new Exchange(i);
    Exchange c = findExchange(a.number);
    if(c!=null){  
      c.children.add(b); 
      b.parent = c;
      }
      else
      System.out.println("the exchange does not exist");
    }
  /////////
  ///NOT REQUIRED NOW...
  public void addExchnge(Exchange a , Exchange b, Exchange c){
  if(a.number == b.number)
  {a.children.add(c);
  c.parent = a;
  }
  else{
      for(int t=0;t<a.numChildren();t++){
          addExchnge(a.child(t),b,c);
      }
  }
  }
      public Exchange findExchng(Exchange q ,int i){
     if(q!=null){
     Exchange res = null;
    // if(q != null){
      if(q.number == i)
         return q;
      else{
          for(int t=0;res == null && t<q.numChildren();t++){
             res= findExchng(q.child(t) , i);
      }
          }
     // }
      return res;}
     else
         return null;
  }
  /////////
  public Exchange findExchange(int a){//exceptions wil come in the path...handle them...
		return findExchng(root,a);
                
  }
   //////////
  public MobilePhone findPhone(int i){//absolutely correct method
    MobilePhone c = null;
   for(int t=0;t<root.set.hi.list.size();t++){
   if(/*c.num*/i == root.set.hi.list.get(t).num)
   {  c = root.set.hi.list.get(t);
       return c;   //why use a break ..just return andit automatically stops...
   }
       }
       return null;
  }
  ////////////
  public void queryNthChild(Exchange a ,int b){///THIS IS ALSOWORKING PERFECTLY NOW......
      if(b>a.numChildren())
          System.out.println("No. of children is less than the index");
      else{
          int t = a.child(b).number;
          System.out.println(t +" ");
      }
    }
  /////////// NOT REQUIRED NOW...
   public void queryNthChild1(Exchange a ,Exchange c,int b){
    if(a.numChildren()!=0){
       if(a.number == c.number){
         if(b>a.numChildren())
                       System.out.println("No. of children is less than the index");
else
             System.out.println(a.child(b).number);
     }
     else{
        for(int i=0;i<a.numChildren();i++)
            queryNthChild1(a.child(i),c,b);
     }
    }
  }
   ////////////
  public void queryMobilePhoneSet(/*Exchange r ,*/Exchange a){
      Vector <MobilePhone> b = new Vector<MobilePhone>();
        int c =0;
      for(int i=0;i<a.set.hi.list.size();i++){//replace r with a 
          b.add(a.set.hi.list.get(i));
      }
      while(c<b.size()){
          if(b.get(c).status == true)
      System.out.print(b.get(c).num + " ");
      c++;
      }
      System.out.println();
     }
  ///////////////
   public void queryMobilePhoneSet1(Exchange r ,Exchange a){
    if( a.number == r.number) {  
       for(int i=0;i<r.set.hi.list.size();i++){
            if(r.set.hi.list.get(i).status==true)
                System.out.print(r.set.hi.list.get(i).num + " ");
        }
System.out.println();
     }
    else{//extra statement added
        if(r.numChildren()!=0){
         for(int w=0;w<r.numChildren();w++)
         queryMobilePhoneSet1(r.child(w),a);
        }
     }
}
  ///////////////
   public Exchange findPhone1(MobilePhone m){//shayad here mobile phone k badle int krna pde
       return m.basestn;
   }
   public Exchange lowestRouter(Exchange a, Exchange b){
       Exchange c = a;
       Exchange d = b;
       while(c.number!=d.number){
           c = c.parent;
           d=d.parent;
       }
       return c;
   }
   ///////////
   public ExchangeList routeCall(/*MobilePhone*/int a,/* MobilePhone*/int b){
      MobilePhone a1 = findPhone(a);
            MobilePhone b1 = findPhone(b);
              if(a1!=null && b1!= null){
       Exchange c = a1.basestn;
       Exchange d = b1.basestn;
       Exchange e = lowestRouter(c,d);
       ExchangeList path = new ExchangeList();
       while(c.number != e.number){
           path.addLast(c);
           c=c.parent;
       }
       path.addLast(e);
        while(d.number != e.number){
          st.push(d);
          d=d.parent;
       }
        while(!st.isEmpty()){
            path.addLast((Exchange) st.pop());
        }
       return path;
       }
       else
       {
           if(a1 == null)
                      System.out.println("ERROR : the phone with identifier " +a +" is switched off");
        if(b1 == null)
                      System.out.println("ERROR : the phone with identifier " +b +" is switched off");
       
       
       }
                   return null;
   }
   /////////////////
   public void movePhone(/*MobilePhone*/int a, Exchange b){
       MobilePhone c = findPhone(a);// add an exception when the exchange does not exist..
       if(c!=null){
           switchOffMobile2(c);
           switchOnMobile2(a,b);
       }
       else{
           System.out.println("the phone does not exist");
       }
   }
  /////////////
 public void performAction(String actionMessage) {
                System.out.println(actionMessage);
                String [] parts = actionMessage.split(" ");
                if(parts[0].equals("addExchange"))
                { 
                   int a = Integer.parseInt(parts[1]);
                                     int   b = Integer.parseInt(parts[2]);
                        Exchange c = findExchng(root,a);
                        if(c!=null)
                                           addExchng(c, b);
else              
                    System.out.println("the exchange does not exist");
    
//   Exchange c =  new Exchange(a); 
                 // Exchange c =new Exchange(a);
                  //Exchange d = new Exchange(b);
                  
                 // addExchnge(root,c,d);

                }
 ///////////////////
   if(parts[0].equals("switchOnMobile"))
 {
  int   a = Integer.parseInt(parts[1]);
     int b = Integer.parseInt(parts[2]);
    // Exchange c = findExchange(b);
  //  Exchange c = new Exchange(b); 
   // MobilePhone d = findPhone(a);
    Exchange c = findExchange(b);
     //switchOnMobile(d,root,c);
     if(c!=null)
     switchOnMobile2(a,c);
       else
     System.out.println("the exchange does not exist");
 
 }
 //////////
  if(parts[0].equals("switchOffMobile"))
  {
          int  a = Integer.parseInt(parts[1]);
     MobilePhone d = findPhone(a);
          //switchOffMobile(a);
   //Exchange p=root;
          //switchOffMobile1(d,p);
          switchOffMobile2(d);

  }
  //////////////
    if(parts[0].equals("queryNthChild")){
       int a = Integer.parseInt(parts[1]);
   int  b = Integer.parseInt(parts[2]);
     Exchange c = findExchng(root,a);
    if(c!=null)
     queryNthChild(c,b);
else
        System.out.println("the echange does not exist");

    /* if(b>c.numChildren())
         System.out.println("no. of children is less than the index");
     int t = c.child(b).number;
          System.out.println(t + " ");*/
  //  Exchange c = new Exchange(a);
    //queryNthChild1(root,c,b);
         }
//////////////
  
              if(parts[0].equals("queryMobilePhoneSet")){
                           int  a = Integer.parseInt(parts[1]);
                            Exchange c = new Exchange(a);
                             queryMobilePhoneSet1(root,c); 
         /*    Exchange c = findExchange(a);
             queryMobilePhoneSet(c);*/
              }
 // till here...
  if(parts[0].equals("queryFindPhone")){
                           int  a = Integer.parseInt(parts[1]);
 MobilePhone b = findPhone(a);
 if(b!=null){
 
 int c = findPhone1(b).number;
 System.out.println(c);}
 else
      System.out.println("the phone does not exist...");
    }
 ///////////
  if(parts[0].equals("queryLowestRouter")){
                           int  a = Integer.parseInt(parts[1]);
                               int  b = Integer.parseInt(parts[2]);
                               Exchange c = findExchange(a);
                               Exchange d = findExchange(b);
                               Exchange e = lowestRouter(c,d);
                               System.out.println(e.number);
                               
  }
  ////////////
  if(parts[0].equals("movePhone")){
                           int  a = Integer.parseInt(parts[1]);
                           int  b = Integer.parseInt(parts[2]);
  Exchange c = findExchange(b);
if(c!=null)  
  movePhone(a,c);
  else
          System.out.println("the exchange does not exist...");

  }
  ////////
   if(parts[0].equals("queryFindCallPath")){// catching null pointer exception here gives quite a bit of learning...
                           int  a = Integer.parseInt(parts[1]);
                               int  b = Integer.parseInt(parts[2]);
                              // MobilePhone m1 = findPhone(a);
                               //MobilePhone m2 = findPhone(b);
                              try{ 
                               ExchangeList c = routeCall(a,b);
                               for(int i=0;i<c.size();i++){
                               System.out.print(c.get(i).number + ",");
                               
                               }
                               System.out.println();
                              }catch(NullPointerException e){
                                  
                              }
   }
                              
   //////
 } 
  
}
 
}
