package week7_Qn2;

public class main {
	public static void main(String[] args) {
		queue qq=new queue();
		
		qq.enqueue(40);
		qq.enqueue(50);
		qq.enqueue(60);
		
		qq.dequeue();
		qq.enqueue(70);
		
		qq.dequeue();
		qq.enqueue(80);
		qq.enqueue(90);
	
//		System.out.println(qq.isEmpty());
//		System.out.println(	qq.isFull());
	
		qq.display();
	}
}
