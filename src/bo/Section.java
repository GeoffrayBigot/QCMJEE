package bo;

public class Section {

	private int idSection;
	private int nbQuestionsAttendues;
	private Theme theme;
	
	public int getIdSection() {
		return idSection;
	}
	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}
	public int getNbQuestionsAttendues() {
		return nbQuestionsAttendues;
	}
	public void setNbQuestionsAttendues(int nbQuestionsAttendues) {
		this.nbQuestionsAttendues = nbQuestionsAttendues;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Section( int nbQuestionsAttendues, Theme theme) {
		super();
		this.nbQuestionsAttendues = nbQuestionsAttendues;
		this.theme = theme;
	}
	public Section(int idSection, int nbQuestionsAttendues, Theme theme) {
		super();
		this.idSection = idSection;
		this.nbQuestionsAttendues = nbQuestionsAttendues;
		this.theme = theme;
	}

	
}
