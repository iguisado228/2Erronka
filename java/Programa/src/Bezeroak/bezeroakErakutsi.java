package Bezeroak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Produktuak.produktua;
import erronka2.konexioa;


public class bezeroakErakutsi {
	
	
	public List<bezeroa> bezeroakErakuts() {
		List <bezeroa> bezeroak = new ArrayList<>();
		
		konexioa k = new konexioa();
		bezeroa bezeroa= null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		try {
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "select * from bezeroa";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				bezeroa be = new bezeroa (rs.getInt("idBezeroa"), rs.getString("nan"), 
						rs.getString("izena"), rs.getString("abizena"), rs.getString("telefonoa"),
						rs.getString("helbidea"), rs.getString("erabiltzaileIzena"), rs.getString("pasahitza"),
						rs.getString("helbideElektronikoa"));
				bezeroak.add(be);
			}
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Errore bat izan da select-a egiterakoan.");
		}
		return  bezeroak;
	}

}