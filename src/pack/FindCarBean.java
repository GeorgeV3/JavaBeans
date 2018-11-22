package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class FindCarBean {
	
	private String registration;
	private String factory ;
	private String model ;
	private String colour ;
	private String cc ;
	private String regdate ;
	
	private  String url = "jdbc:mysql://5.189.135.166:3011/test?useSSL=false";
	private  String usernameDb = "java";
	private  String passwordDb = "java";
	
	public FindCarBean() {}
	
	Connection con = null;
	Statement statement = null;
	

	
	public ArrayList<FindCarBean> find(){
		ArrayList<FindCarBean> carList = new ArrayList<>();
	
		try {
		 
			con = DriverManager.getConnection(url, usernameDb, passwordDb);
			PreparedStatement ps;
			String brb="%";

			ps = con.prepareStatement("SELECT * FROM car WHERE registration like ? and  factory like ? and model like ? and colour like ? and cc like ? and regdate like  ?;");
			if (registration == null || registration.equals("")) {
				ps.setString(1,brb);
			}else {
				ps.setString(1, registration);
			}
			if (factory == null || factory.equals("")) {
				ps.setString(2,brb);
			}else {
				ps.setString(2, factory);
			}
			if (model == null || model.equals("")) {
				ps.setString(3,brb);
			}else {
				ps.setString(3, model);
			}	
			if (colour == null || colour.equals("")) {
				ps.setString(4,brb);
			}else {
				ps.setString(4, colour);
			}	
			if (cc == null || cc.equals("")) {
				ps.setString(5,brb);
			}else {
				ps.setString(5, cc);
			}	
			if (regdate == null || regdate.equals("")) {
				ps.setString(6,brb);
			}else {
				ps.setString(6, regdate);
			}		
			
			ResultSet rst = ps.executeQuery();
			 while(rst.next()) {
				FindCarBean car = new FindCarBean();
				car.setRegistration(rst.getString("registration"));
				car.setFactory(rst.getString("factory"));
				car.setModel(rst.getString("model"));
				car.setColour(rst.getString("colour"));
				car.setCc(rst.getString("cc"));
				car.setRegdate(rst.getString("regdate"));
				carList.add(car);
			 }
			
				con.close();
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			System.out.println("wrong execute statement.");		
		}
		
		return carList;
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
	
	
	