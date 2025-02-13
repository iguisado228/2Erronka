package Eskaerak;

import java.sql.Date;

public class eskaera {
	
	public int idEskaeraTaula;
	public int idEskaera;
	public int bezeroa_idBezeroa;
	public int produktua_idProduktua;
	public String helbidea, egoera;
	public Date eskaeraData;
	
	public eskaera(int idEskaeraTaula, int idEskaera, int bezeroa_idBezeroa, int produktua_idProduktua, Date eskaeraData,
			String helbidea, String egoera) {
		this.idEskaeraTaula = idEskaeraTaula;
		this.idEskaera = idEskaera;
		this.bezeroa_idBezeroa = bezeroa_idBezeroa;
		this.produktua_idProduktua = produktua_idProduktua;
		this.eskaeraData = eskaeraData;
		this.helbidea = helbidea;
		this.egoera = egoera;
	}

	/**
	 * @return the idEskaeraTaula
	 */
	public int getIdEskaeraTaula() {
		return idEskaeraTaula;
	}

	/**
	 * @param idEskaeraTaula the idEskaeraTaula to set
	 */
	public void setIdEskaeraTaula(int idEskaeraTaula) {
		this.idEskaeraTaula = idEskaeraTaula;
	}

	/**
	 * @return the idEskaera
	 */
	public int getIdEskaera() {
		return idEskaera;
	}

	/**
	 * @param idEskaera the idEskaera to set
	 */
	public void setIdEskaera(int idEskaera) {
		this.idEskaera = idEskaera;
	}

	/**
	 * @return the bezeroa_idBezeroa
	 */
	public int getBezeroa_idBezeroa() {
		return bezeroa_idBezeroa;
	}

	/**
	 * @param bezeroa_idBezeroa the bezeroa_idBezeroa to set
	 */
	public void setBezeroa_idBezeroa(int bezeroa_idBezeroa) {
		this.bezeroa_idBezeroa = bezeroa_idBezeroa;
	}

	/**
	 * @return the produktua_idProduktua
	 */
	public int getProduktua_idProduktua() {
		return produktua_idProduktua;
	}

	/**
	 * @param produktua_idProduktua the produktua_idProduktua to set
	 */
	public void setProduktua_idProduktua(int produktua_idProduktua) {
		this.produktua_idProduktua = produktua_idProduktua;
	}
	/**
	 * @return the helbidea
	 */
	public String getHelbidea() {
		return helbidea;
	}

	/**
	 * @param helbidea the helbidea to set
	 */
	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	/**
	 * @return the egoera
	 */
	public String getEgoera() {
		return egoera;
	}

	/**
	 * @param egoera the egoera to set
	 */
	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}

	/**
	 * @return the eskaeraData
	 */
	public Date getEskaeraData() {
		return eskaeraData;
	}

	/**
	 * @param eskaeraData the eskaeraData to set
	 */
	public void setEskaeraData(Date eskaeraData) {
		this.eskaeraData = eskaeraData;
	}
	
	
	
	
}