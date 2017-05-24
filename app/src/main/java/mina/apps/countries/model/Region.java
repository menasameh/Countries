package mina.apps.countries.model;

public class Region implements Comparable<Region>{

    public String name;
    public int countriesCount;

    public Region(String name, int countriesCount) {
        this.name = name;
        this.countriesCount = countriesCount;
    }

    @Override
    public int compareTo(Region another) {
        return name.compareTo(another.name);
    }
}
