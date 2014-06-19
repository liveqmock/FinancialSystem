package financialSystem.action;

import java.util.ArrayList;

import financialSystem.model.CommonUser;
import financialSystem.model.Project;
import financialSystem.service.CommonUserService;
import financialSystem.service.ProjectService;

public class AddHostUsersAction extends BaseAction {
	private CommonUserService commonUserService;
	public CommonUserService getCommonUserService() {
		return commonUserService;
	}

	public void setCommonUserService(CommonUserService commonUserService) {
		this.commonUserService = commonUserService;
	}

	private int p_id;
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String execute(){
		//处理添加项目成员信息
		if(!(request.getParameter("name").equals("") && request.getParameter("money").equals(""))){
			this.p_id = Integer.parseInt(request.getParameter("p_id"));
			commonUserService.addHostUsers(Integer.parseInt(request.getParameter("p_id")), request.getParameter("name"), Double.parseDouble(request.getParameter("money")));
			
			return "success";
		}
		
		return "error";
	}

}
