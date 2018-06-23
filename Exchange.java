
public class Exchange {
	public int number;
	public MobilePhoneSet allmobiles = new MobilePhoneSet();
	public Exchange(int n){
		number=n;
		}
	public Exchange parent;
	public ExchangeList children;
	public Exchange parent(){return parent;}
	public int numChildren(){
		return children.xl.size;
	}
	public Exchange child(int i){
		Node<Exchange> k = children.xl.head;
		for (int j=0;j<i-1;j++){
			k=k.getNext();
		}
		return k.getElement() ;
	}
	public Boolean isRoot(){
		if (parent==null) return true;
		else return false;
	}
	public MobilePhoneSet residentSet(){
		return allmobiles;
	}
	public  RoutingMapTree subtree(int i){
		 RoutingMapTree t =new  RoutingMapTree();
		 t.root=child(i);
		 return t;
		
	}
/*public static void main(String args[]){
	Exchange a = new Exchange(1);
	Exchange a1 = new Exchange(2);
	Exchange a2 = new Exchange(3);
	Exchange a3 = new Exchange(4);
	a.children.xl.addFirst(a1);
	a.children.xl.addFirst(a2);
	a.children.xl.addFirst(a3);
	a.child(3);
	
}*/
}

