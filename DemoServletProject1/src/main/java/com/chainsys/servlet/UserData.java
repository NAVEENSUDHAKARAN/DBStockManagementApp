package com.chainsys.servlet;

import java.util.ArrayList;

public class UserData {
	static ArrayList<UserDetails> data = new ArrayList<UserDetails>();

	public static void setData(String Name, String DOB, String EmpId) {
		
		//UserDetails d = new UserDetails(Name, DOB, EmpId);
		
		//data.add(d);
	}
	
	public static ArrayList<UserDetails> getData(){
		return data;
		
		
	}
	
}
