package Survive;

public class RestClass {
	
	public int[] resting(int[] player) {
		player[3] = (int)(Math.random() * 20);
		return player;
	}
	
	public int[] buildShelter(int[] player) {
		if (player[0] > 50) {
			player[2] += (int)(Math.random() * 50);
		} else if (player[0] <= 50 && player[0] > 20) {
			player[2] += (int)(Math.random() * 30);
		} else if (player[0] <= 20) {
			System.out.println("I can't... I'm just to tired.\n");
		}
		
		if (player[2] > 150) {
			player[2] = 148;
			System.out.printf("Perfect! It's %d percent done.\n", player[2]);
		} else if(player[2] > 80 && player[2] <= 150) {
			System.out.printf("Perfect! It's %d percent done.\n", player[2]);
		} else if(player[2] <= 80 && player[2] > 50) {
			System.out.printf("Looking good! It's %d percent done.\n", player[2]);
		} else if(player[2] <= 50 && player[2] > 20) {
			System.out.printf("I'm trying... but It's gonna need more tweaking. It's %d percent done.\n", player[2]);
		} else if(player[2] <= 20 && player[2] >= 0 ) {
			System.out.printf("Well, I'm just get started! It's %d percent done.\n", player[2]);
		} else if(player[2] < 0) {
			player[2] = 1;
		}
		
		return player;
	}
}
