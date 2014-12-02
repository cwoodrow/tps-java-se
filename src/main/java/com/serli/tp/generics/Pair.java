package com.serli.tp.generics;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkArgument;

public class Pair<T> {
    private final T left;
    private final T right;

    public Pair(T left, T right) {
        checkArgument(left != null);
        checkArgument(right != null);

        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }
}
