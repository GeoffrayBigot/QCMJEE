package bo;

public class ReponseEpreuve extends Proposition {
	private int idEpreuve ; 
	public ReponseEpreuve(int idReponse, String libelle, boolean estCorrecte, int idEpreuve, int idQuestion) {
		super(idReponse, libelle, estCorrecte, idQuestion);
		this.idEpreuve = idEpreuve;
	}
	public int getIdEpreuve() {
		return idEpreuve;
	}


}
