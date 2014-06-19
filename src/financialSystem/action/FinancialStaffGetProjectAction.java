package financialSystem.action;

import java.util.ArrayList;

import financialSystem.model.InvolvedProject;
import financialSystem.service.FinancialStaffService;

public class FinancialStaffGetProjectAction {
	private FinancialStaffService financialStaffService;
	
	private ArrayList<InvolvedProject> projects;

	public FinancialStaffService getFinancialStaffService() {
		return financialStaffService;
	}

	public void setFinancialStaffService(FinancialStaffService financialStaffService) {
		this.financialStaffService = financialStaffService;
	}
	public ArrayList<InvolvedProject> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<InvolvedProject> projects) {
		this.projects = projects;
	}
	
	public String execute(){
		projects = financialStaffService.getProjects();
		
		if(projects != null){
			return "success";
		}
		
		return "error";
	}
}
