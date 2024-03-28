package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

   public int insertMember(SqlSession sqlSession, Member m) {
      
      /*
          * int result = 0;
          * PreparedStatment pstmt = null;
          * String sql = prop.getProperty("insertMember");
          * 
          * try{
          *    pstmt = conn.prepareStatment(sql);
          *  pstmt.setString(1, m.getUserId());
          *  pstmt.setString(2, m.getUserPwd());
          *  .....
          *  
          *  result = pstmt.executeUpdate();
          * 
          * } catch(xxxx){
          * 
          * } finally {
          *    close(pstmt);
          * }
          * 
          * return result;
          * 
          */
      
         /*
          * sqlSession에서 제공하는 메소드를 통해서 sql문을 찾아서 실행하고 결과바로 받음
          * (마이바티스를 연동해야지만 됨)
          * 결과 = sqlSession.sql문종류에맞는메소드("매퍼의별칭.해당sql문고유한id", [그 sql문을 완성시킬 객체]);
          */
      
         //int result = sqlSession.insert("memberMapper.insertMember", m );
         //return result;
         return sqlSession.insert("memberMapper.insertMember",m);

   }
   
   public Member loginMember(SqlSession sqlSession, Member m) {
   
      // selectOne 메소드 : 조회결과가 만일 없다면 null 반환
      //Member loginUser =  sqlSession.selectOne("memberMapper.loginMember", m);
      //return loginUser;
      return sqlSession.selectOne("memberMapper.loginMember", m);
   }
}