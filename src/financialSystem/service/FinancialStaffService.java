package financialSystem.service;

import java.util.ArrayList;

import financialSystem.model.InvolvedProject;

public interface FinancialStaffService {
	public ArrayList<InvolvedProject> getProjects();
	
	public boolean updateState(int p_id, int c_id, String state);
}
