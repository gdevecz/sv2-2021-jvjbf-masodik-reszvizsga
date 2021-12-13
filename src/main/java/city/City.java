package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;

    private long fullArea;

    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public void addBuilding(Building building) {
        if (fullArea >= building.getArea() + getActualArea()) {
            buildings.add(building);
        }
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public Building findHighestBuilding() {
        Building highest = buildings.get(0);
        for (Building building : buildings) {
            if (highest.getLevels() < building.getLevels()) {
                highest = building;
            }
        }
        return highest;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> buildingsOfStreet = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getAddress().getStreet().equals(street)) {
                buildingsOfStreet.add(building);
            }
        }
        return buildingsOfStreet;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numbersOfPeople) {
        for (Building building : buildings) {
            if (building.calculateNumberOfPeopleCanFit() > numbersOfPeople) {
                return true;
            }
        }
        return false;
    }

    private long getActualArea() {
        long sum = 0;
        for (Building building : buildings) {
            sum += building.getArea();
        }
        return sum;
    }
}
