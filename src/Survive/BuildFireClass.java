package Survive;

import java.util.Scanner;

public class BuildFireClass {
	
	public static Scanner scan = new Scanner(System.in);
	public static BuildFireClass f = new BuildFireClass();
	
	public int[] buildfire(int[] player) {
	if(player[5] > 0) {
			if (player[0] > 50) {
				player[4] += (int)(Math.random() * 100);
			} else if (player[0] <= 50 && player[0] > 20) {
				player[4] += (int)(Math.random() * 80);
			} else if (player[0] <= 20) {
				System.out.println("I can't... I'm just too tired.\n");
			}
			
			if (player[4] >= 60) {
				System.out.printf("Yeay, I did it!");
				player[5]--;
			
			} else if (player[4] < 40 && player[4] > 20) {
				System.out.printf("I'm trying... but It's really difficult.\n");
				player[5]--;
				
			} else if (player[4] <= 20 ) {
				System.out.printf("Oh, come on!\n");
				player[5]--;
				
			}
		} else if(player[5] <= 0 ) {
			player[5] = 0;
			System.out.println("I can't... I don't have tinder.");
		
		}
		return player;
	}
	
	public int[] addTinder(int[] player) {
		if(player[5] > 0) {
			player[4] += (int)(Math.random() * 15);
			int hours = player[4] / 60;
			int minutes = player[4] % 60; 
			System.out.printf("Done! It's gonna burn %d hours and %d minutes. \n", hours, minutes);
		} else if(player[5] <= 0) {
			System.out.println("I don't have tinder...");
		}

		return player;
	}
	
	public int[] addWood(int[] player) {
		if(player[6] > 0) {
			player[4] += (int)(Math.random() * 40);
			int hours = player[4] / 60;
			int minutes = player[4] % 60; 
			System.out.printf("Done! It's gonna burn %d hours and %d minutes. \n", hours, minutes);
		} else if(player[5] <= 0) {
			System.out.println("I don't have wood...");
		}
		return player;
	}
	
	public int[] addHardWood(int[] player) {
		if(player[7] > 0) {
			player[4] += (int)((Math.random() * 20) + 60);
			int hours = player[4] / 60;
			int minutes = player[4] % 60; 
			System.out.printf("Done! It's gonna burn %d hours and %d minutes. \n", hours, minutes);
		} else if(player[5] <= 0) {
			System.out.println("I don't have wood...");
		}
		return player;
	}
	
	public int[] feedFire(int[] player) {
		System.out.println("What should I throw?");
		System.out.println("1. tinder " + player[5]);
		System.out.println("2. wood " + player[6]);
		System.out.println("3. hard wood " + player[7]);

		System.out.println("");
		
		int choice = scan.nextInt();
		
		if(choice == 1) {
			player = f.addTinder(player);
			player[5]--;
			
		} else if(choice == 2) {
			player = f.addWood(player);
			player[6]--;
			
		} else if (choice == 3) {
			player = f.addHardWood(player);
			player[7]--;
		}
		
		return player;
	}
	
	public int[] getFireWood(int hour, int[] player) {//hp, bodyHeat, progress, rest, fire, tinder, wood, hardwood 
		if (player[0] > 10) {
			if (hour < 13) {
				int getWood = (int)((Math.random() * 4) + 1);
				int getHardWood = (int)((Math.random() * 2));
				player[6] += getWood; 
				player[7] += getHardWood;
				if(getHardWood <= 0) {
					System.out.printf("I went to get wood for fire. I got %d woods.", getWood);
				} else if(getHardWood > 0) {
					System.out.printf("I went to get wood for fire, and I got lucky! I got %d woods, and %d hard woods", getWood, getHardWood);
				}
				
			} else if (hour >= 13) {
				int getWood = (int)((Math.random() * 2) + 0);
				if(getWood > 0) {
					int getHardWood = (int)((Math.random() * 1) + 0);
					player[6] += getWood; 
					player[7] += getHardWood;
					if(getHardWood <= 0) {
						System.out.printf("It's dark outside... It was hard to see. I got I got %d woods.", getWood);
					} else if(getHardWood > 0) {
						System.out.printf("It was dark outside... but I got lucky! I got %d woods, and %d hard woods", getWood, getHardWood);
					}
				}
			}
			
		} else {
			System.out.println("I'm too tired... I need to get some rest.");
		}
		
		return player;
	}
	
	public int[] shaveWood(int[] player) {
		if(player[6] > 0 || player[7] > 0) {
			int tinder = (int)((Math.random() * 3) + 1);
			System.out.printf("done! I made %d tinders.", tinder);
			player[5] += tinder;
		}
		
		return player;
	}
}

