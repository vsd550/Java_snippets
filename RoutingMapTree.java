
public class RoutingMapTree {
	public Exchange root;
	public RoutingMapTree(){
		root = new Exchange(0);
		root.parent = null ;
		root.children = new ExchangeList();
		root.number = 0;
		}
	public Boolean containsNod(Exchange root,Exchange a){
		if (a==root) return true;
		else{
		Node<Exchange> b= root.children.head;
		while (b!=null){
				if (b.getElement()== a) return true;
				else b=b.getNext();}
		Node<Exchange> c= root.children.head;
		while (c!=null){containsNod(c.getElement(),a);
		c.getNext();
		}
		}
		return false;
	}
	public Boolean containsNode(Exchange a){
		return containsNod(root,a);
	}
	public void switchOn(MobilePhone a,Exchange b){
		if (a.status==false){a.status=true;}
		a.basestation=b;
		b.allmobiles.swaroop.Insert(a);
		Exchange k=b.parent;
		while(k!=null){k.allmobiles.swaroop.Insert(a);
		k=k.parent;}
	}
	public void switchOff(MobilePhone a){
		if (a.status==true){a.status=false;}
		Exchange k=a.basestation;
		while (k!=null){
			k.allmobiles.swaroop.Delete(a);
			k=k.parent;
		}
	}
	public void addExchange(Exchange a,int b){
		Exchange c = new Exchange(b);
		//System.out.println("alkjfa;lfa;");
		if (containsNode(a)){
		a.children.addFirst(c);
		}
		else {
			System.out.println("Exchange a is not available in the tree");
		}
	}
	public void addMobile(MobilePhone i,Exchange E){
		i.status=true;
		E.allmobiles.swaroop.Insert(i);
	}
	public int queryNthChild(Exchange a,int b){
		//System.out.println(" hm ");
		Node<Exchange> k=a.children.head;
		if (b>a.children.size){System.out.println("child doesn't exist");}
		else{
			//System.out.println("vhjvjhbj");	
		for(int i=1;i<b;i++){
				 k=k.getNext();
				}
		return k.getElement().number;
		//System.out.println();
		}
		return -1;	
	}
	public Exchange findexchang(Exchange root,int a){
		if (root.number==a) return root;
		Node<Exchange> k = root.children.head;
		while (k!=null){
			if (k.getElement().number==a) return k.getElement(); else
				k = k.getNext();
		}
		Node<Exchange> c = root.children.head;
		while(k!=null){
			findexchang(c.getElement(),a);
			c = c.getNext();
		}
		return null;
	}
	public Exchange findExchange(int a){
		return findexchang(root,a);
	}
	public MobilePhone findNumber(int a){
		Node<MobilePhone> b = root.allmobiles.swaroop.agni.head;
		while(b!=null){
			if (b.getElement().number==a) return b.getElement();
			b = b.getNext();
		}
		for(int i=1;i<=root.children.size;i++){
			RoutingMapTree c = new RoutingMapTree();
			c=root.subtree(i);
			c.findNumber(a);
		}
		return null;		
	}
	public void queryMobilePhoneSet(Exchange a){
		Node<MobilePhone> b = a.allmobiles.swaroop.agni.head;
			while(b!=null){
			System.out.println(b.getElement().number);
			b = b.getNext();
			}
	}
	public void performAction(String answer){
		                        
                        System.out.println(answer);
                String [] parts = answer.split(" ");
                if(parts[0].equals("addExchange"))
                { 
                   int a1 = Integer.parseInt(parts[1]);
                                     int   b = Integer.parseInt(parts[2]);
                                     
					//int z=Integer.parseInt(answer.substring(12,x+1));
					//int y=Integer.parseInt(answer.substring(x+1,(answer.length())+1));
					Exchange a = findExchange(a1);
				//	int b = ;
					//System.out.println("fakfkf;la");
					addExchange(a,b);
				}
		else {
			//System.out.println(answer);
               // String [] parts = answer.split(" ");
                if(parts[0].equals("switchOnMobile"))
                { 
                   int z = Integer.parseInt(parts[1]);
                                     int   y = Integer.parseInt(parts[2]);
					//	int z=Integer.parseInt(answer.substring(15,x));
					//	int y=Integer.parseInt(answer.substring(x+1,(answer.length())+1));
						MobilePhone a = findNumber(z);
						Exchange b = findExchange(y);
						switchOn(a,b);
			}
			else{
				if(parts[0].equals("switchOffMobile"))
				{
					//System.out.println("hb");
					int x = Integer.parseInt(parts[1]);
					MobilePhone a = findNumber(x);
					switchOff(a);
				}
				else{
					if(parts[0].equals("queryNthchild"))
					{
						//System.out.println("vjhbvk");
                                            int z = Integer.parseInt(parts[1]);
                                     int   b = Integer.parseInt(parts[2]);
						
					//			int z=Integer.parseInt(answer.substring(14,x));
					//			int b=Integer.parseInt(answer.substring(x+1,(answer.length())+1));
								Exchange a = findExchange(z);
								/*System.out.println*/
								queryNthChild(a,b);
					}
					else{
						if(parts[0].equals("queryMobilePhoneSet"))
						{
							//System.out.println("bkjnkl");
							int x = Integer.parseInt(parts[1]);
							Exchange a = findExchange(x);
							queryMobilePhoneSet(a);
						}
					}
				}
			}
		}
	}
public static void main(String args[]){
	RoutingMapTree tree=new RoutingMapTree();
	//tree.performAction("addExchnage 0 1");
	//tree.performAction("switchOnMobile 856 6");
	
}
}