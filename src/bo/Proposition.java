package bo;

public class Proposition {
	
	private int idReponse;
	private String libelle;
	private boolean estCorrecte;
	
	public int getIdReponse() {
		return idReponse;
	}
	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public boolean isEstCorrecte() {
		return estCorrecte;
	}
	public void setEstCorrecte(boolean estCorrecte) {
		this.estCorrecte = estCorrecte;
	}
	
	public Proposition(int idReponse, String libelle, boolean estCorrecte) {
		super();
		this.idReponse = idReponse;
		this.libelle = libelle;
		this.estCorrecte = estCorrecte;
	}
	
	@Override
	public String toString() {
		return "Proposition [idReponse=" + idReponse + ", libelle=" + libelle + ", estCorrecte=" + estCorrecte + "]";
	}

}
