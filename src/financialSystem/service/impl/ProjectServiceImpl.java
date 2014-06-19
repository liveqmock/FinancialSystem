package financialSystem.service.impl;

import java.util.ArrayList;

import financialSystem.dao.CommonUserDao;
import financialSystem.dao.ProjectDao;
import financialSystem.model.HostProject;
import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;
import financialSystem.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	private CommonUserDao commonUserDao;
	private ProjectDao projectDao;
	public CommonUserDao getCommonUserDao() {
		return commonUserDao;
	}
	public void setCommonUserDao(CommonUserDao commonUserDao) {
		this.commonUserDao = commonUserDao;
	}
	public ProjectDao getProjectDao() {
		return projectDao;
	}
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public ArrayList<HostProject> getHostProjects(int c_identifier) {
		return commonUserDao.getHostProjects(c_identifier);
	}
	
	@Override
	public ArrayList<InvolvedProject> getInvolvedProjects(int c_identifier) {
		return projectDao.getInvolvedProjects(c_identifier);
	}
	@Override
	public Project getProjectInfo(int p_id) {
		return projectDao.getProjectInfo(p_id);
	}
	@Override
	public InvolvedProject getInvolvedProjectInfo(int p_id, int c_identifier) {
		return projectDao.getInvolvedProject(p_id, c_identifier);
	}
	@Override
	public boolean updateInvolvedProject(InvolvedProject involvedProject) {
		return projectDao.updateInvolvedProject(involvedProject);
	}
	@Override
	public boolean verifyExpense(int p_id, int c_identifier) {
		return projectDao.verifyExpense(p_id, c_identifier);
	}

}
