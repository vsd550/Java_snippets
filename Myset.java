
public class Myset<E> {
	LinkedList<E> agni = new LinkedList<E>();
	public Boolean IsEmpty(){
		if (agni.IsEmpty()) return true;
			return false;
		}
	public Boolean IsMember(E o){
		Node<E> k = agni.head;
		while (k!=null){
			if (o==k.getElement()){
			return true;}
		else
			{k= k.getNext();
		}	}
			return false;
		}
	public void Insert(E o){
		if (IsMember(o)) {System.out.println("it is available");}
		else
			{agni.addFirst(o);}
		}
	public void Delete(E o){
		if (IsMember(o)==false) {System.out.println("not available");}
		else
		{Node<E> k=agni.head;
		while (k!=null)	{if ((k.getNext()).getElement()==o)
		{k.setNext(k.getNext().getNext());
		}
		else
		{k= k.getNext();}
			}
		}
		}
	public Myset<E> Union(Myset<E> a){
		Node<E> x = agni.head;
		Myset<E> b= new Myset<E>();
		while (x!=null) {
			if (a.IsMember(x.getElement())==true) {
				x=x.getNext();
			}else {
				b.Insert(x.getElement());
				x=x.getNext();
			}
		}
		Node<E> y = a.agni.head;
		while (y!=null) {b.Insert(y.getElement());y=y.getNext();
		}
		return b;	
		}
	public Myset<E> Intersection(Myset<E> a){
		Node<E> x = agni.head;
		Myset<E> c= new Myset<E>();
		while (c!=null) {if (a.IsMember(x.getElement())){
			c.Insert(x.getElement());
		}
			}
		return c;
		}
}
