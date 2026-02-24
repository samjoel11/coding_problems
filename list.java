import java.util.*;
public class list {
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer>no=new ArrayList<>();
		ArrayList<String>st=new ArrayList<>();
		ArrayList<Character>ch=new ArrayList<>();
		no.add(2);
		no.add(4);
		no.add(69);
		no.add(7);
		System.out.println("Integer List:"+no);
		no.sort(Comparator.naturalOrder());
		System.out.println("Sorted Integer List:"+no);
		System.out.print("Enter no=");
		int a=sc.nextInt();
		int removeInt=no.remove(a);
		System.out.println("After removing:"+no);
		st.add("Iam");
		st.add("not in");
		System.out.println("String List:"+st);
		System.out.print("Enter no=");
		int b=sc.nextInt();
		st.add(b,"Danger");
		System.out.println("Updated:"+st);
		System.out.print("Enter no=");
		int c=sc.nextInt();
		String w=st.set(c,"the");
		System.out.println("Replaced:"+st);
		ch.add('H');
		ch.add('A');
		ch.add('N');
		ch.add('K');
		Iterator<Character>ite=ch.iterator();
		System.out.println("Element:Index");
		while(ite.hasNext())
		{
			char el=ite.next();
			System.out.print(el+":");
			System.out.println(ch.indexOf(el));
		}
	}
}
