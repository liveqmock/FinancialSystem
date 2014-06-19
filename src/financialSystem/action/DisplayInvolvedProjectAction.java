package financialSystem.action;

import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;
import financialSystem.service.CommonUserService;
import financialSystem.service.ProjectService;

public class DisplayInvolvedProjectAction extends BaseAction {
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
	private Project project;
	public InvolvedProject getInvolvedProject() {
		return involvedProject;
	}
	public void setInvolvedProject(InvolvedProject involvedProject) {
		this.involvedProject = involvedProject;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	public String execute(){
		involvedProject = projectService.getInvolvedProjectInfo(Integer.parseInt(request.getParameter("p_id")), commonUserService.getIdentifier((String) request.getSession().getAttribute("name")));
		project = projectService.getProjectInfo(Integer.parseInt(request.getParameter("p_id")));

		if(involvedProject != null){
			return "success";
		}
		
		return "error";
	}
}
