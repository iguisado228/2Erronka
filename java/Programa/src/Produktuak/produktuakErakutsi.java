package Produktuak;

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


public class produktuakErakutsi {
	
		
		
	public List<produktua> produktuakErakutsi () {
		List <produktua> produktuak = new ArrayList<>();
		
		konexioa k = new konexioa();
		produktua produktua = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		try {
			
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "select * from produktua";
			pst = conn.prepareStatement(sql);
			/*pst.setInt(1, pr.getIdProduktua());
			pst.setString(2, pr.getIzena());
			pst.setString(3, pr.getDeskribapena());*/
			rs = pst.executeQuery();
			
			
			while (rs.next()) {
				produktua pr = new produktua (rs.getInt("idProduktua"), rs.getString("izena"), rs.getInt("stock"), rs.getDouble("prezioa"), rs.getString("deskribapena"));
				produktuak.add(pr);
				
				/*int idProduktua = rs.getInt("idProduktua");
				String izena = rs.getString("izena");
				boolean stock = rs.getBoolean("stock");
				double prezioa = rs.getDouble("prezioa");
				String deskribapena = rs.getString("deskribapena");*/
			}
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Errore bat izan da select-a egiterakoan.");
		}
		return  produktuak;
	}
	
}
