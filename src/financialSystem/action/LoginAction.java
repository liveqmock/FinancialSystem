package financialSystem.action;

import financialSystem.service.CommonUserService;

public class LoginAction extends BaseAction {
	private CommonUserService commonUserService;
	
	public CommonUserService getCommonUserService() {
		return commonUserService;
	}

	public void setCommonUserService(CommonUserService commonUserService) {
		this.commonUserService = commonUserService;
	}
	
	public String execute(){
		System.out.println(commonUserService == null);
		switch(commonUserService.validateLogin(request.getParameter("name"), request.getParameter("password"))){
			//无该用户
			case 0:
				return "error";
				
			//普通用户
			case 1:
				request.setAttribute("name", request.getParameter("name"));
				request.getSession().setAttribute("name", request.getParameter("name"));
				return "common_user";
				
			//财务审核
			case 2:
				request.setAttribute("name", request.getParameter("name"));
				request.getSession().setAttribute("name", request.getParameter("name"));
				return "financialStaff";
				
			//财务主管	
			case 3:
				request.setAttribute("name", request.getParameter("name"));
				request.getSession().setAttribute("name", request.getParameter("name"));
				return "financialManager";
			
			//管理员
			case 4:
				request.setAttribute("name", request.getParameter("name"));
				request.getSession().setAttribute("name", request.getParameter("name"));
				return "admin";
				
		    //其他
			default:
				return "error";
		}
	}
}
