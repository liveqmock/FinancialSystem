package financialSystem.action;

import financialSystem.service.CommonUserService;

public class RegisterAction extends BaseAction {
	private CommonUserService commonUserService;

	public CommonUserService getCommonUserService() {
		return commonUserService;
	}

	public void setCommonUserService(CommonUserService commonUserService) {
		this.commonUserService = commonUserService;
	}
	
	public String execute(){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String bank_card = request.getParameter("bank_card");

		if(password.equals(request.getParameter("passwordAgain")) && bank_card.equals(request.getParameter("bank_cardAgain"))){
			if(commonUserService.register(name, password, bank_card)){
				return "registeredSuccess";
			}
		}
		
		return "error";
	}
}
