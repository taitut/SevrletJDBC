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

import com.laptrinhjavaweb.DAO.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/new_servlet";
			String user = "root";
			String password = "1234";
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

			} catch (SQLException e2) {
				e2.printStackTrace();
				return null;
			}
		}

	}

	

	@Override
	public void update(String Sql, Object... parameters) {
		this.mo("SET FOREIGN_KEY_CHECKS=0");
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
			this.tat("SET FOREIGN_KEY_CHECKS=1");
			try {
				if (statement != null) {
					statement.close();
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
	public void mo(String sql) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	public void tat(String sql) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
