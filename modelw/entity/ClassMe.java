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
    
    //dau cai gi
//    mo hinh 3 lop anh de mo cho e dễ hiểu
    // lên mạng có hết mà 
    //có cả demo
    //a cứ làm cho m ko đc
    //mang yeu qua thi rut ra doi 30s cam lai xem xem có nhanh hơn ko
    // em căm mấy lần r:))
    // anh kiểm tra kết nối máy em xem tn
    
    
    //mang này là ngon r
    //chắc đg truyền kém ở đâu cx vây mà
    
    // anh xem cho em cái jdbc em làm v có đc k
    // xem có hợp lí không anh
    

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
