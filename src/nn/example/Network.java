/*
  Neural Network Example

  Copyright (c) 2024, rspber (https://github.com/rspber)

  based on: https://www.infoworld.com/article/3685569/how-to-build-a-neural-network-in-java.html

*/

package nn.example;

public class Network {

	final Neuron[] neurons = new Neuron[] {
		new Neuron(),	// 0 = input
		new Neuron(),	// 1 = input
		new Neuron(),	// 2 = input
		new Neuron(),	// 3 = indirect
		new Neuron(),	// 4 = indirect
		new Neuron() 	// 5 = output
	};

	public double predict(final double input1, final double input2)
	{
		return neurons[5].compute(
			neurons[4].compute(
				neurons[0].compute(input1, input2),
				neurons[1].compute(input1, input2)
			),
			neurons[3].compute(
				neurons[1].compute(input1, input2),
				neurons[2].compute(input1, input2)
			)
		);
	}

	public double getNetworkLoss(final Being[] inputs)
	{
		double squareError = 0;
		for( final Being id : inputs ) {
			final double prediction = predict(id.height, id.weight);
			final double error = id.validAnswer - prediction;
			squareError += (error * error);
		}
		return squareError / inputs.length;
	}

	public void train(final Being[] trainInputs)
	{
		Double best = null;	// best epoch loss

		int epoch = 0;
		while( epoch < 1000 ) {

			final Neuron neuron = neurons[epoch % neurons.length];	// this epoch neuron
			neuron.mutate();

			double loss = getNetworkLoss(trainInputs);	// this epoch loss

			if( best == null || loss < best ) {
				best = loss;
			}
			else {
				neuron.restore();
			}

			if( epoch % 10 == 9 ) {
				System.out.println(String.format("Epoch: %5d | %.20f", epoch, best));
			}

			++epoch;
		}
/*
		System.out.println();
		for( final Neuron neuron : neurons ) {
			System.out.println(neuron);
		}
*/
	}

}
