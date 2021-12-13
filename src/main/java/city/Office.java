package city;

public class Office extends Building {

    private String company;

    private int numberOfTablesPerLevel;

    private static final int MIN_AREA_FOR_TABLES = 2;

    private static final int MAX_AREA_FOR_TABLES = 5;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        if (isNumberOfTablesValid(area, levels, numberOfTablesPerLevel)) {
            this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        }
    }

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel * (getLevels() - 1);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    private boolean isNumberOfTablesValid(int area, int levels, int numberOfTablesPerLevel) {
        if (area < numberOfTablesPerLevel * MIN_AREA_FOR_TABLES
                || area > numberOfTablesPerLevel * MAX_AREA_FOR_TABLES) {
            throw new IllegalArgumentException("Not valid number of tables.");
        }
        return true;
    }
}
