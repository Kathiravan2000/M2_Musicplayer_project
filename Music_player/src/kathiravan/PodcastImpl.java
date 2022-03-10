package kathiravan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class PodcastImpl {
ArrayList<Podcast> podcastList=new ArrayList<>();
	
   ArrayList<Podcast> PodCatalog() throws Exception
   {
	   @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	   
	    System.out.println("Enter your choice to display Podcast list : \n 1.celebrity \n 2.Date \n 3. All Podcast Details");
	    
    	int choice=scan.nextInt();
	    
	    switch (choice) {
	    case 1:
	    	Scanner scan1=new Scanner(System.in);
		    System.out.println("Enter your Celebrity Name :");
		    @SuppressWarnings("unused") String name=scan1.nextLine();
		    break;
	    case 2:
		    System.out.println("Enter your Date :");
		    @SuppressWarnings("unused") String relaseDate= scan.next();		    
		    break;
	    case 3:
		    
		    break;
	    }
       	    
	    return podcastList;
        
   }
   
   
    ArrayList<Podcast> ListPodcastBycelebrities(String name) throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
    	PreparedStatement st=con.prepareStatement("select * from Podcasts where celebritiesName=?");
		st.setString(1, name);
		ResultSet rs=st.executeQuery();
    	/*Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from podcasts where celebritiesName ='"+name+"'");*/
		while(rs.next())
		{
			
			Podcast podcast = new Podcast(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getTime(6));
			podcastList.add(podcast);
		}
		return podcastList;
    }
    
    ArrayList<Podcast> ListPodcastByDate(String date) throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
    	PreparedStatement st=con.prepareStatement("select * from Podcasts where releasedate=?");
		st.setString(1, date);
		ResultSet rs=st.executeQuery();
    	/*Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from podcasts where releasedate ='"+date+"'");*/
		while(rs.next())
		{
			
			Podcast podcast = new Podcast(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getTime(6));
			podcastList.add(podcast);
		}
		return podcastList;
    }
    
    ArrayList<Podcast> ListAllPodcast() throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Music","root","kathir123");
    /*	PreparedStatement st=con.prepareStatement("select * from Podcasts=?");
		st.setString(1,podcasts);
		ResultSet rs=st.executeQuery();*/
    	
    	Statement st=con.createStatement();
 		ResultSet rs=st.executeQuery("select * from podcasts");
 		while(rs.next())
 		{
 			
 			Podcast podcast = new Podcast(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getTime(6));
 			podcastList.add(podcast);
 		}
 		return podcastList;
    }

 

}