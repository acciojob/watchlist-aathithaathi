package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("movie was added", HttpStatus.CREATED);
    }

    @PostMapping("add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("director was added ", HttpStatus.CREATED);
    }

    @PostMapping("add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("movie director waw mapped", HttpStatus.CREATED);
    }

    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movie = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movielist = movieService.findAllMovies();
        return new ResponseEntity<>(movielist, HttpStatus.CREATED);
    }

    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String dirname){
        movieService.deleteDirectorByName(dirname);
        return new ResponseEntity<>("director name was delete", HttpStatus.CREATED);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("all director name was deleted", HttpStatus.CREATED);
    }

}
