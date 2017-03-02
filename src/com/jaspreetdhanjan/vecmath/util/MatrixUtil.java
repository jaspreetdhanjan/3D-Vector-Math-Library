package com.jaspreetdhanjan.vecmath.util;

import com.jaspreetdhanjan.vecmath.Mat4;
import com.jaspreetdhanjan.vecmath.Vec3;

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
		normalMatrix.m41 = 0f;
		normalMatrix.m42 = 0f;
		normalMatrix.m43 = 0f;
		normalMatrix.m44 = 1f;
		return normalMatrix.inverse().transpose();
	}

	/**
	 * Creates a perspective matrix.
	 * 
	 * @param fov
	 *            the field-of-view.
	 * @param aspect
	 *            the aspect ratio.
	 * @param near
	 *            the near clipping plane.
	 * @param far
	 *            the far clipping plane.
	 * 
	 * @return this matrix.
	 */
	public static Mat4 createPerspectiveMatrix(float fov, float aspect, float near, float far) {
		Mat4 result = new Mat4();

		float yScale = (float) (1f / Math.tan(Math.toRadians(fov / 2f)));
		float xScale = yScale / aspect;
		float clipPlane = far - near;

		result.m11 = xScale;
		result.m22 = yScale;
		result.m33 = -((far + near) / clipPlane);
		result.m34 = -1f;
		result.m43 = -((2f * far * near) / clipPlane);
		result.m44 = 0f;
		return result;
	}

	/**
	 * Creates an orthographic matrix.
	 * 
	 * @param left
	 *            the left clipping plane.
	 * @param right
	 *            the right clipping plane.
	 * @param bottom
	 *            the bottom clipping plane.
	 * @param top
	 *            the top clipping plane.
	 * @param near
	 *            the near clipping plane.
	 * @param far
	 *            the far clipping plane.
	 * 
	 * @return this matrix.
	 */
	public Mat4 createOrthographicMatrix(float left, float right, float bottom, float top, float near, float far) {
		Mat4 result = new Mat4();

		float xOrth = 2f / (right - left);
		float yOrth = 2f / (top - bottom);
		float zOrth = -2f / (far - near);

		float tx = -(right + left) / (right - left);
		float ty = -(top + bottom) / (top - bottom);
		float tz = -(far + near) / (far - near);

		result.m11 = xOrth;
		result.m22 = yOrth;
		result.m33 = zOrth;
		result.m41 = tx;
		result.m42 = ty;
		result.m43 = tz;
		result.m44 = 1;
		return result;
	}

	/**
	 * Sets the matrix to a look at matrix with a direction and an up vector.
	 * 
	 * Multiply this with a translation matrix to get a camera model-view matrix.
	 * 
	 * @param eye
	 *            the position of the camera.
	 * @param center
	 *            the center position.
	 * @param up
	 *            the up director.
	 * 
	 * @return this matrix.
	 */
	public Mat4 lookAt(Vec3 eye, Vec3 center, Vec3 up) {
		Mat4 result = new Mat4();

		Vec3 forward = center.clone().sub(eye).normalise();
		Vec3 side = forward.clone().cross(up).normalise();
		up = side.clone().cross(forward);

		result.m11 = side.x;
		result.m12 = side.y;
		result.m13 = side.z;
		result.m21 = up.x;
		result.m22 = up.y;
		result.m23 = up.z;
		result.m31 = -forward.x;
		result.m32 = -forward.y;
		result.m33 = -forward.z;
		return result;
	}
}