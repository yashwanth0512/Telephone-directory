package telephone;

public class PhoneBook implements Comparable {

	// person id
	private int pid;
	
	
	// person name
	private String pname;
	
	// person email
	
	private String pemail;
	
	// phone number
	
	private String phone;
	
	// parameterized constructor

	public PhoneBook(int pid, String pname, String pemail, String phone) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pemail = pemail;
		this.phone = phone;
	}

	// generating setter and getter methods
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	 public String toString()
	   {

	      String string = String.format("%1$-10s %2$-10s %3$-12s %4$10s", pid, 
	                                   pname, pemail,phone);      
	      
	      return string;
	   
	   }//end toString method

	 public int compareTo(Object obj)
	   {
	            
	      if(obj instanceof PhoneBook)
	      {
	      
	         PhoneBook pb = (PhoneBook)obj;
	      
	         int answer = 5;
	               
	         if(pid > pb.getPid())
	         {
	         
	            answer = 1;
	         
	         }//end if statement
	         else if(pid < pb.getPid())
	         {
	         
	            answer = -1;
	         
	         }//end if statement
	         else if(pid == pb.getPid())
	         {
	         
	            answer = 0;
	         
	         }//end if statement
	         
	         return answer;
	      
	      }//end if statement
	      
	      //not an instance of class Employee, send error back to calling method
	      else
	      {
	      
	         throw new IllegalStateException("Not an object of Employee.");
	      
	      }//end else statement
	   
	   }//end compareTo method

	
	
}
