package cs.vsu.ru.k2.g42.myshkevich_a_n.task;

import java.util.List;

public class FindNormals {
	public static Vector3f findPolygonsNormals(Vector3f... vs) {
		Vector3f a = vs[0].substract(vs[1]);
		Vector3f b = vs[0].substract(vs[2]);

		Vector3f c = vectorProduct(a, b);
		if (determinant(a, b, c) < 0) {
			c = vectorProduct(b, a);
		}

		return normalize(c);
	}

	public static Vector3f findVertexNormals(List<Vector3f> vs) {
		float xs = 0, ys = 0, zs = 0;

		for (Vector3f v : vs) {
			xs += v.x;
			ys += v.y;
			zs += v.z;
		}

		xs /= vs.size();
		ys /= vs.size();
		zs /= vs.size();

		return normalize(new Vector3f(xs, ys, zs));
	}

	public static double determinant(Vector3f a, Vector3f b, Vector3f c) {
		return a.x * (b.y * c.z) - a.y * (b.x * c.z - c.x * b.z) + a.z * (b.x * c.y - c.x * b.y);
	}

	public static Vector3f normalize(Vector3f v) {
		if (v == null) {
			return null;
		}

		double length = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z);

		if (length == 0) {
			return new Vector3f(0, 0, 0);
		}

		v.x /= length;
		v.y /= length;
		v.z /= length;

		return new Vector3f(v.x, v.y, v.z);
	}

	public static Vector3f vectorProduct(Vector3f a, Vector3f b) {
		return new Vector3f(a.y * b.z - b.y * a.z, -a.x * b.z + b.x * a.z, a.x * b.y - b.x * a.y);
	}
}
