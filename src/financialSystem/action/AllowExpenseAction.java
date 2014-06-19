package financialSystem.action;

import financialSystem.service.CommonUserService;
import financialSystem.service.ProjectService;

public class AllowExpenseAction extends BaseAction {
	private ProjectService projectService;
	private CommonUserService commonUserService;
	public ProjectService getProjectService() {
		return projectService;
	}
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	public CommonUserService getCommonUserService() {
		return commonUserService;
	}
	public void setCommonUserService(CommonUserService commonUserService) {
		this.commonUserService = commonUserService;
	}
	private int p_id;
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	public String execute(){
		this.p_id = Integer.parseInt(request.getParameter("p_id"));
		projectService.verifyExpense(Integer.parseInt(request.getParameter("p_id")), commonUserService.getIdentifier(request.getParameter("c_name")));
		
		if(projectService != null){
			return "success";
		}
		return "error";
	}
}
