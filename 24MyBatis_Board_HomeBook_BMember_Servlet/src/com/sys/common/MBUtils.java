package com.sys.common;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// 마이바티스 사용시 사용할 유틸리티
public class MBUtils {
	
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "com/sys/common/SqlMapConfig.xml";
		// 보조기억장치 파일을 메모리로 읽는 빨대 
		InputStream  reader;
		try {
			reader = Resources.getResourceAsStream(resource);
		}catch (IOException e) {
			// 새로운 예외로 발생시키기 
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSession getSession() {
		// 트랜잭션을 사용하려면 openSession(false),
		// 자동커밋을 원하면 openSession(true) - jdbc에서 conn.setAutoCommit(true) 
		return getSqlSessionFactory().openSession(false);
	}
	
}
