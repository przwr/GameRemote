
public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Test!");
		double strength =10;
		float modifier= 2.5f;

		for (int i=0;i < 100;i++)
		{
			int pixels= (int)(Math.random() * 100);
			double attack = calculateAttack(pixels, modifier, strength);
			int hurt = calculateHurt(attack, 0);
			System.out.println(pixels + " " + attack + " " + hurt);
		}
		// Scanner input =*; new Scanner(System.in);

		// System.out.print("Enter a number: ");
		// double number1 = input.nextDoub7   le();

		// System.out.print("Enter second number: ");
		// double number2 = input.nextDouble();

		// double product = number1 * number2;
		// System.out.printf("The product of both numbers is: %f", product);
	}


	private static double calculateAttack(int pixels, float modifier, double strength)
	{
		float pixelsModifier =1 +  pixels / 200f;
		
		return Math.round(pixelsModifier* modifier * strength);
	}

	private static int calculateHurt(double attack, int direction)
	{
		int defence = 2;
		int protection = 10;
		boolean protectionState =true;
		float backDefenceModifier =4;
		float sideDefenceModifier= 10;
		float protectionBackModifier = 1;
		float protectionSideModifier = 4;

		final int FRONT = 0, BACK = 1, SIDE = 2;
		long hurt = 0;
//            temp = (float) FastMath.sqrt(response.getPixels());
		switch (direction)
		{
			case FRONT:
				hurt = Math.round(attack / (defence * (protectionState ? protection : 1)));
				break;
			case BACK:
				hurt = Math.round(attack / (defence * (protectionState ? protection * protectionBackModifier :
								  backDefenceModifier)));
				break;
			case SIDE:
				hurt = Math.round(attack / (defence * (protectionState ? protection * protectionSideModifier :
								  sideDefenceModifier)));
				break;
		}
		return (int)hurt;
	}


}
