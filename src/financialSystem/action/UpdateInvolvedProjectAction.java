package financialSystem.action;

import java.sql.Date;

import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;
import financialSystem.service.CommonUserService;
import financialSystem.service.ProjectService;

public class UpdateInvolvedProjectAction extends BaseAction {
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
//		System.out.println("!!!!!!!!!!!!!!!!"+Double.parseDouble(request.getParameter("expense")));
//		System.out.println("***********"+(String) request.getSession().getAttribute("name"));
//		System.out.println("^^^^^^^^^^^" + commonUserService.getIdentifier((String) request.getSession().getAttribute("name")));
		project = projectService.getProjectInfo(Integer.parseInt(request.getParameter("p_id")));
		involvedProject = projectService.getInvolvedProjectInfo(Integer.parseInt(request.getParameter("p_id")), commonUserService.getIdentifier((String) request.getSession().getAttribute("name")));
		
		projectService.updateInvolvedProject(new InvolvedProject(Integer.parseInt(request.getParameter("p_id")), commonUserService.getIdentifier((String) request.getSession().getAttribute("name")), project.getP_name(), involvedProject.getMoney(), Double.parseDouble(request.getParameter("device_ratio")), Double.parseDouble(request.getParameter("travel_ratio")), Double.parseDouble(request.getParameter("others_ratio")), Date.valueOf("20" + request.getParameter("start_time")), Date.valueOf("20" + request.getParameter("end_time")), involvedProject.getState(), Double.parseDouble(request.getParameter("expense")), involvedProject.getHost_name()));
		
		project = projectService.getProjectInfo(Integer.parseInt(request.getParameter("p_id")));
		involvedProject = projectService.getInvolvedProjectInfo(Integer.parseInt(request.getParameter("p_id")), commonUserService.getIdentifier((String) request.getSession().getAttribute("name")));

		if(involvedProject != null){
			return "success";
		}
		
		return "error";
	}
}
