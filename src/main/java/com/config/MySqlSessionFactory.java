package com.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {

	static final SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "com/config/Configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream =Resources.getResourceAsStream(resource);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	// SqlSessionFactory 에서 SqlSession 리턴
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}