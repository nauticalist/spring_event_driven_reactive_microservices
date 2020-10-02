package io.seanapse.course.sharedkernel.port.event;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PortCreatedEvent {
    private String portId;
    private String portName;

    public PortCreatedEvent() {
    }

    public PortCreatedEvent(String portId, String portName) {
        this.portId = portId;
        this.portName = portName;
    }

    public String getPortId() {
        return portId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PortCreatedEvent)) return false;

        PortCreatedEvent that = (PortCreatedEvent) o;

        return new EqualsBuilder()
                .append(getPortId(), that.getPortId())
                .append(getPortName(), that.getPortName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPortId())
                .append(getPortName())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "PortCreatedEvent{" +
                "portId='" + portId + '\'' +
                ", portName='" + portName + '\'' +
                '}';
    }
}
