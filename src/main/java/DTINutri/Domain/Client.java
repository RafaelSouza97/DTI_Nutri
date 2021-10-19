package DTINutri.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private int id_client;
    private String name;
    private Date birthdate;
    private String address;
    private String mail;
    private String phone_number;
    private String landline;

    public Client(int id_client, String name, String birthdate, String address, String mail, String phone_number, String landline) throws ParseException {
        this.id_client = id_client;
        this.name = name;
        this.birthdate = new SimpleDateFormat("dd-MM-yyyy").parse(birthdate);
        this.address = address;
        this.mail = mail;
        this.phone_number = phone_number;
        this.landline = landline;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return new SimpleDateFormat("dd-MM-yyyy").format(birthdate);
    }

    public void setBirthdate(String birthdate) throws ParseException {
        this.birthdate = new SimpleDateFormat("dd-MM-yyyy").parse(birthdate);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }
}
