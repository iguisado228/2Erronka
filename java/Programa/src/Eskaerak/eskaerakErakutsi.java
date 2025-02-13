package Eskaerak;


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


public class eskaerakErakutsi {
	
	public List<eskaera> eskaerakErakutsi() {
		List <eskaera> eskaerak = new ArrayList<>();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		

		try {
			
			konexioa k = new konexioa();
			conn = k.getConnection_();
			
			String sql = "select * from eskaera";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				eskaera es = new eskaera (rs.getInt("idEskaeraTaula"), rs.getInt("idEskaera"), 
						rs.getInt("bezeroa_idBezeroa"), rs.getInt("produktua_idProduktua"), 
						rs.getDate("eskaeraData"), rs.getString("helbidea"), rs.getString("egoera"));
				
				eskaerak.add(es);
			}
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Errore bat izan da select-a egiterakoan.");
		}
		return  eskaerak;
	}
	
}

