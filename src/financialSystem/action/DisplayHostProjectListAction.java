package financialSystem.action;

import java.util.ArrayList;

import financialSystem.model.HostProject;
import financialSystem.service.CommonUserService;
import financialSystem.service.ProjectService;

public class DisplayHostProjectListAction extends BaseAction {
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
	
	
	private ArrayList<HostProject> hostProjects;
	public ArrayList<HostProject> getHostProjects() {
		return hostProjects;
	}
	public void setHostProjects(ArrayList<HostProject> hostProjects) {
		this.hostProjects = hostProjects;
	}
	
	public String execute(){
		hostProjects = projectService.getHostProjects(commonUserService.getIdentifier((String) request.getSession().getAttribute("name")));
		
		if(hostProjects != null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
}
