package duncan.music.repository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import duncan.music.model.Song;

@Repository
public class SongRepository {
	private List<Song> songs;

	public void initialize() {
		if (songs == null) {
			songs = Arrays.asList(new Song[] { new Song(1, "Blackened", "6:42"),
					new Song(2, "... And Justice For All", "9:46"), new Song(3, "Eye of the Beholder", "6:25"),
					new Song(4, "One", "6:25"), new Song(5, "The Shortest Straw", "6:35"),
					new Song(6, "Harvester of Sorrow", "5:45"), new Song(7, "The Frayed Ends of Sanity", "7:43"),
					new Song(8, "To Live Is to Die", "9:49"), new Song(9, "Dyers Eve", "5:14"),
					new Song(10, "Ashes", "1:21"), new Song(11, "Rats", "4:21"), new Song(12, "Faith", "4:29"),
					new Song(13, "See The Light", "4:05"), new Song(14, "Miasma", "5:17"),
					new Song(15, "Dance Macabre", "3:39"), new Song(16, "Pro Memoria", "5:39"),
					new Song(17, "Witch Image", "3:30"), new Song(18, "Helvetesfonster", "5:55"),
					new Song(19, "Life Eternal", "3:27"), });
		}

	}

	public Optional<Song> findById(int id) {
		initialize();
		return songs.stream().filter(song -> song.id() == id).findFirst();
	}
	
	public List<Song> findAll() {
		initialize();
		return songs;
	}
	
	public Song create(Song song) {
		if (songs.add(song))
			return song;
		return null;
	}
	
	public Song update(Song song) {
		Song oldSong = findById(song.id()).orElseThrow(() -> new NoSuchElementException("Song with id " + song.id() + " not found"));
		Song newSong = new Song(oldSong.id(), song.name(), song.length());
		songs.add(newSong);
		return newSong;
	}
	
	public void deleteById(int id) {
		songs.removeIf(song -> song.id() == id);
	}
}
