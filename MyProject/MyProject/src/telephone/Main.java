package telephone;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String id;
		String name;
		String email;
		String phone;
		String msg="";
		try
	      {
	         FileWriter fileOut = new FileWriter("outPhones.txt", true);
	         PrintWriter pw = new PrintWriter(fileOut);
	         Maintain maintain=new Maintain();
	      
		int ch;
		do
		{
			  maintain.showMenuList();
			  ch=sc.nextInt();
			  if(ch==1)
			  {
				  pw.println ("-----------------");
			         System.out.println("-----------------");
			         maintain.menu("1 - Phones.txt", pw);
			         System.out.println("1 - Phones.txt");
			         pw.println ();
			         pw.println ("----------------------------------------------------------------------------");
			              
			  }
			  else if(ch==2)
			  {
    				  pw.println ("----------------------------------------------------------------------------");
			         pw.println ("add an Person Details to the tree");
			         pw.println ("---------------------------------");
			         
			         System.out.println("----------------------------------------------------------------------------");
			         System.out.println ("add an Person Details to the tree");
			         System.out.println("---------------------------------");
			         
			        System.out.println("Enter the id");
			        id=sc.next();
			        System.out.println("Enter the name");
			        name=sc.next();
			        System.out.println("Enter the email");
			        email=sc.next();
			        System.out.println("Enter the phone");
			        phone=sc.next();
			        
			         msg="2 - "+id+" "+name+" "+email+" "+phone;
			         maintain.menu(msg, pw);
			         pw.println ();
			         pw.println ("----------------------------------------------------------------------------");				  
			  }
			  else if(ch==3)
			  {
				     pw.println ("----------------------------------------------------------------------------");
			         pw.println ("remove an Phone details  from the tree");
			         pw.println ("---------------------------------------");
			         System.out.println("remove an Phone details  from the tree");
			         System.out.println("---------------------------------------");
			         System.out.println("Enter the id");
			         id=sc.next();
			         maintain.menu("3 - "+id, pw);
			         
			  }
			  else if(ch==4)
			  {
				  pw.println ();
			         pw.println ("----------------------------------------------------------------------------");
			         pw.println ();
			         pw.println ("retrieve an Phone Details from the tree and print the Person record");
			         pw.println ("-------------------------------------------------------------------------------");
			        
			         System.out.println("----------------------------------------------------------------------------");
			         System.out.println ();
			         System.out.println("retrieve an Phone Details from the tree and print the Person record");
			         System.out.println ("-------------------------------------------------------------------------------");
			         System.out.println("Enter the id");
			         id=sc.next();
			         maintain.menu("4 - "+id, pw);
			        
			  }
			  else if(ch==5)
			  {
				     pw.println ();
			         pw.println ("----------------------------------------------------------------------------");
			         pw.println ();
			         pw.println ("update the phone details from the tree and print the new ");
			         pw.println ("---------------------------------------------------------------");
			         
			         System.out.println("----------------------------------------------------------------------------");
			         System.out.println ();
			         System.out.println ("update the phone details from the tree and print the new ");
			         System.out.println ("---------------------------------------------------------------");
			          System.out.println("Enter the id");
			          id=sc.next();
			          System.out.println("Enter the phone");
			          phone=sc.next();
			         maintain.menu("5 - "+id+" "+phone, pw);
			  }
			  else if(ch==6)
			  {
				     pw.println ();
			         pw.println ("----------------------------------------------------------------------------");
			         pw.println ();
			         pw.println ("display the tree ");
			         pw.println ("--------------------");
			         System.out.println("----------------------------------------------------------------------------");
			         System.out.println ();
			         System.out.println ("display the tree ");
			         System.out.println ("--------------------");
			         maintain.menu("6", pw);
			  }
			  else if(ch==7)
			  {
				  maintain.menu("7", pw);
				
			  }
			  
		}while(ch!=8);
	}
	
    catch(IOException e)
    {
       e.printStackTrace();
        System.out.println("That file does not exist");
      
    }//end catch

}
}