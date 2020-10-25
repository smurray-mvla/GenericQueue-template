import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class GenericQueue<E> {
	private static final int MAX_QUEUE_SIZE = 20;
	private LinkedList<E> queue = new LinkedList<>();

	public GenericQueue() {		
	}

	public boolean add (E o) throws IllegalStateException {
		if (queue.size() == MAX_QUEUE_SIZE) 
			throw new IllegalStateException("Add failed - Queue is full");
		queue.addLast(o);
		return true;
	}
	
	public E remove() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("No Element to be removed - Queue is empty");
		return(queue.removeFirst());
	}

	public E element() throws NoSuchElementException {	
		if (isEmpty())
			throw new NoSuchElementException("No Element to be removed - Queue is empty");
		return(queue.getFirst());
	}
	
	public boolean offer (E o) {
		if (queue.size() == MAX_QUEUE_SIZE)
			return false;
		queue.addLast(o);
		return true;
	}
	
	public E poll() {
		if (isEmpty()) 
			return null;
		return(queue.removeFirst());
	}

	public E peek() {	
		if (isEmpty()) 
			return null;
		return(queue.getFirst());
	}
	
	public boolean isEmpty() {
		return (queue.isEmpty());
	}
	
	public int getSize() {
		return (queue.size());
	}
	
	@Override
	public String toString() {
		String str = "queue: [";
		ListIterator<E> list = queue.listIterator(0);
		if (list != null) {
			while (list.hasNext()) {
				str += list.next();
				if (list.hasNext()) str += ",";
			}
		}
		str += "]";
		return str;
	}

}
