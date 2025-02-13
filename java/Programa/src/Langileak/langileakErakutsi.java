package Langileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import erronka2.konexioa;

public class langileakErakutsi {
	
	
	public List<langilea> langileakErakutsi() {
		
		List <langilea> langileak = new ArrayList<>();
		
		konexioa k = new konexioa();
		langilea langilea = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		try {
			
			Connection connection_ = k.getConnection_();
			conn = konexioa.getConnection_();
			String sql = "select * from langilea";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				langilea la = new langilea (rs.getInt("idLangilea"), rs.getString("nan"), rs.getString("izena"), 
						rs.getString("abizena"), rs.getString("lanPostua"), rs.getString("telefonoa"), 
						rs.getString("helbidea"), rs.getString("postaKodea"), 
						rs.getString("erabiltzaileIzena"), rs.getString("pasahitza"));
				langileak.add(la);
				
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Errore bat izan da select-a egiterakoan.");
		}
		return  langileak;
	}

}
