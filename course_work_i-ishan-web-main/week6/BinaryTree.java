package week6;

public class BinaryTree {
	 int nodes [];
	    BinaryTree(int height) {
	        nodes = new int[(int)Math.pow(2, height)];
	        for (int i=0; i<nodes.length; i++) {
	            nodes[i] = -1;
	        }
	    }
	    public void createTree(int child, int parent, String position) {
	        int index_of_child;
	        int index_of_parent = getIndex(parent);
	        if (position == "left") {
	            index_of_child = (2*index_of_parent) + 1;
	            nodes[index_of_child] = child;
	        } else if(position == "right") {
	            index_of_child = (2*index_of_parent) + 2;
	            nodes[index_of_child] = child;
	        }

	    }
	    public int getIndex(int data) {
	        int index = -1;
	        for (int i=0; i<nodes.length; i++) {
	            if (nodes[i] == data) {
	                index = i;
	                break;
	            }
	        }
	        return index;
	    }
	    public void printTree() {
	        for (int i=0; i<nodes.length; i++) {
	            System.out.print(nodes[i] + " ");
	        }
	        System.out.println();
	    }
	    public int findParentIndex(int child) {
	        int child_index = getIndex(child);
	        return (child_index-1)/2;
	    }
	    public boolean isBalanced(int head[]) {
	        boolean balanced = false;
	        int parent_index, left_data, right_data;
	        for(int i=0; i<head.length; i++) {
	            parent_index = getIndex(head[i]);
	            left_data = nodes[(2*parent_index) + 1];
	            right_data = nodes[(2*parent_index) + 2];
	            if (left_data != -1 && right_data != -1) {
	                balanced = true;
	            } else {
	                balanced = false;
	                break;
	            }
	        }
	        return balanced;
	    }

	    public static void main(String[] args) {
	        BinaryTree bt = new BinaryTree(4);
	        bt.nodes[0] = 1;
	        bt.createTree(2, 1, "left");
	        bt.createTree(3, 1, "right");
	        bt.createTree(5, 2, "right");
	        bt.createTree(6, 3, "left");
	        bt.createTree(7, 3, "right");
	        bt.createTree(14, 7, "left");
	        bt.createTree(15, 7, "right");
	        bt.printTree();
	        int head[] = {3, 7};
	        System.out.println(bt.isBalanced(head));
	    }
}
