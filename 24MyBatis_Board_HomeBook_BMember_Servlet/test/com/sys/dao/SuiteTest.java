package com.sys.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sys.service.TestOfServiceDAO;

@RunWith(Suite.class)
@Suite.SuiteClasses(
		{TestOfBoardDAO.class,
		 TestOfBMemberDAO.class,
		 TestOfHomeBookDAO.class,
		 TestOfServiceDAO.class
		})
public class SuiteTest {

}
