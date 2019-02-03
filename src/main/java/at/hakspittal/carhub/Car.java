package at.hakspittal.carhub;

import java.sql.Date;

public class Car {

	private int id;
	private String category;
	private String marke;
	private String modell;
	private Date erstzulassung;
	private String kraftstoffart;
	private String km;
	private String desc;
	
	public Car(int id, String category, String marke, String modell, Date erstzulassung, String kraftstoffart,
			String km, String desc) {
		super();
		this.id = id;
		this.category = category;
		this.marke = marke;
		this.modell = modell;
		this.erstzulassung = erstzulassung;
		this.kraftstoffart = kraftstoffart;
		this.km = km;
		this.desc = desc;
	}
	
	public int getId() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	public String getMarke() {
		return marke;
	}
	public String getModell() {
		return modell;
	}
	public Date getErstzulassung() {
		return erstzulassung;
	}
	public String getKraftstoffart() {
		return kraftstoffart;
	}
	public String getKm() {
		return km;
	}
	public String getDesc() {
		return desc;
	}	
}
