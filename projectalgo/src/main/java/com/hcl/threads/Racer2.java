package com.hcl.threads;

public class Racer2 {
	private int tortoiseDistance;// the distance the turtle ran
	private int rabbitDistance;// the distance the rabbit ran

	/**
	 * Turtle thread inner class
	 */
	class Tortoise extends Thread {

		@Override
		public void run() {
			// Analysis of programming code
			for (int i = 1; i <= 1000; i++) {
				// Determine whether the rabbit has reached the end
				if (rabbitDistance == 1000) {
					// When the rabbit hits 1000 m, the rabbit has won.
					System.out.println(
							"The rabbit won the game, at which point the turtle ran " + tortoiseDistance + "m");
					break;
				} else {
					// The turtle starts running
					tortoiseDistance += 1;
					// Determine whether the distance is a multiple of 100 and display.
					if (tortoiseDistance % 100 == 0) {
						try {
							System.out.println("The turtle ran through " + tortoiseDistance
									+ " meters, at this time the rabbit ran " + rabbitDistance + " meters.");
							Thread.sleep(500); // Shorten time to increase Tortoise chances.
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}
	}

	/**
	 * Rabbit thread inner class
	 */
	class Rabbit extends Thread {

		@Override
		public void run() {
			// 
			for (int i = 1; i <= 1000/5; i++) {
				// Determine whether the rabbit has reached the end
				if (tortoiseDistance == 1000) {
					// When the rabbit hits 1000 m, the rabbit has won.
					System.out.println("The turtle won the game, at this time the rabbit ran " + rabbitDistance + "m");
					break;
				} else {
					// The turtle starts running
					rabbitDistance += 5;
					// Determine whether the distance is a multiple of 100
					if (rabbitDistance % 100 == 0) {
						try {
							System.out.println("The rabbit ran " + rabbitDistance + " meters."
									+ " The tortoise ran over " + tortoiseDistance + " meters.");
							Thread.sleep(700);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}
	}

	// test
	public static void main(String[] args) {
		Racer2 racer = new Racer2();
		Rabbit rabbit = racer.new Rabbit();
		Tortoise tortoise = racer.new Tortoise();
		/*
		 *  In reality, it’s impossible to run both at the same time. This is also very
		 *	fair. 
		 */
		rabbit.start();
		tortoise.start();
	}
}
