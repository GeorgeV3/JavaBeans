package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.fabric.Response;

public class NewCarBean {

	private String registration;
	private String factory ;
	private String model ;
	private String colour ;
	private String cc ;
	private String regdate ;

	private  String url = "jdbc:mysql://5.189.135.166:3011/test?useSSL=false";
	private  String usernameDb = "java";
	private  String passwordDb = "java";
	Connection con = null;


	public NewCarBean(){}

	//	public String insert() {
	//		Connection con = null;
	//		Statement statement = null;
	//		String SQLstr;
	//		String retString = "";
	//		
	//		if(registration == null  || factory == null || model== null || colour==null || cc == null || regdate == null ||
	//				registration.equals("")  || factory.equals("") || model.equals("") || colour.equals("") || cc.equals("") || regdate.equals("")) {
	//			retString = "Fill the text fields";
	//		}else {
	//			try {
	//				con = DriverManager.getConnection(url, usernameDb, passwordDb);
	//				SQLstr =  "INSERT INTO CAR VALUES ('"+getRegistration()+"','"+getFactory()+"','"+getModel()+"','"+getColour()+"','"+getCc()+"','"
	//						+ getRegdate()+");)";
	//				
	//				statement = con.createStatement();
	//				statement.executeUpdate(SQLstr);
	//				retString ="Success register";
	//			} catch (SQLException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		} return retString;
	//			
	//	}




	public String registerCar() {
		String retString = "";
	
		if(registration == null  || factory == null || model== null || colour==null || cc == null || regdate == null ||
				registration.equals("")  || factory.equals("") || model.equals("") || colour.equals("") || cc.equals("") || regdate.equals("")) {
			retString = "Fill the text fields";
		}else {
			try {
				con = DriverManager.getConnection(url, usernameDb, passwordDb);
				PreparedStatement ps;
				ps = con.prepareStatement("INSERT INTO car\r\n" + 
						"VALUES (?,?,?,?,?,?);");
				ps.setString(1,getRegistration());
				ps.setString(2,getFactory());
				ps.setString(3,getModel());
				ps.setString(4,getColour());
				ps.setString(5, getCc());
				ps.setString(6,getRegdate());
				ps.executeUpdate();
				con.close();
				retString ="Success register";

			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				System.out.println("wrong execute statement.");		
			}
		}return retString;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
