package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.dao.DBConnection;
import cn.entity.Limit;
import cn.entity.User;

public class RoleImpl implements RoleDao {
	
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	
	@Override
	public Limit SearchRoleById(int id) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select Limitt.* from User,Role,User_Role,Limitt,Role_Limit ");
		sb.append(" where User.id=User_Role.userid AND Role.id=User_Role.roleid "
				+ "AND Role.id=Role_Limit.roleid AND Limitt.id=Role_Limit.limitid AND User.id=?");
		Limit u = null;
		try {
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setInt(1, id);
			
			System.out.println(sb.toString());
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				System.out.println("根据username找user");
				u = new Limit();
				u.setAction(rs.getInt("action"));
				//u.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return u;
	}

}
