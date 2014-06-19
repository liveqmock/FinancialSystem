package financialSystem.action;

import financialSystem.model.CommonUser;
import financialSystem.service.AdminService;

public class AdminGetSingleFinancialStaffAction extends BaseAction {
	private AdminService adminService;
	private CommonUser commonUser;
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public CommonUser getCommonUser() {
		return commonUser;
	}
	public void setCommonUser(CommonUser commonUser) {
		this.commonUser = commonUser;
	}
	
	public String execute(){
		commonUser = adminService.getSingleFinancialStaff(Integer.parseInt(request.getParameter("identifier")));
		
		if(commonUser != null){
			return "success";
		}
		
		return "error";
	}
}
