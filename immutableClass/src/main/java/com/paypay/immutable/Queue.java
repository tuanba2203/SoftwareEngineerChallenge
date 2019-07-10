package com.paypay.immutable;

/**
 *  This is an interface of Queue.
 *
 * @param <T>
 */
public interface Queue<T> {
    public Queue<T> enQueue(T t);
    // Removes the element at the beginning of the immutable queue, and returns the new queue.
    public Queue<T> deQueue();
    public T head();
    public boolean isEmpty();
}
