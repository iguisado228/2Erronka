package LoginaEgiteko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import erronka2.konexioa;


public class ErabiltzaileKudeaketa {
	
	public erabiltzailea erabiltzaileaLortu(erabiltzailea era) {
		
		konexioa k = new konexioa();
		
		erabiltzailea erabiltzailea = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection conn = k.getConnection_();
		
		try {
			String sql = "select * from langilea where erabiltzaileIzena = ? and pasahitza = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, era.getErabiltzaileIzena());
			pst.setString(2, era.getPasahitza());
			
			rs = pst.executeQuery();
			
			
			while (rs.next()) {
				System.out.println("Admin "+rs.getBoolean(6));
				erabiltzailea = new erabiltzailea (rs.getString(1), rs.getString(2),rs.getBoolean(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore bat izan da select-a egiterakoan.");
		}
		
		return erabiltzailea;
	}

}
