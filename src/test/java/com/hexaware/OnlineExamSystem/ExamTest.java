package com.hexaware.OnlineExamSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hexaware.OnlineExamSystem.dao.ExamDao;
import com.hexaware.OnlineExamSystem.dao.ExamDaoImplementation;
import com.hexaware.OnlineExamSystem.entity.Question;
import com.hexaware.OnlineExamSystem.service.ExamService;
import com.hexaware.OnlineExamSystem.util.DBConnectionUtil;

public class ExamTest {
	
	static Connection  con;
	static ExamDao examDao;
	
	
	@BeforeAll
	public static void setup() {
		try {
			con = DBConnectionUtil.getConnection();
			examDao = new ExamDaoImplementation();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@BeforeEach
	public void addQuestion() {
		try {
			Question q1 = new Question(1000, "Sample", "1", "2", "3", "4", "4");
			examDao.addQuestion(q1);
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void checkInsert() {
		try {
			Question q1 = new Question(1000, "Sample", "1", "2", "3", "4", "4");
			PreparedStatement p1 = con.prepareStatement("select * from question where questionId=?");
			p1.setInt(1, 1000);
			ResultSet res = p1.executeQuery();
			Question q2 = null;
			while(res.next()) {
				q2 = new Question(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
			}
			
			assertEquals(q1, q2);
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void checkUpdate() {
		try {
			Question q1 = new Question(1000, "New Updated Sample Question", "1", "2", "3", "4", "4");
			examDao.updateQuestion(q1);
			PreparedStatement p1 = con.prepareStatement("select * from question where questionId=?");
			p1.setInt(1, 1000);
			ResultSet res = p1.executeQuery();
			Question q2 = null;
			while(res.next()) {
				q2 = new Question(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
			}
			
			assertEquals(q1.getQuestionText(), q2.getQuestionText());
		}catch(Exception e){
			
		}
	}
	
	@AfterEach
	public void clean() {
		try {
	
			PreparedStatement p1 = con.prepareStatement("delete  from question where questionId=?");
			p1.setInt(1, 1000);
			p1.executeUpdate();
			
		}catch(Exception e){
			
		}
	}
	
	
	@AfterAll
	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			
		}
	}
}
