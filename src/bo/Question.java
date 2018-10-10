package bo;

import java.util.ArrayList;

public class Question {
	
	private Theme theme;
	private int idQuestion;;
	private String enonce;
	private String image;
	private int point;

	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Question(Theme theme, int idQuestion, String enonce, String image, int point) {
		super();
		this.theme = theme;
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.image = image;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", enonce=" + enonce + ", image=" + image
				+ ", point=" + point +" ,theme=" + theme+"]";
	}
	
}
