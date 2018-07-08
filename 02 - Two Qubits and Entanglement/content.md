## Combining Two Qubits
We know how to combine classical bits, it’s just the binary number system that we use everyday. For example, the combination of 2 bits have exactly 4 possible states, namely 00, 01, 10 and 11. Notice that although each bit exists separately, to have meaning the bits need to be considered together, as a single register, in a given combined state.

In a similar way quantum bits can be combined into quantum registers and, just as we saw that a quantum bit can be considered a mix or *superposition* of `True` and `False` states, so can the quantum registers be considered a superposition of their possible states, although unfortunately there is no easy way to intuitively visualise them as there is with the Bloch sphere of a single quantum bit.

In other words, the quantum register is some weighted superposition of `False`-`False` plus `False`-`True` plus `True`-`False` plus `True`-`True`. The weights of the components defines the combined state, just as it did in the single qubit case.

## Entanglement
When measured, a 2-bit quantum register will collapse to just one of 4 possible states, just as in the classical case.

What’s remarkable about quantum registers is that the number of possible states for the register *before* measurement is greater than the number of states that could produced from two single quantum bits working separately.

Let that sink in. 

Two linked, or entangled, quantum bits forming a 2-bit quantum register can be in a state which is not a combination of individual qubits! What's more, the measurement process collapses both qubits into a particular classical state, even if they are separated by great distances.

Einstein called this "spooky action at a distance" and the physical mechanisms behind it are still a mystery. Nonetheless it has been show and confirmed by many experiments and it is one of the remarkable facts that gives quantum computing its immense power and set it apart from classical computing.

To go deeper into the maths and coding examples: [Composing Qubits and Gates](ex02%20-%20composing%20qubits%20and%20gates.md)

To continue to the next section: Quantum algorithms (WIP)
