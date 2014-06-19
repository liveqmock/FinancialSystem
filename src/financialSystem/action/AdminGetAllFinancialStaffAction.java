package financialSystem.action;

import java.util.ArrayList;

import financialSystem.model.CommonUser;
import financialSystem.service.AdminService;

public class AdminGetAllFinancialStaffAction {
	private AdminService adminService;
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public ArrayList<CommonUser> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<CommonUser> users) {
		this.users = users;
	}

	private ArrayList<CommonUser> users;
	
	public String execute(){
		users = adminService.getAllFinancialStaff();
		
		if(users != null){
			return "success";
		}
		
		return "error";
	}
}
