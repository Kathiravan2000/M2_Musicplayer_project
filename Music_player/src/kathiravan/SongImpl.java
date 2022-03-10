package kathiravan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

@SuppressWarnings("unused")
public class SongImpl{
	
	ArrayList<Song> songList=null;
	
    ArrayList<Song> getAllSongs1() throws Exception
    {
    	if(songList==null) {
    		songList=new ArrayList<>();
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Songs");
		while(rs.next())
		{	
			Song song= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			songList.add(song);
		}
    	}
    	
		return songList;
    }
    
  public void   getAllSongs() throws Exception
    {
    	 
    		songList=new ArrayList<>();
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Songs");
		while(rs.next())
		{	
			Song song= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			songList.add(song);
		}
    	
    	
		
    }
    public ArrayList<Song> displayAllSongs(ArrayList<Song> allsongs)throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
    	
    	for(Song song:allsongs)
    	{
    		System.out.printf("%10s", song);
    		
    	}
    	System.out.println(allsongs);
//    	System.out.println("Enter Your Song Id to Play:::");
    	int songId;
    	@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
    	songId=scanner.nextInt();
    	
    	PlayAudio playAudio=new PlayAudio();
    	playAudio.playAudio(songId);
    	
    	return allsongs;
    }
    public ArrayList<Song> displayAllSongs( )throws Exception
    {
    	getAllSongs1();
    	for(Song song:this.songList)
    	{
    		System.out.println( song);
    		
    	}
//    	System.out.println(songList);
    	System.out.println("Enter Your Song Id to Play:::");
    	int songId;
    	@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
    	songId=scanner.nextInt();
    	
    	PlayAudio playAudio=new PlayAudio();
    	playAudio.playAudio(songId);
    	
    	return songList;
    }
    
    ArrayList<Song> ListSongsByArtist(String name) throws Exception
    {
    	ArrayList<Song> songsByAritist=new ArrayList<Song>();
    	for(Song song:this.songList)
    	{
    		if(song.getArtistName().equals(name)) {
    			songsByAritist.add(song);
    		}
    		
    	}
    	return songsByAritist;
    	
    	
//    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","12345");
//		PreparedStatement st=con.prepareStatement("select * from songs where artistName =?");
//		st.setString(1, name);
//		ResultSet rs=st.executeQuery();
//		while(rs.next())
//		{
//			
//			Song song = new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
//			songList.add(song);
//		}
//		return songList;
    }
    
    ArrayList<Song> ListSongsByAlbumName(String AlbumName) throws Exception
    {
    	ArrayList<Song> songsByAlbumName=new ArrayList<Song>();
    	for(Song song:this.songList)
    	{
    		if(song.getAlbumName().equals(AlbumName)) {
    			songsByAlbumName.add(song);
    		}
    		
    	}
    	return songsByAlbumName;
//    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","12345");
//    	PreparedStatement st=con.prepareStatement("select * from songs where albumName=?");
//		st.setString(1, name);
//    	System.out.println(name);
//		ResultSet rs=st.executeQuery();
//		while(rs.next())
//		{
//			
//			Song song = new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
//			songList.add(song);
//		}
//		return songList;
    }
    
    ArrayList<Song> ListSongsByGenreType(String GenreType) throws Exception
    {
    	ArrayList<Song> songsByGenreType=new ArrayList<Song>();
    	for(Song song:this.songList)
    	{
    		if(song.getGenreType().equals(GenreType)) {
    			songsByGenreType.add(song);
    		}
    		
    	}
    	return songsByGenreType;
    	
//    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","12345");
//		Statement st=con.createStatement();
//		ResultSet rs=st.executeQuery("select * from songs where genreType ='" +name+"'");
//		while(rs.next())
//		{
//			
//			Song song = new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
//			songList.add(song);
//		}
//		return songList;
    }
}