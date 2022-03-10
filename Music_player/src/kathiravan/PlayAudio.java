package kathiravan;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

@SuppressWarnings("unused")
public class PlayAudio {
	Long currentFrame;
	Clip clip;
	String status;
	static String filePath;
	AudioInputStream audioInputStream;
	private int songId;
	

	public void playAudio(int songId) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		filePath = "E:\\Songs\\" + songId + ".wav";
		System.out.println(filePath);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);

		status = "play";

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. pause");
			System.out.println("2. resume");
			System.out.println("3. restart");
			System.out.println("4. stop");
			System.out.println("5. Jump to specific time");
			int c = sc.nextInt();
			this.userChoice(c);
			if (c == 4)
				break;
		}
		sc.close();

	}

	public void userChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		switch (c) {
		case 1:
			pause();
			break;
		case 2:
			resumeAudio();
			break;
		case 3:
			restart();
			break;
		case 4:
			stop();
			break;
		case 5:
			System.out.println("Enter time (" + 0 + ", " + clip.getMicrosecondLength() + ")");
			Scanner sc = new Scanner(System.in);
			long c1 = sc.nextLong();
			jump(c1);
			break;

		}
	}

	public void play() {
		clip.start();
		status = "play";

	}

	public void pause() {
		if (status.equals("paused")) {
			System.out.println("audio is already paused");
			return;
		}
		this.currentFrame = this.clip.getMicrosecondPosition();

		clip.stop();
		status = "paused";
	}

	public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (status.equals("play")) {
			System.out.println("Audio is already " + "being played");
			return;
		}
		clip.close();
		resetAudioStream(songId);
		clip.setMicrosecondPosition(currentFrame);
		this.play();
	}

	public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		clip.stop();
		clip.close();
		resetAudioStream(songId);
		currentFrame = 0L;
		clip.setMicrosecondPosition(0);
		this.play();
	}

	public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		System.out.println(" Current Frame Stop at :: " + this.currentFrame + " ms.");
		currentFrame = 0L;
		clip.stop();
		clip.close();
	}

	// Method to jump over a specific part
	public void jump(long c) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (c > 0 && c < clip.getMicrosecondLength()) {
			clip.stop();
			clip.close();
			resetAudioStream(songId);
			currentFrame = c;
			clip.setMicrosecondPosition(c);
			this.play();
		}
	}

	public void resetAudioStream(int songId ) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	
		filePath = "E:\\Songs\\" +  songId + ".wav";
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}

}