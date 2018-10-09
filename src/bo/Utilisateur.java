package bo;

public class Utilisateur {

	private int idUser;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private Profil profil;
	private Promotion promotion;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public Utilisateur(int idUser, String nom, String prenom, String email, String password, Profil profil,
			Promotion promotion) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.profil = profil;
		this.promotion = promotion;
	}
	public Utilisateur(String nom, String prenom, String email, String password, Profil profil, Promotion promotion) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.profil = profil;
		this.promotion = promotion;
	}


	
	
}
