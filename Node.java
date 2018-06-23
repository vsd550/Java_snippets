
public class Node<E>{
	public E element;
	public Node<E> next;
	Node(E e, Node<E> n){
		element=e;
		next=n;
	}
	public E getElement(){return element;}
	public Node<E> getNext(){return next;}
	public void setNext(Node<E>k){next=k;}
}
