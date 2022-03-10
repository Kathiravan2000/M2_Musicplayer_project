package kathiravan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Scanner;
import java.util.Random;

@SuppressWarnings("unused")
public class Main {

	static Random rand = new Random();

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);

		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("-*-Welcome to the Jukebox World-*-");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

		System.out.println("1.create account\t\t2.login");
		int choice = sc.nextInt();
		sc.nextLine();

		SongImpl songs = new SongImpl();
		PodcastImpl podcastimpl = new PodcastImpl();
		PlaylistImpl play = new PlaylistImpl();
		UserImpl user = new UserImpl();

		ArrayList<Song> songList = new ArrayList<Song>();

		ArrayList<Podcast> podcastList = new ArrayList<Podcast>();

		ArrayList<Playlist> playlist = new ArrayList<Playlist>();
		
		ArrayList<User> userList = new ArrayList<User>();
		

		switch (choice) {
		case 1:

			int userid = rand.nextInt(1000);
			System.out.println("your user id is:" + userid + " :note it down for further use");
			System.out.println("Enter the your name:");
			String username = sc.nextLine();
			System.out.println("Enter the email:");
			String emailid = sc.nextLine();
			System.out.println("Enter the password:");
			String passcode = sc.nextLine();
			String output = user.addUser(userid, username, emailid, passcode);
			System.out.println(output);
			System.exit(1);

			break;

		case 2:
			System.out.println("Enter the username:");
			 username =sc.nextLine();
			System.out.println("Enter the password:");
			 passcode=sc.nextLine();
			boolean validation=user.checkUser(username,passcode);
			if(validation) {
				System.out.println("welcome user");
				songs.getAllSongs();
				
			}
			else {
				System.out.println("Invalid Password Try Again");
				System.out.println("1.create account\t\t2.login");
				
			}

			
			while (true) {
				System.out.println("Enter you choice : \n 1.Display all songs \n2.ArtistName \n3.AlbumName \n4.GenreType \n5.Podcast \n6InsertSong \n7InsertPodcast \n8 CombinationOfpodcastAnd  \n9 Exit");
				int choice1 = scan1.nextInt();

				switch (choice1) {

				case 1:
					
					songs.displayAllSongs();
					break;
				case 2:
					Scanner scan = new Scanner(System.in);
					System.out.println("Enter your Artist Name :");
					String Name = scan.nextLine();
					songList = songs.ListSongsByArtist(Name);
					if(songList.isEmpty()) {
						System.out.println("Aritist Not Found");
					}
					else {
						System.out.println("Enter Your Song Id to Play:::");
						songs.displayAllSongs(songList);
						 
					}
						
					
					break;
				case 3:
					System.out.println("Enter your Album Name :");
					Scanner scan2 = new Scanner(System.in);
					String AlbumName = scan2.nextLine();
					songList = songs.ListSongsByAlbumName(AlbumName);
					if(songList.isEmpty()) {
						System.out.println("Album Not Found");
					}
					else {
						System.out.println("Enter Your Song Id to Play:::");
						songs.displayAllSongs(songList);
					}
					
					break;
				case 4:
					Scanner scan3 = new Scanner(System.in);
					System.out.println("Enter your Genre Type Name :");
					String GenreType = scan3.nextLine();
					songList = songs.ListSongsByGenreType(GenreType);
					if(songList.isEmpty()) {
						System.out.println("Genere Not Found");
					}
					else {
						System.out.println("Enter Your Song Id to Play:::");
						songs.displayAllSongs(songList);
					}
					break;

				case 5:
					podcastList = podcastimpl.PodCatalog();
					break;

				case 6:
					Scanner scan4 = new Scanner(System.in);
					System.out.println("Enter playlist name:");
					String playlistName = scan4.next();
					System.out.println("enter songid:");
					int songid = scan4.nextInt();
					play.insertSong(songList, playlistName, songid);
					songs.getAllSongs();
					break;
				case 7:
					Scanner scan5 = new Scanner(System.in);
					System.out.println("enter playlistname:");
					String name1 = scan5.next();
					System.out.println("enter  podcastid");
					int podcastid = scan5.nextInt();
					play.insertPodcast(podcastList, name1, podcastid);
					break;
				case 8:
					Scanner scan6 = new Scanner(System.in);
					System.out.println("enter playlistname:");
					String name2 = scan6.next();
					System.out.println("enter songid ");
					int id = scan6.nextInt();
					System.out.println("enter  podcastid ");
					int podcastid1 = scan6.nextInt();
					play.insertCombinedList(id, podcastid1, name2, podcastList, songList);
					break;
				case 9:
					System.out.println("Thank you");
					System.exit(0); 
					break;
				}

			}
		}
	}
}

