package demoSongPlayer;

import javax.swing.JOptionPane;

import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
import songplayer.SongPlayer;

/**
 * Play three songs assuming you close the modal dialog box. When run, you can
 * actually have two songs playing at the same time.
 * 
 * The end of song listener prints the fully qualified file name and the time
 * the song finished playing pass as the argument to the listener.
 * 
 * @author Rick Mercer
 */

public class Play3SongsPausedByAModalDialogBox {

	/**
	 * Play three songs assuming you close the modal dialog box. When run, you
	 * can actually have two songs playing at the same time.
	 * 
	 * @param args
	 *            An array of strings not often used by anybody
	 */
	public static void main(String[] args) {
		ObjectWaitingForSongToEnd waiter = new ObjectWaitingForSongToEnd();

		JOptionPane.showMessageDialog(null, "Play short aif file");
		SongPlayer.playFile(waiter, baseDir + "flute.aif");

		JOptionPane.showMessageDialog(null, "Play tada.wav");
		SongPlayer.playFile(waiter, baseDir + "tada.wav");

		JOptionPane.showMessageDialog(null, "Play an MP3");
		SongPlayer.playFile(waiter, baseDir + "SwingCheese.mp3");
	}

	/**
	 * This inner class allows us to have an callback function that receive a
	 * songFinishedPlaying message whenever an audio file has been played.
	 * 
	 * Note: this is a static class because it is being called from main, which
	 * is a static context. If you are using a GUI, you won't need static
	 */
	private static class ObjectWaitingForSongToEnd implements EndOfSongListener {

		public void songFinishedPlaying(EndOfSongEvent eosEvent) {
			System.out.println("Finished " + eosEvent.fileName() + ", " + eosEvent.finishedDate() + ", "
					+ eosEvent.finishedTime());
		}
	}

	/**
	 * baseDir will be the fully qualified path to the directory in which this
	 * program is running on any machine. System.getProperty("file.separator")
	 * returns "\" when running on Unix or "/" when running on windows.
	 */
	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");

}