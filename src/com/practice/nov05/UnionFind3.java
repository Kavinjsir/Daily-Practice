package com.practice.nov05;

public class UnionFind3 {
	private int[] parent;
	private int[] sz;
	private int count;

	public UnionFind3(int n) {
		count = n;
		sz = new int[count];
		parent = new int[count];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			sz[i] = 1;
		}
	}

	private int find(int p) {
		assert (p >= 0 && p < count);
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot) {
			return;
		}

		if(sz[pRoot] < sz[qRoot]) {
			parent[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		} else {
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
	}
}
