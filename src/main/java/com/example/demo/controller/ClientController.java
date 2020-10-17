package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@RequestMapping("/rent")
public class ClientController {
    public ClientController(ClientHelper clientHelper) {
        this.clientHelper = clientHelper;
    }

    ClientHelper clientHelper;

    @GetMapping("/movielist")
    @ResponseBody
    public String movieList() {
        return clientHelper.getList();
    }

    @GetMapping("/getinfo/{x}")
    @ResponseBody
    public Movie movieDetails(@PathVariable("x") String title) {
        System.out.println("Controller with pv: " + title);
        return clientHelper.returnDetails(title.toLowerCase());
    }

    @GetMapping("/reserve/{x}")
    @ResponseBody
    public Movie reserve(@PathVariable("x") String title) {
        System.out.println("RESERVE title: " + title);
        if (title == null || title == "") {
            title = "blackswan";
        }
        return clientHelper.reserve(title);
    }

    @GetMapping("/return/{x}")
    @ResponseBody
    public Movie returnMovie(@PathVariable("x") String title) {
        System.out.println("RESERVE title: " + title);
        return clientHelper.returnMovie(title);
    }

    @GetMapping("/moviedetails")
    @ResponseBody
    public List<MovieDto> movieDetails() {
        System.out.println("Controller: " + clientHelper.returnMovieDetails());
        return clientHelper.returnMovieDetails();
    }

    @GetMapping("/login/{x}")
    @ResponseBody
    public String login(@PathVariable("x") String user) {
        clientHelper.login(user);
        return "ok";
    }
}
