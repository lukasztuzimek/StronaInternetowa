package com.example.demo.config;


import com.example.demo.model.Address;
import com.example.demo.model.Client;
import com.example.demo.model.Employee;
import com.example.demo.model.Movie;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class State {
    private Map<String, Employee> employeeMap = new HashMap<String, Employee>();
    private Map<String, Address> addressMap = new HashMap<String, Address>();
    private Map<String, Client> clientMap = new HashMap<String, Client>();
    private Map<String, Movie> movieMap = new HashMap<String, Movie>();
    private Client client = new Client();
    private String user;



    @PostConstruct
    private void init(){
        movieMap.put("blackswan", new Movie(1, "Black Swan", 21.067, 20));
        movieMap.put("thefighter", new Movie(1, "The Fighter", 12.968, 20));
        movieMap.put("Thekidsareallright", new Movie(1, "The Kids Are All Right", 63.646, 20));
        movieMap.put("theking'sspeech", new Movie(1, "The King's Speech", 20.165, 20));
        movieMap.put("127hours", new Movie(1, "127 Hours", 13.346, 20));
        movieMap.put("thesocialnetwork", new Movie(1, "The Social Network", 24.832, 20));
        movieMap.put("toystory3", new Movie(1, "Toy Story 3", 28.309, 20));
        movieMap.put("truegrit", new Movie(1, "True Grit", 16.634, 20));
        movieMap.put("winter'sbone", new Movie(1, "Winter's Bone", 10.189, 20));

        addressMap.put("ad1", new Address("ul. klienta", "1", "2", "00-000", "Miejscowosc"));
        addressMap.put("ad2", new Address("ul. pracownika", "3", "4b", "11-111", "Miejscowosc Wielka"));
        clientMap.put("login1", new Client(1, "Name", "Nazwisko", addressMap.get("ad1"), new ArrayList<String>(),"haslo"));
        employeeMap.put("emp1", new Employee("Pracownik", "Dobry", 2400, addressMap.get("ad2")));

        // System.out.println(employeeMap.size());
        // System.out.println(addressMap.size());
        // System.out.println(clientMap.size());
        // System.out.println(movieMap.size());
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public Map<String, Address> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<String, Address> addressMap) {
        this.addressMap = addressMap;
    }

    public Map<String, Client> getClientMap() {
        return clientMap;
    }

    public void setClientMap(Map<String, Client> clientMap) {
        this.clientMap = clientMap;
    }

    public Map<String, Movie> getMovieMap() {
        return movieMap;
    }

    public void setMovieMap(Map<String, Movie> movieMap) {
        this.movieMap = movieMap;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
