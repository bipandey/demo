package system.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;

import system.beans.UserDetail;

@ManagedBean
// @RequestScoped
public class UserHandlerDao extends JdbcConnection {

	private String sql;

	public Connection getDbConnection() {
		return conn;
	}

	public List<UserDetail> getAuthors() throws SQLException {
		sql = "select * from user_detail";
		stmt = getDbConnection().prepareStatement(sql);
		rs = stmt.executeQuery(sql);

		List<UserDetail> authors = new ArrayList<UserDetail>();

		while (rs.next()) {
			UserDetail user_detail = new UserDetail();
			user_detail.setId(rs.getInt("id"));
			user_detail.setName(rs.getString("name"));
			user_detail.setEmail(rs.getString("email"));
			user_detail.setSex(rs.getString("sex"));
			authors.add(user_detail);
		}
		return authors;

	}

	public void add(UserDetail detail) throws SQLException {

		sql = "insert into user_detail (id,name,email,sex) values(?,?,?,?)";
		stmt = getDbConnection().prepareStatement(sql);
		stmt.setInt(1, detail.getId());
		stmt.setString(2, detail.getName());
		stmt.setString(3, detail.getEmail());
		stmt.setString(4, detail.getSex());
		stmt.executeUpdate();
	}

	
	  public void delete(String name) throws SQLException {
	   sql ="delete from user_detail where name=?"; 
	  stmt =getDbConnection().prepareStatement(sql);
	   stmt.setString(1, name);
	  stmt.executeUpdate(); }
	 
/*
	public void delete(UserDetail id) throws SQLException {
		
		stmt = getDbConnection().prepareStatement(null);

		stmt.executeUpdate();
	}
*/
}