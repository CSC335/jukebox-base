package demoSongPlayer;

import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
/**
 * Play one audio file from the songfiles directory.
 * There is no listener for the end of song event.
 * 
 * @author Rick Mercer
 */
import songplayer.SongPlayer;

public class PlayOneSong {

	/**
	 * Play one audio file with no listener for the end of song event. A println
	 * is included to indicate the song is playing in a separate Thread.
	 */
	public static void main(String[] args) {

		// If there are no GUI components present, wrap the code in the
		// public void run method of this anonymous class
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ObjectWaitingForSongToEnd waiter = new ObjectWaitingForSongToEnd();
				SongPlayer.playFile(waiter, "./songfiles/tada.wav");
				System.out.println("Song played in a separate Thread so this appears immediately");
				System.out.println("This program terminates only when song finishes...");
			}
		});
	}

	/**
	 * An inner class that allows an instance of this to receive a
	 * songFinishedPlaying when the audio file has been played. Note: static was
	 * added here because it is called from main.
	 */
	private static class ObjectWaitingForSongToEnd implements EndOfSongListener {

		@Override
		public void songFinishedPlaying(EndOfSongEvent eventWithFileNameAndDateFinished) {
			System.out.print("Finished " + eventWithFileNameAndDateFinished.fileName());
			System.exit(0);
		}
	}

}