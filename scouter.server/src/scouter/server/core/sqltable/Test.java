package scouter.server.core.sqltable;

import java.io.File;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import scouter.server.core.SqlTables;
import scouter.util.FileUtil;

public class Test {

	/**
	 * @param args
	 * @throws JSQLParserException
	 */
	public static void main(String[] args) throws JSQLParserException {
		CCJSqlParserManager pm = new CCJSqlParserManager();
//		String sql = "update XXX set x=10 where x in( SELECT * FROM MY_TABLE1, MY_TABLE2, (SELECT * FROM MY_TABLE3) LEFT OUTER JOIN MY_TABLE4 "
//				+ " WHERE ID = (SELECT MAX(ID) FROM MY_TABLE5) AND ID2 IN (SELECT * FROM MY_TABLE6) and x= ? )";
//		String sql2 = "update XXX set x =10 where aa like '%55' ";
//		String sql3 = "select now ";
//		String sql4 = "delete from xxx ";
//		String sql5 = "insert into xxx values (10,20)";

//		String file ="d:/tmp/sample-query2.out";
//		String sql=new String(FileUtil.readAll(new File(file)));

		String sql="select * from sss where is1='a' ";
		System.out.println(sql);
//		EscapeLiteralSQL esql =new EscapeLiteralSQL(sql);
//		esql.process();
//		System.out.println(esql.getParsedSql());
//		
		System.out.println(SqlTables.doAction(sql));
//		System.out.println(SqlTables.getInstance().doAction(sql2));
//		System.out.println(SqlTables.getInstance().doAction(sql3));
//		System.out.println(SqlTables.getInstance().doAction(sql4));
//		System.out.println(SqlTables.getInstance().doAction(sql5));
		}

}

