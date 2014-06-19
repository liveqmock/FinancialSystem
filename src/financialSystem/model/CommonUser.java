package financialSystem.model;

import java.util.ArrayList;

public class CommonUser {
	private String name;
	private int identifier;
	private String bank_card;
	
	public CommonUser(String name, int identifier, String bank_card,
			ArrayList<Integer> host_projects,
			ArrayList<Integer> involved_projects) {
		this.name = name;
		this.identifier = identifier;
		this.bank_card = bank_card;
		this.host_projects = host_projects;
		this.involved_projects = involved_projects;
	}
	
	//主持的项目id
	private ArrayList<Integer> host_projects = new ArrayList<Integer>();
	//参与的项目id
	private ArrayList<Integer> involved_projects = new ArrayList<Integer>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public String getBank_card() {
		return bank_card;
	}
	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}
	public ArrayList<Integer> getHost_projects() {
		return host_projects;
	}
	public void setHost_projects(ArrayList<Integer> host_projects) {
		this.host_projects = host_projects;
	}
	public ArrayList<Integer> getInvolved_projects() {
		return involved_projects;
	}
	public void setInvolved_projects(ArrayList<Integer> involved_projects) {
		this.involved_projects = involved_projects;
	}
	
}
