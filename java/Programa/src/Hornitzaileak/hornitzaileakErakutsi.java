package Hornitzaileak;
 
 
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
 
	import erronka2.konexioa;
 
 
	public class hornitzaileakErakutsi {
		
			
			
		public List<hornitzailea> hornitzaileakErakutsi () {
			List <hornitzailea> hornitzaileak = new ArrayList<>();
			
			konexioa k = new konexioa();
			hornitzailea hornitzailea = null;
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pst = null;
			
			try {
				
				Connection connection_ = k.getConnection_();
				conn = konexioa.getConnection_();
				String sql = "select * from hornitzailea";
				pst = conn.prepareStatement(sql);
 
				rs = pst.executeQuery();
				
				
				while (rs.next()) {
					hornitzailea h = new hornitzailea (rs.getInt("idHornitzailea"), rs.getString("NAN"), rs.getString("izena"), rs.getString("abizena"), rs.getString("telefonoa"), rs.getString("helbidea"), rs.getString("erabiltzaileIzena"), rs.getString("pasahitza"));
					hornitzaileak.add(h);
 
				}
			} catch (Exception e){
				e.printStackTrace();
				System.out.println("Errore bat izan da select-a egiterakoan.");
			}
			return  hornitzaileak;
		}
	}

