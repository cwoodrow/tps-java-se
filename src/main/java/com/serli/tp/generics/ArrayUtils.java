package com.serli.tp.generics;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkArgument;

public final class ArrayUtils {
    private ArrayUtils(){}

    public static <T>  Collection<T> arrayToCollection(T[] array){
        checkArgument(array != null);

        Collection<T> collection = new ArrayList<T>();
        for(T element : array){
            collection.add(element);
        }
        return collection;
    }
}
