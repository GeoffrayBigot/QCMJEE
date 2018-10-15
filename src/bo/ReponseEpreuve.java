package bo;

public class ReponseEpreuve extends Proposition {
	private int idEpreuve ; 
	public ReponseEpreuve(int idReponse, String libelle, boolean estCorrecte, int idEpreuve) {
		super(idReponse, libelle, estCorrecte);
		this.idEpreuve = idEpreuve;
	}
	public int getIdEpreuve() {
		return idEpreuve;
	}


}
