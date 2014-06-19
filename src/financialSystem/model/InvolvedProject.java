package financialSystem.model;

import java.sql.Date;

public class InvolvedProject {
	public InvolvedProject(int p_id, int c_identifier, String p_name, double money,
			double device_ratio, double travel_ratio, double others_ratio,
			Date start_time, Date end_time, String state,double expense, String host_name) {
		super();
		this.p_id = p_id;
		this.c_identifier = c_identifier;
		this.p_name = p_name;
		this.money = money;
		this.device_ratio = device_ratio;
		this.travel_ratio = travel_ratio;
		this.others_ratio = others_ratio;
		this.start_time = start_time;
		this.end_time = end_time;
		this.state = state;
		this.expense = expense;
		this.host_name = host_name;
	}
	private int p_id;
	private int c_identifier;
	private String p_name;
	private double money;
	private double device_ratio;
	private double travel_ratio;
	private double others_ratio;
	private Date start_time;
	private Date end_time;
	private String state;
	private double expense;
	private String host_name;
	
	public int getC_identifier() {
		return c_identifier;
	}
	public void setC_identifier(int c_identifier) {
		this.c_identifier = c_identifier;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
}
