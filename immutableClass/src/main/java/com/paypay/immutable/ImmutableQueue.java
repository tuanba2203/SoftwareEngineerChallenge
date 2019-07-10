package com.paypay.immutable;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.LinkedList;

/**
 *  This class represents a Immutable Queue.
 *
 * @author tuanba
 *
 * @param <T>
 */
public final class ImmutableQueue<T> implements com.paypay.immutable.Queue<T> {
    private final Queue<T> queue;

    /**
     * Public default Constructor.
     */
    public ImmutableQueue() {
        this(new LinkedList<>());
    }

    /**
     * Private constructor to initialize a java.util.queue instance.
     * @param queue
     */
    private ImmutableQueue(Queue<T> queue) {
        this.queue = queue;
    }

    /**
     * Do add new element into queue.
     * @param t
     * @return
     */
    @Override
    public com.paypay.immutable.Queue<T> enQueue(T t) {
        this.queue.add(t);
        return new ImmutableQueue<>(queue);
    }

    /**
     * Do remove first element of queue.
     * @return
     * @throws NoSuchElementException if this queue is empty, hash no element
     */
    @Override
    public com.paypay.immutable.Queue<T> deQueue() {
        // throw empty exception if queue is empty
        if (this.queue.isEmpty())
            throw new NoSuchElementException();

        // If not empty, remove head and return content
        this.queue.poll();

        return new ImmutableQueue<>(queue);
    }

    /**
     * Do get the first element.
     * @return
     * @throws NoSuchElementException if this queue is empty, hash no element
     */
    @Override
    public T head() {
        return this.queue.element();
    }

    /**
     * Do check is queue empty or not.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
