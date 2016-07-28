package com.jaspreetdhanjan.vecmath;

public class Vec2 {
	public float x;
	public float y;

	public Vec2() {
		this(0, 0);
	}

	public Vec2(float a) {
		this(a, a);
	}

	public Vec2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vec2(Vec2 r) {
		this.x = r.x;
		this.y = r.y;
	}

	public Vec2 set(Vec2 r) {
		this.x = r.x;
		this.y = r.y;
		return this;
	}

	public Vec2 set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Vec2 add(float r) {
		x += r;
		y += r;
		return this;
	}

	public Vec2 add(float xx, float yy) {
		x += xx;
		y += yy;
		return this;
	}

	public Vec2 add(Vec2 r) {
		x += r.x;
		y += r.y;
		return this;
	}

	public Vec2 sub(float r) {
		x -= r;
		y -= r;
		return this;
	}

	public Vec2 sub(float xx, float yy) {
		x -= xx;
		y -= yy;
		return this;
	}

	public Vec2 sub(Vec2 r) {
		x -= r.x;
		y -= r.y;
		return this;
	}

	public Vec2 mul(float r) {
		x *= r;
		y *= r;
		return this;
	}

	public Vec2 mul(float xx, float yy) {
		x *= xx;
		y *= yy;
		return this;
	}

	public Vec2 mul(Vec2 r) {
		x *= r.x;
		y *= r.y;
		return this;
	}

	public Vec2 div(float r) {
		x /= r;
		y /= r;
		return this;
	}

	public Vec2 div(float xx, float yy) {
		x /= xx;
		y /= yy;
		return this;
	}

	public Vec2 div(Vec2 r) {
		x /= r.x;
		y /= r.y;
		return this;
	}

	public Vec2 clone() {
		return new Vec2(x, y);
	}

	public float dot(Vec2 r) {
		return x * r.x + y * r.y;
	}

	public Vec2 normalise() {
		return div(length());
	}

	public Vec2 mid(Vec2 r) {
		float xx = (x + r.x) / 2f;
		float yy = (y + r.y) / 2f;
		return set(xx, yy);
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public float distanceTo(Vec2 r) {
		float xd = r.x - x;
		float yd = r.y - y;
		return (float) Math.sqrt(xd * xd + yd * yd);
	}

	public float distanceToSqrt(Vec2 r) {
		float xd = r.x - x;
		float yd = r.y - y;
		return xd * xd + yd * yd;
	}

	public Vec2 rot(float angle) {
		float cos = (float) Math.cos(angle);
		float sin = (float) Math.sin(angle);
		return new Vec2(cos * x, sin * y);
	}

	public float cross(Vec2 s) {
		return x * s.y - y * s.x;
	}

	public Vec2 lerpTo(Vec2 p, float t) {
		float xx = x + (p.x - x) * t;
		float yy = y + (p.y - y) * t;
		return set(xx, yy);
	}

	public Vec2 mulAdd(Vec2 v, float s) {
		x += v.x * s;
		y += v.y * s;
		return this;
	}

	public Vec2 abs() {
		return set(Math.abs(x), Math.abs(y));
	}

	public Vec2 reciprocal() {
		return set(1f / x, 1f / y);
	}

	public String toString() {
		return "Vec2(" + x + ", " + y + ")";
	}

	public int hashCode() {
		return Float.floatToRawIntBits(x) ^ Float.floatToRawIntBits(y);
	}

	public boolean equals(Object o) {
		if (o instanceof Vec2) {
			Vec2 r = (Vec2) o;
			if (x == r.x && y == r.y) return true;
		}
		return false;
	}
}