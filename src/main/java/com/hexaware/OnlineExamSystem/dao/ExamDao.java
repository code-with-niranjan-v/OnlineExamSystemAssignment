package com.hexaware.OnlineExamSystem.dao;

import com.hexaware.OnlineExamSystem.entity.Question;

public interface ExamDao {
	void addQuestion(Question q);
	void updateQuestion(Question q);
	void viewAllQuestions();
}
