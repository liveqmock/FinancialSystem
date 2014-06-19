package financialSystem.model;

import java.sql.Date;

public class HostProject {
	private int p_id;
	private String p_name;
	private double money;
	private Date start_time;
	private Date end_time;
	
	public HostProject(int p_id, String p_name, double money, Date start_time,
			Date end_time) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.money = money;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
}
