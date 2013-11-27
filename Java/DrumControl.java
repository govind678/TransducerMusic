package transducerMusic;

import com.cycling74.max.*;

public class DrumControl extends MaxObject {
	
	int[] currentRhythm = new int[32];
	
	int currentRhythmSize;
	
	int bar = 0;
	
	public DrumControl(Atom[] args) {
		declareInlets(new int[]{DataTypes.ALL});
		declareOutlets(new int[]{DataTypes.ALL, DataTypes.ALL, DataTypes.ALL, DataTypes.ALL});
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
		}
			
	}
	
	
	private void processBar(int barCount) {
		
	}
	
	
	public void reset ()
	{
		
	}
}
