package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/*
	 * 기존 JDBC
	 * public static Connection getConnection(){
	 *      // driver.properties 파일 읽어들여서
	 *      // 해당 DB와 접속된 Connection 객체 생성해서 반환
	 * 
	 * }
	 * 
	 * public static void close(JDBC용 객체){
	 *    // 전달받은 JDBC용 객체를 반납시키는 구문
	 *    
	 * }
	 * 
	 * 
	 * public static void commit|rollback(Conn){
	 *         // 트랜젝션 처리 
	 */
	
	// 마이바티스
	public static SqlSession getSqlSession() {
		// mybatis-config.xml 파일 읽어들여서
		//해당  DB와 접속된 SqlSession 객체 생성하여 반환
		SqlSession sqlSession = null;
		
		//SqlSession 생성하기 위해서 => SqlSessionFactory 필요!
		//SqlSessionFactory생성하기 위해서 => SqlSessionFactoryBuoilder필요!
		
		String resource ="/mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
         sqlSession =new SqlSessionFactoryBuilder().build(stream).openSession(false);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return sqlSession;
	}		
}