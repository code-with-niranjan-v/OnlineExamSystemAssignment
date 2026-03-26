package com.hexaware.OnlineExamSystem;

import java.util.Scanner;

import com.hexaware.OnlineExamSystem.service.ExamService;
import com.hexaware.OnlineExamSystem.service.MemberService;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        boolean isEnd = false;
        MemberService memberService = new MemberService();
        ExamService examService = new ExamService();
        while(!isEnd) {
        	System.out.println("1.Admin\n2.User\n3.Exit");
        	int option = Integer.parseInt(sc.nextLine());
        	boolean isBack = false;
        	while(!isBack) {
        		switch(option) {
        		case 1:{
        			System.out.println("1.Add Question\n2.Update Question\n3.View All Questions\n4.Back");
        			int op = Integer.parseInt(sc.nextLine());
        			switch(op) {
        			case 1:{
        				examService.addQuestion();
        			}
        			break;
        			case 2:{
        				examService.updateQuestion();
        			}
        			break;
        			case 3:{
        				examService.viewAllQuestion();
        			}
        			break;
        			case 4:{
        				isBack = true;
        			}
        			break;
        			}
        		}break;
        		case 2:{
        			System.out.println("1.Register\n2.Take Exam\n3.Back");
        			int op = Integer.parseInt(sc.nextLine());
        			switch(op) {
        			case 1:{
        				memberService.registerUser();
        			}
        			break;
        			case 2:{
        				memberService.takeExam();
        			}
        			break;
        			case 3:{
        				isBack = true;
        			}
        			break;}
        		}break;
        		case 3:{
        			isEnd = true;
        			isBack = true;
        		}
        		break;
        		}
        	}
        }
    }
}
