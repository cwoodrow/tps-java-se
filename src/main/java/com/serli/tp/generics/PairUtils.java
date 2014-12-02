package com.serli.tp.generics;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkArgument;

public final class PairUtils {
    private PairUtils(){}

    public static <T> boolean sameContent(Pair<T> p1, Pair<T> p2) {
        checkArgument(p1 != null);
        checkArgument(p2 != null);

        return p1.getLeft().equals(p2.getLeft()) &&
                p1.getRight().equals(p2.getRight());
    }
}
