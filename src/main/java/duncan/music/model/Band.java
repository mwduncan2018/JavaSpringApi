package duncan.music.model;

import java.util.List;

public record Band(
		int id,
		String name,
		List<Album> albums) {
}