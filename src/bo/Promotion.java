package bo;

public class Promotion {
	private String codePromotion;
	private String libelle;

	public Promotion(String codePromotion, String libelle) {
		super();
		this.codePromotion = codePromotion;
		this.libelle = libelle;
	}
	
	public Promotion() {
		this.codePromotion = "";
		this.libelle = "";
	}

	public String getCodePromotion() {
		return codePromotion;
	}
	public void setCodePromotion(String codePromotion) {
		this.codePromotion = codePromotion;
	}
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Promotion [codePromotion=" + codePromotion + ", libelle=" + libelle + "]";
	}

	
}
