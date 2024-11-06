package cs.vsu.ru.k2.g42.myshkevich_a_n.task;

public class Vector3f {
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public boolean equals(Vector3f other) {
		final float eps = 1e-7f;
		return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps && Math.abs(z - other.z) < eps;
	}

	public Vector3f substract(Vector3f v) {
		float x = this.x - v.x;
		float y = this.y - v.y;
		float z = this.z - v.z;

		return new Vector3f(x, y, z);
	}

	public float[] getCoords() {
		return new float[] { this.x, this.y, this.z };
	}

	public void printVec() {
		System.out.println(x + " " + y + " " + z);
	}

	float x, y, z;
}