package Produktuak;

public class produktua {
	
	private int idProduktua;
	private String izena, deskribapena;
	private double prezioa;
	private int stock;
	
	
	public produktua(int idProduktua, String izena, int stock, double prezioa, String deskribapena) {
		this.idProduktua = idProduktua;
		this.izena = izena;
		this.stock = stock;
		this.prezioa = prezioa;
		this.deskribapena = deskribapena;
	}
	
	public produktua() {}

	/**
	 * @return the idProduktua
	 */
	public int getIdProduktua() {
		return idProduktua;
	}


	/**
	 * @param idProduktua the idProduktua to set
	 */
	public void setIdProduktua(int idProduktua) {
		this.idProduktua = idProduktua;
	}


	/**
	 * @return the izena
	 */
	public String getIzena() {
		return izena;
	}


	/**
	 * @param izena the izena to set
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}


	/**
	 * @return the deskribapena
	 */
	public String getDeskribapena() {
		return deskribapena;
	}


	/**
	 * @param deskribapena the deskribapena to set
	 */
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}


	/**
	 * @return the prezioa
	 */
	public double getPrezioa() {
		return prezioa;
	}


	/**
	 * @param prezioa the prezioa to set
	 */
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}


	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}


	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
