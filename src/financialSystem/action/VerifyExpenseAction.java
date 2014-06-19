package financialSystem.action;

import financialSystem.model.InvolvedProject;
import financialSystem.service.CommonUserService;
import financialSystem.service.ProjectService;

public class VerifyExpenseAction extends BaseAction {
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
	
	private InvolvedProject involvedProject;
	public InvolvedProject getInvolvedProject() {
		return involvedProject;
	}
	public void setInvolvedProject(InvolvedProject involvedProject) {
		this.involvedProject = involvedProject;
	}
	
	public String execute(){
		involvedProject = projectService.getInvolvedProjectInfo(Integer.parseInt(request.getParameter("p_id")), commonUserService.getIdentifier(request.getParameter("c_name")));
		
		if(involvedProject != null){
			return "success";
		}
		
		return "error";
	}
}
