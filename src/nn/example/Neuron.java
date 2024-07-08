/*
  Neural Network Example

  Copyright (c) 2024, rspber (https://github.com/rspber)

  based on: https://www.infoworld.com/article/3685569/how-to-build-a-neural-network-in-java.html

*/

package nn.example;

import java.util.Random;

class Current {
	int which;		// 1 - weight1, 2-weight2, 0 - bias
	double value, correction;
}

public class Neuron {

	private final static int LEARNING_SPEED = 1;	// up to 10 max

	private Random random = new Random();

	private double random_1_1() {
		return 2 * random.nextDouble() - 1;   // -1 .. 1
	}
	
	private double weightInput1 = random_1_1();
	private double weightInput2 = random_1_1();
	private double bias         = random_1_1();

	private Current curr = new Current(); 

	public double compute(final double input1, final double input2)
	{
		final double res = (weightInput1 * input1) + (weightInput2 * input2) + bias;
		return 1 / (1 + Math.exp(-res));
	}

	public void mutate()
	{
		curr.which = random.nextInt(3);
		curr.correction = LEARNING_SPEED * random_1_1();		// correction
		switch( curr.which ) {
		case 1:
			curr.value = weightInput1; 
			weightInput1 += curr.correction;
			break;
		case 2:
			curr.value = weightInput2; 
			weightInput2 += curr.correction;
			break;
		case 0:
			curr.value = bias; 
			bias += curr.correction;
			break;
		}
	}

	public void restore()
	{
		switch( curr.which ) {
		case 1:
			weightInput1 = curr.value; 
			break;
		case 2:
			weightInput2 = curr.value; 
			break;
		case 0:
			bias = curr.value; 
			break;
		}
	}

	@Override
	public String toString() {
		return String.format("%.10f | %.10f | %.10f", weightInput1, weightInput2, bias );
	}
	
}
