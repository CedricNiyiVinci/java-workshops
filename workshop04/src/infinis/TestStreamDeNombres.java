package infinis;

import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class TestStreamDeNombres {

    private static double[] doubles;

    public static void main(String[] args) {
        doubles = new Random().doubles(10,0,100).toArray();

        System.out.println("1. Moyenne des racines carrée = "  + moyenneDesRacinesCarrees());
        System.out.println("\n2. Génération de streams infinis de doubles");
        listeDe10PuisTabDe20DoubleStream();
        listeDe10PuisTabDe20StreamDouble();
        System.out.println("\n3. 20 nombres entiers pairs entre 0 et 100");
        System.out.println(
                //TODO: générer le stream ici (faites d'abord les points 1. et 2.)
        );

    }

    /**
     * cf. point 1
     */
    private static double moyenneDesRacinesCarrees() {
        //TODO: utilisez DoubleStream.of(double... values)
        return 0.0;
    }

    /**
     * cf. point 2
     */
    private static DoubleStream randomDoubleStream(double maxValue) {
        //TODO: utiliser la fonction generate() de la classe DoubleStream
        return null;
    }

    /**
     * cf. point 2
     */
    private static Stream<Double> randomStreamDouble(double maxValue) {
        //TODO: utiliser la fonction generate() de la classe Stream
        return null;
    }

    /**
     * cf. point 2
     */
    private static void listeDe10PuisTabDe20DoubleStream() {
        List<Double> numsList = null;
        //TODO: utiliser randomDoubleStream pour initialiser numsList
        //      note : il est normal que que le collect(Collectors.toList())
        //      fonctionne pas comme d'abitude ;)
        System.out.println(numsList);

        double[] numTab = null;
        //TODO: utiliser randomDoubleStream pour initialiser numsTab
        System.out.print("{ ");
        for(double d : numTab) System.out.print(d + " ");
        System.out.println("}");
    }

    /**
     * cf. point 2
     */
    private static void listeDe10PuisTabDe20StreamDouble() {
        List<Double> numsList = null;
        //TODO: utiliser randomStreamDouble pour initialiser numsList
        System.out.println(numsList);

        double[] numTab = null;
        //TODO: utiliser randomStreamDouble pour initialiser numsTab
        //      note : il est normal que que le toArray ne fonctionne
        //      pas comme d'abitude ;)
        System.out.print("{ ");
        for(double d : numTab) System.out.print(d + " ");
        System.out.println("}");
    }

}
