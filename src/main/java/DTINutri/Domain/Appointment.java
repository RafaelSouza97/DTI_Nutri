package DTINutri.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appointment {
    private int id_appointment;
    private Client client;
    private Date daytime;

    private Double weight;
    private Double bodyfat;
    private String phsical_description;
    private List<Restriction> restrictions;
    private double calories_goal;

    public Appointment(int id_appointment, Client client, String daytime) throws ParseException {
        this.id_appointment = id_appointment;
        this.client = client;
        Date data = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(daytime);
        this.daytime = data;
        this.restrictions = new ArrayList<Restriction>();
    }

    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDaytime() {
        String daytime_s = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(daytime);
        return daytime_s;
    }

    public void setDaytime(String daytime) throws ParseException {
        Date data = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(daytime);
        this.daytime = data;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBodyfat() {
        return bodyfat;
    }

    public void setBodyfat(Double bodyfat) {
        this.bodyfat = bodyfat;
    }

    public String getPhsical_description() {
        return phsical_description;
    }

    public void setPhsical_description(String phsical_description) {
        this.phsical_description = phsical_description;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restriction restriction) {
        this.restrictions.add(restriction);
    }

    public double getCalories_goal() {
        return calories_goal;
    }

    public void setCalories_goal(double calories_goal) {
        this.calories_goal = calories_goal;
    }

}