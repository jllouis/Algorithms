/**
 * Created by lael on 9/5/16.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int N) // set id of each object to itself (N array accesses)
    {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int i) // chase parent pointers until reach root (depth of i accesses)
    {
        while (i != id[i])
        {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) // check if p and q have same root (depth accesses)
    {
        return root(p) == root(q);
    }

    public void union(int p, int q) // change root of p to point to root of q (depth accesses)
    {
        int i = root(p);
        int j = root(q);
        //id[i] = j;
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
    }
}
