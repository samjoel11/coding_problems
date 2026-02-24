import java.util.Scanner;
public class Decrpat {
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no=");
		int n=sc.nextInt();
		int i,j;
		for(i=0;i<n;i++)
		{
			for(j=i;j<n;j++)
			{
				System.out.print((char)(65+j));
			}
			System.out.println();
		}
	}

}
