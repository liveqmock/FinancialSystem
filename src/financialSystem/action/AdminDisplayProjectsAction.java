package financialSystem.action;

import java.util.ArrayList;

import financialSystem.dao.AdminDao;
import financialSystem.model.Project;
import financialSystem.service.AdminService;

public class AdminDisplayProjectsAction extends BaseAction {
	private AdminService adminService;
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	ArrayList<Project> projectList;
	public ArrayList<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(ArrayList<Project> projectList) {
		this.projectList = projectList;
	}

	public String execute(){
		projectList = adminService.getProjectLists();
		
		if(projectList != null){
			return "success";
		}
		
		return "error";
	}
}
