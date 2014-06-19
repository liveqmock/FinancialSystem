package financialSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import financialSystem.dao.AdminDao;
import financialSystem.dao.CommonUserDao;
import financialSystem.dao.DaoHelper;
import financialSystem.dao.ProjectDao;
import financialSystem.model.CommonUser;
import financialSystem.model.HostProject;
import financialSystem.model.Project;

public class AdminDaoImpl implements AdminDao {
	private DaoHelper daoHelper;
	private CommonUserDao commonUserDao;
	private ProjectDao projectDao;
	
	public CommonUserDao getCommonUserDao() {
		return commonUserDao;
	}
	public void setCommonUserDao(CommonUserDao commonUserDao) {
		this.commonUserDao = commonUserDao;
	}
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
	public boolean addCommonUser(String name, String password, String bank_card) {
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

	@Override
	public boolean addFinancialStaff(String name, String password) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO common_user(name, password, type) values (?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setInt(3, new Integer(2));
			
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

	@Override
	public boolean addFinancialManager(String name, String password) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO common_user(name, password, type) values (?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setInt(3, new Integer(3));
			
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
	
	@Override
	public ArrayList<Project> getProjectLists() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Project> projects = new ArrayList<Project>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM project_info");
			result = stmt.executeQuery();
			
			while(result.next()){
				projects.add(new Project(result.getInt("p_id"), result.getString("p_name"), result.getInt("host_identifier"), result.getDouble("money"), result.getDouble("device_ratio"), result.getDouble("travel_ratio"), result.getDouble("others_ratio"), result.getDate("start_time"), result.getDate("end_time"), null, result.getString("host_name")));
			}
			
			return projects;
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
	public Project getSingleProject(int p_id) {
		return projectDao.getProjectInfo(p_id);
	}
	
	@Override
	public boolean updateProject(Project project) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE project_info SET p_name = ?,"
					+ " host_name = ?, host_identifier = ?, "
					+ "money = ?, start_time = ?, end_time = ?,"
					+ " travel_ratio = ?, device_ratio = ?, others_ratio = ?"
					+ " WHERE p_id = ?");
			stmt.setString(1, project.getP_name());
			stmt.setString(2, project.getHost_name());
			stmt.setInt(3, commonUserDao.getIdentifier(project.getHost_name()));
			stmt.setDouble(4, project.getMoney());
			stmt.setDate(5, project.getStart_time());
			stmt.setDate(6, project.getEnd_time());
			stmt.setDouble(7, project.getTravel_ratio());
			stmt.setDouble(8, project.getDevice_ratio());
			stmt.setDouble(9, project.getOthers_ratio());
			stmt.setInt(10, project.getP_id());
			
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
	@Override
	public boolean addProject(Project project) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO project_info (p_name, host_name, host_identifier, money, start_time, end_time, travel_ratio, device_ratio, others_ratio) values (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, project.getP_name());
			stmt.setString(2, project.getHost_name());
			stmt.setInt(3, commonUserDao.getIdentifier(project.getHost_name()));
			stmt.setDouble(4, project.getMoney());
			stmt.setDate(5, project.getStart_time());
			stmt.setDate(6, project.getEnd_time());
			stmt.setDouble(7, project.getTravel_ratio());
			stmt.setDouble(8, project.getDevice_ratio());
			stmt.setDouble(9, project.getOthers_ratio());
			
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
	@Override
	public ArrayList<CommonUser> getAllCommonUser() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<CommonUser> commonUsers = new ArrayList<CommonUser>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM common_user WHERE type = ?");
			stmt.setInt(1, new Integer(1));
			result = stmt.executeQuery();
			
			while(result.next()){
				commonUsers.add(new CommonUser(result.getString("name"), result.getInt("identifier"), result.getString("bank_card"), null, null));
			}
			
			return commonUsers;
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
	public ArrayList<CommonUser> getAllFinancialStaff() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<CommonUser> commonUsers = new ArrayList<CommonUser>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM common_user WHERE type = ?");
			stmt.setInt(1, new Integer(2));
			result = stmt.executeQuery();
			
			while(result.next()){
				commonUsers.add(new CommonUser(result.getString("name"), result.getInt("identifier"), result.getString("bank_card"), null, null));
			}
			
			return commonUsers;
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
	public ArrayList<CommonUser> getAllFinancialManager() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<CommonUser> commonUsers = new ArrayList<CommonUser>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM common_user WHERE type = ?");
			stmt.setInt(1, new Integer(3));
			result = stmt.executeQuery();
			
			while(result.next()){
				commonUsers.add(new CommonUser(result.getString("name"), result.getInt("identifier"), result.getString("bank_card"), null, null));
			}
			
			return commonUsers;
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
	public CommonUser getSingleCommonUser(int c_identifier) {
		return commonUserDao.getPersonalInfo(c_identifier);
	}
	@Override
	public CommonUser getSingleFinancialStaff(int c_identifier) {
		return commonUserDao.getPersonalInfo(c_identifier);
	}
	@Override
	public CommonUser getSingleFinancialManager(int c_identifier) {
		return commonUserDao.getPersonalInfo(c_identifier);
	}
	
	@Override
	public boolean updateCommonUser(CommonUser commonUser, String password) {
		return commonUserDao.updatePersonalInfo(commonUser, password);
	}
	
	@Override
	public boolean updateFinancialStaff(CommonUser commonUser, String password) {
		return commonUserDao.updatePersonalInfo(commonUser, password);
	}
	@Override
	public boolean updateFinancialManager(CommonUser commonUser, String password) {
		return commonUserDao.updatePersonalInfo(commonUser, password);
	}

}
