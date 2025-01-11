import java.util.Arrays;
import java.util.Comparator;

public class LabWork4 {
    public static void main(String[] args) {
        int studentNumber = 4;
        int C11 = studentNumber % 11;
        System.out.println("C11: " + C11);

        try {
            if (C11 == 4) {
                MorskyChoven[] boats = new MorskyChoven[] {
                    new MorskyChoven("Вітерець", "Яхта", 2010, 25.5, "Одеса"),
                    new MorskyChoven("Бриз", "Катер", 2015, 15.0, "Київ"),
                    new MorskyChoven("Шторм", "Лайнер", 2005, 50.0, "Львів"),
                    new MorskyChoven("Рив'єра", "Ферйо", 2020, 10.5, "Харків"),
                    new MorskyChoven("Північ", "Фрегат", 2012, 30.0, "Дніпро")
                };

                System.out.println("Початковий масив:");
                for (MorskyChoven boat : boats) {
                    System.out.println(boat);
                }

                Arrays.sort(boats, Comparator.comparingInt(MorskyChoven::getYearBuilt)
                        .thenComparing(Comparator.comparingDouble(MorskyChoven::getLength).reversed()));

                System.out.println("\nВідсортований масив:");
                for (MorskyChoven boat : boats) {
                    System.out.println(boat);
                }
            } else {
                throw new UnsupportedOperationException("Невідомий варіант завдання для C11 = " + C11);
            }
        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class MorskyChoven {
    private String name;
    private String type;
    private int yearBuilt;
    private double length;
    private String homePort;

    public MorskyChoven(String name, String type, int yearBuilt, double length, String homePort) {
        this.name = name;
        this.type = type;
        this.yearBuilt = yearBuilt;
        this.length = length;
        this.homePort = homePort;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public double getLength() {
        return length;
    }

    public String getHomePort() {
        return homePort;
    }

    @Override
    public String toString() {
        return "МорськийЧовен{" +
                "назва='" + name + '\'' +
                ", тип='" + type + '\'' +
                ", рік побудови=" + yearBuilt +
                ", довжина=" + length +
                ", домашній порт='" + homePort + '\'' +
                '}';
    }
}
