package com.hexaware.OnlineExamSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hexaware.OnlineExamSystem.dao.ExamDao;
import com.hexaware.OnlineExamSystem.dao.ExamDaoImplementation;
import com.hexaware.OnlineExamSystem.dao.MemberDao;
import com.hexaware.OnlineExamSystem.dao.MemberDaoImplementation;
import com.hexaware.OnlineExamSystem.entity.Member;
import com.hexaware.OnlineExamSystem.entity.Question;
import com.hexaware.OnlineExamSystem.util.DBConnectionUtil;

public class MemberTest {
	static Connection  con;
	static MemberDao memberDao;
	
	
	@BeforeAll
	public static void setup() {
		try {
			con = DBConnectionUtil.getConnection();
			memberDao = new MemberDaoImplementation();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@BeforeEach
	public void addMember() {
		try {
			Member m = new Member(1000,"Sample User","Sample Email");
			memberDao.registerMember(m);
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void testRegisterMember() {
		try {
			Member m1 = new Member(1000,"Sample User","Sample Email");
			PreparedStatement p1 = con.prepareStatement("select * from member where userId=?");
			p1.setInt(1, 1000);
			ResultSet res = p1.executeQuery();
			Member m2 = null;
			while(res.next()) {
				m2 = new Member(res.getInt(1), res.getString(2), res.getString(3));
			}
			
			assertEquals(m1, m2);
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void testGetAllQuestion() {
		try {
			List<Question> q1 = memberDao.getAllQuestion();
			List<Question> q2 = null;
			PreparedStatement p1 = con.prepareStatement("select * from question");
			ResultSet res = p1.executeQuery();
			while(res.next()) {
				Question q = new Question(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
				q2.add(q);
			}
			
			assertEquals(q1, q2);
		}catch(Exception e){
			
		}
	}
	
	@AfterEach
	public void clean() {
		try {
	
			PreparedStatement p1 = con.prepareStatement("delete  from member where userId=?");
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
