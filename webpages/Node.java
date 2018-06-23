/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages;

/**
 *
 * @author Vijay
 */
public class Node{
        int val; Node left; Node right;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
}

class Test{
    int a; int b;
    Test(){ 
        this(10,10);
        System.out.println("Andar Se"+ this.a);
        
    }
    Test(int a,int b){
        
        this.a = a; ///this 
        this.b = b;
    }
    
    public void show(Test t){
        System.out.print(t.a + " xx " +t.b);
    }
    
    public void get(){ ///this as a methid parameter
        show(this);
    }
    
   // public static void main(String [] args){
    //Test t = new Test();
//}
}

class Base{
     public static void show(){ ///final nahi kr skte...wont be over ridden in sub class
        System.out.println("Base SE");
    }
}

class Derived extends Base{
     public static void show(){ ///if it has to override, it has to be static...although PLOYMORPHISM WONT HAPPEN
        System.out.println("Derived SE");
    }
}

class Derived2 extends Base{
     public static void show(){ ///if it has to override, it has to be static...although PLOYMORPHISM WONT HAPPEN
        System.out.println("Derived2 SE");
    }
}

    class Main{
        public static void DoPrint(Base o){ //isme Derived object bhipass ho skte
            System.out.println("hahah");
        }
        public static void DoPrint2(Derived o){ //isme Base object nhi pass ho skte
            System.out.println("hahahXP");
        }
public static void main(String [] args){
    Test t = new Test();
    Base b =  new Derived(); /// we want this functionality, then only polymorphism comes into play
    Base b2 = new Derived2();
    
    Derived d = new Derived();/// show to iska apna function hai...
    Derived2 d2 = new Derived2();
    d.show(); // this would show derived se
    b.show();
    
    DoPrint(b);
    DoPrint(b2);
   // DoPrint2(b);
   t.get();
   System.out.println();
}
    }

