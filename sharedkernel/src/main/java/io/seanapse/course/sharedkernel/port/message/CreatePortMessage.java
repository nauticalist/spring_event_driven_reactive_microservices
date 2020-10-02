package io.seanapse.course.sharedkernel.port.message;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CreatePortMessage {
    private String portId;
    private String portName;
    private String country;
    private String unLoCode;
    private double latitude;
    private double longitude;

    public CreatePortMessage() {
    }

    public CreatePortMessage(String portId, String portName, String country, String unLoCode, double latitude, double longitude) {
        this.portId = portId;
        this.portName = portName;
        this.country = country;
        this.unLoCode = unLoCode;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CreatePortMessage)) return false;

        CreatePortMessage that = (CreatePortMessage) o;

        return new EqualsBuilder()
                .append(getLatitude(), that.getLatitude())
                .append(getLongitude(), that.getLongitude())
                .append(getPortId(), that.getPortId())
                .append(getPortName(), that.getPortName())
                .append(getCountry(), that.getCountry())
                .append(getUnLoCode(), that.getUnLoCode())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPortId())
                .append(getPortName())
                .append(getCountry())
                .append(getUnLoCode())
                .append(getLatitude())
                .append(getLongitude())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CreatePortMessage{" +
                "portId='" + portId + '\'' +
                ", portName='" + portName + '\'' +
                ", country='" + country + '\'' +
                ", unLoCode='" + unLoCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
