package reflection;

import java.lang.reflect.*;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Engine himsen = new Engine();
        System.out.println(himsen);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Class engineClass = Class.forName(Engine.class.getName());
        Object object = engineClass.newInstance();
        System.out.println("himsen object -> " + object + "\n");


        //Interfaces
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n" + "\t" + "INTERFACES" + "\n");

        Class[] arrayOfInterfaces = engineClass.getInterfaces();
        for (Class i : arrayOfInterfaces) {
            System.out.println(i.getName());
        }

        //Methods
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n" + "\t" + "METHODS" + "\n");

        Method[] arrayOfMethods = engineClass.getDeclaredMethods();

        for (Method method : arrayOfMethods) {
            System.out.println(method.getName());
        }


        //Invoke Method
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n" + "\t" + "INVOKED PRIVATE METHOD" + "\n");

        invokePrivateMethod(engineClass,himsen,"turningByAir");


        //Constructor
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n" + "\t" + "CONSTRUCTORS" + "\n");

        Constructor[] arrayOfConstructors = engineClass.getDeclaredConstructors();

        int indexNumber = 1;
        for (Constructor constructor : arrayOfConstructors) {
            System.out.println("\n" + indexNumber++ + "\t" + " NAME - > " + constructor.getName());

            Parameter[] arrayOfParameters = constructor.getParameters();
            for (Parameter parameter : arrayOfParameters) {
                System.out.println("\t" + " Name " + parameter.getName() + "\t" + "Type " + parameter.getType());
            }

            int modifiers = constructor.getModifiers();
            System.out.println("\t" + " MODIFIER " + getModifiers(modifiers));
        }

        //Fields
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n" + "\t" + "FIELDS" + "\n");

        Field[] arrayOfFields = engineClass.getDeclaredFields();

        for (Field field : arrayOfFields) {
            System.out.println(field.getName());
        }
    }

    public static void invokePrivateMethod(Class engineClass, Engine engine, String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method privateMethod = engineClass.getDeclaredMethod(methodName);
        privateMethod.setAccessible(true);
        privateMethod.invoke(engine, null);
    }

    public static String getModifiers(int modifiers) {

        StringBuilder answer = new StringBuilder();

        if (Modifier.isAbstract(modifiers)) answer.append(" abstract ");
        if (Modifier.isPublic(modifiers)) answer.append(" public ");
        if (Modifier.isFinal(modifiers)) answer.append(" final ");
        if (Modifier.isStatic(modifiers)) answer.append(" static ");
        if (Modifier.isPrivate(modifiers)) answer.append(" private ");

        return answer.toString();
    }

}
