package financialSystem.action;

import financialSystem.service.AdminService;

public class AdminAddFinancialStaff extends BaseAction {
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String execute(){
		if(adminService.addFinancialStaff(request.getParameter("name"), request.getParameter("password"))){
			return "success";
		}
		
		return "error";
	}
}
