package com.paypay.immutable;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Class for testing.
 *
 * @author tuanba
 */
public class ImmutableQueueTests{

    // Immutable queue for empty testing
    private ImmutableQueue<Integer> emptyImQueue;
    // Immutable queue for testing with Integer
    private ImmutableQueue<Integer> integerImQueue;
    // Immutable queue for testing with String
    private ImmutableQueue<String> stringImQueue;
    private static final String FIRST = "first";
    private static final String SECOND = "second";
    private static final String THIRD = "third";
    private static final String FOURTH = "fourth";

    /**
     * Setup for testing.
     */
    @Before
    public void setup() {
        // Construct empty immutable queue
        emptyImQueue = new ImmutableQueue<>();
        // Construct Integer immutable queue
        integerImQueue = new ImmutableQueue<>();
        integerImQueue.enQueue(1);
        integerImQueue.enQueue(2);
        integerImQueue.enQueue(3);
        // Construct String immutable queue
        stringImQueue = new ImmutableQueue<>();
        stringImQueue.enQueue(FIRST);
        stringImQueue.enQueue(SECOND);
        stringImQueue.enQueue(THIRD);
    }

    // START - Empty ImmutableQueue Tests

    /**
     * Empty Check for Empty Immutable Queue.
     */
    @Test
    public void testEmptyQueueMustBeEmpty() {
        assertTrue(emptyImQueue.isEmpty());
    }

    /*
     * DeQueue check for Empty Immutable Queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void testEmptyQueueMustThrowExceptionWhenDequeue() {
        emptyImQueue.deQueue();
    }

    /**
     * Head check for Empty Immutable Queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void testEmptyQueueMustThrowExceptionWhenGetHead() {
        emptyImQueue.head();
    }

    // END - Empty ImmutableQueue Tests


    // START - Integer ImmutableQueue Tests

    /**
     * Empty Check for Integer Immutable Queue.
     */
    @Test
    public void testIntegerQueueMustBeNotEmpty() {
        assertFalse(integerImQueue.isEmpty());
    }

    /**
     * Do test with scenario: enQueue, deQueue, head.
     */
    @Test
    public void testIntegerQueueWithScenario() {
        // 1. do check current head of queue. Current queue elements order: [3, 2, 1]
        assertEquals(integerImQueue.head(), Integer.valueOf(1));
        // 2. do add new integer to queue.
        integerImQueue.enQueue(4);
        // 3. do remove head. Current queue elements order: [4, 3, 2, 1]
        integerImQueue.deQueue();
        // 4. do remove head. Current queue elements order: [4, 3, 2]
        integerImQueue.deQueue();
        // 5. do remove head. Current queue elements order: [4, 3]
        integerImQueue.deQueue();
        // 6. do check current head of queue. Current queue elements order: [4]
        assertEquals(integerImQueue.head(), Integer.valueOf(4));
        // 7. do remove head. Current queue elements order: [] => empty
        integerImQueue.deQueue();
        // 8. Empty Check for Immutable Queue after remove all elements.
        assertTrue(integerImQueue.isEmpty());
    }

    // END - Integer ImmutableQueue Tests


    // START - String ImmutableQueue Tests

    /**
     * Empty Check for Integer Immutable Queue.
     */
    @Test
    public void testStringQueueMustBeNotEmpty() {
        assertFalse(stringImQueue.isEmpty());
    }

    /**
     * Do test with scenario: enQueue, deQueue, head.
     */
    @Test
    public void testStringQueueWithScenario() {
        // 1. do check current head of queue. Current queue elements order: ["third", "second", "first"]
        assertEquals(stringImQueue.head(), FIRST);
        // 2. do add new integer to queue. Current queue elements order: ["third", "second", "first"]
        stringImQueue.enQueue(FOURTH);
        // 3. do remove head. Current queue elements order: ["fourth", "third", "second", "first"]
        stringImQueue.deQueue();
        // 4. do remove head. Current queue elements order: ["fourth", "third", "second"]
        stringImQueue.deQueue();
        // 5. do remove head. Current queue elements order: ["fourth", "third"]
        stringImQueue.deQueue();
        // 6. do check current head of queue. Current queue elements order: ["fourth"]
        assertEquals(stringImQueue.head(), FOURTH);
        // 7. do remove head. Current queue elements order: [] => empty
        stringImQueue.deQueue();
        // 8. Empty Check for Immutable Queue after remove all elements.
        assertTrue(stringImQueue.isEmpty());
    }

    // END - String ImmutableQueue Tests

}