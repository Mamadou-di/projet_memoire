package smartfx.project.models;

public class Facture {
	private int id;
	private String libelle;
	private String nom;
	private String prenom;
	private double quantite;
	private int prix_unitaire;
	private int total;
	private String date;
	public Facture(int id, String libelle, String nom, String prenom, double quantite, int prix_unitaire, int total,
			String date) {
		
		this.id = id;
		this.libelle = libelle;
		this.nom = nom;
		this.prenom = prenom;
		this.quantite = quantite;
		this.prix_unitaire = prix_unitaire;
		this.total = total;
		this.date = date;
	}
	public Facture(String libelle, String nom, String prenom, double quantite, int prix_unitaire, int total,
			String date) {
		
		
		this.libelle = libelle;
		this.nom = nom;
		this.prenom = prenom;
		this.quantite = quantite;
		this.prix_unitaire = prix_unitaire;
		this.total = total;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(int prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
