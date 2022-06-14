package telephone;

import java.util.*;
import java.io.*;

class TreeTest
{
  public static void main (String[] args)
  {
      try
      {
         FileWriter fileOut = new FileWriter("outPhones.txt", true);
         PrintWriter pw = new PrintWriter(fileOut);
         Maintain maintain=new Maintain();
         pw.println ("create the tree from an input file Phone.txt");
         System.out.println("create the tree from an input file Employee.txt");
         pw.println ("-----------------");
         System.out.println("-----------------");
         maintain.menu("1 - Phones.txt", pw);
         System.out.println("1 - Phones.txt");
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ("add an Person Details to the tree");
         pw.println ("---------------------------------");
         
         System.out.println("----------------------------------------------------------------------------");
         System.out.println ("add an Person Details to the tree");
         System.out.println("---------------------------------");
         
         maintain.menu("2 - 8765 yashwant yash@gmail.com 8990909090", pw);
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ("remove an Phone details from the tree");
         pw.println ("---------------------------------------");
         
         pw.println ("----------------------------------------------------------------------------");
         pw.println ("remove an Phone details  from the tree");
         pw.println ("---------------------------------------");
         maintain.menu("3 - 4892", pw);
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ();
         pw.println ("retrieve an Phone Details from the tree and print the Person record");
         pw.println ("-------------------------------------------------------------------------------");
        
         System.out.println("----------------------------------------------------------------------------");
         System.out.println ();
         System.out.println("retrieve an Phone Details from the tree and print the Person record");
         System.out.println ("-------------------------------------------------------------------------------");
         maintain.menu("4 - 3924", pw);
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ();
         pw.println ("update the phone details from the tree and print the new ");
         pw.println ("---------------------------------------------------------------");
         
         System.out.println("----------------------------------------------------------------------------");
         System.out.println ();
         System.out.println ("update the phone details from the tree and print the new ");
         System.out.println ("---------------------------------------------------------------");
         maintain.menu("5 - 8765 897850123", pw);
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
         pw.println ("----------------------------------------------------------------------------");
         pw.println ();
         pw.println ();
         pw.close();
      }
      catch(IOException e)
      {
         e.printStackTrace();
          System.out.println("That file does not exist");
        
      }//end catch
   }
}
