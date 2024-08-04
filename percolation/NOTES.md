# Dynamic Connectivity (Union-find)

## the problem model

Given a set of N objects.

* Union command: Connect two objects.
* Find/connected query: is there a path connecting the two objects?

## Modelling the Connections

We assume "is connected to" is an equivalence relation

* Reflexive: `p` is connected to `p`.
* Symmetric: if `p` is connected to `q`, the `q` is connected to `p`.
* Transitive: of `p` is connected to `q` and `q` is connected to  `r`, then `p` is connected to `r`.

## Connected Components

Maximal set of objects that are mutually connected.

## Implementing the operations

Find query. Check if two objects are in the same component.

Union command. Replace components containing two objects with their union.

## Union-find data type (API)

Goal. Design efficient data structure for union-find.
* Number of objects `N` can be huge.
* Number of operations `M` can be huge.
* Find queries and union commands may be intermixed.

## Dynamic-connectivity client

* Read in number of objects `N` from standard input.
* Repeat:
    - read in pairs of integers from standard input
    - if they are not connected, connect them and print out the pair

| algorithm | worst-case time |
|:---------:|:---------------:|
| quick-find | $MN$ |
| quick-union | $MN$ |
| weighted QU | $N + M\lg(N)$ |
| QU + path compression | $N + M\lg(N)$ |
| weighted QU + path compression | $N + M\lg*(N)$ |
