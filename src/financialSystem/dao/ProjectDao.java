package financialSystem.dao;

import java.util.ArrayList;

import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;

public interface ProjectDao {
	//查询参与项目信息
	public ArrayList<InvolvedProject> getInvolvedProjects(int c_identifier);
	
	//获取单个项目信息
	public Project getProjectInfo(int p_id);
	//获取单个参与项目信息
	public InvolvedProject getInvolvedProject(int p_id, int c_identifier);
	//更新个人参与项目信息
	public boolean updateInvolvedProject(InvolvedProject involvedProject);
	//审核报销
	public boolean verifyExpense(int p_id, int c_identifier);
}
