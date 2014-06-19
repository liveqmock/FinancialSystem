package financialSystem.action;

import financialSystem.service.FinancialStaffService;

public class FinancialStaffUpdateStateAction extends BaseAction {
	private FinancialStaffService financialStaffService;
	public FinancialStaffService getFinancialStaffService() {
		return financialStaffService;
	}

	public void setFinancialStaffService(FinancialStaffService financialStaffService) {
		this.financialStaffService = financialStaffService;
	}
	
	public String execute(){
//		System.out.println("~~" + request.getParameter("p_id") + "!!" + request.getParameter("c_id") + "**" + request.getParameter("state") + "__");
		if(financialStaffService.updateState(Integer.parseInt(request.getParameter("p_id")), Integer.parseInt(request.getParameter("c_id")), request.getParameter("state"))){
			return "success";
		}
		
		return "error";
	}
}
