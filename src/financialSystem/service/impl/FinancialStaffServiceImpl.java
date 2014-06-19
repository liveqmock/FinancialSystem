package financialSystem.service.impl;

import java.util.ArrayList;

import financialSystem.dao.FinancialStaffDao;
import financialSystem.model.InvolvedProject;
import financialSystem.service.FinancialStaffService;

public class FinancialStaffServiceImpl implements FinancialStaffService {
	private FinancialStaffDao financialStaffDao;
	public FinancialStaffDao getFinancialStaffDao() {
		return financialStaffDao;
	}

	public void setFinancialStaffDao(FinancialStaffDao financialStaffDao) {
		this.financialStaffDao = financialStaffDao;
	}

	@Override
	public ArrayList<InvolvedProject> getProjects() {
		return financialStaffDao.getProjects();
	}

	@Override
	public boolean updateState(int p_id, int c_id, String state) {
		return financialStaffDao.updateState(p_id, c_id, state);
	}
}
