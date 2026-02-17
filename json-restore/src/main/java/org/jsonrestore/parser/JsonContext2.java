package org.jsonrestore.parser;

import lombok.Getter;

import java.util.*;

public class JsonContext2 {
    private Stack<ContextValue> context;
    private Map<ContextValue, Integer> contextCount;
    @Getter
    private ContextValue current;

    public JsonContext2() {
        this.context = new Stack<>();
        this.contextCount = new HashMap<>();
        this.current = null;
    }

    /**
     * Set a new context value.
     *
     * @param value The context value to be added.
     */
    public void set(ContextValue value) {
        context.push(value);
        contextCount.putIfAbsent(value, 0);
        contextCount.put(value, contextCount.get(value) + 1);
        current = value;
    }

    /**
     * Remove the most recent context value.
     */
    public void reset() {
        try {
            ContextValue pop = context.pop();
            if (contextCount.get(pop) == 1) {
                contextCount.remove(pop);
            } else {
                contextCount.put(pop, contextCount.get(pop) - 1);
            }
            current = pop;
        } catch (EmptyStackException e) {
            current = null;
            contextCount.clear();
        }
    }

    public boolean contains(ContextValue value) {
        return contextCount.containsKey(value);
    }

    public boolean isEmpty() {
        return this.context.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("%s", context);
    }
}