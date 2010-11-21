package com.pholser.junit.parameters.random;

import java.util.List;

public interface SourceOfRandomness {

	boolean nextBoolean();

	void nextBytes(byte[] bytes);

	byte[] nextBytes(int length);

	double nextDouble();

	float nextFloat();

	double nextGaussian();

	int nextInt();

	int nextInt(int n);

	long nextLong();

	void setSeed(long seed);

	<T> T oneOf(T... items);

	<T> T oneOf(List<T> items);

	<T> List<T> pick(int number, List<T> items);

	<T> List<T> pickUpTo(int number, List<T> items);

	String nextString();

}
