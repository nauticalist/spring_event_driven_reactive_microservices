package io.seanapse.course.microservices.portedgeservice.api.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePortRequest {
    @NotNull(message = "Port name must be provided.")
    @Size(min=2, max=100, message = "Port name must be minimum 2 maximum 100 characters.")
    private String portName;

    @NotNull(message = "Country must be provided.")
    @Size(min=2, max=100, message = "Country must be minimum 2 maximum 100 characters.")
    private String country;

    @NotNull(message = "Ports UN location code must be provided.")
    @Size(min=2, max=100, message = "Ports UN location code must be minimum 2 maximum 100 characters.")
    private String unLoCode;

    @DecimalMin(value = "-90.0", inclusive = false)
    @DecimalMax(value = "90.0", inclusive = false)
    private double latitude;

    @DecimalMin(value = "-180.0", inclusive = false)
    @DecimalMax(value = "180.0", inclusive = false)
    private double longitude;

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

        if (!(o instanceof CreatePortRequest)) return false;

        CreatePortRequest that = (CreatePortRequest) o;

        return new EqualsBuilder()
                .append(getLatitude(), that.getLatitude())
                .append(getLongitude(), that.getLongitude())
                .append(getPortName(), that.getPortName())
                .append(getCountry(), that.getCountry())
                .append(getUnLoCode(), that.getUnLoCode())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPortName())
                .append(getCountry())
                .append(getUnLoCode())
                .append(getLatitude())
                .append(getLongitude())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CreatePortRequest{" +
                "portName='" + portName + '\'' +
                ", country='" + country + '\'' +
                ", unLoCode='" + unLoCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
