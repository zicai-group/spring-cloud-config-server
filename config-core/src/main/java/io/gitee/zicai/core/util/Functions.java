package io.gitee.zicai.core.util;

import org.springframework.beans.BeanUtils;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Functions
 *
 * @author zicai
 * @since 2019-01-24
 */
public abstract class Functions {

    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return forMap(map, null);
    }

    public static <K, V> Function<K, V> forMap(Supplier<Map<K, V>> supplier) {
        return forMap(supplier.get());
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> map, V defaultValue) {
        return key -> map.getOrDefault(key, defaultValue);
    }

    public static <E> Function<Object, E> constant(E value) {
        return o -> value;
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return predicate::test;
    }

    public static <T> Function<Object, T> forSupplier(Supplier<T> supplier) {
        return o -> supplier.get();
    }

    public static <T> Function<T, T> forConsumer(Consumer<T> consumer) {
        return o -> { consumer.accept(o); return o;};
    }

    public static <T, R> Function<T, T> forConsumer(Function<T, R> foo, Consumer<R> consumer) {
        return o -> { consumer.accept(foo.apply(o)); return o;};
    }

    public static <T, R> Function<T, R> convert(Class<R> r) {
        return it -> {
            R o = BeanUtils.instantiateClass(r);
            BeanUtils.copyProperties(it, o);
            return o;
        };
    }
}
