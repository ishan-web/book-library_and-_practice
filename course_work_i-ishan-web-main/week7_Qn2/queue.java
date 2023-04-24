package week7_Qn2;

public class queue {
	int queue[]=new int[6];
	int size;
	int rear;
	int front;
	
	
	//template
	public void enqueue(int value) {
		if(!isFull()) {
			queue[rear]=value;
			rear= (rear +1)%6; //rear+1;
			//size++;
			size=size+1;
		}
		else {
			System.out.println("quess is full");
		}
		
	}
	public void dequeue() {
		if(!isEmpty()) {
			front= (front +1) %6;//front+1;
			size--;
		}
		else {
			System.out.println("queue is Empty");
		}
		
	}
	public boolean isEmpty() {
		
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
		//return size==0;
	}
	public boolean isFull() {
		return size==6;
	}
	public void display() {
		System.out.println("rear " + rear);
		System.out.println("front " + front);
		System.out.println("size " + size);
		
		System.out.print("Element in queue ");
		for(int i=0; i<size; i++) {
			//System.out.print(queue[i] + " ");
			//to do the front using deque you have to do
			System.out.print(queue[(front + i)%6] + " ");
		}
		System.out.print("\nactual array ");
		for(int i:queue) {
			System.out.print(i + " ");
		}
	}
	
	
}
