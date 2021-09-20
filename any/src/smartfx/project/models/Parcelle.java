package smartfx.project.models;

public class Parcelle {
	private int id;
	private String nom;
	private String nom_culture;
	private double superficie;
	private Culture culture;
	public Parcelle(int id, String nom, String nom_culture, double superficie) {
		this.id = id;
		this.nom = nom;
		this.nom_culture = nom_culture;
		this.superficie = superficie;
	}
	public Parcelle(String nom, String nom_culture, double superficie) {
		this.nom = nom;
		this.nom_culture = nom_culture;
		this.superficie = superficie;
	}
	public Parcelle(int id, String nom, String nom_culture, double superficie, Culture culture) {
		this.id = id;
		this.nom = nom;
		this.nom_culture = nom_culture;
		this.superficie = superficie;
		this.culture = culture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom_culture() {
		return nom_culture;
	}
	public void setNom_culture(String nom_culture) {
		this.nom_culture = nom_culture;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public Culture getCulture() {
		return culture;
	}
	public void setCulture(Culture culture) {
		this.culture = culture;
	}

}
