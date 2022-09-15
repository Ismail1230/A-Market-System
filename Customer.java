package Customer;

public class Customer {
	private static int count = 0;
	private int id;
	private String first_name;
	private String last_name;
	private String username;
	private String phoneNumber;
	private String Email;
	private final PrivilegeCard privilegecard;
	
	
	public Customer(String first_name,String last_name ,String phoneNumber,String Email,String username) {
		count++;
		this.id=id+count;
		this.first_name=first_name;
		this.last_name=last_name;
		this.phoneNumber=phoneNumber;
		this.Email=Email;
		this.username= username;
		this.privilegecard= new PrivilegeCard(first_name,last_name,Email);
		
		
		
	}



	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	
	public String getFullname() {
		return this.first_name +" "+this.last_name;
	}

	
	public PrivilegeCard getCard() {
		return privilegecard;
	}
	
	public String toString() {
		return  "NAME:"+getFullname()+" ,Tel:"+phoneNumber+" Email:"+Email+"Points:"+privilegecard.getPoints();
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}
	
	

	
	
}
