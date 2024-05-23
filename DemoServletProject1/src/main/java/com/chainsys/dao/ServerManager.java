package com.chainsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.servlet.UserDetails;
//import com.chainsys.util.ConnectUtil;
import com.chainsys.util.ConnectUtil;

public class ServerManager {

	
	public void insertToDB(UserDetails user) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = connect.getConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		

		int result = 0;
		
		
		String query = "INSERT INTO User_Cred (Name,DOB,EmpId) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2, user.getDOB());
            preparedStatement.setString(3, user.getEmpId());
            
            result = preparedStatement.executeUpdate();
            
            System.out.println(result);

        } 

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
	}
	

	public ArrayList<UserDetails> getUserDetails() throws ClassNotFoundException {
	    ArrayList<UserDetails> userDetailsList = new ArrayList<>();
	    
	    try {
	        Connection connection = ConnectUtil.getConnection();
	        String query = "SELECT * FROM User_Cred";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            UserDetails userDetails = new UserDetails();
	            userDetails.setName(resultSet.getString("Name"));
	            userDetails.setDOB(resultSet.getString("DOB"));
	            userDetails.setEmpId(resultSet.getString("EmpId"));
	            userDetailsList.add(userDetails);
	        }
	        
	        resultSet.close();
	        preparedStatement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return userDetailsList;
	}
	
	public static ArrayList<UserDetails> delete(int id) throws ClassNotFoundException {
		try {
			Connection connection = ConnectUtil.getConnection();
			
			ArrayList<UserDetails> deletedList = new ArrayList<>();
			String query = "Delete from User_Cred where EmpId = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			
			prepareStatement.setInt(1, id);
			
			int rows = prepareStatement.executeUpdate();
			
			if(rows > 0)
			{
				deletedList.add(new UserDetails());
			}
			
			return deletedList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
			
	}
	
	public static ArrayList<UserDetails> update(int id, String name) throws ClassNotFoundException, SQLException{
		try {
			Connection connection = ConnectUtil.getConnection();
			
			ArrayList<UserDetails> updatedList = new ArrayList<>();
			UserDetails user = new UserDetails();
			String query = "update User_Cred set Name = ? where EmpId = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, id);
			
			int rows = prepareStatement.executeUpdate();
			
			if(rows > 0)
			{
				updatedList.add(new UserDetails());
			}
			return updatedList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
 