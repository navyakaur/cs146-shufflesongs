package sjsu.kaur.cs146.project1;

import java.util.ArrayList;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;


import org.junit.Test;

//this is testing to SongShuffler Class and making sure it is being shuffled properly
public class SongShufflerTest {
	
	@Test
	public void testCreatePlaylist() throws IOException {
		
		SongShuffler s1 = new SongShuffler();
		
		//reading the two files and putting it into an array
		String name1 = "/Users/navyakaur/Documents/cs146/potika/Project1/ShuffleSongs/src/sjsu/kaur/cs146/project1/Playlist.txt";
		String name2 = "/Users/navyakaur/Documents/cs146/potika/Project1/ShuffleSongs/src/sjsu/kaur/cs146/project1/Target1.txt";
		
		FileReader f1 = new FileReader(name1); 
		FileReader f2 = new FileReader(name2);
		
		BufferedReader In = new BufferedReader(f1);
		BufferedReader Out = new BufferedReader(f2);
        
		List<String> lines = new ArrayList<String>();
        List<String> lines2 = new ArrayList<String>();
        
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("/Users/navyakaur/Documents/cs146/potika/Project1/ShuffleSongs/src/sjsu/kaur/cs146/project1/KaurNavyaPlaylist.txt"));
        
        String line = null;
        String line2 = null;
        String[] playlist1 = null;
        String[] playlist2 = null;
        
        //reading into arraylist
        try {
	        while ((line = In.readLine()) != null) 
	        {
	        	lines.add(line);
	        }
	        
	        while ((line2 = Out.readLine()) !=null) {
	        	lines2.add(line2);
	        }
	         
	        In.close();
	        Out.close();
	        
	        //putting arraylist into array
	        playlist1 = lines.toArray(new String[lines.size()]); //old unshuffled array
	        playlist2 = lines2.toArray(new String[lines2.size()]); //target array
	        
	        String[] shuffled = s1.shuffle(playlist1); //shuffle the old array
	        
	        for (int i = 0; i < shuffled.length; i++) {
	          outputWriter.write(shuffled[i]);
	          outputWriter.newLine();
	        }
	        outputWriter.flush();  
	        outputWriter.close();
	        
	        //iterating through each array and comparing
	        for (int i = 0; i < playlist1.length; i++) {
	        	assertEquals(shuffled[i], playlist2[i]);
	        }

        }
        
        catch(IOException e)
        {
            // Print out the exception that occurred
            System.out.println("Unable to create "+ ": "+ e.getMessage());              
        }
        
	}

}
