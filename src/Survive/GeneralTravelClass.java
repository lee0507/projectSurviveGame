package Survive;

public class GeneralTravelClass {
	
	public int travel(int distance) {
		distance -= (int)(Math.random() * 5);
		return distance;
		
	}
	
	public int[] yourStat(int[] player, int hour) {
		int hp = (int)(Math.random() * 15); //hp
		int bh = (int)(Math.random() * 15); //body heat
		int downBh = (int)(Math.random() * 15); // getting colder
		int integrity = (int)(Math.random() * 10); //integrity of the shelter
		//int[] player = {100, 70, 0, 0, 0, 0, 0, 0}; hp, bodyHeat, progress, rest, fire, tinder, wood, hardwood
		
		if(player[3] <= 0) {	
			player[0] -= hp;
		} else if (player[3] > 0) {
			player[0]+= player[3];
			player[3] = 0;
		}
		
		if(player[0] >= 100) {
			player[0] = 100; // hp rebalancing
		}
		

		if(hour > 12) { // getting cold at night
			if(player[4] <= 5) {
				player[1] -= bh;
			} else if (player[4] > 5) {
				player[1] += bh;
			}
		}

		if(player[4] > 0) {
			player[4] -= 20;
		} 
		
		if(player[4] <= 0) {
			player[4] = 1;
 		}
				
		if(player[1] >= 100) { // bodyheat rebalancing
			player[1] = 100;
		}
		
		if(player[2] > 20){
			player[2] -= integrity;
		}
		
		return player;
		
	}
	
	public void printStat(int[] player) {
		if (player[0] <= 100 && player[0] > 70) {
			System.out.printf("I'm still good. My hp is %d percent. \n", player[0]);
		} else if(player[0] <= 70 && player[0] > 20) {
			System.out.printf("meh... so-so. My hp is %d percent. \n", player[0]);
		} else if(player[0] <= 20 && player[0] > 0) {
			System.out.printf("I'm a bit tired... I should get some rest. My hp is %d percent. \n", player[0]);
		}
		
		if (player[1] <= 100 && player[1] > 70) {
			System.out.printf("It's warm enough! my body heat is %d percent. \n", player[1]);
		} else if (player[1] <= 70 && player[1] > 50) {
			System.out.printf("It's still fine. my body heat is %d percent. \n", player[1]);
		} else if (player[1] <= 50 && player[1] > 30) {
			System.out.printf("It's a bit chilly... I need to build a fire. my body heat is %d percent. \n", player[1]);
		} else if(player[1] <= 30 && player[1] > 10) {
			System.out.printf("I reaaaaaally need to build a fire! my body heat is %d percent. \n", player[1]);
		} else if (player[1] <=10 && player[1] > 0) {
			System.out.println("........");
			System.out.println("(Dead don't talk.)");
		}
		System.out.println(player[5] + " " + player[6] + " " + player[7]);
	}
}
