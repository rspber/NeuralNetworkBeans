/*
  Neural Network Example

  Copyright (c) 2024, rspber (https://github.com/rspber)

  based on: https://www.infoworld.com/article/3685569/how-to-build-a-neural-network-in-java.html

*/

package nn.example;

public class Main {

	public static void main(final String[] args) {

		final Network network = new Network();

		final Being[] knownInputs = new Being[] {
			new Being(115, 66,  1.0),	// male	
			new Being(175, 78,  0.0),	// female	
			new Being(205, 72,  0.0),	// female	
			new Being(120, 67,  1.0),	// male	
		};

		network.train(knownInputs);

		System.out.println();
		test(network, 175, 84);
		test(network, 105, 67);
		test(network, 120, 72);
		test(network, 143, 67);
		test(network, 130, 66);
	}

	private static void test(final Network network, final int height, final int weight) {
		System.out.println(String.format("%d, %d = %.15f", height, weight, network.predict(height, weight)));
	}
	
}

/*

   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . o . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 200..    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 190..    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 180..    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . . . . , . . o . , . . . ? , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 170..    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 160..    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 150..    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . ? . . , . . . . , . . . . , . . . . , . . . . ,      
 140..    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 130..    , . . . . , ? . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 120..    , . . . . , . x . . , . ? . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , x . . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 110..    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   7.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
   5.0    , . . . . , . ? . . , . . . . , . . . . , . . . . , . . . . ,      
   2.5    , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,      
 100      , . . . . , . . . . , . . . . , . . . . , . . . . , . . . . ,       
          6 . . . . 6 . . . . 7 . . . . 7 . . . . 8 . . . . 8 . . . . 9      
          0 . . . . 5 . . . . 0 . . . . 5 . . . . 0 . . . . 5 . . . . 0

*/