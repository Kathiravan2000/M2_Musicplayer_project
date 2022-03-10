package kathiravan;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
public class PlaylistImpl
{
	
	void displayData() throws Exception
	{
		
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from playlist");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
		st.close();
		rs.close();
		con.close();
	}
	void insertSong(List<Song> songlist, String playlistname, int songid) throws Exception
	{
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
			PreparedStatement ps=con.prepareStatement("insert into playlist (playlistname,songid) values(?,?)");
			ps.setString(1,playlistname);
			ps.setInt(2, songid);
     		ps.executeUpdate();
			ps.close();
			con.close();
		
	}
	void insertPodcast(List<Podcast> podcastList, String playlistName, int podcastid ) throws Exception
	{
		
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
			PreparedStatement ps=con.prepareStatement("insert into playlist (playlistname,podcastid)values(?,?)");
			ps.setString(1, playlistName);
			ps.setInt(2, podcastid);
			ps.executeUpdate();
			ps.close();
			con.close();
		
	}

	public void insertCombinedList(int songid, int podcastid, String playlistName, List<Podcast> podList, List<Song> songlist) throws Exception
	{
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
			PreparedStatement ps=con.prepareStatement("insert into playlist (playlistname,songid,podcastid)values(?,?,?)");
			ps.setString(1, playlistName);
			ps.setInt(2, songid);
			ps.setInt(3, podcastid);
			ps.executeUpdate();
			ps.close();
			con.close();			
			
	}
}