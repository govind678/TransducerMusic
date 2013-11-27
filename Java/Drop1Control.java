package transducerMusic;

import com.cycling74.max.*;

public class Drop1Control extends MaxObject {
	
	int[] currentRhythm = new int[32];
	
	int currentRhythmSize;
	
	int bar = 0;
	
	public Drop1Control(Atom[] args) {
		declareInlets(new int[]{DataTypes.ALL});
		declareOutlets(new int[]{DataTypes.ALL, DataTypes.ALL, DataTypes.ALL, DataTypes.ALL, DataTypes.ALL, DataTypes.ALL, DataTypes.ALL, DataTypes.ALL});
	}
	
	public void list (Atom[] args) {
		
		currentRhythmSize = args[0].getInt();
		
		for (int i=0; i<currentRhythmSize; i++) {
			currentRhythm[i] = args[i+1].getInt();
		}
	}
	
	
	public void inlet (int beat)
	{
		if (beat == 1) {
			bar++;
			processBar(bar);
		}
			
		if (currentRhythm[beat-1] == 1) {
			outlet(0,"bang");
		} else if (currentRhythm[beat-1] == 2) {
			outlet(1,"bang");
		} else if (currentRhythm[beat-1] == 3) {
			outlet(2,"bang");
		} else if (currentRhythm[beat-1] == 4) {
			outlet(3,"bang");
		} else if (currentRhythm[beat-1] == 5) {
			outlet(4,"bang");
		} else if (currentRhythm[beat-1] == 6) {
			outlet(5,"bang");
		} else if (currentRhythm[beat-1] == 7) {
			outlet(6,"bang");
		} else if (currentRhythm[beat-1] == 8) {
			outlet(7,"bang");
		} else if (currentRhythm[beat-1] == 9) {
			outlet(1,"bang");
			outlet(3,"bang");
		} else if (currentRhythm[beat-1] == 10) {
			outlet(1,"bang");
			outlet(5,"bang");
		} else if (currentRhythm[beat-1] == 11) {
			outlet(2,"bang");
			outlet(4,"bang");
		} else if (currentRhythm[beat-1] == 12) {
			outlet(2,"bang");
			outlet(6,"bang");
		} else if (currentRhythm[beat-1] == 13) {
			outlet(5,"bang");
			outlet(7,"bang");
		} else if (currentRhythm[beat-1] == 14) {
			outlet(0,"bang");
			outlet(3,"bang");
		}
		
			
	}
	
	
	private void processBar(int barCount) {
		
	}
	
	
	public void reset ()
	{
		
	}

}
