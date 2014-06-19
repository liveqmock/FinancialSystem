package financialSystem.action;

import java.util.ArrayList;

import financialSystem.model.InvolvedProject;
import financialSystem.service.CommonUserService;
import financialSystem.service.ProjectService;

public class DisplayInvolvedProjectListAction extends BaseAction {
	private ProjectService projectService;
	private CommonUserService commonUserService;
	
	public CommonUserService getCommonUserService() {
		return commonUserService;
	}
	public void setCommonUserService(CommonUserService commonUserService) {
		this.commonUserService = commonUserService;
	}
	public ProjectService getProjectService() {
		return projectService;
	}
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	ArrayList<InvolvedProject> involvedProjects;
	public ArrayList<InvolvedProject> getInvolvedProjects() {
		return involvedProjects;
	}
	public void setInvolvedProjects(ArrayList<InvolvedProject> involvedProjects) {
		this.involvedProjects = involvedProjects;
	}
	
	public String execute(){
		involvedProjects = projectService.getInvolvedProjects(commonUserService.getIdentifier((String) request.getSession().getAttribute("name")));
		if(involvedProjects != null){
			return "success";
		}
		else{
			return "error";
		}
	}
	


	
}
