package financialSystem.action;

import financialSystem.model.CommonUser;
import financialSystem.service.AdminService;

public class AdminUpdateCommonUserAction extends BaseAction {
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String execute(){
//		System.out.println("!!!" + request.getParameter("new_name")+"~~~~"+request.getParameter("identifier") + "******" + request.getParameter("new_bank_card") + "_________" + request.getParameter("new_password"));
		
		if(adminService.updateCommonUser(new CommonUser(request.getParameter("new_name"), Integer.parseInt(request.getParameter("identifier")), request.getParameter("new_bank_card"), null, null), request.getParameter("new_password"))){
			return "success";
		}
		
		return "error";
	}
}
