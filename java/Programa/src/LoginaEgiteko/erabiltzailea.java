package LoginaEgiteko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import erronka2.konexioa;

public class erabiltzailea {

	private static String erabiltzaileIzena;
	private String pasahitza;
	private boolean admin;

	public erabiltzailea(String erabiltzaileIzena, String pasahitza,boolean admin) {
		this.erabiltzaileIzena = erabiltzaileIzena;
		this.pasahitza = pasahitza;
		this.admin = admin;
	}

	/**
	 * @return the erabiltzaileIzena
	 */
	public String getErabiltzaileIzena() {
		return erabiltzaileIzena;
	}

	/**
	 * @param erabiltzaileIzena the erabiltzaileIzena to set
	 */
	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.erabiltzaileIzena = erabiltzaileIzena;
	}

	/**
	 * @return the pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}

	/**
	 * @param pasahitza the pasahitza to set
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	

	/*public static boolean isAdmin() {
		boolean admin = false;
		konexioa k = new konexioa();
		Connection connection_ = k.getConnection_();
		
		erabiltzailea erabiltzailea = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		try {
			conn = konexioa.getConnection_();
			String sql = "select admin from langilea where erabiltzaileIzena = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, erabiltzaileIzena);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				admin = rs.getBoolean("admin");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore bat izan da select-a egiterakoan.");
		}
		return admin;
	}*/
	

	
}
