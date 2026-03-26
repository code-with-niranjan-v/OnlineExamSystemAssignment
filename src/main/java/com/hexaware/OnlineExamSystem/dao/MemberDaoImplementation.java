package com.hexaware.OnlineExamSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.OnlineExamSystem.entity.Member;
import com.hexaware.OnlineExamSystem.entity.Question;
import com.hexaware.OnlineExamSystem.util.DBConnectionUtil;

public class MemberDaoImplementation implements MemberDao {
	
	Connection con;
	public MemberDaoImplementation() {
		try {
			con = DBConnectionUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void registerMember(Member m) {
		try {
			PreparedStatement p1 = con.prepareStatement("insert into member values(?,?,?)");
			p1.setInt(1, m.getUserId());
			p1.setString(2, m.getName());
			p1.setString(3, m.getEmail());

			int r = p1.executeUpdate();
			if(r>0) {
				System.out.println("Member Registration Successful!");
			}else {
				System.out.println("Member Registration Failed!");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Question> getAllQuestion() {
		List<Question> questions = new ArrayList<Question>();
		try {
			PreparedStatement p1 = con.prepareStatement("select * from question");
			ResultSet res = p1.executeQuery();
			while(res.next()) {
				Question q = new Question(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
				questions.add(q);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

}
