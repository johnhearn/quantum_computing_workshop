As we saw in the previous section, a qubit generalises a classical bit by representing it as an arrow of length exactly 1.0 (by definition) pointing in any direction in 3D space. 

The direction represents a particular *state* of the qubit. 

Intuitively, rotating the arrow in any direction by any amount modifies the state of the qubit. This operation is called a *gate*. 

#### Step 1.

Write a test which instantiates a qubit representing the `False` or `0` state. Measure the qubit and assert that has 100% probability of being `False`.

Here is an example of what that test might look like in Java:
```java
@Test
public void () {
    Qubit qubit = Qubit.zero();
    assertThat(qubit.measure()).isTrue();
}
```

Hint:

Represent a qubit in code by a direction in 3D space. One obvious way of doing this is to define two angles, for example the co-latitude and longitude, as in the diagram below.

![angles](https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Bloch_sphere.svg/384px-Bloch_sphere.svg.png)


#### Step 2.

Represent in code a gate by an operation which rotates the qubit by a certain angle. That angle could be

```java
@Test
public void rotate_a_zero_qubit_by_180_degrees_and_produce_a_one_qubit() {
    Qubit qubit = Qubit.zero();
    NotGate gate = new NotGate();
    assertThat(gate.apply(qubit)).isEqualTo(Qubit.one());
}
```