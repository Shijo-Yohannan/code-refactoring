import java.util.*;
import java.io.*;
class t
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
			c++;
			sc=new Scanner(s);
			x=sc.next();
			if(x.compareTo("for")==0)
			{
				k++;
			}
			if(k==2 && x.compareTo("if")==0)
			{
				v=sc.next();
				break;
			}
		}
		t o=new t();
		System.out.println("The Original File:\n");
		o.display("code");
		o.modify(o.extract(v));
		System.out.println("\nThe Refactored File:\n");
		o.display("refactor");
	}

	public String extract(String v)
	{
		String a="";
		for(int i=0;i<v.length();i++)
			if(v.charAt(i)!='[')
				a+=v.charAt(i);
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
				u.write(x.nextLine()+"\n");
			}
			for(int i=0;i<c-3;i++)
			{
				u.write(f.nextLine()+"\n");
			}
			for(int i=0;i<4;i++)
				if(f.hasNextLine())
					s1=f.nextLine();
			u.write("quicksort("+s+",0,n-1)\n");
			while(f.hasNextLine())
			{
				u.write(f.nextLine()+"\n");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("no file apparently");
		}
		catch(Exception e)
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
			System.out.println(f.nextLine());
	}
}

