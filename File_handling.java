package k;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_handling 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		String fna[]=new String[10];
		String fp[]=new String[10];
		int i=0;
		File fi=new File("E://");
		
		try
		{
			
			for(File ls:fi.listFiles())
				
			{
				if(ls.getName().endsWith(".txt"))
				{
					fna[i]=ls.getName();
					fp[i]=ls.getPath();
					i++;
					
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		for(int x=0;x<fna.length;x++)
		{
			System.out.println(fna[x]);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("\n Enter the file name");
		
		String fn=sc.next();
		
		for(int x=0;x<fna.length;x++)
		{
			if(fn.equals(fna[x]))
			
		{
				fi=new File(fp[x]);
						sc=new Scanner(fi);
				
			while(sc.hasNext())
			{
				System.out.println(sc.nextLine());
			}
			
	
		}
		
		}
	}
}
				
		
		




