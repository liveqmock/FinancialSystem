package financialSystem.service.impl;

import java.util.ArrayList;

import financialSystem.dao.CommonUserDao;
import financialSystem.dao.ProjectDao;
import financialSystem.model.CommonUser;
import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;
import financialSystem.service.CommonUserService;

public class CommonUserServiceImpl implements CommonUserService {
	private CommonUserDao commonUserDao;
	public CommonUserDao getCommonUserDao() {
		return commonUserDao;
	}
	public void setCommonUserDao(CommonUserDao commonUserDao) {
		this.commonUserDao = commonUserDao;
	}
	
	
	@Override
	public CommonUser getCommonUserInfo(int identifier) {
		return commonUserDao.getPersonalInfo(identifier);
	}
	
	@Override
	public int validateLogin(String name, String password) {
		return commonUserDao.validate(name, password);
	}
	
	@Override
	public boolean register(String name, String password, String bank_card) {
		return commonUserDao.register(name, password, bank_card);
	}
	@Override
	public int getIdentifier(String name) {
		return commonUserDao.getIdentifier(name);
	}
	@Override
	public double getSingleProjectMoney(int p_id, int c_identifier) {
		return commonUserDao.getSingleProjectMoney(p_id, c_identifier);
	}
	@Override
	public boolean addHostUsers(int p_id, String name, double money) {
		return commonUserDao.addHostUsers(p_id, name, money);
	}
	@Override
	public boolean updatePersonalInfo(CommonUser commonUser, String password) {
		return commonUserDao.updatePersonalInfo(commonUser, password);
	}
}
