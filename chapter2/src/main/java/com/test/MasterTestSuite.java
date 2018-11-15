package com.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value={Test1.class, TestMockMvc.class})
public class MasterTestSuite {



}
