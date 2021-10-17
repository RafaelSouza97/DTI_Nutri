package DTINutri.Repository;

import DTINutri.Domain.Appointment;
import DTINutri.Domain.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Appointment_Repository {
    private List<Appointment> cad_appointment;

    public Appointment_Repository() {
        this.cad_appointment = new ArrayList<Appointment>();
    }

    public List<Appointment> get_all_appointment() {
        return cad_appointment;
    }

    public void insert_appointment(Appointment appointment) {
        this.cad_appointment.add(appointment);
    }

    public Appointment search_appointment(int id_search){
        Appointment appointment;

        Collection<Appointment> collection = this.cad_appointment;
        Stream<Appointment> result = collection.stream().filter(c -> c.getId_appointment() == id_search);

        try {
            appointment = result.findFirst().get();
        }catch (Exception e){
            appointment = null;
        }

        return appointment;
    }

    public List<Appointment> search_client_appointments(int id_client){

        Collection<Appointment> collection = this.cad_appointment;
        Stream<Appointment> results = collection.stream().filter(c -> c.getClient().getId_client() == id_client);
        List<Appointment> list_results;

        try {
            list_results = results.collect(Collectors.toList());
        }catch (Exception e){
            list_results = null;
        }

        return list_results;
    }
}
