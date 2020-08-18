import java.util.*;
import java.io.*;
class refactoring
{
	static int c=0;
	public static void main(String args[])throws IOException
	{
		int k=0;
		String s="",x="",v="";
		File file = new File("code"); 
		BufferedReader br=new BufferedReader(new FileReader(file));
		Scanner sc=null;
		while((s=br.readLine())!=null)
		{
			c++;						//counting lines
			sc=new Scanner(s);
			x=sc.next();
			if(x.compareTo("for")==0)
			{
				k++;
			}
			if(k==2 && x.compareTo("if")==0)		//k==2 implies nested for loop and if condition states bubble sort algorithm pattern
			{
				v=sc.next();				//if condition contains array name and v is used to hold array name to be extracted
				break;
			}
		}
		refactoring r=new refactoring();
		System.out.println("The Original File:\n");
		r.display("code");					// printing original file
		r.modify(r.extract(v));					// extracting array name and using that to refactor original code
		System.out.println("\nThe Refactored File:\n");
		r.display("refactor");					// Printing refactored code
	}

	public String extract(String v)
	{
		String a="";
		for(int i=0;i<v.length();i++)
			if(v.charAt(i)!='[')				// 'array[i]' has the array named 'array'; 'a[i]' has the array named 'a' - hence String a accepts input until '[' 
'				a+=v.charAt(i);
			else
				break;
		return a;
	}

	public void modify(String s)throws IOException
	{
		String s1;
		Scanner f=new Scanner(new BufferedReader(new FileReader("code")));
		Scanner x=new Scanner(new BufferedReader(new FileReader("q")));
		FileWriter u=new FileWriter("refactor");
		try
		{
			while(x.hasNextLine())
			{
				u.write(x.nextLine()+"\n");		// adding quick sort as a function from file q
			}
			for(int i=0;i<c-3;i++)
			{
				u.write(f.nextLine()+"\n");		// adding original code until bubble sort was encountered until 3 lines before counted lines - nested for loop and if condition
			}
			for(int i=0;i<4;i++)
				if(f.hasNextLine())
					s1=f.nextLine();		// moving cursor past the bubble sort
			u.write("quicksort("+s+",0,n-1)\n");		// adding quicksort function call with extracted array name
			while(f.hasNextLine())
			{
				u.write(f.nextLine()+"\n");		// adding remaining part of the original code file
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Missing");
		}
		catch(Exception e)					// any other exceptions will be caught and displayed 
		{
			System.out.println(e);
		}
		finally
		{
			f.close();
			x.close();
			u.close();
		}
	}
	
	public void display(String s)throws IOException
	{
		Scanner f=new Scanner(new BufferedReader(new FileReader(s)));
		while(f.hasNextLine())
			System.out.println(f.nextLine());		// Displaying contents of file
	}
}

