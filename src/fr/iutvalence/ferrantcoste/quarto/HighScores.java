package fr.iutvalence.ferrantcoste.quarto;
import java.io.*;		/* sert à lire et modifier des fichier */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class HighScores {
	
	private final Map<String, Integer> scoresMap;
	private final File scoresfile;
	boolean isCorrupted = false;
	
	public HighScores(final String p_file) throws Exception {
		
		scoresfile = new File(p_file);
		scoresMap = new HashMap<>(10);
		boolean isCorrupted = false;

		if (!this.scoresfile.exists())
		{
			scoresfile.createNewFile();
		}
		else
		{
			try (final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(scoresfile), "UTF-8")))
			{
				br.readLine();
				br.readLine();

				String line = br.readLine();
				while (!line.startsWith("*****"))
				{
					try
					{
						final String[] parts = Pattern.compile(" - ").split(line);
						scoresMap.put(parts[0], Integer.parseInt(parts[1]));
						line = br.readLine();
					}
					catch (final IOException exception)
					{
						System.out.println("Can't properly read highscore m_file");
					}
					catch (final ArrayIndexOutOfBoundsException exception2)
					{
						isCorrupted = true;
						System.out.println("Can't properly read highscore m_file");
					}
				}
			}
			catch (final IOException exception)
			{
				System.out.println("Can't properly read highscore m_file");
			}
			catch (final NullPointerException exception2)
			{
				isCorrupted = true;
				System.out.println("Can't properly read highscore m_file");
			}
			finally
			{
				/* If the file is corrupted. */
				if (isCorrupted)
				{
					this.scoresfile.delete();
				}
			}
		}
	}
	
	
	
	
	/**
	 * The method to update the score.
	 */

	public void submitScores(final Player p)
	{
		final Integer i = scoresMap.get(p.getPseudo());
		if (! (p.getPseudo() == "AI") && ((i == null) || (i < p.getScore())) )
		{
			scoresMap.put(p.getPseudo(), p.getScore());
		}
	}

	/**
	 * Display the file of high scores.
	 */
	public void printAll()
	{
		if (this.scoresMap.size() == 0)
		{
			System.out.println("There isn't any highscore yet");
		}
		else
		{

			ArrayList<Player> sortedScores = new ArrayList<Player>();

			for (Map.Entry<String, Integer> entry : this.scoresMap.entrySet())
			{
				sortedScores.add(new Player(entry.getValue(), entry.getKey()));
			}

			sortedScores.sort(new PlayerComparator());

			System.out.println("*----THE BEST SCORES----*\n*************************");

			for (final Player player : sortedScores)
			{
				System.out.print(String.format("%s - %d\n", player.getPseudo(), player.getScore()));
			}
			System.out.println("*************************\n");
		}
	}
	/**
	 *
	 * @throws HighScoreAccessException
	 */
	public void close() throws Exception
	{
		ArrayList<Player> sortedScores = new ArrayList<Player>();

		for (Map.Entry<String, Integer> entry : this.scoresMap.entrySet())
		{
			sortedScores.add(new Player(entry.getValue(), entry.getKey()));
		}

		sortedScores.sort(new PlayerComparator());

		try (final BufferedWriter bw = new BufferedWriter(
											new OutputStreamWriter(
													new FileOutputStream(scoresfile, false),
													"UTF-8")))
		{
			bw.write("*----THE BEST SCORES----*\r\n*************************\r\n");
			for (final Player player : sortedScores)
			{
				bw.write(String.format("%s - %d\r\n", player.getPseudo(), player.getScore()));
			}
			bw.write("*************************\r\n");
		}
		catch (final IOException exception)
		{
			throw new Exception("Can't properly write in the highscore m_file", exception);
		}
	}

	private static final class PlayerComparator implements Comparator<Player>
	{
		public int compare(final Player o1, final Player o2)
		{
			return o2.getScore() - o1.getScore();
		}
	}

	@Override
	public String toString()
	{
		return String.format("HighScore{scoresMap=%s, scoresfile=%s}", scoresMap, scoresfile);
	}
}

