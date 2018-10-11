package bo;

public class Profil {

	private int codeProfil;
	private String libelle;
	
	public Profil(int codeProfil, String libelle) {
		super();
		this.codeProfil = codeProfil;
		this.libelle = libelle;
	}
	
	public Profil() {
		this.codeProfil = 0;
		this.libelle = "";
	}
	
	public int getCodeProfil() {
		return codeProfil;
	}
	public void setCodeProfil(int codeProfil) {
		this.codeProfil = codeProfil;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
