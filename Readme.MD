# Utility Functions

This is a Java project that includes several utility functions for grouping and counting letters in a string.

## Features

- Count Letters
- Group Sorted Letters

## Usage

```java
// Count Each Letter
String input1 = "We Always Mekar";
String input2 = "coding is fun";

System.out.println("Count Each Letter");
System.out.println("-".repeat(20));
countEachLetter(input1);
countEachLetter(input2);

// Group Sorted Letters
String[] letters = {"Abc", "bCd"};
String[] letters2 = {"Oke", "One"};
String[] letters3 = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};

System.out.println("\nGroup Sorted Letters");
System.out.println("-".repeat(20));
System.out.println(groupLetters(letters));
System.out.println(groupLetters(letters2));
System.out.println(groupLetters(letters3));
```
