package com.jaspreetdhanjan.vecmath;

import java.nio.FloatBuffer;

public interface Vecmath<T> {
	public T set(FloatBuffer buffer);

	public void putInto(FloatBuffer buffer);
}