package io.gitee.zicai.core.util;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Predicates
 *
 * @author zicai
 * @since 2019-01-23
 */
public abstract class Predicates {

    public static <T> Predicate<T> wrap(Predicate<T> predicate) {
        return predicate;
    }

    public static <T> Predicate<T> isTrue(boolean result) {
        return it -> result;
    }

    public static <T, R> Predicate<T> isTrue(Predicate<R> predicate, R r) {
        return it -> predicate.test(r);
    }

    public static <T> Predicate<T> isNull(Object o) {
        return it -> Objects.isNull(o);
    }

    public static <T> Predicate<T> notNull(Object o) {
        return it -> Objects.nonNull(o);
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }

    public static <T, R> Predicate<T> notEqual(R r, Function<T, R> mapper) {
        return isEqual(r, mapper).negate();
    }

    public static <T, R> Predicate<T> isEqual(R r, Function<T, R> mapper) {
        return compose(Predicate.isEqual(r), mapper);
    }

    public static <T, R> Predicate<T> compose(Predicate<R> predicate, Function<T, R> mapper) {
        return it -> predicate.test(mapper.apply(it));
    }

    public static <T> Predicate<T> in(Collection<T> collection) {
        return collection::contains;
    }

    public static <T, R> Predicate<T> in(Collection<R> collection, Function<T, R> mapper) {
        return it -> in(collection).test(mapper.apply(it));
    }

    public static <T> Predicate<T> notIn(Collection<T> collection) {
        return in(collection).negate();
    }

    public static <T, R> Predicate<T> notIn(Collection<R> collection, Function<T, R> mapper) {
        return in(collection, mapper).negate();
    }

}
