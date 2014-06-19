package financialSystem.service;

import java.util.ArrayList;

import financialSystem.model.CommonUser;
import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;

public interface CommonUserService {
	public CommonUser getCommonUserInfo(int identifier);
	public int validateLogin(String name, String password);
	public boolean register(String name, String password, String bank_card);
	public int getIdentifier(String name);
	public double getSingleProjectMoney(int p_id, int c_identifier);
	public boolean addHostUsers(int p_id, String name, double money);
	public boolean updatePersonalInfo(CommonUser commonUser, String password);
}
