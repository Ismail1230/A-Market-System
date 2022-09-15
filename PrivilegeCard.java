package Customer;

public class PrivilegeCard  {
	private static int idCount = 0;
	private int cardid;
    private int Points;
	private String first_name;
	private String last_name;
	private String Email;
	
	public PrivilegeCard() {};
	
	public PrivilegeCard(String first_name,String last_name,String Email) {
		idCount++;
		this.cardid=idCount;
		this.first_name=first_name;
		this.last_name=last_name;
		this.Email=Email;
		this.Points=0;
	}
	
	public int getCardid() {
		return this.cardid;
	}
	public int getPoints() {
		return this.Points;
	}

	public void setPoints(int points) {
		this.Points = points;
	}

	
	public void incrementPoints() {
		if (this.Points == 110) {
			this.Points = 10;
		} else {
			this.Points = this.Points + 10;
		}
	}
	
	public String toString() {
		return "customercardID:"+cardid+" First Name:"+first_name+" Last Name: "+last_name+" Email: "+Email+" Points: "+Points;
	}

		
}
