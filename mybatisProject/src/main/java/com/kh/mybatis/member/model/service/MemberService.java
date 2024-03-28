package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {


	//인터페이스 :상수필드(public static final) + 추상메소드(public abstract)
	
	/*public abstract*/ int insertMember(Member m);
	
	Member loginMember(Member m);
	
   int updateMember(Member m);
   
   int deleteMember(String userId);
}
