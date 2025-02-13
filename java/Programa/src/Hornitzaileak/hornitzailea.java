package Hornitzaileak;
 
public class hornitzailea {
 
	private int idHornitzailea;
	private String NAN, izena, abizena, telefonoa, helbidea, erabiltzaileIzena, pasahitza;
	
	
	public hornitzailea (int idHornitzailea, String NAN, String izena, String abizena, String telefonoa, String helbidea, String erabiltzaileIzena, String pasahitza) {
		
		this.idHornitzailea=idHornitzailea;
		this.NAN=NAN;
		this.izena=izena;
		this.abizena=abizena;
		this.telefonoa=telefonoa;
		this.helbidea=helbidea;
		this.erabiltzaileIzena=erabiltzaileIzena;
		this.pasahitza=pasahitza;
		
	}
	
	public hornitzailea() {}
	
	
	public int getIdHornitzailea() {
		return idHornitzailea;
		
	}
	
	public void setIdHornitzailea(int idHornitzailea) {
		this.idHornitzailea=idHornitzailea;
	}
	
	public String getNAN() {
		return NAN;
		
	}
	
	public void setNAN(String NAN) {
		this.NAN=NAN;
	}
	
	public String getIzena() {
		return izena;
		
	}
	
	public void setIzena (String izena) {
		this.izena=izena;
	}
	
	public String getAbizena() {
		return abizena;
		
	}
	
	public void setAbizena(String abizena) {
		this.abizena=abizena;
	}
	
	public String getTelefonoa() {
		return telefonoa;
		
	}
	
	public void setTelefonoa(String telefonoa) {
		this.telefonoa=telefonoa;
	}
	
	public String getHelbidea() {
		return helbidea;
		
	}
	
	public void setHelbidea(String helbidea) {
		this.helbidea=helbidea;
	}
	
	public String getErabiltzaileIzena() {
		return erabiltzaileIzena;
		
	}
	
	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.erabiltzaileIzena=erabiltzaileIzena;
	}
	
	public String getPasahitza() {
		return pasahitza;
		
	}
	
	public void setPasahitza(String pasahitza) {
		this.pasahitza=pasahitza;
	}
	
 
	
}