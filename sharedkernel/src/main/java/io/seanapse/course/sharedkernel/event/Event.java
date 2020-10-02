package io.seanapse.course.sharedkernel.event;

import java.time.LocalDateTime;

public class Event<K, T> {

    private K key;
    private T data;
    private LocalDateTime eventCreatedAt;

    public Event() {
        this.key = null;
        this.data = null;
        this.eventCreatedAt = null;
    }

    public Event(K key, T data) {
        this.key = key;
        this.data = data;
        this.eventCreatedAt = LocalDateTime.now();
    }

    public K getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getEventCreatedAt() {
        return eventCreatedAt;
    }
}
