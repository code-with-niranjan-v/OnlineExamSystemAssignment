package com.hexaware.OnlineExamSystem.dao;

import java.util.List;

import com.hexaware.OnlineExamSystem.entity.Member;
import com.hexaware.OnlineExamSystem.entity.Question;

public interface MemberDao {
	void registerMember(Member m);
	List<Question> getAllQuestion();
}
