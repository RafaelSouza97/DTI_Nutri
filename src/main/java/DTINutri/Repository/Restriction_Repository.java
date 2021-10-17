package DTINutri.Repository;

import DTINutri.Domain.Restriction;

import java.util.ArrayList;
import java.util.List;

public class Restriction_Repository {
    private List<Restriction> cad_restrictions;

    public Restriction_Repository() {
        this.cad_restrictions = new ArrayList<Restriction>();
    }

    public List<Restriction> get_all_restrictions() {
        return cad_restrictions;
    }

    public void insert_restrictions(Restriction restriction) {
        this.cad_restrictions.add(restriction);
    }
}
