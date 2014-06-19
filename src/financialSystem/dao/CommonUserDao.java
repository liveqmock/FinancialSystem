package financialSystem.dao;

import java.sql.Date;
import java.util.ArrayList;

import financialSystem.model.CommonUser;
import financialSystem.model.HostProject;
import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;

public interface CommonUserDao {
	/**作为项目主持人**/
	//设置报销项目比例
	public boolean setReimbursementRatio(int p_id, String device_ratio, String travel_ratio, String others_ratio);
	//设置经费总额
	public boolean setTotalMoney(int p_id, double money);
	//设置时间期限
	public boolean setTime(int p_id, Date start_time, Date end_time);
	//分配经费
	public boolean distrubuteMoeny(int p_id, int identifier, double money);
	//审核报销数据
	public boolean examineReimbursement(int p_id, int indentifier);
	//添加项目成员
	public boolean addHostUsers(int p_id, String name, double money);
	
	/**作为项目参与人**/
	public boolean applyForReimbursement(int p_id, InvolvedProject project);
	
	/**另外功能**/
	//查询个人信息
	public CommonUser getPersonalInfo(int c_identifier);
	//查询主持项目经费
	public ArrayList<Double> getHostProjectsMoney(int c_identifier);
	//查询参与项目经费
	public ArrayList<Double> getInvolvedProjectsMoney(int c_identifier);
	//查询报销状态
	public String getState(int c_identifier, int p_id);
	//查询主持项目清单
	public ArrayList<HostProject> getHostProjects(int c_identifier);
	//查询参与项目个人报销情况
	public InvolvedProject getInvolvedProject(int c_identifier);
	//验证登录
	public int validate(String name, String password);
	//普通用户注册
	public boolean register(String name, String password, String bank_card);
	//查询个人Identifer
	public int getIdentifier(String name);
	//获取个人某个项目经费
	public double getSingleProjectMoney(int p_id, int c_identifier);
	//更新个人信息
	public boolean updatePersonalInfo(CommonUser commonUser,  String password);
}
