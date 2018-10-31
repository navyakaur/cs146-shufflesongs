package sjsu.kaur.cs146.project1;

import java.util.Random;

//this class shuffles a music playlist filled with song titles
public class SongShuffler {
	
	private Random r;
	
	public SongShuffler() {
		//this ensures the same random # is used for tests
		r = new Random();
		r.setSeed(20);
	
	}
	
	//generates next pseudorandom between 0.0 and 1.0 from this random number generator's sequence
	public double myrandom() {
		return r.nextDouble(); //random in 0-1
	}
	
	//uses Fisher-Yates algorithm
	public String[] shuffle(String[] playlist) {
		
		//iterating through array to shuffle it
		for (int i = playlist.length - 1; i > 0; i--) {
			
			//finding random element to swap with
			int x = (int)(myrandom() * playlist.length);
			
			//swapping
			String temp = playlist[i];
			playlist[i] = playlist[x];
			playlist[x] = temp;
			
		}
		
		return playlist;

	}

}
