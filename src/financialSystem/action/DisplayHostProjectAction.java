package financialSystem.action;

import java.util.ArrayList;

import financialSystem.model.CommonUser;
import financialSystem.model.Project;
import financialSystem.service.CommonUserService;
import financialSystem.service.ProjectService;

public class DisplayHostProjectAction extends BaseAction {
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
	
	private Project project;
	ArrayList<CommonUser> involvedUserInfo ;
	ArrayList<Double> involvedUserMoney;
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public ArrayList<CommonUser> getInvolvedUserInfo() {
		return involvedUserInfo;
	}
	public void setInvolvedUserInfo(ArrayList<CommonUser> involvedUserInfo) {
		this.involvedUserInfo = involvedUserInfo;
	}
	public ArrayList<Double> getInvolvedUserMoney() {
		return involvedUserMoney;
	}
	public void setInvolvedUserMoney(ArrayList<Double> involvedUserMoney) {
		this.involvedUserMoney = involvedUserMoney;
	}

	public String execute(){
		project = projectService.getProjectInfo(Integer.parseInt(request.getParameter("p_id")));
		
		if(project!=null){
			//获取参与项目人员各种信息
			involvedUserInfo = new ArrayList<CommonUser>();
			involvedUserMoney = new ArrayList<Double>();
			for(int i=0; i<project.getInvolved_users().size(); i++){
				involvedUserInfo.add(commonUserService.getCommonUserInfo(project.getInvolved_users().get(i)));
				involvedUserMoney.add(commonUserService.getSingleProjectMoney(Integer.parseInt(request.getParameter("p_id")), project.getInvolved_users().get(i)));
			}
			return "success";
		}
		else{
			return "error";
		}
	}

}
