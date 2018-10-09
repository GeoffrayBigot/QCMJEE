package bo;

import java.sql.Date;
import java.util.ArrayList;

public class Epreuve {

	private Date debutValidite;
	private Date finValidite;
	private int tempsEcoule;
	private int etatEpreuve;
	private int note;
	private String niveauAcquisition;
	private ArrayList<QuestionEpreuve> questions;

	public Epreuve(Date debutValidite, Date finValidite, int tempsEcoule, int etatEpreuve, int note,
			String niveauAcquisition) {
		super();
		this.debutValidite = debutValidite;
		this.finValidite = finValidite;
		this.tempsEcoule = tempsEcoule;
		this.etatEpreuve = etatEpreuve;
		this.note = note;
		this.niveauAcquisition = niveauAcquisition;
		this.questions = new ArrayList<>();
	}

	public Date getDebutValidite() {
		return debutValidite;
	}

	public void setDebutValidite(Date debutValidite) {
		this.debutValidite = debutValidite;
	}

	public Date getFinValidite() {
		return finValidite;
	}

	public void setFinValidite(Date finValidite) {
		this.finValidite = finValidite;
	}

	public int getTempsEcoule() {
		return tempsEcoule;
	}

	public void setTempsEcoule(int tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}

	public int getEtatEpreuve() {
		return etatEpreuve;
	}

	public void setEtatEpreuve(int etatEpreuve) {
		this.etatEpreuve = etatEpreuve;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getNiveauAcquisition() {
		return niveauAcquisition;
	}

	public void setNiveauAcquisition(String niveauAcquisition) {
		this.niveauAcquisition = niveauAcquisition;
	}

	public ArrayList<QuestionEpreuve> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<QuestionEpreuve> questions) {
		this.questions = questions;
	}
	
	public void ajouter(QuestionEpreuve question) {
		questions.add(question);
	}
	
	public QuestionEpreuve extraire(int index) {
		return questions.get(index);
	}

}
