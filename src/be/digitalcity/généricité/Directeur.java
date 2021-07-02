package be.digitalcity.généricité;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Directeur <T extends Personnel> extends Personnel {
    public T assistant;

    public void setAssistant(Class<T> monTypeAssistant, String nomAssistant) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> ctor = monTypeAssistant.getConstructor(String.class);
        ctor.newInstance(nomAssistant);
    }

    public void afficher() {
        System.out.println(assistant);
    }
}
