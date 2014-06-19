package financialSystem.action;

import financialSystem.model.Project;
import financialSystem.service.AdminService;

public class AdminGetProjectInfoAction extends BaseAction {
	private AdminService adminService;
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	private Project project;
	
	public String execute(){
		project = adminService.getProjectInfo(Integer.parseInt(request.getParameter("p_id")));
		
		if(project != null){
			return "success";
		}
		
		return "error";
	}

}
