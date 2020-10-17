package com.example.demo.controller;

import com.example.demo.config.State;
import com.example.demo.model.Client;
import com.example.demo.model.Movie;
import com.example.demo.model.MovieDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class ClientHelper {
    public ClientHelper(State state) {
        this.state = state;
    }

    State state;

    public String getList() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse res = null;
        HttpGet get = new HttpGet("https://api.themoviedb.org/3/list/4?api_key=5c8444934ca3bab35b79a7502e03285a&language=en-US");
        try {
            res = httpClient.execute(get);
            JSONArray str = new JSONObject(EntityUtils.toString(res.getEntity())).getJSONArray("items");
//            System.out.println(str.toString());
            return str.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "[{error}]";
        }
    }

    public Movie returnDetails(String title) {
//        System.out.println("helper method: ");
        Movie movie = state.getMovieMap().get(title);
//        System.out.println("movie helper: " + movie.getId() + " " + movie.getTitle());
//        System.out.println("Info: " + movie.getTitle() + " " + movie.getPopularity());
        return movie;
    }

    public Movie reserve(String title) {
        if (state.getUser() != null) {
            Movie movie = state.getMovieMap().get(title);
            movie.setAvailable(movie.getAvailable() - 1);
            Client current = state.getClientMap().get(state.getUser());
            current.getMoviesRented().add(movie.getTitle());
            return movie;
        } else return state.getMovieMap().get(title);
    }

    public Movie returnMovie(String title) {
        if (state.getUser() != null) {
            Movie movie = state.getMovieMap().get(title);
            movie.setAvailable(movie.getAvailable() + 1);
            Client current = state.getClientMap().get(state.getUser());
            List<String> list = current.getMoviesRented();
            list.removeIf(s -> s.equals(title));
            return movie;
        } else return state.getMovieMap().get(title);
    }

    public List<MovieDto> returnMovieDetails() {
        System.out.println("returnMovieDetails");
        List<MovieDto> returnJson = new ArrayList<>();
        for (Map.Entry<String, Movie> entry : state.getMovieMap().entrySet()) {
            MovieDto temp = new MovieDto();
            temp.setName(entry.getKey());
            temp.setPopularity(String.valueOf(entry.getValue().getPopularity()));
            temp.setAvailable(String.valueOf(entry.getValue().getAvailable()));
            temp.setPrice(String.valueOf(entry.getValue().getAvailable()));
            System.out.println("Adding in foreacH: " + temp.getName());
            returnJson.add(temp);
        }
        System.out.println("Return json: " + returnJson.toString());
        return returnJson;
    }

    public void login(String user) {
        state.setUser(user);
    }
}

