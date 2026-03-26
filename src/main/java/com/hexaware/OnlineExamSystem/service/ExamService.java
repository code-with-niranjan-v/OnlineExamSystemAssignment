package com.hexaware.OnlineExamSystem.service;

import java.util.Scanner;

import com.hexaware.OnlineExamSystem.dao.ExamDao;
import com.hexaware.OnlineExamSystem.dao.ExamDaoImplementation;
import com.hexaware.OnlineExamSystem.entity.Question;

public class ExamService {
	Scanner sc;
	ExamDao examDao;
	public ExamService() {
		sc = new Scanner(System.in);
		examDao = new ExamDaoImplementation();
	}
	public void addQuestion() {
		System.out.println("Enter your Question Id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter your Question: ");
		String questionText = sc.nextLine();
		System.out.println("Enter your Option A: ");
		String optionA = sc.nextLine();
		System.out.println("Enter your Option B: ");
		String optionB = sc.nextLine();
		System.out.println("Enter your Option C: ");
		String optionC = sc.nextLine();
		System.out.println("Enter your Option D: ");
		String optionD = sc.nextLine();
		System.out.println("Enter your Correct Answer: ");
		String correctAnswer = sc.nextLine();
		Question q = new Question(id, questionText, optionA, optionB, optionC, optionD, correctAnswer);
		examDao.addQuestion(q);
	}
	
	
	public void updateQuestion() {
		System.out.println("Enter your Question Id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter your Question: ");
		String questionText = sc.nextLine();
		System.out.println("Enter your Option A: ");
		String optionA = sc.nextLine();
		System.out.println("Enter your Option B: ");
		String optionB = sc.nextLine();
		System.out.println("Enter your Option C: ");
		String optionC = sc.nextLine();
		System.out.println("Enter your Option D: ");
		String optionD = sc.nextLine();
		System.out.println("Enter your Correct Answer: ");
		String correctAnswer = sc.nextLine();
		Question q = new Question(id, questionText, optionA, optionB, optionC, optionD, correctAnswer);
		examDao.updateQuestion(q);
	}
	
	public void viewAllQuestion() {
		examDao.viewAllQuestions();
	}
}
