package kathiravan;

public class Playlist {
	private String playListName ;
	private int songId;
	private int podcastId;
	
	
	public Playlist(String playListName,int songId,int podcastId)
	{
		this.playListName=playListName;
		this.songId=songId;
		this.podcastId=podcastId;
	}
	
	public String getPlayListName()
	{
		return playListName;
	}
	public int getSongId()
	{
		return songId;
	}
	public int getPodcastId()
	{
		return podcastId;
	}
	
	public String toString()
	{
		return (playListName+songId+podcastId);
	}
}
