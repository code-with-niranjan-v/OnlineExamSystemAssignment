package com.hexaware.OnlineExamSystem.service;

import java.util.List;
import java.util.Scanner;

import com.hexaware.OnlineExamSystem.dao.MemberDao;
import com.hexaware.OnlineExamSystem.dao.MemberDaoImplementation;
import com.hexaware.OnlineExamSystem.entity.Member;
import com.hexaware.OnlineExamSystem.entity.Question;

public class MemberService {
	Scanner sc;
	MemberDao memberDao;
	
	public MemberService() {
		sc = new Scanner(System.in);
		memberDao = new MemberDaoImplementation();
	}
	
	public void registerUser() {
		System.out.println("Enter your Id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter your Name: ");
		String name = sc.nextLine();
		System.out.println("Enter your Email: ");
		String email = sc.nextLine();
		
		Member m = new Member(id, name, email);
		memberDao.registerMember(m);
	}
	
	public void takeExam() {
		List<Question> questions = memberDao.getAllQuestion();
		int score = 0;
		System.out.println("Answer the following questions");
		for(Question q:questions) {
			System.out.println(q.getQuestionId()+" "+q.getQuestionText()+"\nA. "+q.getOptionA()+"\nB. "+q.getOptionB()+"\nC. "+q.getOptionC()+"\nD. "+q.getOptionD());
			String answer = sc.nextLine();
			if(answer.toLowerCase().equals(q.getCorrectAnswer().toLowerCase())) {
				score+=5;
			}
		}
		System.out.println("Score: "+score+"/"+(5*questions.size()));
	}
}
