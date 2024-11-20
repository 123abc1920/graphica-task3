package cs.vsu.ru.k2.g42.myshkevich_a_n.normal;

import java.util.List;

import cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Vector3f;

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
			xs += v.getX();
			ys += v.getY();
			zs += v.getZ();
		}

		xs /= vs.size();
		ys /= vs.size();
		zs /= vs.size();

		return normalize(new Vector3f(xs, ys, zs));
	}

	public static double determinant(Vector3f a, Vector3f b, Vector3f c) {
		return a.getX() * (b.getY() * c.getZ()) - a.getY() * (b.getX() * c.getZ() - c.getX() * b.getZ())
				+ a.getZ() * (b.getX() * c.getY() - c.getX() * b.getY());
	}

	public static Vector3f normalize(Vector3f v) {
		if (v == null) {
			return null;
		}

		double length = Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY() + v.getZ() * v.getZ());

		if (length == 0) {
			return new Vector3f(0, 0, 0);
		}

		v.setX((float) (v.getX() / length));
		v.setY((float) (v.getY() / length));
		v.setZ((float) (v.getZ() / length));

		return new Vector3f(v.getX(), v.getY(), v.getZ());
	}

	public static Vector3f vectorProduct(Vector3f a, Vector3f b) {
		return new Vector3f(a.getY() * b.getZ() - b.getY() * a.getZ(), -a.getX() * b.getZ() + b.getX() * a.getZ(),
				a.getX() * b.getY() - b.getX() * a.getY());
	}
}
