package financialSystem.action;

import financialSystem.service.AdminService;

public class AdminAddCommonUser extends BaseAction {
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String execute(){
		if(adminService.addCommonUser(request.getParameter("name"), request.getParameter("password"), request.getParameter("bank_card"))){
			return "success";
		}
		
		return "error";
	}
}
