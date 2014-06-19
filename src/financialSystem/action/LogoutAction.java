package financialSystem.action;

import java.io.UnsupportedEncodingException;

public class LogoutAction extends BaseAction {
	public String execute(){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset='utf-8'");
			request.getSession().invalidate();
			
			return SUCCESS;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
