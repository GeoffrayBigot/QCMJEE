package bo;

import java.awt.Image;

public class QuestionEpreuve extends Question {

	private boolean marquee;

	public QuestionEpreuve(Theme theme, int idQuestion, String enonce, byte[] image, int point) {
		super(theme, idQuestion, enonce, image, point);
		marquee = false;
	}

	public boolean isMarquee() {
		return marquee;
	}

	public void setMarquee(boolean marquee) {
		this.marquee = marquee;
	}

}
