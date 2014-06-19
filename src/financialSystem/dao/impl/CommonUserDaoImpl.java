package financialSystem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import financialSystem.dao.CommonUserDao;
import financialSystem.dao.DaoHelper;
import financialSystem.dao.ProjectDao;
import financialSystem.model.CommonUser;
import financialSystem.model.HostProject;
import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;

public class CommonUserDaoImpl implements CommonUserDao {
	private DaoHelper daoHelper;
	private ProjectDao projectDao;
	public DaoHelper getDaoHelper() {
		return daoHelper;
	}
	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public boolean setReimbursementRatio(int p_id, String device_ratio,
			String travel_ratio, String others_ratio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTotalMoney(int p_id, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTime(int p_id, Date start_time, Date end_time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean distrubuteMoeny(int p_id, int identifier, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean examineReimbursement(int p_id, int indentifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean applyForReimbursement(int p_id, InvolvedProject project) {
		// TODO Auto-generated method stub
		return false;
	}

	//查询个人信息
	@Override
	public CommonUser getPersonalInfo(int c_identifier) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		CommonUser commonUser = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM common_user WHERE identifier = ?");
			stmt.setInt(1, c_identifier);
			result = stmt.executeQuery();
			
			while(result.next()){
				String name = result.getString("name");
				int identifier = result.getInt("identifier");
				String bank_card = result.getString("bank_card");

				ArrayList<Integer> host_projects = daoHelper.getLists("SELECT p_id FROM project_info WHERE host_identifier = ?", c_identifier, "p_id");
				ArrayList<Integer> involved_projects = daoHelper.getLists("SELECT p_id FROM project_involved_users WHERE identifier = ?", c_identifier, "p_id");
				
				commonUser = new CommonUser(name, identifier, bank_card, host_projects, involved_projects);
			}
			
			return commonUser;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return null;
	}

	//查询主持项目经费
	@Override
	public ArrayList<Double> getHostProjectsMoney(int c_identifier) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Double> moneys = new ArrayList<Double>();
		
		try {
			stmt = con.prepareStatement("SELECT money FROM project_info WHERE host_identifier = ?");
			stmt.setInt(1, c_identifier);
			result = stmt.executeQuery();
			
			while(result.next()){
				moneys.add(result.getDouble("money"));
			}
			return moneys;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return null;
	}

	//查询参与项目经费
	@Override
	public ArrayList<Double> getInvolvedProjectsMoney(int c_identifier) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Double> moneys = new ArrayList<Double>();
		
		try {
			stmt = con.prepareStatement("SELECT money FROM project_involved_users WHERE identifier = ?");
			stmt.setInt(1, c_identifier);
			result = stmt.executeQuery();
			
			while(result.next()){
				moneys.add(result.getDouble("money"));
			}
			return moneys;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return null;
	}

	//查询报销状态
	@Override
	public String getState(int c_identifier, int p_id) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("SELECT state FROM project_involved_users WHERE identifier = ? and pid = ?");
			stmt.setInt(1, c_identifier);
			stmt.setInt(2, p_id);
			result = stmt.executeQuery();
			
			while(result.next()){
				return result.getString("state");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return null;
	}

	//查询主持项目清单
	@Override
	public ArrayList<HostProject> getHostProjects(int c_identifier) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<HostProject> hostProjects = new ArrayList<HostProject>();
		
		try {
			stmt = con.prepareStatement("SELECT p_id, p_name, money, start_time, end_time FROM project_info WHERE host_identifier = ?");
			stmt.setInt(1, c_identifier);
			result = stmt.executeQuery();
			
			while(result.next()){
				hostProjects.add(new HostProject(result.getInt("p_id"), result.getString("p_name"), result.getDouble("money"), result.getDate("start_time"), result.getDate("end_time")));
			}
			
			return hostProjects;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return null;
	}

	@Override
	public InvolvedProject getInvolvedProject(int c_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	//验证登录
	@Override
	public int validate(String name, String password) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("SELECT password, type FROM common_user WHERE name = ?");
			stmt.setString(1, name);
			result = stmt.executeQuery();
			
			while(result.next()){
				if(result.getString("password").equals(password)){
					return result.getInt("type");
				}
				else{
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return 0;
	}

	//普通用户注册
	@Override
	public boolean register(String name, String password, String bank_card) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO common_user(name, password, bank_card, type) values (?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setString(3, bank_card);
			stmt.setInt(4, new Integer(1));
			
			if(stmt.executeUpdate() != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return false;
	}

	//查询个人Identifer
	@Override
	public int getIdentifier(String name) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("SELECT identifier FROM common_user WHERE name = ?");
			stmt.setString(1, name);
			result = stmt.executeQuery();
			
			while(result.next()){
				return result.getInt("identifier");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return 0;
	}

	//获取个人某个项目经费
	@Override
	public double getSingleProjectMoney(int p_id, int c_identifier) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("SELECT money FROM project_involved_users WHERE p_id = ? and identifier = ?");
			stmt.setInt(1, p_id);
			stmt.setInt(2, c_identifier);
			result = stmt.executeQuery();
			
			while(result.next()){
				return result.getDouble("money");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		
		return 0;
	}

	//添加项目成员
	@Override
	public boolean addHostUsers(int p_id, String name, double money) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		Project project = projectDao.getProjectInfo(p_id);
		
		try {
			stmt = con.prepareStatement("INSERT INTO project_involved_users(device_ratio"
					+ ", end_time, identifier, money, others_ratio, p_id, "
					+ "p_name, start_time, state, travel_ratio) values (?,?,?,?,?,?,?,?,?,?)");
			stmt.setDouble(1, project.getDevice_ratio());
			stmt.setDate(2, project.getEnd_time());
			stmt.setInt(3, this.getIdentifier(name));
			stmt.setDouble(4, money);
			stmt.setDouble(5, project.getOthers_ratio());
			stmt.setInt(6, p_id);
			stmt.setString(7, project.getP_name());
			stmt.setDate(8, project.getStart_time());
			stmt.setString(9, "submitted");
			stmt.setDouble(10, project.getTravel_ratio());
			
			if(stmt.executeUpdate() != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		
		return false;
	}
	
	//更新个人信息
	@Override
	public boolean updatePersonalInfo(CommonUser commonUser, String password) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE common_user SET name = ?, bank_card = ?, password = ? WHERE identifier = ?");
			stmt.setString(1, commonUser.getName());
			stmt.setString(2, commonUser.getBank_card());
			stmt.setString(3, password);
			stmt.setInt(4, commonUser.getIdentifier());
			
			if(stmt.executeUpdate() != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		
		return false;
	}

}
