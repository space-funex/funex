package space_funexp.github.com.funex.model;

import java.util.ArrayList;
import java.util.List;

public class SignificantArea {
    double longitude;
    double latitude;
    String name;
    String description;

    SignificantArea(double longitude, double latitude, String name, String description) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static List<SignificantArea> getSamples() {
        List<SignificantArea> l = new ArrayList<SignificantArea>();

        // https://liu.se/liu-nytt/arkiv/reportage/ett-lyft-for-flyg-och-miljo?l=en

        l.add(new SignificantArea(58.4034176,15.6530015, "RUAG Aerospace", "RUAG Space’s core business is the development and manufacture of subsystems & equipment for satellites and launch vehicles"));
        l.add(new SignificantArea(58.40414, 15.67543, "Saab Aeronautics", "Saab Aeronautics offers airborne systems, related subsystems, Unmanned Aerial Systems (UAS) and aerostructures. The business area Aeronautics is responsible for airframe structures for JAS 39 Gripen, and whole sections for Airbus, Boeing and NH90; and system development of the JAS 39 Gripen and the Skeldar VTOL UAV"));
        l.add(new SignificantArea(58.3984323,15.5757578, "Linköping University", "Linköping University provide research and education in a whide range of areas e.g. Aeronautical Engineering, Control Systems, Robotics and Autonomous Systems"));
        l.add(new SignificantArea(58.4135144,15.6159573, "Itceum", "Itceum is a computer museum with displays from several old computing systems with close ties to the development of avionics software, e.g. computer systems used for calculations on the jet fighter Saab 37 Viggen."));
        l.add(new SignificantArea(58.4098685,15.5230715, "Flygvapenmuseum", "The Swedish Air Force Museum, Flygvapenmuseum, in Linköping reflects the development of the Swedish military aviation from the early pioneers to the present day"));
        l.add(new SignificantArea(58.5890918,16.177274, "Visualiseringscenter C", "Visualization Center C is a research and science center in Norrköping, Sweden, conducting a unique mix of leading visualization research and public outreach activities. The center hosts a large-scale arena for public visits and events including media labs, interactive exhibitions and an immersive 3D fulldome theatre."));

        return l;
    }
}
