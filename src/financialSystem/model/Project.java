package financialSystem.model;

import java.sql.Date;
import java.util.ArrayList;


public class Project {
	public Project(int p_id, String p_name, int host_identifier,
			double money, double device_ratio, double travel_ratio,
			double others_ratio, Date start_time, Date end_time,
			ArrayList<Integer> involved_users, String host_name) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.host_identifier = host_identifier;
		this.money = money;
		this.device_ratio = device_ratio;
		this.travel_ratio = travel_ratio;
		this.others_ratio = others_ratio;
		this.start_time = start_time;
		this.end_time = end_time;
		this.involved_users = involved_users;
		this.host_name = host_name;
	}
	private String host_name;
	private int p_id;
	private String p_name;
	private int host_identifier;
	private double money;
	private double device_ratio;
	private double travel_ratio;
	private double others_ratio;
	private Date start_time;
	private Date end_time;
	
	//项目参与人员的u_id
	private ArrayList<Integer> involved_users = new ArrayList<Integer>();
	
	public int getHost_identifier() {
		return host_identifier;
	}
	public void setHost_identifier(int host_identifier) {
		this.host_identifier = host_identifier;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getDevice_ratio() {
		return device_ratio;
	}
	public void setDevice_ratio(double device_ratio) {
		this.device_ratio = device_ratio;
	}
	public double getTravel_ratio() {
		return travel_ratio;
	}
	public void setTravel_ratio(double travel_ratio) {
		this.travel_ratio = travel_ratio;
	}
	public double getOthers_ratio() {
		return others_ratio;
	}
	public void setOthers_ratio(double others_ratio) {
		this.others_ratio = others_ratio;
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
	public ArrayList<Integer> getInvolved_users() {
		return involved_users;
	}
	public void setInvolved_users(ArrayList<Integer> involved_users) {
		this.involved_users = involved_users;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	
}
