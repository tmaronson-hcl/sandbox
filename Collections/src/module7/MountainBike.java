package module7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/*
 * This is a sample file that was written by an apprentice trainee
 * that shows nice work. We refactored it in certain places based
 * on conventions, basic principles, and elimination of some
 * code smells. It is not complete from that respect but the
 * trainee analyst is working on it from here.
 * 
 */
public class MountainBike {
	public static void main(String[] args) {
		System.out.println(MountainBike.Type.ALUMINUM.getType());
		System.out.println(MountainBike.Type.ALUMINUM.getTypeWeight());
		System.out.println(MountainBike.Size.LARGE.getSizeWeight());
		System.out.println(MountainBike.Color.OLIVECHROME.getColor());
		System.out.println("------ Testing 123 ------");
		MountainBike test = new MountainBike(Type.CARBONFIBER, Size.LARGE, Color.BLACKGLOSS);
		System.out.println(test.type.getType());
		System.out.println(test.type.getTypeWeight());
		System.out.println(test.size.getSizeWeight());
		System.out.println(test.color.getColor());
		System.out.println();
//      Aluminum Bikes
		MountainBike aluminumSmallRG = new MountainBike(Type.ALUMINUM, Size.SMALL, Color.REDWINEGLOSS);
		MountainBike aluminumSmallBG = new MountainBike(Type.ALUMINUM, Size.SMALL, Color.BLACKGLOSS);
		MountainBike aluminumSmallBM = new MountainBike(Type.ALUMINUM, Size.SMALL, Color.BLUEMATTE);
		MountainBike aluminumSmallOC = new MountainBike(Type.ALUMINUM, Size.SMALL, Color.OLIVECHROME);
		MountainBike aluminumLargeRG = new MountainBike(Type.ALUMINUM, Size.LARGE, Color.REDWINEGLOSS);
		MountainBike aluminumLargeBG = new MountainBike(Type.ALUMINUM, Size.LARGE, Color.BLACKGLOSS);
		MountainBike aluminumLargeBM = new MountainBike(Type.ALUMINUM, Size.LARGE, Color.BLUEMATTE);
		MountainBike aluminumLargeOC = new MountainBike(Type.ALUMINUM, Size.LARGE, Color.OLIVECHROME);
//      Carbon Fiber Bikes
		MountainBike carbonfiberSmallRG = new MountainBike(Type.CARBONFIBER, Size.SMALL, Color.REDWINEGLOSS);
		MountainBike carbonfiberSmallBG = new MountainBike(Type.CARBONFIBER, Size.SMALL, Color.BLACKGLOSS);
		MountainBike carbonfiberSmallBM = new MountainBike(Type.CARBONFIBER, Size.SMALL, Color.BLUEMATTE);
		MountainBike carbonfiberSmallOC = new MountainBike(Type.CARBONFIBER, Size.SMALL, Color.OLIVECHROME);
		MountainBike carbonfiberLargeRG = new MountainBike(Type.CARBONFIBER, Size.LARGE, Color.REDWINEGLOSS);
		MountainBike carbonfiberLargeBG = new MountainBike(Type.CARBONFIBER, Size.LARGE, Color.BLACKGLOSS);
		MountainBike carbonfiberLargeBM = new MountainBike(Type.CARBONFIBER, Size.LARGE, Color.BLUEMATTE);
		MountainBike carbonfiberLargeOC = new MountainBike(Type.CARBONFIBER, Size.LARGE, Color.OLIVECHROME);
//      Steel Bikes
		MountainBike steelSmallRG = new MountainBike(Type.STEEL, Size.SMALL, Color.REDWINEGLOSS);
		MountainBike steelSmallBG = new MountainBike(Type.STEEL, Size.SMALL, Color.BLACKGLOSS);
		MountainBike steelSmallBM = new MountainBike(Type.STEEL, Size.SMALL, Color.BLUEMATTE);
		MountainBike steelSmallOC = new MountainBike(Type.STEEL, Size.SMALL, Color.OLIVECHROME);
		MountainBike steelLargeRG = new MountainBike(Type.STEEL, Size.LARGE, Color.REDWINEGLOSS);
		MountainBike steelLargeBG = new MountainBike(Type.STEEL, Size.LARGE, Color.BLACKGLOSS);
		MountainBike steelLargeBM = new MountainBike(Type.STEEL, Size.LARGE, Color.BLUEMATTE);
		MountainBike steelLargeOC = new MountainBike(Type.STEEL, Size.LARGE, Color.OLIVECHROME);
		List<MountainBike> mountainBikes = Arrays.asList(aluminumSmallRG, aluminumSmallBG, aluminumSmallBM,
				aluminumSmallOC, aluminumLargeRG, aluminumLargeBG, aluminumLargeBM, aluminumLargeOC, carbonfiberSmallRG,
				carbonfiberSmallBG, carbonfiberSmallBM, carbonfiberSmallOC, carbonfiberLargeRG, carbonfiberLargeBG,
				carbonfiberLargeBM, carbonfiberLargeOC, steelSmallRG, steelSmallBG, steelSmallBM, steelSmallOC,
				steelLargeRG, steelLargeBG, steelLargeBM, steelLargeOC);
		System.out.println();
		System.out.println("------ Streams ------");
//      Count Total Number of Variations -> 24
		System.out.println(mountainBikes.stream().count());
//      Count Total Number where Color is Black Gloss -> 6
		System.out.println("------ Total Number of Bikes Where Color is Black Gloss ------");
		System.out.println(mountainBikes.stream().filter(mB -> mB.color.getColor() == Color.BLACKGLOSS).count());
//      Get Total Weight of Each Bike that is Black Gloss
		System.out.println("------ Total Weight of each Bike that is Black Gloss ------");
		System.out.println(mountainBikes.stream().filter(mB -> mB.color.getColor() == Color.BLACKGLOSS)
				.mapToDouble(mB -> mB.size.getSizeWeight()).sum());
//      List Bikes are over 50lbs?
		System.out.println("------ List Bikes Over 50lbs ------");
		/*  NO - this concatenates and combines String addition with arithmetic addition
		 * to give a String and nonsensical values overall.
		 *  
		 * System.out.println( mountainBikes.stream() .filter(mB ->
		 * mB.size.getSizeWeight() + mB.type.getTypeWeight() > 50) //Need to Add
		 * mB.size.getSizeWeight() + mBtype.getTypeWeight(); It is currently
		 * concatenating instead of adding .map(mB -> mB.size + "/" + mB.type + ":" +
		 * mB.color + "->" + mB.size.getSizeWeight() + mB.type.getTypeWeight() +"\n")
		 * .collect(Collectors.toList()) );
		 */
		System.out.println(mountainBikes.stream().filter(mB -> mB.getBikeWeight() > 50)
				// Need to Add mB.size.getSizeWeight() + mBtype.getTypeWeight(); It is currently
				// concatenating instead of adding
				// .map(mB -> mB.size + "/" + mB.type + ":" + mB.color + "->" +
				// mB.size.getSizeWeight() + mB.type.getTypeWeight() +"\n")
				.map(mB -> mB.size + "/" + mB.type + ":" + mB.color + "->" + mB.getBikeWeight() + "\n")
				.collect(Collectors.toList()));
		// .collect(Collectors.groupingBy(MountainBike::getSize),
		// Collectors.groupingBy(MountainBike::getType),
		// Collectors.summingDouble(MountainBike::getBikeWeight));

		// Collectors.summingDouble(MountainBike::getMoutainBikeWeight)));

	}

//  Instance Variables
	private Type type;

	public Color getColor() {
		return color;
	}

	private Size size;
	private Color color;

//  OuterClass Constructor
	public MountainBike() {
	}

	public MountainBike(Type type, Size size, Color color) {
		this.type = type;
		this.size = size;
		this.color = color;
	}

//  OuterClass Methods
	// NO - do not want this method - code smell and not OOP. See getBikeWeight()
	/*
	 * public double getMoutainBikeWeight(Type type, Size size) { if (type ==
	 * Type.STEEL && size == Size.LARGE) { return Type.STEEL.getTypeWeight() +
	 * Size.LARGE.getSizeWeight(); } else if (type == Type.STEEL && size ==
	 * Size.SMALL) { return Type.STEEL.getTypeWeight() + Size.SMALL.getSizeWeight();
	 * } if (type == Type.ALUMINUM && size == Size.LARGE) { return
	 * Type.ALUMINUM.getTypeWeight() + Size.LARGE.getSizeWeight(); } else if (type
	 * == Type.ALUMINUM && size == Size.SMALL) { return
	 * Type.ALUMINUM.getTypeWeight() + Size.SMALL.getSizeWeight(); } if (type ==
	 * Type.CARBONFIBER && size == Size.LARGE) { return
	 * Type.CARBONFIBER.getTypeWeight() + Size.LARGE.getSizeWeight(); } else if
	 * (type == Type.CARBONFIBER && size == Size.SMALL) { return
	 * Type.CARBONFIBER.getTypeWeight() + Size.SMALL.getSizeWeight(); } return 0; }
	 */
	double getBikeWeight() {
		return this.size.getSizeWeight() + this.type.getTypeWeight();
	}

//  OuterClass Enum
	enum Color {
		REDWINEGLOSS, OLIVECHROME, BLUEMATTE, BLACKGLOSS;

		public Color getColor() {
//          System.out.println(this);
			return this;
		}
	}

	enum Size {
		SMALL, LARGE;

		public double getSizeWeight() {
			double small = 5;
			double large = 10;
			if (this == SMALL) {
//              System.out.println(small);
				return small;
			} else {
//              System.out.println(large);
				return large;
			}
		}
	}

	enum Type {
		STEEL, ALUMINUM, CARBONFIBER;

		public Type getType() {
			Type bikeType = this;
//          System.out.println(bikeType);
			return bikeType;
		}

		public double getTypeWeight() {
			double steel = 104.5;
			double aluminum = 45.7;
			double carbonfiber = 26.5;
			switch (this) {
			case STEEL:
//              System.out.println(steel);
				return steel;
			case ALUMINUM:
//              System.out.println(aluminum);
				return aluminum;
			case CARBONFIBER:
//              System.out.println(carbonfiber);
				return carbonfiber;
			}
			return 0;
		}
	}
}
