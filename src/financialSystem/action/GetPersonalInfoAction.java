package financialSystem.action;

import financialSystem.model.CommonUser;
import financialSystem.service.CommonUserService;

public class GetPersonalInfoAction extends BaseAction {
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
			return "success";
		}
		
		return "error";
	}
}
