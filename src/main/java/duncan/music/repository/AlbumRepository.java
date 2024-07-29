package duncan.music.repository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import duncan.music.model.Album;
import duncan.music.model.Song;

@Repository
public class AlbumRepository {
	private List<Album> albums;
	private SongRepository songRepository = new SongRepository();

	public void initialize() {
		if (albums == null) {
			albums = Arrays.asList(new Album[] {
					new Album(1, "... And Justice For All",
							Arrays.asList(new Song[] { songRepository.findById(1).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(2).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")),
									songRepository.findById(3).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(4).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(5).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")),
									songRepository.findById(6).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(7).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(8).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")),
									songRepository.findById(9).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), })),
					new Album(2, "Prequelle",
							Arrays.asList(new Song[] { songRepository.findById(10).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(11).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")),
									songRepository.findById(12).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(13).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")),
									songRepository.findById(14).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(15).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")),
									songRepository.findById(16).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(17).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")),
									songRepository.findById(18).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), songRepository.findById(19).orElseThrow(() -> new NoSuchElementException("Song with id " + "0" + " not found")), })) });
		}
	}
	
	public Album findById(int id) {
		initialize();
		return albums.stream().filter(album -> album.id() == id).toList().get(0);
	}
	
	public List<Album> findAll() {
		initialize();
		return albums;
	}
}
