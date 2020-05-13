package com.paradise.think.enum19;

/**
 * @author Paradise
 */
public interface Generator<T> {
    /**
     * 随机产生
     *
     * @return T 随机
     */
    T next();
}
