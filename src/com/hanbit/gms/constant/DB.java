package com.hanbit.gms.constant;

public class DB {
	public static final	String ORDRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String ORURL="jdbc:oracle:thin:@localhost:1521:xe";
	
	public static final	String DB2_DRIVER="";
	public static final String DB2_URL="";
	
	public static final	String MYSQL_DRIVER="";
	public static final String MYSQL_URL="";
	
	public static final	String MSSQL_DRIVER="";
	public static final String MSSQL_URL="";
	
	public static final	String MARIADB_DRIVER="";
	public static final String MARIADB_URL="";
	
	public static final String USERNAME="hanbit";
	public static final String PASSWORD="hanbit";
	public static final String TABLE_MEMBER = "Member";
	public static final String TABLE_BOARD = "Board";
	
	public static final String MEMBER_ID = "id";
	public static final String MEMBER_NAME = "name";
	public static final String MEMBER_PASS = "password";
	public static final String MEMBER_SSN = "ssn";
	public static final String MEMBER_REGDATE = "regdate";

	public static final String BOARD_ID = "id";
	public static final String BOARD_TITLE = "title";
	public static final String BOARD_CONTENT = "content";
	public static final String BOARD_REGDATE = "regdate";
	public static final String BOARD_SEQ = "article_Seq";
	public static final String BOARD_HC = "hitcount";
}
