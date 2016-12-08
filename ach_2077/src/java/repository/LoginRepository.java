/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;


import controller.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginRepository {

	public static Long validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("select id_usuario, email, senha from usuarios where email = ? and senha = ?");
			ps.setString(1, user);
			ps.setString(2, password);
                        
                        System.out.println(ps.toString());
                        
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
                                return rs.getLong("id_usuario");
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return -1L;
		} finally {
			DataConnect.close(con);
		}
		return -1L;
	}
}