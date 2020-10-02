package io.seanapse.course.sharedkernel.port.dto;

import java.util.Arrays;

public class PortResponseDTO {
    private String portId;
    private String portName;
    private String country;
    private String unLoCode;
    private double[] location;

    public PortResponseDTO() {
    }

    public PortResponseDTO(String portId, String portName, String country, String unLoCode, double[] location) {
        this.portId = portId;
        this.portName = portName;
        this.country = country;
        this.unLoCode = unLoCode;
        this.location = location;
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
    public String toString() {
        return "PortResponseDTO{" +
                "portId='" + portId + '\'' +
                ", portName='" + portName + '\'' +
                ", country='" + country + '\'' +
                ", unLoCode='" + unLoCode + '\'' +
                ", location=" + Arrays.toString(location) +
                '}';
    }
}
