package bo;

public class Theme {

	private int idTheme;
	private String libelle;
	
	public int getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Theme(int idTheme, String libelle) {
		super();
		this.idTheme = idTheme;
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "Theme [idTheme=" + idTheme + ", libelle=" + libelle + "]";
	}

	
}
