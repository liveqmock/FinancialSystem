package financialSystem.service.impl;

import java.util.ArrayList;

import financialSystem.dao.AdminDao;
import financialSystem.model.CommonUser;
import financialSystem.model.Project;
import financialSystem.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public ArrayList<Project> getProjectLists() {
		return adminDao.getProjectLists();
	}
	
	@Override
	public Project getProjectInfo(int p_id) {
		return adminDao.getSingleProject(p_id);
	}
	
	@Override
	public boolean updateProject(Project project) {
		return adminDao.updateProject(project);
	}
	
	@Override
	public boolean addProject(Project project) {
		return adminDao.addProject(project);
	}
	@Override
	public boolean addCommonUser(String name, String password, String bank_card) {
		return adminDao.addCommonUser(name, password, bank_card);
	}
	@Override
	public boolean addFinancialStaff(String name, String password) {
		return adminDao.addFinancialStaff(name, password);
	}
	@Override
	public boolean addFinancialManager(String name, String password) {
		return adminDao.addFinancialManager(name, password);
	}
	@Override
	public ArrayList<CommonUser> getAllCommonUser() {
		return adminDao.getAllCommonUser();
	}
	
	@Override
	public ArrayList<CommonUser> getAllFinancialStaff() {
		return adminDao.getAllFinancialStaff();
	}
	
	@Override
	public ArrayList<CommonUser> getAllFinancialManager() {
		return adminDao.getAllFinancialManager();
	}
	
	@Override
	public CommonUser getSingleCommonUser(int c_identifier) {
		return adminDao.getSingleCommonUser(c_identifier);
	}
	
	@Override
	public CommonUser getSingleFinancialStaff(int c_identifier) {
		return adminDao.getSingleFinancialStaff(c_identifier);
	}
	
	@Override
	public CommonUser getSingleFinancialManager(int c_identifier) {
		return adminDao.getSingleFinancialManager(c_identifier);
	}
	
	@Override
	public boolean updateCommonUser(CommonUser commonUser, String password) {
		return adminDao.updateCommonUser(commonUser, password);
	}
	
	@Override
	public boolean updateFinancialStaff(CommonUser commonUser, String password) {
		return adminDao.updateFinancialStaff(commonUser, password);
	}
	
	@Override
	public boolean updateFinancialManager(CommonUser commonUser, String password) {
		return adminDao.updateFinancialManager(commonUser, password);
	}
}
