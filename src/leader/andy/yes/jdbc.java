package leader.andy.yes;

import java.sql.*;
public class jdbc 
{
	Connection conn=null;
	Statement s=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public jdbc()
	{
		//����JDBC��������
		//String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//����JDBC��url����
		String conURL="jdbc:sqlserver://localhost:1433;databaseName=andydata;user=sa;password=123456";
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		}
		catch(Exception e)
		{
			System.out.println("�޷�����JDBC��������"+e.getMessage());
		}
		
		try
		{
			//�������ݿ�URL
			conn=DriverManager.getConnection(conURL);
			s=conn.createStatement();
			//��ѯ
			String sql=new String("select * from medicine");
			rs=s.executeQuery(sql);
			while(rs.next())
			{
				
			}
			//System.out.println("���ݿ�����ɹ�!!!");
		}
		catch(SQLException e)
		{
			System.out.println("SQLException:"+e.getMessage());
		}
		finally
		{
			try
			{
				if(ps!=null)
				{
					ps.close();
					ps=null;
				}
				if(conn!=null)
				{
					conn.close();
					conn=null;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
