package week7_Qn1;

import java.util.Stack;

public class giftwrapping {
	public int direction(coordinate p, coordinate q, coordinate r) {
		//formula for convex hall
		int area=(q.x-p.x)*(r.y-q.y)-(q.y-p.y)*(r.x-q.x);
		return area;
		
	}
	public void convexHall(coordinate point[]) {
		Stack<coordinate> Stack=new Stack<coordinate>();
		int left=0;
		int n=point.length;
		
		//finding the left most
		for(int i=1;i<n;i++) {
			if(point[i].x<point[left].x) {
				left=i;
			}
		}
		int p=left;
		
		//finding the convex hall point
		do {
			Stack.add(point[p]);
			int q=(p+1)%n;
			for(int r=0; r<n; r++) {
				if(direction(point[p],point[q],point[r])>0) {
					q=r;
				}
			}
			p=q;
		}
		while(p!=left);
		{
			Stack.add(point[p]);
		}
		//display
		for(coordinate i: Stack) {
			System.out.println("convex hall point( "+i.x+" "+i.y+ ")");
		}
	}

}
