package duncan.music.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duncan.music.model.Song;
import duncan.music.repository.AlbumRepository;
import duncan.music.repository.BandRepository;
import duncan.music.repository.SongRepository;

@RestController
@RequestMapping(path = "/songs")
public class SongController {
	private final BandRepository bandRepository;
	private final AlbumRepository albumRepository;
	private final SongRepository songRepository;

	public SongController(BandRepository bandRepository, AlbumRepository albumRepository,
			SongRepository songRepository) {
		this.bandRepository = bandRepository;
		this.albumRepository = albumRepository;
		this.songRepository = songRepository;
	}

	@GetMapping(path = "/numbertwo/{id}")
	public Song getSongsById(@PathVariable("id") int id) {
		return songRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Song with id " + id + " not found"));
	}

	@GetMapping(path = "/all")
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Song create(@RequestBody Song song) {
		return songRepository.create(song);
	}

	@GetMapping(path = "/{id}")
	public Song get(int id) {
		return songRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Song with id " + id + " not found"));
	}

	@PutMapping
	public Song update(@RequestBody Song song) {
		return songRepository.update(song);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(int id) {
		songRepository.deleteById(id);
	}

}
