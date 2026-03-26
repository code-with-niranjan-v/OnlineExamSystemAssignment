package com.hexaware.OnlineExamSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hexaware.OnlineExamSystem.entity.Question;
import com.hexaware.OnlineExamSystem.util.DBConnectionUtil;

public class ExamDaoImplementation implements ExamDao {

	Connection con;
	public ExamDaoImplementation() {
		try {
			con = DBConnectionUtil.getConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void addQuestion(Question q) {
		try {
			PreparedStatement p1 = con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
			p1.setInt(1, q.getQuestionId());
			p1.setString(2, q.getQuestionText());
			p1.setString(3, q.getOptionA());
			p1.setString(4, q.getOptionB());
			p1.setString(5, q.getOptionC());
			p1.setString(6, q.getOptionD());
			p1.setString(7, q.getCorrectAnswer());
			
			int r = p1.executeUpdate();
			if(r>0) {
				System.out.println("Question Added Successfully!");
			}else {
				System.out.println("Question Addition Failed!");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateQuestion(Question q) {
		try {
			PreparedStatement p1 = con.prepareStatement("update question set questionText=?,optionA=?,optionB=?,optionC=?,optionD=?,correctAnswer=? where questionId=?");
			
			p1.setString(1, q.getQuestionText());
			p1.setString(2, q.getOptionA());
			p1.setString(3, q.getOptionB());
			p1.setString(4, q.getOptionC());
			p1.setString(5, q.getOptionD());
			p1.setString(6, q.getCorrectAnswer());
			p1.setInt(7, q.getQuestionId());
			
			int r = p1.executeUpdate();
			if(r>0) {
				System.out.println("Question Updated Successfully!");
			}else {
				System.out.println("Question Updation Failed!");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewAllQuestions() {
		try {
			PreparedStatement p1 = con.prepareStatement("select * from question");
			ResultSet res = p1.executeQuery();
			while(res.next()) {
				Question q = new Question(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
				System.out.println(q);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
