package week7_Qn1;

public class Main {
	public static void main(String[] args) {
		coordinate point[]=new coordinate[9];
		
		    point[0]=new coordinate(5,5);
	        point[1]=new coordinate(2,1);
	        point[2]=new coordinate(3,2);
	        point[3]=new coordinate(0,3);
	        point[4]=new coordinate(5,0);
	        point[5]=new coordinate(2,4);
	        point[6]=new coordinate(0,0);
	        point[7]=new coordinate(5,3);
	        point[8]=new coordinate(6,3);
		
		giftwrapping gr=new giftwrapping();
		gr.convexHall(point);
	}
}
