## Representing the Qubit
As we saw in the previous section, a qubit generalises a classical bit by representing it as an arrow of unit length pointing in any direction in a 3D space. The direction represents a particular *state* of the qubit. 

Therefore we can represent a qubit in code by a direction in 3D space. One way of doing this is to define two angles, for example the co-latitude θ and longitude φ, as in the diagram below.

![angles](Bloch_sphere_with_angles.png)

Intuitively, the closeness of the arrow to `False` (straight up) should be some function of the angle between them, θ. In fact, the state is definitely `False` when θ=0 and is definitely **not** `False` when θ=π (180º). Similarly the arrow is definitely `True` when θ=π (180º) and is definitely **not** `True` when θ=0. 

Everywhere else, the state is neither `True` AND `False` but rather combination or *superposition* of both, a bit of each.

(This kind of combination of states is popularised in the well known Schrodingers' cat thought experiment.)

So the amount of `False`ness goes from 100% when θ=0 down to 0% as θ goes to π (180º). That's a lot like the function *cos(θ/2)*.

Likewise the amount of `True`ness varies from 100% when θ=π down to zero when θ=0, that is the arrow is pointing straight up. That's a lot like the function *sin(θ/2)*<sup>[1]</sup>.

It seems natural to use trigonometric functions when dealing with angles and it turns out, and this is borne out by experiment, that these functions are indeed the right way to describe the weights of `True` and `False` in the state. There is a deep mathematical foundation to these weights that we are skimming over here but will come back to in the following sections.

What about φ? Mathematically we can use a complex factor of *e<sup>iφ</sup>* on either of the other weights to represent the angle. Using the imaginary number *i* is a mathematical trick to add another degree of rotation and this is where the maths gets heavier so we'll come back to this later. Given the high level of symmetry involved it turns out we can get a lot further without considering this angle yet.

## Measurement
Now as was mentioned earlier, God really does play dice. When a qubit is measured it *collapses* to either `True` or `False`, never anything in between, and it does this in an indeterministic way<sup>[2]</sup>. 

Quantum mechanics gives us the formula for calculating the probability of a given measured state. It is the square of its weight, namely, *cos<sup>2</sup>(θ/2)* for `False` and *sin<sup>2</sup>(θ/2)* `True`. Conveniently the sum of these trigonometric functions [add up to exactly 100%](https://en.wikipedia.org/wiki/Pythagorean_trigonometric_identity), that is to say, the measurement will result in one of these outcomes and no other. Again this has been demonstrated beyond any possible doubt by numerous experiments.

## A quantum random bit generator
We now have enough information to simulate a single qubit and use that qubit and its properties to simulate the generation of random bits. Not very useful but it's a start. Let's model the concepts in a feature test.

#### Step 1. Write a feature test which instantiates 100 qubits in the `False` state and then rotates the state by 90º. *Measure* all the qubits and assert that the probability of each being `False` is close to 50%.
Hint: here is an example of what that test might look like in Java:
```java
    @Test
    void quantum_random_bit_generator() {
        QubitSource qubitSource = new QubitSource(new Random(1));
        assertThat(Stream.generate(qubitSource::prepareFalse)
                .limit(100L)
                .map(Qubit::halfNot)
                .filter(Qubit::measure)
                .count()).isBetween(45L, 55L); // ~50% False ~50% True
    }
```
It uses Java's build in `Stream` class to generate 100 qubits prepared by a quantum source to be in the `False` state, it then rotates them by 90º (a so called [√NOT or NOT<sup>½</sup> gate]https://en.wikipedia.org/wiki/Quantum_logic_gate#Square_root_of_NOT_gate_(%E2%88%9ANOT))) and then ensures that the measured number of random `True` states is around 50%.

This is just an example of a test for the random bit generator. There are a million other ways to write this test, in any number of languages. Choose the one that you are most comfortable with.

#### Step 2. Generate empty classes to make the test compile.
In the real world quantum bits must be prepared before use so the `QubitSource` class represents the aparatus to prepare the qubit. A Qubit class will also naturally be needed.

#### Step 3. Write a unit test for the QubitSource class.
This will initially just instanciate a new, empty Qubit object. We'll implement the `prepareFalse()` method to do that.

#### Step 4. Write a unit test which instantiates 100 of a Qubit in state `False`.
Like the feature test, create 100 instances and but this time measure all of them to ensure 100% of them are `false`. For the moment a `measure` method/function which always returns `false` wil be sufficient.

#### Step 5. Write a unit test which instantiates 100 qubits in the `True` state. *Measure* all the qubits and assert that the probability of each being `True` is 100%.
This test will be very similar to step 4 however we won't create qubits in the `True` state directly but rather use a 180º rotation (a `NOT` operation) of the `False` qubit.

Hint:
```java
	@Test
	void create_100_true_qubits() {
		assertTrue(Stream.generate(() -> new Qubit())
            .map(Qubit::not)
			.limit(100)
			.allMatch(Qubit::measure));
	}
```
Create the new methods with empty implementations and make sure the test fails.

By this stage `Qubit` will need a field representing the Qubit state internally and you will have to manipulate that state by simple operations. The measurement will check the state and return a boolean `true` or `false` accordingly.

#### Step 6. Write a unit test for the Qubit class which represents a √NOT gate by an operation on the qubit which rotates it by an angle of 90º.
A new `halfNot()` method rotates by 90º leaving the qubit in a half-`True`, half-`False` state, i.e. the probability of measuring the qubit as `True` or `False` is 50% in both cases.

Prepare for the test by making sure that the internal state of the Qubit is represented by an angle, if you haven't already done so, and then run all the previous tests again. They should continue to pass. 

We saw earlier, the probability of a particular result is given by trigonometric funtions of its angle, namely, *cos<sup>2</sup>(θ/2)* for `False` and *sin<sup>2</sup>(θ/2)* `True`. Implement the `measure()` method using these functions. All tests should continue to pass.

The feature test should now also pass and we have simulated our first quantum system!


# Footnotes

1. Another way to look at it is to turn the sphere upside down. Following the same argument we can see that by symmetry the weight of the `True` component should be *cos(π/2 - θ/2)*. This is equal to *sin(θ/2)*. 
2. This is one of the enigmas quantum mechanics. In fact, it is thought that the underlying "local" state of the qubit is hidden from view in a fundamental way. See Bell's Theorem.

# Glossary

1. *Unit* vector is often used in mathematics to mean "an arrow of length exactly 1.0". 
2. An a *unitary* operation means any operation on a unit vector which results in another unit vector. A rotation is one example.