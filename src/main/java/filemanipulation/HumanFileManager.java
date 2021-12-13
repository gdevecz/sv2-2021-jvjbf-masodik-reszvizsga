package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try {
            List<String> rows = Files.readAllLines(path);
            humans.addAll(getHumansFromRows(rows));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            List<Human> males = getMales();
            Files.write(path, humansInRows(males));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private List<Human> getHumansFromRows(List<String> rows) {
        List<Human> newHumans = new ArrayList<>();
        for (String row : rows) {
            newHumans.add(getHumanFromRow(row));
        }
        return newHumans;
    }

    private Human getHumanFromRow(String row) {
        String[] data = row.split(";");
        return new Human(data[0], data[1]);
    }

    private List<String> humansInRows(List<Human> humans) {
        List<String> rows = new ArrayList<>();
        for (Human human : humans) {
            rows.add(human.printInCsv());
        }
        return rows;
    }

    private List<Human> getMales() {
        List<Human> males = new ArrayList<>();
        for (Human human : humans) {
            if (isMale(human)) {
                males.add(human);
            }
        }
        return males;
    }

    private boolean isMale(Human human) {
        return human.getIdentityNumber().startsWith("1")
                || human.getIdentityNumber().startsWith("3");
    }
}
