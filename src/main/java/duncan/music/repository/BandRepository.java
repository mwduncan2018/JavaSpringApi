package duncan.music.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import duncan.music.model.Album;
import duncan.music.model.Band;

@Repository
public class BandRepository {
	private List<Band> bands;
	private AlbumRepository albumRepository;

	public void initialize() {
		if (bands == null) {
			bands = Arrays.asList(
					new Band[] { new Band(1, "Metallica", Arrays.asList(new Album[] { albumRepository.findById(1) })),
							new Band(2, "Ghost", Arrays.asList(new Album[] { albumRepository.findById(2) })) });
		}
	}

	public Optional<Band> findById(int id) {
 		initialize();
		return bands.stream().filter(band -> band.id() == id).findFirst();
	}
	
	public List<Band> findAll() {
		initialize();
		return bands;
	}
}
