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
public class ClassMe {
    public String Lecturers,ClassDescription,SchoolDay,ClassTime;
    public int IDClass;

    public ClassMe() {
    }
    

    

    public ClassMe(String Lecturers, String ClassDescription, String SchoolDay, String ClassTime, int IDClass) {
        this.Lecturers = Lecturers;
        this.ClassDescription = ClassDescription
                ;
        this.SchoolDay = SchoolDay;
        this.ClassTime = ClassTime;
        this.IDClass = IDClass;
    }

    public String getLecturers() {
        return Lecturers;
    }

    public void setLecturers(String Lecturers) {
        this.Lecturers = Lecturers;
    }

    public String getClassDescription() {
        return ClassDescription;
    }

    public void setClassDescription(String ClassDescription) {
        this.ClassDescription = ClassDescription;
    }

    public String getSchoolDay() {
        return SchoolDay;
    }

    public void setSchoolDay(String SchoolDay) {
        this.SchoolDay = SchoolDay;
    }

    public String getClassTime() {
        return ClassTime;
    }

    public void setClassTime(String ClassTime) {
        this.ClassTime = ClassTime;
    }

    public int getIDClass() {
        return IDClass;
    }

    public void setIDClass(int IDClass) {
        this.IDClass = IDClass;
    }
    
}
