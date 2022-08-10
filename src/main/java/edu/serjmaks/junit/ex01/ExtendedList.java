package edu.serjmaks.junit.ex01;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExtendedList<E> extends ArrayList<E> {

    @SafeVarargs
    public ExtendedList(E... elems) {
        Collections.addAll(this, elems);
    }

    public <R> List<R> map(Function<E, R> mapper) {
        ExtendedList<R> result = new ExtendedList<>();
        for (E elem : this) {
            R mapped = mapper.apply(elem);
            result.add(mapped);
        }
        return result;
    }

    public List<E> fill(Supplier<E> supplier, int elemCount) {
        ExtendedList<E> result = new ExtendedList<>();
        for (int i = 0; i < elemCount; i++) {
            result.add(supplier.get());
        }
        return result;
    }

    public boolean forAll(Predicate<E> predicate) {
        for (E elem : this) {
            if (!predicate.test(elem)) {
                return false;
            }
        }
        return true;
    }

    public Map<Boolean, List<E>> partition(Predicate<E> predicate) {
        List<E> listTrue = new ArrayList<>();
        List<E> listFalse = new ArrayList<>();
        for (E elem : this) {
            if (predicate.test(elem)) {
                listTrue.add(elem);
            } else {
                listFalse.add(elem);
            }
        }
        Map<Boolean, List<E>> result = new HashMap<>();
        result.put(true, listTrue);
        result.put(false, listFalse);
        return result;
    }

    public E reduce(BinaryOperator<E> binaryOperator, E identity) {
        E result = identity;
        for (E element : this) {
            result = binaryOperator.apply(result, element);
        }
        return result;
    }
}
