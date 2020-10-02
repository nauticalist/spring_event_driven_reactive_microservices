package io.seanapse.course.microservices.portservice.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Arrays;

@Document(collection = "ports")
public class Port {
    @Id
    private String id;

    @Version
    private Integer version;

    @Indexed(unique = true)
    private String portId;

    @TextIndexed
    private String portName;

    private String country;

    private String unLoCode;

    private double[] location;

    public Port() {
    }

    @PersistenceConstructor
    Port(String portId, String portName, String country, String unLoCode, double[] location) {
        super();
        this.portId = portId;
        this.portName = portName;
        this.country = country;
        this.unLoCode = unLoCode;
        this.location = location;
    }

    public Port(String portId, String portName, String country, String unLoCode, double latitude, double longitude) {
        super();
        this.portId = portId;
        this.portName = portName;
        this.country = country;
        this.unLoCode = unLoCode;
        this.location = new double[] { latitude, longitude };
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUnLoCode() {
        return unLoCode;
    }

    public void setUnLoCode(String unLoCode) {
        this.unLoCode = unLoCode;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Port)) return false;

        Port port = (Port) o;

        return new EqualsBuilder()
                .append(getId(), port.getId())
                .append(getVersion(), port.getVersion())
                .append(getPortId(), port.getPortId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getVersion())
                .append(getPortId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Port{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", portId='" + portId + '\'' +
                ", portName='" + portName + '\'' +
                ", country='" + country + '\'' +
                ", unLoCode='" + unLoCode + '\'' +
                ", location=" + Arrays.toString(location) +
                '}';
    }
}
