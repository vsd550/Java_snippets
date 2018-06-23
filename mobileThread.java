import java.util.*;
public class mobileThread extends Thread{
    public int num1; 

public mobileThread(int num){//imp while extending a class having a constructor
    //super(num);//Might get ERROR here...
    num1 = num;
   // MobilePhone m = new MobilePhone(num);
  }
        MobilePhone m = new MobilePhone(num1);

    public void run(){//over riding the run method is very imp...
      //as each mobile is a thread waiting of thread via sleep will be useful
          Random r = new Random();
     //   int a;
       // while(System.currentTimeMillis() - tstart < 2)
        //  a = 1+r.nextInt(3);//rand values between 1 and 3...
    if(1+r.nextInt(3) == 1){
        if(m.isBusy())
            System.out.println("phone is busy on another call");
        else{
            ///initiate a call ...but how??/
        }
    } 
    if(1+r.nextInt(3) == 2){
       m.switchOn();
    }
    if(1+r.nextInt(3) == 3){
        
    }
    
    }
         
   
    
    }
  

