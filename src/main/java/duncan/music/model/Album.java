package duncan.music.model;

import java.util.List;

public record Album(
		int id,
		String name,
		List<Song> songs) {
}