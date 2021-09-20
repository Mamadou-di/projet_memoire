package smartfx.project.models;

public class Culture {

	private String nom;
	private int quantite;
	private String type;
	private double rendement;
	public Culture(String nom, int quantite, String type, double rendement) {

		this.nom = nom;
		this.quantite = quantite;
		this.type = type;
		this.rendement = rendement;
	}
	public Culture(String nom, int quantite, String type) {

		this.nom = nom;
		this.quantite = quantite;
		this.type = type;

	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getRendement() {
		return rendement;
	}
	public void setRendement(double rendement) {
		this.rendement = rendement;
	}

}
