/*
  Neural Network Example

  Copyright (c) 2024, rspber (https://github.com/rspber)

  based on: https://www.infoworld.com/article/3685569/how-to-build-a-neural-network-in-java.html

*/

package nn.example;

public class Being {

	public final int height;	// input 1
	public final int weight;	// input 2
	public final double validAnswer;	// 0.0 = female,  1.0 = male

	public Being(final int height, final int weight, final double answer)
	{
		this.height = height;
		this.weight = weight;
		this.validAnswer = answer;
	}

}
