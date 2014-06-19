package financialSystem.action;

import financialSystem.model.CommonUser;
import financialSystem.service.CommonUserService;

public class SubmitPersonalInfoAction extends BaseAction {
	private CommonUserService commonUserService;
	public CommonUserService getCommonUserService() {
		return commonUserService;
	}
	public void setCommonUserService(CommonUserService commonUserService) {
		this.commonUserService = commonUserService;
	}
	public CommonUser getCommonUser() {
		return commonUser;
	}
	public void setCommonUser(CommonUser commonUser) {
		this.commonUser = commonUser;
	}

	private CommonUser commonUser;
	
	public String execute(){
		commonUser = commonUserService.getCommonUserInfo(commonUserService.getIdentifier((String) request.getSession().getAttribute("name")));
		
		if(commonUser != null){
			commonUser.setName(request.getParameter("name"));
			request.getSession().setAttribute("name", request.getParameter("name"));
			commonUser.setBank_card(request.getParameter("bank_card"));
			if(commonUserService.updatePersonalInfo(commonUser, request.getParameter("newPasswrod"))){
				return "success";
			}
		}
		
		return "error";
	}
}
