# Work in progress

#
#
# Quantum Computing Workshop for Programmers

The world of quantum computing can be difficult to absorb at first, partly due to the unintuitive nature of quantum mechanics and partly due to the heavy mathematical language used to express it. 

In this workshop I’ve tried to convey the power and beauty of quantum computing in a way that programmers can understand. It introduces just enough maths and physics to get to grips with the subject without simplifiying to the point of absurdity.

Using practical exercises it moves from an intuitive understanding of the concepts through to the fundamental quantum algorithms.

Each section is organised into an explanation with the minimum maths followed by one or more programming exercises which introduce the mathematics and reenforce it with practical use. Each exercise builds on the last culminating in a basic working quantum computer simulator.

A reasonably high level of programming skills is assumed. If you want to learn programming then this is not the place. Also, a familiarity with linear algebra will also be useful but not necessary.

Exercises will be guided using tests, that is, I provide feature or unit tests and the challenge is to write the code to pass the tests. Hints will be given in Java so the ability to at least read Java will be useful.

This is the course that I wanted to do. I hope it’s of some use to someone else.


## Introduction to the Qubit

- Extending the classical bit
- Gates
- God *does* play dice

Exercises: representing the qubit, quantum randomness simulation

(Concepts: qubit, unitary state vector, unitary operator)

## Two Qubits, Entanglement

- The rules for composing two qubits
- Two qubit gates
- Conditional NOT
- Entanglement
- Partial measurement

Exercises: superdense coding, teleportation

(Concepts: tensor product of states and operators, entanglement)

## Multiple Qubits

- Composing several unitary gates (2^n)
- Oracles

Exercises: recursive tensor product, Grover's Search

## Further Topics

- Factoring a composite integer (Shor's Algorithm)
- Quantum computing SDKs and real quantum computers
- Implications for the future

# Online Resources

Michael Nielson's YouTube course - [Quantum Computing for the Determined](https://www.youtube.com/playlist?list=PL1826E60FD05B44E4)

Microsoft's Q# - [What is Quantum Computing?](https://docs.microsoft.com/en-us/quantum/quantum-concepts-1-intro?view=qsharp-preview)

Craig Gidney's [Quirk](http://algassert.com/quirk) online quantum circuit simulator and [blog](http://algassert.com/).

# License

[Creative Commons Attribution-ShareAlike 4.0 International License](http://creativecommons.org/licenses/by-sa/4.0/).

![Creative Commons Licence](https://i.creativecommons.org/l/by-sa/4.0/88x31.png)
