package com.piniponselvagem.azerolib.utils.queries.lazy;

import com.piniponselvagem.azerolib.utils.queries.BaseQueries;
import com.piniponselvagem.azerolib.utils.queries.Queries;
import com.piniponselvagem.azerolib.utils.queries.lazy.iterators.FilterIterator;
import com.piniponselvagem.azerolib.utils.queries.lazy.iterators.LimitIterator;
import com.piniponselvagem.azerolib.utils.queries.lazy.iterators.MapIterator;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class LazyQueries<T> extends BaseQueries<T> {

    private LazyQueries(Iterable<T> src) {
        super(src);
    }

    @Override
    public Queries<T> filter(Predicate<T> filter) {
        return new LazyQueries<>(new Iterable<T>() {
            //Kept has an example without using lambda
            @Override
            public Iterator<T> iterator() {
                return new FilterIterator<>(src.iterator(), filter);
            }
        });
    }

    @Override
    public <R> Queries<R> map(Function<T, R> mapper) {
        return new LazyQueries<>(() -> new MapIterator<>(src.iterator(), mapper));
    }

    @Override
    public Queries<T> limit(int n) {
        return new LazyQueries<>(() -> new LimitIterator<>(src.iterator(), n));
    }

    public static <T> Queries<T> of(Iterable<T> src) {
        return new LazyQueries<>(src);
    }

    public static <T> Queries<T> from(T[] items) {
        return new LazyQueries<>(() -> new Iterator<T>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < items.length;
            }

            @Override
            public T next() {
                return items[i++];
            }
        });
    }
}
