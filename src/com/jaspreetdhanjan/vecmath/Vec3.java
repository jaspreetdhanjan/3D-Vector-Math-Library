package com.jaspreetdhanjan.vecmath;

public class Vec3 {
	public static final Vec3 X = new Vec3(1f, 0f, 0f);
	public static final Vec3 Y = new Vec3(0f, 1f, 0f);
	public static final Vec3 Z = new Vec3(0f, 0f, 1f);

	public float x;
	public float y;
	public float z;

	public Vec3() {
		this(0, 0, 0);
	}

	public Vec3(float a) {
		this(a, a, a);
	}

	public Vec3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vec3(Vec3 r) {
		this.x = r.x;
		this.y = r.y;
		this.z = r.z;
	}

	public Vec3 set(Vec3 r) {
		this.x = r.x;
		this.y = r.y;
		this.z = r.z;
		return this;
	}

	public Vec3 set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	public Vec3 add(float r) {
		x += r;
		y += r;
		z += r;
		return this;
	}

	public Vec3 add(float xx, float yy, float zz) {
		x += xx;
		y += yy;
		z += zz;
		return this;
	}

	public Vec3 add(Vec3 r) {
		x += r.x;
		y += r.y;
		z += r.z;
		return this;
	}

	public Vec3 sub(float r) {
		x -= r;
		y -= r;
		z -= r;
		return this;
	}

	public Vec3 sub(float xx, float yy, float zz) {
		x -= xx;
		y -= yy;
		z -= zz;
		return this;
	}

	public Vec3 sub(Vec3 r) {
		x -= r.x;
		y -= r.y;
		z -= r.z;
		return this;
	}

	public Vec3 mul(Vec3 r) {
		x *= r.x;
		y *= r.y;
		z *= r.z;
		return this;
	}

	public Vec3 mul(float xx, float yy, float zz) {
		x *= xx;
		y *= yy;
		z *= zz;
		return this;
	}

	public Vec3 mul(float r) {
		x *= r;
		y *= r;
		z *= r;
		return this;
	}

	public Vec3 div(float r) {
		x /= r;
		y /= r;
		z /= r;
		return this;
	}

	public Vec3 div(Vec3 r) {
		x /= r.x;
		y /= r.y;
		z /= r.z;
		return this;
	}

	public Vec3 div(float xx, float yy, float zz) {
		x /= xx;
		y /= yy;
		z /= zz;
		return this;
	}

	public Vec3 clone() {
		return new Vec3(x, y, z);
	}

	public Vec3 normalise() {
		return div(length());
	}

	public float dot(Vec3 r) {
		return x * r.x + y * r.y + z * r.z;
	}

	public Vec3 mid(Vec3 r) {
		float xx = (x + r.x) / 2f;
		float yy = (y + r.y) / 2f;
		float zz = (z + r.z) / 2f;
		return set(xx, yy, zz);
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	public float distanceTo(Vec3 r) {
		float xd = r.x - x;
		float yd = r.y - y;
		float zd = r.z - z;
		return (float) Math.sqrt(xd * xd + yd * yd + zd * zd);
	}

	public float distanceToSqrt(Vec3 r) {
		float xd = r.x - x;
		float yd = r.y - y;
		float zd = r.z - z;
		return xd * xd + yd * yd + zd * zd;
	}

	public Vec3 rotX(float angle) {
		float sin = (float) Math.sin(angle);
		float cos = (float) Math.cos(angle);
		return set(x, cos * y + sin * z, cos * z - sin * y);
	}

	public Vec3 rotY(float angle) {
		float sin = (float) Math.sin(angle);
		float cos = (float) Math.cos(angle);
		return set(cos * x + sin * z, y, cos * z - sin * x);
	}

	public Vec3 rotZ(float angle) {
		float sin = (float) Math.sin(angle);
		float cos = (float) Math.cos(angle);
		return set(cos * x - sin * y, sin * x + cos * y, z);
	}

	public Vec3 cross(Vec3 r) {
		float xx = y * r.z - z * r.y;
		float yy = z * r.x - x * r.z;
		float zz = x * r.y - y * r.x;
		return set(xx, yy, zz);
	}

	public Vec3 lerp(Vec3 p, float t) {
		float xx = x + (p.x - x) * t;
		float yy = y + (p.y - y) * t;
		float zz = x + (p.z - z) * t;
		return set(xx, yy, zz);
	}

	public Vec3 mulAdd(Vec3 v, float s) {
		x += v.x * s;
		y += v.y * s;
		z += v.z * s;
		return this;
	}

	public float angle(Vec3 v) {
		float d = dot(v);
		float len = length() * v.length();
		return (float) Math.acos(d / len);
	}

	public Vec3 abs() {
		return set(Math.abs(x), Math.abs(y), Math.abs(z));
	}

	public Vec3 reciprocal() {
		float xx = 1f / x;
		float yy = 1f / y;
		float zz = 1f / z;
		return set(xx, yy, zz);
	}

	public Vec2 toVec2() {
		return new Vec2(x, y);
	}

	public String toString() {
		return "Vec3(" + x + ", " + y + ", " + z + ")";
	}

	public int hashCode() {
		return Float.floatToRawIntBits(x) ^ Float.floatToRawIntBits(y) ^ Float.floatToRawIntBits(z);
	}

	public boolean equals(Object o) {
		if (o instanceof Vec3) {
			Vec3 r = (Vec3) o;
			if (r.x == x && r.y == y && r.z == z) return true;
		}
		return false;
	}

	public Vec3 toInt() {
		return set((int) x, (int) y, (int) z);
	}
}