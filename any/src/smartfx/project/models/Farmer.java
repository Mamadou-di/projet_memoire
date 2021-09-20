package smartfx.project.models;

public class Farmer extends User {
	private String nom;
	private int telephone;
	private String prenom;
	private int id;
	private String adresse;

	public Farmer(int id,String nom, String prenom,String login,String password, int telephone,  String adresse) {
		super(login,password);
		this.nom = nom;
		this.telephone = telephone;
		this.prenom = prenom;
		this.id = id;
		this.adresse = adresse;
	}
	public Farmer(String nom, String prenom,String login,String password, int telephone,  String adresse) {
		super(login,password);
		this.nom = nom;
		this.telephone = telephone;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getPrenom() {
		return prenom;
		
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



}
