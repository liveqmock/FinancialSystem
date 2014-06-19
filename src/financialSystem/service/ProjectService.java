package financialSystem.service;

import java.util.ArrayList;

import financialSystem.model.HostProject;
import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;

public interface ProjectService {
	public ArrayList<HostProject> getHostProjects(int c_identifier);
	//查询参与项目信息
	public ArrayList<InvolvedProject> getInvolvedProjects(int c_identifier);
	//获取单个项目信息
	public Project getProjectInfo(int p_id);
	public InvolvedProject getInvolvedProjectInfo(int p_id, int c_identifier);
	public boolean updateInvolvedProject(InvolvedProject involvedProject);
	public boolean verifyExpense(int p_id, int c_identifier);
}
