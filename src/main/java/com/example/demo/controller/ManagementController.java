package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Genero;
import com.example.demo.model.Movie;
import com.example.demo.service.GeneroService;
import com.example.demo.service.MovieService;

@Controller
@RequestMapping("/management")
public class ManagementController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping("/movies")
	public String getAllPeliculas(Model model) {
		List<Movie> listMovies = movieService.getAllMovies();
		model.addAttribute("movies", listMovies);
        return "movies";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("generos", generoService.getAllGenero());
		return "movieRegister";
	}
	
	@PostMapping("/register")
	public String createProduct(@RequestParam("nombre") String name, 
			@RequestParam("director") String director,
			@RequestParam("fechaEstreno") Date fechaEstreno,
			@RequestParam("id") Long id, Model model) {
		
		Movie movie = new Movie();
		movie.nombre = name;
		movie.director = director;
		movie.fechaEstreno = fechaEstreno;
		
		Genero genero = generoService.getGeneroByID(id);

		movie.genero = genero;
		
		movieService.createMovie(movie);
		
		model.addAttribute("movies", movieService.getAllMovies());
		model.addAttribute("generos", generoService.getAllGenero());
		
		return "movies";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		
		Movie movie = movieService.getMovieByID(id);
		
		model.addAttribute("movie", movie);
		model.addAttribute("generos", generoService.getAllGenero());
		
		return "movieEdit";
	}
	
	
	@PostMapping("/edit")
	public String createProduct(@RequestParam("id") Long id, @RequestParam("nombre") String name, 
			@RequestParam("director") String director,
			@RequestParam("fechaEstreno") Date fechaEstreno,
			@RequestParam("idGenero") Long idGenero, Model model) {
		
		Movie movie = movieService.getMovieByID(id);
		movie.nombre = name;
		movie.director = director;
		movie.fechaEstreno = fechaEstreno;
		
		Genero genero = generoService.getGeneroByID(idGenero);

		movie.genero = genero;
		
		movieService.createMovie(movie);
		
		model.addAttribute("movies", movieService.getAllMovies());
		model.addAttribute("generos", generoService.getAllGenero());
		
		return "movies";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable Long id, Model model) {
		movieService.deleteMovie(id);
		
		model.addAttribute("movies", movieService.getAllMovies());
		model.addAttribute("generos", generoService.getAllGenero());
		
		return "movies";
	}
	
}
