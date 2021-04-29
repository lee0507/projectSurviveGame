package Survive;

import java.util.ArrayList;
import java.util.Scanner;

public class TextGame {
	public static Scanner scan = new Scanner(System.in);
	public static TextGame p = new TextGame();
	public static BuildFireClass f = new BuildFireClass();
	public static RestClass r = new RestClass();
	public static GeneralTravelClass g = new GeneralTravelClass();

	public static void main(String[] args) {
		int[] player = {100, 70, 0, 0, 0, 3, 0, 0}; //hp, bodyHeat, progress, rest, fire, tinder, wood, hardwood 
		int distance = 100;
		
		p.introduction();
		
		
		int day = 0;
		int hour = 0;
		while (hour < 24) {
			
			if (hour >= 0 && hour <= 12) {
				int action = p.menuDay(day, hour);
				if(action == 1) {
					g.printStat(player);
					
				} else if(action == 2) {
					player = r.buildShelter(player);
					player = g.yourStat(player, hour);
					hour++;
					
				} else if (action == 3) {
					player = f.buildfire(player);
					player = g.yourStat(player, hour);
					hour++;
					
				} else if(action == 4) {
					f.getFireWood(hour, player);
					hour++;
					
				} else if(action == 5) {
					distance = g.travel(distance);
					player = g.yourStat(player, hour);
					hour++;
					
				} else if (action == 6) {
					player = r.resting(player);
					player = g.yourStat(player, hour);
					hour++;
				} else if (action == 7) {
					f.feedFire(player);
					g.yourStat(player, hour);
					
				}   else if(action == 8) {
					f.shaveWood(player);
					g.yourStat(player, hour);
				}
				
			}
			
			if (hour >= 13){
				int action = p.menuNight(day, hour);
				
				if(action == 1) {
					g.printStat(player);
				
				} else if(action == 2) {
					player = r.buildShelter(player);
					player = g.yourStat(player, hour);
					hour++;
					
				} else if (action == 3) {
					player = f.buildfire(player);
					player = g.yourStat(player, hour);
					hour++;
					
				} else if (action == 4) {
					player = r.resting(player);					
					player = g.yourStat(player, hour);
					hour++;
				
				} else if(action == 5) {
					f.feedFire(player);
					g.yourStat(player, hour);
					
				}  else if(action == 6) {
					f.shaveWood(player);
					g.yourStat(player, hour);
				}
				
				if(hour >= 24) {
					hour = 0;
					day++;
				}
			}
			
			if(player[0] <= 0 || player[1] <= 0){
				System.out.println("I'm dead");
				break;
			}
			
			if(distance <= 0) {
				System.out.println("I'm saved!");
				break;
			}

		}
		
		
	}
	
	public void introduction() {
		System.out.println("I was on the hike... but I fell from the cliff. Lucky I didn't get hurt. It was just a scratch. Anyway I fell, and I woke up.");
	}
	
	public int menuNight(int day, int hour) {
		System.out.println("\n" + day + "Day " + hour + "hour");
		System.out.print("It's dark outside...");
		System.out.println("What should I do?");
		System.out.println("1. Check Stat");
		System.out.println("2. Make Shelter.");
		System.out.println("3. Build Fire.");
		System.out.println("4. Get some rest");
		System.out.println("5. Feed fire");
		
		return scan.nextInt();
	}
	
	public int menuDay(int day, int hour) {
		System.out.println("\n" + day + "Day " + hour + "hour");
		System.out.print("The sun is up! ");
		System.out.println("What should I do?");
		System.out.println("1. Check Stat.");
		System.out.println("2. Make Shelter.");
		System.out.println("3. Build Fire.");
		System.out.println("4. Get Firewoods.");
		System.out.println("5. travel.");
		System.out.println("6. Get some rest");
		System.out.println("7. Feed fire");
		
		return scan.nextInt();
	}

}
	
