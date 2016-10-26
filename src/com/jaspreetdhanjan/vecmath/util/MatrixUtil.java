package com.jaspreetdhanjan.vecmath.util;

import com.jaspreetdhanjan.vecmath.Mat4;

public class MatrixUtil {
	/**
	 * Creates a normal matrix from the model-view matrix.
	 * 
	 * @param modelViewMatrix
	 *            the model-view matrix of the scene.
	 * 
	 * @return a new matrix with the normal information.
	 */
	public static Mat4 createNormalMatrix(Mat4 modelViewMatrix) {
		Mat4 normalMatrix = modelViewMatrix.clone();
		normalMatrix.m30 = 0f;
		normalMatrix.m31 = 0f;
		normalMatrix.m32 = 0f;
		normalMatrix.m33 = 1f;
		return normalMatrix.inverse().transpose();
	}
}