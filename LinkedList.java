
public class LinkedList<E> {
	public Node<E> head=null;
	public Node<E> tail=null;
	public int size=0;
	public int size(){return size;}
	public Boolean IsEmpty(){
		if (size==0) return true;
		else return false;
		}
	public E first(){
		if (size==0) return null;
		else return head.getElement();
		}
	public E last(){
		if (size==0) return null;
		else return tail.getElement();
		}
	public void addFirst(E e){
		head = new Node<>(e,head);
		if (IsEmpty()) head = tail;
		size++;
		}
	public void addLast(E e){
		Node<E> newest = new Node<>(e,null);
		if (IsEmpty()) head = newest;
		tail.setNext(newest);
		tail = newest;
		size++;
		}
	public E removeFirst(){
		if (IsEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size==0)
			tail = null;
		return answer;
		}
	
}
