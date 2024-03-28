package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService{
	
  private	MemberDao mDao = new MemberDao();

	@Override
	public int insertMember(Member m) {
		/*
	       * Connection conn = JDBCTemplate.getConenction();
	       * int result = new MemberDao().insertMember(conn,m);
	       * 
	       * if(result>0){
	       *       JDBCTemplate.commit(conn);
	       * }else{
	       *       JDBCTemplate.rollback(conn);
	       * }
	       * 
	       * return result;
	       */
		
		
		
   SqlSession sqlSession =	Template.getSqlSession();
   //이때 mybatis-config.xml문서 읽어들임
   //이때 등록시킨 mapper.xml문서들도 다읽어들여짐
   
    int result = mDao.insertMember(sqlSession, m);
    
    
       if(result >0) {
    	   sqlSession.commit();
       }
       
      sqlSession.close();
      
      return result;
        
	}

	@Override
	public Member loginMember(Member m) {
		
		
	SqlSession sqlSession = Template.getSqlSession();
	Member loginUser =	mDao.loginMember(sqlSession,m);
	
	   sqlSession.close();
	   
	   return loginUser;
	
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
