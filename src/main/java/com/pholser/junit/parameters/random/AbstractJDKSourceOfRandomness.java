package com.pholser.junit.parameters.random;

import static java.lang.Math.min;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

abstract class AbstractJDKSourceOfRandomness implements SourceOfRandomness {
	private final Random random;

	protected AbstractJDKSourceOfRandomness(Random random) {
		this.random = random;
	}

	@Override
	public boolean nextBoolean() {
		return random.nextBoolean();
	}

	@Override
	public void nextBytes(byte[] bytes) {
		random.nextBytes(bytes);
	}

	@Override
	public byte[] nextBytes(int length) {
		byte[] bytes = new byte[length];
		nextBytes(bytes);
		return bytes;
	}

	@Override
	public double nextDouble() {
		return random.nextDouble();
	}

	@Override
	public float nextFloat() {
		return random.nextFloat();
	}

	@Override
	public double nextGaussian() {
		return random.nextGaussian();
	}

	@Override
	public int nextInt() {
		return random.nextInt();
	}

	@Override
	public int nextInt(int n) {
		return random.nextInt(n);
	}

	@Override
	public long nextLong() {
		return random.nextLong();
	}

	@Override
	public String nextString() {
		return new String(nextBytes(nextInt(1024)));
	}

	@Override
	public void setSeed(long seed) {
		random.setSeed(seed);
	}

	public <T> T oneOf(T... items) {
		return oneOf(asList(items));
	}

	public <T> T oneOf(List<T> items) {
		return items.get(nextInt(items.size()));
	}

	public <T> List<T> pickUpTo(int number, List<T> items) {
		return pick(nextInt(number), items);
	}

	public <T> List<T> pick(int number, List<T> items) {
		List<T> itemsCopy = new ArrayList<T>(items);
		Collections.shuffle(itemsCopy, random);
		return itemsCopy.subList(0, min(number, items.size()));
	}

}
