package financialSystem.service;

import java.util.ArrayList;

import financialSystem.model.CommonUser;
import financialSystem.model.Project;

public interface AdminService {
	public ArrayList<Project> getProjectLists();
	public Project getProjectInfo(int p_id);
	
	public boolean updateProject(Project project);
	public boolean addProject(Project project);
	
	public boolean addCommonUser(String name, String password, String bank_card);
	public boolean addFinancialStaff(String name, String password);
	public boolean addFinancialManager(String name, String password);
	
	public ArrayList<CommonUser> getAllCommonUser();
	public ArrayList<CommonUser> getAllFinancialStaff();
	public ArrayList<CommonUser> getAllFinancialManager();
	
	public CommonUser getSingleCommonUser(int c_identifier);
	public CommonUser getSingleFinancialStaff(int c_identifier);
	public CommonUser getSingleFinancialManager(int c_identifier);
	
	public boolean updateCommonUser(CommonUser commonUser, String password);
	public boolean updateFinancialStaff(CommonUser commonUser, String password);
	public boolean updateFinancialManager(CommonUser commonUser, String password);
}
