# Vector Math Library

<h2>Introduction</h2>
A vector maths library written in Java for 2D or 3D projects.

Created by Jaspreet Dhanjan.

<h2>Features</h2>
- 4x4 Matrix type
- 2D and 3D Vectors
- Utilities like orthographic and perspective matrices
- Well tested
- No external libraries needed

<h2>Usage</h2>
All operations on instances of the object are designed to modify the attributes of the object itself.

```
	Vec3 a = new Vec3(1, 2, 1);
	Vec3 b = new Vec3(-1, 1, -1);
	a.add(b);
```

The instance of Vec3 "a" has now been reassigned to a+b or (0, 3, 0).

```
	Vec3 forward = new Vec3(0, 0, 1);
	Vec3 right = new Vec3(1, 0, 0);
	Vec3 up = forward.clone().cross(right);
```

The Vector-Math-Library overrides Java's `clone` method. You can use this to create a "copy" of a vector to store the result of any operations.

Most operations return the instance of itself – this allows for a fluent interface style by decluttering lines of code:

```
	float playerRotationX = 0.4245f;
	Vec3 playerPosition = new Vec3(2, 0, 5);
	Mat4 modelViewMatrix = new Mat4().identity().translate(playerPosition).rotX(playerRotationX);
```

Within 3 lines of code a model-view matrix has been created ready to send to OpenGL.

The Matrix API has been inherently designed for OpenGL use:

```
	FloatBuffer matrixBuffer = modelViewMatrix.export();
	glUniformMatrix4fv(mat4Location, false, matrixBuffer);
```

<h2>License</h2>
Free to use for anyone.
