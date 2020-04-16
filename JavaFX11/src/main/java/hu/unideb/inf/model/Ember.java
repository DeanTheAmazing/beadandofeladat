package hu.unideb.inf.model;

import java.io.*;
import javax.persistence.*;

enum Gender
{
    MALE,
    FEMALE
}

@javax.persistence.Entity
@Table(name = "people")
public class Ember implements Serializable{
    
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    
    @Column(name = "Gender")
    private Gender gender;
    
    @Column (name = "Name")
    private String name;
    
    @Column(name = "Date_Of_Birth")
    private String dateOfBirth;
    
    @Column (name = "Place_Of_Birth")
    private String placeOfBirth;
    
    @Column(name = "TB_Number")
    private String tbNumber;
    
    @Column (name = "Home_Address")
    private Address homeAddress;
    
    @Column(name = "Phone_Number")
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender.toString();
    }

    public void setGender(String gender) {
        this.gender = Enum.valueOf(Gender.class, gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getTbNumber() {
        return tbNumber;
    }

    public void setTbNumber(String tbNumber) {
        this.tbNumber = tbNumber;
    }

    public String getHomeAddress() {
        return homeAddress.toString();
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress.setAddress(homeAddress); ;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
       
    public Ember(){
        
    }
    
    public Ember(String name, String placeOfBirth, String dateOfBirth, Gender gender, String tbNumber, String homeAddress, String phoneNumber) {
        this.gender = gender;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.tbNumber = tbNumber;
        this.homeAddress= new Address(homeAddress);
        this.phoneNumber = phoneNumber;
    }
    
    private void readObject(ObjectInputStream str) throws IOException, ClassNotFoundException{
        this.dateOfBirth = str.readUTF();
        this.placeOfBirth = str.readUTF();
        this.name  = str.readUTF();
        this.gender  = Enum.valueOf(Gender.class,str.readUTF());
        this.homeAddress.setAddress(str.readUTF());
        this.phoneNumber = str.readUTF();
        this.tbNumber = str.readUTF();
    }
    
    private void writeObject(ObjectOutputStream str) throws IOException{
        str.writeUTF(name);
        str.writeUTF(dateOfBirth);
        str.writeUTF(placeOfBirth);
        str.writeUTF(gender.toString());
        str.writeUTF(homeAddress.toString());
        str.writeUTF(phoneNumber);
        str.writeUTF(tbNumber);
    }
    
}
