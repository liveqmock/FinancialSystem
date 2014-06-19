package financialSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import financialSystem.dao.CommonUserDao;
import financialSystem.dao.DaoHelper;
import financialSystem.dao.ProjectDao;
import financialSystem.model.InvolvedProject;
import financialSystem.model.Project;

public class ProjectDaoImpl implements ProjectDao {
	private DaoHelper daoHelper;
	private CommonUserDao commonUserDao;

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
	

	// 查询参与项目信息
	@Override
	public ArrayList<InvolvedProject> getInvolvedProjects(int c_identifier) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<InvolvedProject> involvedProjects = new ArrayList<InvolvedProject>();

		try {
			stmt = con
					.prepareStatement("SELECT p_id, identifier, p_name, money, device_ratio, travel_ratio, others_ratio, start_time, end_time, state, expense, host_name FROM project_involved_users WHERE identifier = ?");
			stmt.setInt(1, c_identifier);
			result = stmt.executeQuery();

			while (result.next()) {
				involvedProjects
						.add(new InvolvedProject(result.getInt("p_id"), result
								.getInt("identifier"), result
								.getString("p_name"),
								result.getDouble("money"), result
										.getDouble("device_ratio"), result
										.getDouble("device_ratio"), result
										.getDouble("others_ratio"), result
										.getDate("start_time"), result
										.getDate("end_time"), result
										.getString("state"), result.getDouble("expense"), result.getString("host_name")));
			}

			return involvedProjects;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return null;
	}

	// 获取单个项目信息
	@Override
	public Project getProjectInfo(int p_id) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		Project project = null;

		try {
			stmt = con
					.prepareStatement("SELECT p_id, p_name, host_identifier, money, device_ratio, travel_ratio, others_ratio, start_time, end_time, host_name FROM project_info WHERE p_id = ?");
			stmt.setInt(1, p_id);
			result = stmt.executeQuery();

			while (result.next()) {
				ArrayList<Integer> involved_users = daoHelper
						.getLists(
								"SELECT identifier FROM project_involved_users WHERE p_id = ?",
								p_id, "identifier");
				project = new Project(result.getInt("p_id"),
						result.getString("p_name"),
						result.getInt("host_identifier"),
						result.getDouble("money"),
						result.getDouble("device_ratio"),
						result.getDouble("travel_ratio"),
						result.getDouble("others_ratio"),
						result.getDate("start_time"),
						result.getDate("end_time"), involved_users,
						result.getString("host_name"));
			}
			return project;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return null;
	}

	//获取单个参与项目信息
	@Override
	public InvolvedProject getInvolvedProject(int p_id, int c_identifier) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		InvolvedProject involvedProject = null;
		
		try {
			stmt = con
					.prepareStatement("SELECT p_id, identifier, money, p_name, device_ratio, travel_ratio, others_ratio, start_time, end_time, state, expense, host_name FROM project_involved_users WHERE p_id = ? and identifier = ?");
			stmt.setInt(1, p_id);
			stmt.setInt(2, c_identifier);
			result = stmt.executeQuery();

			while (result.next()) {
				involvedProject = new InvolvedProject(result.getInt("p_id"), result.getInt("identifier"), result.getString("p_name"), result.getDouble("money"), result.getDouble("device_ratio"), result.getDouble("travel_ratio"), result.getDouble("others_ratio"), result.getDate("start_time"), result.getDate("end_time"), result.getString("state"), result.getDouble("expense"), result.getString("host_name"));
			}
			return involvedProject;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return null;
	}

	//更新个人参与项目信息
	@Override
	public boolean updateInvolvedProject(InvolvedProject involvedProject) {
//		System.out.println("~~~~~~~~" + involvedProject.getExpense() + "  " + involvedProject.getC_identifier() + " " + involvedProject.getP_id());
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM project_involved_users WHERE p_id = ? and identifier = ?");
			stmt.setInt(1, involvedProject.getP_id());
			stmt.setInt(2, involvedProject.getC_identifier());
			stmt.execute();
			daoHelper.closePreparedStatement(stmt);
			
			stmt = con.prepareStatement("INSERT INTO project_involved_users ("
					+ "device_ratio, end_time, expense, host_name, "
					+ "identifier, money, others_ratio, p_id, "
					+ "p_name, start_time, state, travel_ratio) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setDouble(1, involvedProject.getDevice_ratio());
			stmt.setDate(2, involvedProject.getEnd_time());
			stmt.setDouble(3, involvedProject.getExpense());
			stmt.setString(4, involvedProject.getHost_name());
			stmt.setInt(5, involvedProject.getC_identifier());
			stmt.setDouble(6, involvedProject.getMoney());
			stmt.setDouble(7, involvedProject.getOthers_ratio());
			stmt.setInt(8, involvedProject.getP_id());
			stmt.setString(9, involvedProject.getP_name());
			stmt.setDate(10, involvedProject.getStart_time());
			stmt.setString(11, involvedProject.getState());
			stmt.setDouble(12, involvedProject.getTravel_ratio());
			
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
	
	//审核报销
	@Override
	public boolean verifyExpense(int p_id, int c_identifier) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE project_involved_users SET state = ? WHERE identifier = ? and p_id = ?");
			stmt.setString(1, "host_agree");
			stmt.setInt(2, c_identifier);
			stmt.setInt(3, p_id);
			
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
