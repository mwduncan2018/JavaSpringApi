package duncan.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import duncan.music.model.Album;
import duncan.music.repository.AlbumRepository;
import duncan.music.repository.BandRepository;
import duncan.music.repository.SongRepository;

@RestController
public class AlbumController {

	private final BandRepository bandRepository;
	private final AlbumRepository albumRepository;
	private final SongRepository songRepository;

	public AlbumController(BandRepository bandRepository, AlbumRepository albumRepository, SongRepository songRepository) {
		this.bandRepository = bandRepository;
		this.albumRepository = albumRepository;
		this.songRepository = songRepository;
	}

	@GetMapping(path = "/albums/{id}")
	public Album getAlbumById(@PathVariable("id") int id) {
		return albumRepository.findById(id);
	}
	
	@GetMapping(path = "/albums")
	public List<Album> getAllAlbums() {
		return albumRepository.findAll();
	}

}
