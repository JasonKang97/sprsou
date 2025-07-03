package pack;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	private final MovieRepository movieRepository;
	
	
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){	// 전체 읽기
		return movieRepository.findAll();
	}
	
	@GetMapping("/recommend/{genre}")
	public List<Movie> recommendMovies(@PathVariable(name="genre")String genre){	// 전체 읽기
		return movieRepository.findByGenre(genre);
	} 
	
	@PostMapping("/movies")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
}
