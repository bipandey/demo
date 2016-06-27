package system.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import system.beans.UserDetail;
import system.dao.*;

@ManagedBean
 @RequestScoped
public class UserHandler {
	@ManagedProperty(value = "#{userDetail}")
	private UserDetail userDetail;

	
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<UserDetail> getDetail() {
		UserHandlerDao userhandlerdao = new UserHandlerDao();
		List<UserDetail> userdetail = new ArrayList<UserDetail>();

		try {
			userdetail = userhandlerdao.getAuthors();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userdetail;
	}

	public void addUser()  {
	
		UserHandlerDao uhd = new UserHandlerDao();
		try {
			uhd.add(userDetail);
		setMessage("sucessfully Added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

		public void delete(String name) throws SQLException {

		UserHandlerDao uhd = new UserHandlerDao();
		uhd.delete(name);
		setMessage("user deleted");
	}
 
	
	/*  public void delete(UserDetail id) throws SQLException{
	  
	  UserHandlerDao uhd=new UserHandlerDao();
	  uhd.delete(userDetail); }
	*/
		/*public String getWelcomeMessage(UserDeta)
		{
	return "hello" +name;
}
		*/
	public String getDisplay(){
		 String a="defa";
		//UserHandler uh=new UserHandler();
		 a=userDetail.getName();
		return a+" HELLO";
	}
		
}
