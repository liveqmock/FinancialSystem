package financialSystem.action;

import java.sql.Date;

import financialSystem.model.Project;
import financialSystem.service.AdminService;

public class AdminUpdateProjectAction extends BaseAction {
	private AdminService adminService;
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String execute(){
//		System.out.println("!!!!!!" + request.getParameter("p_id") + "~~~~~~");
		Project project = new Project(Integer.parseInt(request.getParameter("p_id")), request.getParameter("p_name"), new Integer(0), Double.parseDouble(request.getParameter("money")), Double.parseDouble(request.getParameter("device_ratio")), Double.parseDouble(request.getParameter("travel_ratio")), Double.parseDouble(request.getParameter("others_ratio")), Date.valueOf("20" + request.getParameter("start_time")), Date.valueOf("20" + request.getParameter("end_time")), null, request.getParameter("host_name"));
		
		if(adminService.updateProject(project)){
			return "success";
		}
		
		return "error";
	}
}
