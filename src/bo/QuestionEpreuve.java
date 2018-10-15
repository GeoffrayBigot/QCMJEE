package bo;



public class QuestionEpreuve extends Question {

	private boolean marquee;

	public QuestionEpreuve(Theme theme, int idQuestion, String enonce, byte[] image, int point) {
		super(theme, idQuestion, enonce, image, point);
		marquee = false;
	}
	
	public QuestionEpreuve(int idTheme, String enonce, byte[] image, int point) {
		super(idTheme,enonce,image,point);
		marquee = false;
	}

	public boolean isMarquee() {
		return marquee;
	}

	public void setMarquee(boolean marquee) {
		this.marquee = marquee;
	}

}
