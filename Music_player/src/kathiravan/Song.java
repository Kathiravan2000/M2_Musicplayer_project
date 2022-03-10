package kathiravan;

public class Song {
	private int songId;
	private String songsName;
	private String artistName;
	private String albumName;
	private String genreType;

	public Song(int songId, String songsName, String artistName, String albumName, String genreType) {

		this.songId = songId;
		this.songsName = songsName;
		this.artistName = artistName;
		this.albumName = albumName;
		this.genreType = genreType;

	}
	public int getSongId() {
		return songId;
	}
	public String getSongsName() {
		return songsName;
	}
	public String getArtistName() {
		return artistName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public String getGenreType() {
		return genreType;
	}
	public String toString() {
		return (songId + songsName + artistName + albumName + genreType);
	}
}