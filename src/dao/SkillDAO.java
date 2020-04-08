package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
	public List<Skill> listAll_Skills () throws Exception {
		List<Skill> list=new ArrayList<Skill>();
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.getConnection();
		Skill skill=null;
		String sql="SELECT NAME FROM SKILLS";
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			skill=new Skill();
		    skill.setSkillName(rs.getString("name"));
			list.add(skill);
		}
		

		
		con.close();
		rs.close();
		stmt.close();
		return list;
	}
}
