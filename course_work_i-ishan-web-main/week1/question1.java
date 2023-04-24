package week1;
import java.util.HashSet;
import java.util.LinkedList;

public class question1 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static LinkedList<Integer> mylist = new LinkedList();

    public static void printArray(int[] r) {

        System.out.println("");
        for(int i=0; i<r.length; i++)
            System.out.print(r[i]);
            //System.out.println("-->");
    }

    public static void swap(int[] s, int o, int f) {
        int temp=s[o];
        s[o]=s[f];
        s[f]=temp;

    }

    public static void printPermutation(int[] e, int b) {
        if (b == e.length-1) {
           toBinary(e);
            return;
        }

        HashSet<Integer>hash = new HashSet<Integer>();
        for (int i=b; i<e.length; i++) {
            if(hash.contains(e[i])==true)
                continue;
            hash.add(e[i]);

            swap(e, i , b);
            printPermutation(e, b+1);
            swap(e, i, b);
        }
    }

    public static void toBinary(int binary[]) {	    	

        int decimal = 0;

        int length = binary.length;
        for (int a=length-1;a>=0;a--){

            decimal = (int) (decimal + binary[a]* Math.pow(2,length-1-a));
        }
        mylist.add(decimal);

    }
    public static void main(String[] args) {
        int[] t= {1,0,1};
        printPermutation(t, 0);
        System.out.println(mylist);

//        toBinary();
}
}
