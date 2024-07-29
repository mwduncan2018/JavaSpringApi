package duncan.music.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import duncan.music.model.Band;
import duncan.music.repository.AlbumRepository;
import duncan.music.repository.BandRepository;
import duncan.music.repository.SongRepository;

@RestController
public class BandController {
	private final BandRepository bandRepository;
	private final AlbumRepository albumRepository;
	private final SongRepository songRepository;

	public BandController(BandRepository bandRepository, AlbumRepository albumRepository,
			SongRepository songRepository) {
		this.bandRepository = bandRepository;
		this.albumRepository = albumRepository;
		this.songRepository = songRepository;
	}

	@GetMapping(path = "/bands/{id}")
	public Band getBandById(@PathVariable("id") int id) {
		return bandRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Band with id " + id + " not found"));
	}

	@GetMapping(path = "/bands")
	public List<Band> getAllBands() {
		return bandRepository.findAll();
	}
}
