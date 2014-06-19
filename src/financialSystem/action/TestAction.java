package financialSystem.action;

import financialSystem.model.CommonUser;
import financialSystem.service.CommonUserService;

public class TestAction extends BaseAction {
	private CommonUserService commonUserService;

	public CommonUserService getCommonUserService() {
		return commonUserService;
	}
	public void setCommonUserService(CommonUserService commonUserService) {
		this.commonUserService = commonUserService;
	}
	
	public String execute(){
//		System.out.println(commonUserService==null);
		CommonUser commonUser = null;
		try {
			commonUser = commonUserService.getCommonUserInfo(new Integer(1000000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(commonUser.getHost_projects().size() + "~~~~~~~~~~~~~");
		
		if(commonUser == null){
System.out.println("没有！！！！！！！！");
			return "error";
		}
		else{
			request.setAttribute("commonUser", commonUser);
System.out.println("有了！！！！");
			
			return "success";
		}
	}

}
