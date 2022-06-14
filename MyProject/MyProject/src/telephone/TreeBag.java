package telephone;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeBag
{
   private BTNode root;
   
   
   public void add(Comparable x)  
   {
      root = addNode (x,root);
   }

   
   private BTNode addNode(Comparable x, BTNode p)
   {
      if (p == null)
         //create the node  - base case
         p = new BTNode(x,null,null);
      else if (x.compareTo(p.getData())<0)
         p.setLeft(addNode(x,p.getLeft()));
      else if(x.compareTo(p.getData())>0)  
         p.setRight(addNode(x,p.getRight()));
      else // keys are equal - replace with new data
         p.setData(x);
      return p;
   }

   
   
   public boolean remove(Comparable target)
   { 
      boolean answer = false;
   
      Object obj = retrieve(target, root);
      System.out.println("The obj value is "+obj+" print");
      if(obj != null)
      {
    	  System.out.println("Removing node");
         root = removeNode(root, target);
         answer = true;
      }
      return answer;
   }

   private BTNode removeNode(BTNode p, Comparable target)
   {  
      if(p == null)  // tree is empty, target is not found 
         return p;
        System.out.println("The root value is "+root.getData());
      System.out.println("The target value is "+target);
      int answer = target.compareTo(p.getData());
      System.out.println("The answer is "+answer);
   	if(answer == -1) 
  	      p.setLeft( removeNode( p.getLeft(), target));
  	   else if(answer == 1)
  	   {
  		   System.out.println("The right most data is "+p.getRight().getData());
         p.setRight(removeNode(p.getRight(), target));
  	   }  
         //found the node to be removed

         //if the node has two children 
      else if((p.getLeft() != null) && (p.getRight() != null)) 
   	{      
 		   // get the data in the right most node in the left subtree 
         p.setData(p.getLeft().getRightmostData());
        	// delete the right most data in the left subtree
         p.setLeft(p.getLeft().removeRightmost() );
  	   }

      else if (p.getLeft() ==null)           
      //only right child
         p = p.getRight();
      else                                              
      // only left child 
		   p = p.getLeft();
      return p;      
   }
   
   
   public Object retrieve(Comparable obj, BTNode aNode)
   {
      Comparable answer = null;
      
      if(obj.compareTo(aNode.getData()) == 0)
         answer = (Comparable)aNode.getData();
      else if(obj.compareTo(aNode.getData())>0 && !aNode.isLeaf())
         answer = (Comparable)retrieve(obj, aNode.getRight());
      else if(obj.compareTo(aNode.getData())<0 && !aNode.isLeaf())
         answer = (Comparable)retrieve(obj, aNode.getLeft());
      
      return answer; 
   }
   ArrayList<PhoneBook> al=new ArrayList<PhoneBook>();
   public ArrayList<PhoneBook> getData(BTNode aNode,PrintWriter pw)
   {
	 
	   al.clear();
	   display(aNode,pw);
	   return al;
   }
   
   //Display all the objects in the tree
   public void display(BTNode aNode, PrintWriter pw)
   {
      if(aNode.getLeft() != null)
         display(aNode.getLeft(), pw);
      pw.println(aNode.getData().toString());
      System.out.println(aNode.getData().toString());
      String str=aNode.getData().toString();
      StringTokenizer st=new StringTokenizer(str);
      int id=Integer.parseInt(st.nextToken().toString());
      String name=st.nextToken();
      String email=st.nextToken();
      String phone=st.nextToken();
      PhoneBook pb=new PhoneBook(id, name, email, phone);
      al.add(pb);
      
      if(aNode.getRight() != null)
         display(aNode.getRight(), pw); 
   }
   
   //method to return the root of the tree
   public BTNode getRoot()
   {
      return root;
   }  
}