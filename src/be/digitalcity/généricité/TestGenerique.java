package be.digitalcity.généricité;

public class TestGenerique {

    public int Addition( int a, int b) {
        return a + b;
    }

    public static <T extends Number> Number addition(T a, T b) {
        if (a.getClass().getSimpleName().equals(b.getClass().getSimpleName())) {
            switch (a.getClass().getSimpleName()) {
                case "Integer":
                    return (int) a + (int) b;
                case "Double":
                    return (double) a + (double) b;
                case "Float":
                    return (float) a + (float) b;
                //etc..
            }
        }
        throw new IllegalArgumentException("Mauvais type de données");
    }


}
