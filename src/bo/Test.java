package bo;

import java.util.ArrayList;

public class Test {

	private int idTest;
	private String nom;
	private String description;
	private int duree;
	private int seuilHaut;
	private int seuilBas;
	private ArrayList<Section> sections;
	private static int totalQuestionPosees;

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getSeuilHaut() {
		return seuilHaut;
	}

	public void setSeuilHaut(int seuilHaut) {
		this.seuilHaut = seuilHaut;
	}

	public int getSeuilBas() {
		return seuilBas;
	}

	public void setSeuilBas(int seuilBas) {
		this.seuilBas = seuilBas;
	}

	public ArrayList<Section> getSections() {
		return sections;
	}

	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}

	public static int getTotalQuestionPosees() {
		return totalQuestionPosees;
	}

	public static void setTotalQuestionPosees(ArrayList<Section> sections) {
		for (Section s : sections) {
			totalQuestionPosees += s.getNbQuestionsAttendues();
		}
	}

	public Test(int idTest, String nom, String description, int duree, int seuilHaut, int seuilBas) {
		super();
		this.idTest = idTest;
		this.nom = nom;
		this.description = description;
		this.duree = duree;
		this.seuilHaut = seuilHaut;
		this.seuilBas = seuilBas;
		this.sections = new ArrayList<>();
		setTotalQuestionPosees(sections);

	}

	public void ajouter(Theme theme, int nbQuestion) {
		sections.add(new Section(nbQuestion, theme));
	}

	public Section extraire(int index) {
		return sections.get(index);
	}

	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", nom=" + nom + ", description=" + description + ", duree=" + duree
				+ ", seuilHaut=" + seuilHaut + ", seuilBas=" + seuilBas + ", sections=" + sections + "]";
	}

}
