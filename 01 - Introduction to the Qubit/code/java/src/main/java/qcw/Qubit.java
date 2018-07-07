package qcw;

import java.util.Random;

import static java.lang.Math.sin;

class Qubit {

    private final Random random;
    private final double theta;

    Qubit(Random random) {
        this(0.0, random);
    }

    private Qubit(double theta, Random random) {
        this.theta = theta;
        this.random = random;
    }

    boolean measure() {
        return random.nextDouble() < square(sin(theta));
    }

    private double square(double value) {
        return value * value;
    }

    Qubit not() {
        return new Qubit(theta + Math.PI/2, random);
    }

    Qubit halfNot() {
        return new Qubit(theta + Math.PI/4, random);
    }
}
