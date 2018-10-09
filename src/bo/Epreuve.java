package bo;

import java.sql.Date;
import java.util.ArrayList;

public class Epreuve {

	private Date debutValidite;
	private Date finValidite;
	private int tempsEcoule;
	private EtatEpreuve etatEpreuve;
	private int note;
	private Utilisateur user;
	private Test test;
	private NiveauAquisition niveauAcquisition;
	private ArrayList<QuestionEpreuve> questions;

	public Epreuve(Date debutValidite, Date finValidite,Test test, Utilisateur user) {
		super();
		this.debutValidite = debutValidite;
		this.finValidite = finValidite;
		this.user = user;
		this.test = test;
		this.etatEpreuve = EtatEpreuve.ENATTENTE;
		this.niveauAcquisition= NiveauAquisition.NONAQUIS;
		
		
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

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public ArrayList<QuestionEpreuve> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<QuestionEpreuve> questions) {
		this.questions = questions;
	}
	
	public EtatEpreuve getEtatEpreuve() {
		return etatEpreuve;
	}

	public void setEtatEpreuve(EtatEpreuve etatEpreuve) {
		this.etatEpreuve = etatEpreuve;
	}

	public NiveauAquisition getNiveauAcquisition() {
		return niveauAcquisition;
	}

	public void setNiveauAcquisition(NiveauAquisition niveauAcquisition) {
		this.niveauAcquisition = niveauAcquisition;
	}

	public Utilisateur getUser() {
		return user;
	}

	public Test getTest() {
		return test;
	}

	public void ajouter(QuestionEpreuve question) {
		questions.add(question);
	}
	
	public QuestionEpreuve extraire(int index) {
		return questions.get(index);
	}

}
