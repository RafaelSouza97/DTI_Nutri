package DTINutri.Repository;

import DTINutri.Domain.Client;
import org.yaml.snakeyaml.comments.CommentLine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Client_Repository {
    private List<Client> cad_clients;

    public Client_Repository() {
        this.cad_clients = new ArrayList<Client>();
    }

    public List<Client> get_all_clients() {
        return cad_clients;
    }

    public void insert_client(Client client) {
        this.cad_clients.add(client);
    }

    public Client search_client(int id_search){
        Client client;

        Collection<Client> collection = this.cad_clients;
        Stream<Client> result = collection.stream().filter(c -> c.getId_client() == id_search);

        try {
            client = result.findFirst().get();
        }catch (Exception e){
            client = null;
        }

        return client;
    }
}
