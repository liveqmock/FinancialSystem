package financialSystem.action;

import financialSystem.model.CommonUser;
import financialSystem.service.AdminService;

public class AdminUpdateFinancialStaffAction extends BaseAction {
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String execute(){
		if(adminService.updateFinancialStaff(new CommonUser(request.getParameter("new_name"), Integer.parseInt(request.getParameter("identifier")), "", null, null), request.getParameter("new_password"))){
			return "success";
		}
		
		return "error";
	}
}
