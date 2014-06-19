package financialSystem.model;

public class FinancialStaff {
	private String name;
	private String password;
	private String type;
	
	public FinancialStaff(String name, String password, String type) {
		this.name = name;
		this.password = password;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
