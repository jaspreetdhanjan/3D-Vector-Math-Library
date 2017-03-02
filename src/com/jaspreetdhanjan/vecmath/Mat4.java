package com.jaspreetdhanjan.vecmath;

import java.nio.FloatBuffer;

/**
 * A row-major 4x4 matrix that is represented by 16 single-precision floating numbers.
 *
 * @author Jaspreet Dhanjan
 */

public class Mat4 implements Vecmath<Mat4> {
	public float m11, m12, m13, m14;
	public float m21, m22, m23, m24;
	public float m31, m32, m33, m34;
	public float m41, m42, m43, m44;

	// Constructors and setters

	/**
	 * Constructs an identity matrix.
	 */
	public Mat4() {
		identity();
	}

	/**
	 * Constructs a matrix with given parameters.
	 */
	public Mat4(float m11, float m12, float m13, float m14, float m21, float m22, float m23, float m24, float m31, float m32, float m33, float m34, float m41, float m42, float m43, float m44) {
		set(m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m33, m34, m41, m42, m43, m44);
	}

	/**
	 * Constructs a matrix using the attributes of anothing matrix.
	 * 
	 * @param otherMatrix
	 *            the matrix to copy.
	 */
	public Mat4(Mat4 otherMatrix) {
		set(otherMatrix.m11, otherMatrix.m12, otherMatrix.m13, otherMatrix.m14, otherMatrix.m21, otherMatrix.m22, otherMatrix.m23, otherMatrix.m24, otherMatrix.m31, otherMatrix.m32, otherMatrix.m33, otherMatrix.m34, otherMatrix.m41, otherMatrix.m42, otherMatrix.m43, otherMatrix.m44);
	}

	/**
	 * Sets the matrix values to the respective arguments.
	 * 
	 * @return this matrix.
	 */
	public Mat4 set(float m11, float m12, float m13, float m14, float m21, float m22, float m23, float m24, float m31, float m32, float m33, float m34, float m41, float m42, float m43, float m44) {
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m14 = m14;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m24 = m24;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
		this.m34 = m34;
		this.m41 = m41;
		this.m42 = m42;
		this.m43 = m43;
		this.m44 = m44;
		return this;
	}

	/**
	 * Sets the matrix values to the same arguments as the other matrix.
	 * 
	 * @param otherMatrix
	 *            the matrix to copy.
	 * 
	 * @return this matrix.
	 */
	public Mat4 set(Mat4 otherMatrix) {
		return set(otherMatrix.m11, otherMatrix.m12, otherMatrix.m13, otherMatrix.m14, otherMatrix.m21, otherMatrix.m22, otherMatrix.m23, otherMatrix.m24, otherMatrix.m31, otherMatrix.m32, otherMatrix.m33, otherMatrix.m34, otherMatrix.m41, otherMatrix.m42, otherMatrix.m43, otherMatrix.m44);
	}

	/**
	 * Sets the matrix values to the values of the FloatBuffer.
	 * 
	 * @param b
	 *            the FloatBuffer to copy.
	 * 
	 * @return this matrix.
	 */
	public Mat4 set(FloatBuffer b) {
		int pp = 0;
		return set(b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++));
	}

	/**
	 * Compresses the matrix information into the given FloatBuffer, ready for OpenGL usage.
	 * 
	 * @param tmpBuffer
	 *            the buffer where the matrix will be stored into.
	 */
	public void putInto(FloatBuffer tmpBuffer) {
		tmpBuffer.clear();
		tmpBuffer.put(m11).put(m12).put(m13).put(m14).put(m21).put(m22).put(m23).put(m24).put(m31).put(m32).put(m33).put(m34).put(m41).put(m42).put(m43).put(m44);
		tmpBuffer.flip();
	}

	/**
	 * Sets the values of the matrix to zero.
	 * 
	 * @return this matrix.
	 */
	public Mat4 setZero() {
		return set(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	/**
	 * Sets the values of the matrix to an identity matrix.
	 * 
	 * @return this matrix.
	 */
	public Mat4 identity() {
		return set(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
	}

	/**
	 * Translates the matrix by the vector r.
	 * 
	 * @param r
	 *            the translation vector.
	 * 
	 * @return this matrix.
	 */
	public Mat4 translate(Vec3 r) {
		return translate(r.x, r.y, r.z);
	}

	/**
	 * Translates the matrix by the given x, y, z values.
	 * 
	 * @param x
	 *            the x translation coordinate.
	 * @param y
	 *            the y translation coordinate.
	 * @param z
	 *            the z translation coordinate.
	 * 
	 * @return this matrix.
	 */
	public Mat4 translate(float x, float y, float z) {
		m41 += m11 * x + m21 * y + m31 * z;
		m42 += m12 * x + m22 * y + m32 * z;
		m43 += m13 * x + m23 * y + m33 * z;
		m44 += m14 * x + m24 * y + m34 * z;
		return this;
	}

	/**
	 * Rotates the matrix by a given angle on the x-axis.
	 * 
	 * @param angle
	 *            the angle to rotate by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 rotX(float angle) {
		return rotate(angle, Vec3.X);
	}

	/**
	 * Rotates the matrix by a given angle on the y-axis.
	 * 
	 * @param angle
	 *            the angle to rotate by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 rotY(float angle) {
		return rotate(angle, Vec3.Y);
	}

	/**
	 * Rotates the matrix by a given angle on the z-axis.
	 * 
	 * @param angle
	 *            the angle to rotate by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 rotZ(float angle) {
		return rotate(angle, Vec3.Z);
	}

	/**
	 * Rotates the matrix by a given angle on a given axis.
	 * 
	 * @param angle
	 *            the angle to rotate by.
	 * @param axis
	 *            the axis to rotate along.
	 * 
	 * @return this matrix.
	 */
	public Mat4 rotate(float angle, Vec3 axis) {
		float sin = (float) Math.sin(angle);
		float cos = (float) Math.cos(angle);
		float acos = 1f - cos;

		float xy = axis.x * axis.y;
		float yz = axis.y * axis.z;
		float xz = axis.x * axis.z;

		float xs = axis.x * sin;
		float ys = axis.y * sin;
		float zs = axis.z * sin;

		float f00 = axis.x * axis.x * acos + cos;
		float f01 = xy * acos + zs;
		float f02 = xz * acos - ys;

		float f10 = xy * acos - zs;
		float f11 = axis.y * axis.y * acos + cos;
		float f12 = yz * acos + xs;

		float f20 = xz * acos + ys;
		float f21 = yz * acos - xs;
		float f22 = axis.z * axis.z * acos + cos;

		float t00 = m11 * f00 + m21 * f01 + m31 * f02;
		float t01 = m12 * f00 + m22 * f01 + m32 * f02;
		float t02 = m13 * f00 + m23 * f01 + m33 * f02;
		float t03 = m14 * f00 + m24 * f01 + m34 * f02;
		float t10 = m11 * f10 + m21 * f11 + m31 * f12;
		float t11 = m12 * f10 + m22 * f11 + m32 * f12;
		float t12 = m13 * f10 + m23 * f11 + m33 * f12;
		float t13 = m14 * f10 + m24 * f11 + m34 * f12;

		m31 = m11 * f20 + m21 * f21 + m31 * f22;
		m32 = m12 * f20 + m22 * f21 + m32 * f22;
		m33 = m13 * f20 + m23 * f21 + m33 * f22;
		m34 = m14 * f20 + m24 * f21 + m34 * f22;

		m11 = t00;
		m12 = t01;
		m13 = t02;
		m14 = t03;
		m21 = t10;
		m22 = t11;
		m23 = t12;
		m24 = t13;
		return this;
	}

	/**
	 * Scales the matrix by the a vector r.
	 * 
	 * @param r
	 *            the vector to scale.
	 * 
	 * @return this matrix.
	 */
	public Mat4 scale(Vec3 r) {
		return scale(r.x, r.y, r.z);
	}

	/**
	 * Scales the matrix by the given x, y, z values.
	 * 
	 * @param x
	 *            the x translation coordinate.
	 * @param y
	 *            the y translation coordinate.
	 * @param z
	 *            the z translation coordinate.
	 * 
	 * @return this matrix.
	 */
	public Mat4 scale(float x, float y, float z) {
		m11 *= x;
		m12 *= x;
		m13 *= x;
		m14 *= x;
		m21 *= y;
		m22 *= y;
		m23 *= y;
		m24 *= y;
		m31 *= z;
		m32 *= z;
		m33 *= z;
		m34 *= z;
		return this;
	}

	/**
	 * Adds a scalar r to the matrix.
	 * 
	 * @param r
	 *            the value to add.
	 * 
	 * @return this matrix.
	 */
	public Mat4 add(float r) {
		m11 += r;
		m22 += r;
		m33 += r;
		m44 += r;
		return this;
	}

	/**
	 * Adds another matrix to this.
	 * 
	 * @param r
	 *            the value to add.
	 * 
	 * @return this matrix.
	 */
	public Mat4 add(Mat4 r) {
		m11 += r.m11;
		m12 += r.m12;
		m13 += r.m13;
		m14 += r.m14;
		m21 += r.m21;
		m22 += r.m22;
		m23 += r.m23;
		m24 += r.m24;
		m31 += r.m31;
		m32 += r.m32;
		m33 += r.m33;
		m34 += r.m34;
		m41 += r.m41;
		m42 += r.m42;
		m43 += r.m43;
		m44 += r.m44;
		return this;
	}

	/**
	 * Multiplies this matrix by a vector r.
	 * 
	 * @param r
	 *            the vector to multiply by.
	 * 
	 * @return a new vector with missing w component.
	 */
	public Vec3 mul(Vec3 r) {
		float x = m11 * r.x + m12 * r.y + m13 * r.z + m14;
		float y = m21 * r.x + m22 * r.y + m23 * r.z + m24;
		float z = m31 * r.x + m32 * r.y + m33 * r.z + m34;
		// float w = m41 * r.x + m42 * r.y + m33 * r.z + m44;
		return new Vec3(x, y, z);
	}

	/**
	 * Multiplies this matrix by a scalar s.
	 * 
	 * @param r
	 *            the value to multiply by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 mul(float s) {
		return set(m11 * s, m12 * s, m13 * s, m14 * s, m21 * s, m22 * s, m23 * s, m24 * s, m31 * s, m32 * s, m33 * s, m34 * s, m41 * s, m42 * s, m43 * s, m44 * s);
	}

	/**
	 * Multiplies this matrix by another matrix m.
	 * 
	 * @param m
	 *            the value to multiply by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 mul(Mat4 m) {
		m11 = m11 * m.m11 + m12 * m.m21 + m13 * m.m31 + m14 * m.m41;
		m12 = m11 * m.m12 + m12 * m.m22 + m13 * m.m32 + m14 * m.m42;
		m13 = m11 * m.m13 + m12 * m.m23 + m13 * m.m33 + m14 * m.m43;
		m14 = m11 * m.m14 + m12 * m.m24 + m13 * m.m34 + m14 * m.m44;

		m21 = m21 * m.m11 + m22 * m.m21 + m23 * m.m31 + m24 * m.m41;
		m22 = m21 * m.m12 + m22 * m.m22 + m23 * m.m32 + m24 * m.m42;
		m23 = m21 * m.m13 + m22 * m.m23 + m23 * m.m33 + m24 * m.m43;
		m24 = m21 * m.m14 + m22 * m.m24 + m23 * m.m34 + m24 * m.m44;

		m31 = m31 * m.m11 + m32 * m.m21 + m33 * m.m31 + m34 * m.m41;
		m32 = m31 * m.m12 + m32 * m.m22 + m33 * m.m32 + m34 * m.m42;
		m33 = m31 * m.m13 + m32 * m.m23 + m33 * m.m33 + m34 * m.m43;
		m34 = m31 * m.m14 + m32 * m.m24 + m33 * m.m34 + m34 * m.m44;

		m41 = m41 * m.m11 + m42 * m.m21 + m43 * m.m31 + m44 * m.m41;
		m42 = m41 * m.m12 + m42 * m.m22 + m43 * m.m32 + m44 * m.m42;
		m43 = m41 * m.m13 + m42 * m.m23 + m43 * m.m33 + m44 * m.m43;
		m44 = m41 * m.m14 + m42 * m.m24 + m43 * m.m34 + m44 * m.m44;
		return this;
	}

	/**
	 * Linearly interpolates between this matrix and the given matrix m.
	 * 
	 * @param m
	 *            the other matrix.
	 * @param t
	 *            the step size.
	 * 
	 * @return this matrix.
	 */
	public Mat4 lerpTo(Mat4 m, float t) {
		m11 *= (1 - t) + m.m11 * t;
		m12 *= (1 - t) + m.m12 * t;
		m13 *= (1 - t) + m.m13 * t;
		m14 *= (1 - t) + m.m14 * t;
		m21 *= (1 - t) + m.m21 * t;
		m22 *= (1 - t) + m.m22 * t;
		m23 *= (1 - t) + m.m23 * t;
		m24 *= (1 - t) + m.m24 * t;
		m31 *= (1 - t) + m.m31 * t;
		m32 *= (1 - t) + m.m32 * t;
		m33 *= (1 - t) + m.m33 * t;
		m34 *= (1 - t) + m.m34 * t;
		m41 *= (1 - t) + m.m41 * t;
		m42 *= (1 - t) + m.m42 * t;
		m43 *= (1 - t) + m.m43 * t;
		m44 *= (1 - t) + m.m44 * t;
		return this;
	}

	/**
	 * Multiplies the matrix by -1.
	 * 
	 * @return this matrix.
	 */
	public Mat4 negate() {
		return mul(-1f);
	}

	/**
	 * Gets the determinant of this matrix.
	 * 
	 * @return the value of the determinant.
	 */
	public float getDeterminant() {
		return m41 * m32 * m23 * m14 - m31 * m42 * m23 * m14 //
				- m41 * m22 * m33 * m14 + m21 * m42 * m33 * m14 //
				+ m31 * m22 * m43 * m14 - m21 * m32 * m43 * m14 //
				- m41 * m32 * m13 * m24 + m31 * m42 * m13 * m24 //
				+ m41 * m12 * m33 * m24 - m11 * m42 * m33 * m24 //
				- m31 * m12 * m43 * m24 + m11 * m32 * m43 * m24 //
				+ m41 * m22 * m13 * m34 - m21 * m42 * m13 * m34 //
				- m41 * m12 * m23 * m34 + m11 * m42 * m23 * m34 //
				+ m21 * m12 * m43 * m34 - m11 * m22 * m43 * m34 //
				- m31 * m22 * m13 * m44 + m21 * m32 * m13 * m44 //
				+ m31 * m12 * m23 * m44 - m11 * m32 * m23 * m44 //
				- m21 * m12 * m33 * m44 + m11 * m22 * m33 * m44;//
	}

	/**
	 * Inverses the matrix.
	 * 
	 * @throws a
	 *             RuntimeException if the matrix is singular (non-invertible).
	 * 
	 * @return this matrix.
	 */
	public Mat4 inverse() {
		if (!isInvertible()) {
			throw new RuntimeException("Non-Invertible matrix: " + this);
		}

		float determinant = getDeterminant();
		float invDeterminant = 1f / determinant;

		float t00 = m23 * m34 * m42 - m24 * m33 * m42 + m24 * m32 * m43 - m22 * m34 * m43 - m23 * m32 * m44 + m22 * m33 * m44;
		float t01 = m14 * m33 * m42 - m13 * m34 * m42 - m14 * m32 * m43 + m12 * m34 * m43 + m13 * m32 * m44 - m12 * m33 * m44;
		float t02 = m13 * m24 * m42 - m14 * m23 * m42 + m14 * m22 * m43 - m12 * m24 * m43 - m13 * m22 * m44 + m12 * m23 * m44;
		float t03 = m14 * m23 * m32 - m13 * m24 * m32 - m14 * m22 * m33 + m12 * m24 * m33 + m13 * m22 * m34 - m12 * m23 * m34;
		float t10 = m24 * m33 * m41 - m23 * m34 * m41 - m24 * m31 * m43 + m21 * m34 * m43 + m23 * m31 * m44 - m21 * m33 * m44;
		float t11 = m13 * m34 * m41 - m14 * m33 * m41 + m14 * m31 * m43 - m11 * m34 * m43 - m13 * m31 * m44 + m11 * m33 * m44;
		float t12 = m14 * m23 * m41 - m13 * m24 * m41 - m14 * m21 * m43 + m11 * m24 * m43 + m13 * m21 * m44 - m11 * m23 * m44;
		float t13 = m13 * m24 * m31 - m14 * m23 * m31 + m14 * m21 * m33 - m11 * m24 * m33 - m13 * m21 * m34 + m11 * m23 * m34;
		float t20 = m22 * m34 * m41 - m24 * m32 * m41 + m24 * m31 * m42 - m21 * m34 * m42 - m22 * m31 * m44 + m21 * m32 * m44;
		float t21 = m14 * m32 * m41 - m12 * m34 * m41 - m14 * m31 * m42 + m11 * m34 * m42 + m12 * m31 * m44 - m11 * m32 * m44;
		float t22 = m12 * m24 * m41 - m14 * m22 * m41 + m14 * m21 * m42 - m11 * m24 * m42 - m12 * m21 * m44 + m11 * m22 * m44;
		float t23 = m14 * m22 * m31 - m12 * m24 * m31 - m14 * m21 * m32 + m11 * m24 * m32 + m12 * m21 * m34 - m11 * m22 * m34;
		float t30 = m23 * m32 * m41 - m22 * m33 * m41 - m23 * m31 * m42 + m21 * m33 * m42 + m22 * m31 * m43 - m21 * m32 * m43;
		float t31 = m12 * m33 * m41 - m13 * m32 * m41 + m13 * m31 * m42 - m11 * m33 * m42 - m12 * m31 * m43 + m11 * m32 * m43;
		float t32 = m13 * m22 * m41 - m12 * m23 * m41 - m13 * m21 * m42 + m11 * m23 * m42 + m12 * m21 * m43 - m11 * m22 * m43;
		float t33 = m12 * m23 * m31 - m13 * m22 * m31 + m13 * m21 * m32 - m11 * m23 * m32 - m12 * m21 * m33 + m11 * m22 * m33;
		return set(t00, t01, t02, t03, t10, t11, t12, t13, t20, t21, t22, t23, t30, t31, t32, t33).mul(invDeterminant);
	}

	private boolean isInvertible() {
		return getDeterminant() != 0f;
	}

	/**
	 * Transposes the matrix to a column-major matrix.
	 * 
	 * @return this matrix.
	 */
	public Mat4 transpose() {
		float t00 = m11, t01 = m12, t02 = m13, t03 = m14;
		float t10 = m21, t11 = m22, t12 = m23, t13 = m24;
		float t20 = m31, t21 = m32, t22 = m33, t23 = m34;
		float t30 = m41, t31 = m42, t32 = m43, t33 = m44;
		return set(t00, t10, t20, t30, t01, t11, t21, t31, t02, t12, t22, t32, t03, t13, t23, t33);
	}

	/**
	 * Gets the reciprocal of this matrix.
	 * 
	 * @return this matrix.
	 */
	public Mat4 reciprocal() {
		return set(1f / m11, 1f / m12, 1f / m13, 1f / m14, 1f / m21, 1f / m22, 1f / m23, 1f / m24, 1f / m31, 1f / m32, 1f / m33, 1f / m34, 1f / m41, 1f / m42, 1f / m43, 1f / m44);
	}

	// java.lang.Object overrides

	public Mat4 clone() {
		return new Mat4(m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m33, m34, m41, m42, m43, m44);
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(m11).append(" ").append(m12).append(" ").append(m13).append(" ").append(m14).append("\n");
		b.append(m21).append(" ").append(m22).append(" ").append(m23).append(" ").append(m24).append("\n");
		b.append(m31).append(" ").append(m32).append(" ").append(m33).append(" ").append(m34).append("\n");
		b.append(m41).append(" ").append(m32).append(" ").append(m43).append(" ").append(m44).append("\n");
		return b.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(m11);
		result = prime * result + Float.floatToIntBits(m12);
		result = prime * result + Float.floatToIntBits(m13);
		result = prime * result + Float.floatToIntBits(m14);
		result = prime * result + Float.floatToIntBits(m21);
		result = prime * result + Float.floatToIntBits(m22);
		result = prime * result + Float.floatToIntBits(m23);
		result = prime * result + Float.floatToIntBits(m24);
		result = prime * result + Float.floatToIntBits(m31);
		result = prime * result + Float.floatToIntBits(m32);
		result = prime * result + Float.floatToIntBits(m33);
		result = prime * result + Float.floatToIntBits(m34);
		result = prime * result + Float.floatToIntBits(m41);
		result = prime * result + Float.floatToIntBits(m42);
		result = prime * result + Float.floatToIntBits(m43);
		result = prime * result + Float.floatToIntBits(m44);
		return result;
	}

	public boolean equals(Object o) {
		if (o instanceof Mat4) {
			Mat4 r = (Mat4) o;
			if (m11 != r.m11 && m12 != r.m12 && m13 != r.m13 && m14 != r.m14) return false;
			if (m21 != r.m21 && m22 != r.m22 && m23 != r.m23 && m24 != r.m24) return false;
			if (m31 != r.m31 && m32 != r.m32 && m33 != r.m33 && m34 != r.m34) return false;
			if (m41 != r.m41 && m42 != r.m42 && m43 != r.m43 && m44 != r.m44) return false;
			return true;
		}
		return false;
	}
}