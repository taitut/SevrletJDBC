package com.laptrinhjavaweb.DAO.Ipl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.laptrinhjavaweb.DAO.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	ResourceBundle resource = ResourceBundle.getBundle("db");
	public Connection getConnection() {
		try {
			Class.forName(resource.getString("driverName"));
			String url = resource.getString("url");
			String user = resource.getString("user");
			String password = resource.getString("password");
			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public void setParameter(PreparedStatement satement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					satement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					satement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					satement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					satement.setTimestamp(index, (Timestamp) parameter);
				} else if (parameter instanceof Timestamp) {
					satement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public <T>List<T> query(String sql, RowMapper<T> row, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(row.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
//				if (con != null) {
//					con.close();
//				}

			} catch (SQLException e2) {
				e2.printStackTrace();
				return null;
			}
		}

	}

	

	@Override
	public void update(String Sql, Object... parameters) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			statement = con.prepareStatement(Sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public Long insert(String Sql, Object... parameters) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Long id = null;
			con = getConnection();
			con.setAutoCommit(false);
			statement = con.prepareStatement(Sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			con.commit();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
				return null;
			}
			return null;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
				return null;
			}
		}
	}
	@Override
	public int Count(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			con = getConnection();
			statement = con.prepareStatement(sql);
			setParameter(statement, parameters);
			
			resultSet= statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
				return 0;
			}
			return 0;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
				return 0;
			}
		}
	}

}
