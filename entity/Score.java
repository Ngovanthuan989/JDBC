/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ngova
 */
public class Score {
    public int id,studentID,ExamScore;
    public String ExamSubject;

    public Score() {
    }

    public Score(int id, int studentID, int ExamScore, String ExamSubject) {
        this.id = id;
        this.studentID = studentID;
        this.ExamScore = ExamScore;
        this.ExamSubject = ExamSubject;
    }

    public Score(int a, String b, String c, int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public float getExamScore() {
        return ExamScore;
    }

    public void setExamScore(int ExamScore) {
        this.ExamScore = ExamScore;
    }

    public String getExamSubject() {
        return ExamSubject;
    }

    public void setExamSubject(String ExamSubject) {
        this.ExamSubject = ExamSubject;
    }

    @Override
    public String toString() {
        return "Score{" + "id=" + id + ", studentID=" + studentID + ", ExamScore=" + ExamScore + ", ExamSubject=" + ExamSubject + '}';
    }
    
    
}
