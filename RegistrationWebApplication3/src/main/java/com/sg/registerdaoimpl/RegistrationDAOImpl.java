package com.sg.registerdaoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sg.registerdao.RegistrationDAO;
import com.sg.registrationmodelclass.Registration;

public class RegistrationDAOImpl implements RegistrationDAO {
	
	
	ArrayList<Registration> rList = new ArrayList<Registration>();
	String url = "jdbc:mysql://localhost:3306/driveassesment";
	String nm = "root";
	String pass = "root";
	private Connection con;
	String insertQuery = "insert into `registration`(`name`,`email`,`dob`,`phone`,`address`) values (?,?,?,?,?)";
	String fetchAllQuery = "select * from `registration`";
	String updateQuery = "update `registration` set `name` = ? , `email` = ? , `dob` = ? , `phone` = ? , `address` = ? where `id` = ?";
	String deleteQuery = "delete from `registration` where `id` = ?";
	String fetchOnId = "select * from `registration` where `id` = ?";
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;
	
	public RegistrationDAOImpl() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,nm,pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public int insertData(Registration r) {
	    try {
	        pstmt = con.prepareStatement(insertQuery);
	        pstmt.setString(1, r.getName());
	        pstmt.setString(2, r.getEmail());

	        // Convert LocalDate to java.sql.Date
	        java.sql.Date sqlDate = java.sql.Date.valueOf(r.getDob());
	        pstmt.setDate(3, sqlDate);

	        pstmt.setString(4, r.getPhone());
	        pstmt.setString(5, r.getAddress());

	        status = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}

	
	@Override
	public ArrayList<Registration> fetchAll()
	{
		try {
			
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(fetchAllQuery);
			
			return extractData(resultSet);
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public Registration fetchAllId(int id) {
		
		try {
			
			pstmt = con.prepareStatement(fetchOnId);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			
			rList=  extractData(resultSet);
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return rList.get(0);
		
	}
	
	
	@Override
	public int updateData(Registration r) {
	    try {
	        pstmt = con.prepareStatement(updateQuery);
	        pstmt.setString(1, r.getName());
	        pstmt.setString(2, r.getEmail());

	        // Convert LocalDate to java.sql.Date
	        java.sql.Date sqlDate = java.sql.Date.valueOf(r.getDob());
	        pstmt.setDate(3, sqlDate);

	        pstmt.setString(4, r.getPhone());
	        pstmt.setString(5, r.getAddress());
	        pstmt.setInt(6,r.getId());

	        status = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}

	
	@Override
	public int deleteData(int id)
	{
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
	public ArrayList<Registration> extractData(ResultSet res)
	{
		try {
			while(res.next())
			{
				
					rList.add(new Registration(res.getInt("id"),
							res.getString("name"),
							res.getString("email"),
							res.getDate("dob").toLocalDate(),
							res.getString("phone"),
							res.getString("address")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rList;
	}
	
	
	

}
