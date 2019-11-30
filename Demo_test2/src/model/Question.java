package model;

public class Question {
	private Integer QID;
	private String questionSTR;
 
 
	Question(int ID, String STR) {
		this.QID = ID;
		this.questionSTR = STR ;
	}
 
	public String getQuestionSTR() {
		return questionSTR;
	}
	int getQuestionID () {
		return QID;
	}
}
