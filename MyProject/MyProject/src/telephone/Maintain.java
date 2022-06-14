package telephone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Maintain {

	 private TreeBag pbTree;
	 ArrayList<PhoneBook> al=new ArrayList<PhoneBook>();
     
	   //header for print
	   private final String RECORD_STRING = String.format("%1$-10s %2$-10s %3$-12s %4$10s",
	                                 "Pid", "PName", "pemail", "Phone") + 
	                                 "\n------------------------------------------------"; 
	   
	   
	   public void menu(String st, PrintWriter pw)throws IOException
	   {
	      
	      //showMenuList();
	      
	      StringTokenizer token = new StringTokenizer(st," -\t");
	      int choice = Integer.parseInt(token.nextToken());
	      //System.out.println("The choice is "+choice);
	      int pid;
	      String pname, pemail,phone;
	      
	      PhoneBook pbook;
           
	      
	      switch(choice)
	      {
	      
	         case 1:
	         
	            //Create the tree
	            pbTree = new TreeBag();
	            
	            //Create the FileReader and link it to the file specified
	            FileReader fr = new FileReader("Phone.txt");
	            BufferedReader inFile = new BufferedReader(fr);
	            
	            //Get the first line of the file
	            String line = inFile.readLine();
	            
	            //Create a StringTokenizer from the line of the file 
	            StringTokenizer ph = new StringTokenizer(line," \t");
	               
	            //Set the employee variables to the information from the file
	            pid = Integer.parseInt(ph.nextToken());
	            pname = ph.nextToken();
	            pemail = ph.nextToken();
	            phone = ph.nextToken();
	               
	            //Create the PhoneBoook
	            
	            pbook=new PhoneBook(pid,pname,pemail,phone);
	               
	            //Add the phonebook to the tree
	            pbTree.add(pbook);
	            al.add(pbook) ;  
	            //Get the next line from the file
	            line = inFile.readLine();
	            
	            while(line != null)
	            {  
	               //Create a StringTokenizer from the line of the file 
	               ph = new StringTokenizer(line," \t");
	               
	               //Set the employee variables to the information from the file
	                pid = Integer.parseInt(ph.nextToken());
		            pname = ph.nextToken();
		            pemail = ph.nextToken();
		            phone = ph.nextToken();
		            
		            pbook=new PhoneBook(pid,pname,pemail,phone);
		               
		            //Add the phonebook to the tree
		            pbTree.add(pbook);
		            al.add(pbook);
	               
	               //Get the next line from the file
	               line = inFile.readLine();
	               
	              
	            
	            }//end while loop
	            
	            //print the tree
	            pw.println(RECORD_STRING);
	            System.out.println(RECORD_STRING);
	            
	            pbTree.display(pbTree.getRoot(), pw);
	            
	            break;
	         
	         //-------------------------------------------------------------------      
	         case 2:
	         
	            //add employee
	            
	            //if the tree is not constructed, construct it
	            if(pbTree == null)
	               pbTree = new TreeBag();
	            
	            //Get the employee's information
	            pid = Integer.parseInt(token.nextToken());
	            pname = token.nextToken();
	            pemail = token.nextToken();
	            phone = token.nextToken();
	            
	            pbook=new PhoneBook(pid,pname,pemail,phone);
	               
	            //Add the phonebook to the tree
	            pbTree.add(pbook);
	           
	            //print the updated tree
	            pw.println(RECORD_STRING);
	            
	            System.out.println(RECORD_STRING);
	            pbTree.display(pbTree.getRoot(), pw);
	            
	            break;
	            
	         //-------------------------------------------------------------------
	                  
	         case 3:
	         
	            //remove an Phone
	            
	            //Get the ID of the Phone to be deleted
	            pid = Integer.parseInt(token.nextToken());
	            System.out.println("The removed pid "+pid);   
	            //Create the Phone with place holders for the name and salary
	            pbook = new PhoneBook(pid, " ", " ", " ");
	            
	            //Remove the 
	            boolean answer = pbTree.remove(pbook);
	            
	            System.out.println("The answer is "+answer);
	            if(answer == true)
	            {
	               pw.println("The Phone Book Record has been removed from the system.");
	              System.out.println("The Phone Book Record has been removed from the system.");
	            }
	            else
	            {
	               pw.println("The Phone Record  could not be found.");
	             System.out.println("The Phone Record  could not be found.");
	            }  
	            //print the updated tree
	            pw.println(RECORD_STRING);
	            System.out.println(RECORD_STRING);
	            pbTree.display(pbTree.getRoot(), pw);
	            
	            break;
	            
	         //-------------------------------------------------------------------
	            
	         case 4:
	         
	            //retrieve an Phone
	            
	            //Get the ID of the employee to be retrieved
	            pid = Integer.parseInt(token.nextToken());
	            
	            pbook = new PhoneBook(pid, " ", " ", " ");
		            
	            //Retrieve the employee
	            pbook = (PhoneBook)pbTree.retrieve(pbook, pbTree.getRoot()); 
	            
	            //Print the phone if the PhoneBook was found
	            if(pbook != null)
	            {
	               pw.println(pbook.toString());
	               System.out.println(pbook.toString());
	            }
	            else
	            {
	               pw.println("Employee Not Found");
                   System.out.println("Employee Not Found");
	            }
	            break;
	            
	         //-------------------------------------------------------------------
	            
	         case 5:
	         
	            //update an employee
	            
	            //Get ID and Salary
	            pid = Integer.parseInt(token.nextToken());
	            phone = token.nextToken();
	            
	            pbook = new PhoneBook(pid, " ", " ", " ");
	            
	            //Retrieve the phone book
	            pbook = (PhoneBook)pbTree.retrieve(pbook, pbTree.getRoot());
	            
	            //Update the phonebook
	            pbook.setPhone(phone);
	            
	            
	            //Place the updated employee in the tree
	            pbTree.add(pbook);
	            
	            //Print the new employees information
	            pw.println(pbTree.toString());
	            System.out.println(pbTree);
	            
	            break;
	            
	         //-------------------------------------------------------------------
	            
	         case 6:
	         
	            //display the Person Deails in Asccending order using ID
	            pw.println(RECORD_STRING);
	            System.out.println(RECORD_STRING);
	            pbTree.display(pbTree.getRoot(), pw);
	            
	            
	            
	            break;
	            
	         //-------------------------------------------------------------------
	            
	         case 7:
	   
	        	   System.out.println("The radix sorting is ");
	        	   al.clear();
	        	   al=pbTree.getData(pbTree.getRoot(), pw);
	        	   Collections.sort(al, new Sortbyname());
	        	   for (PhoneBook pb:al)
					  {
						  System.out.println(pb.getPid()+" "+pb.getPname()+" "+pb.getPemail()+" "+pb.getPhone());
					  }   
	        	   
	        	 break;
	         case 8:
	         
	            //Quit
	            System.exit(0);
	            
	         break;
	      
	      }//end switch
	   
	   }//end menu method
	   
	   /**
	   * This method only prints to the screen the menu the user will read from to 
	   * make a selection. Expects no incoming data nor returns anything.
	   */
	   public void showMenuList()
	   {
	   
		   System.out.println("1.) Import all the contacts from the system.");
		      System.out.println("2.) Add a contact to the system.");
		      System.out.println("3.) Remove a contact details from the telephone system.");
		      System.out.println("4.) search a contact.");
		      System.out.println("5.) Update contact phone number.");
		      System.out.println("6.) Display all the contact Details.");
		      System.out.println("7.) sort the contacts alphabetically");
		      System.out.println("8.) Quit.");
	   
	   }//end showMenuList method


}

class Sortbyname implements Comparator<PhoneBook> {
	 
    // Method
    // Sorting in ascending order of name
    public int compare(PhoneBook a, PhoneBook b)
    {
 
        return a.getPname().compareTo(b.getPname());
    }
}