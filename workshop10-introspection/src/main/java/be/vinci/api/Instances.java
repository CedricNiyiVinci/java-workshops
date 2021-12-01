package be.vinci.api;

import be.vinci.classes.User;
import be.vinci.instances.InstanceGraph1;
import be.vinci.services.ClassAnalyzer;
import be.vinci.services.InstancesAnalyzer;
import jakarta.json.JsonStructure;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Send instances graph data to make object diagrams
 *
 * The instances graphs are initialized by a class containing the "initInstanceGraph" method,
 * building the instance graph, and returning it.
 *
 * The "instance builder class name" must be given and present into the "instances" package
 */
@Path("instances")
public class Instances {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonStructure getInstanceGraphInfo(@QueryParam("builderclassname") String builderClassname) {
        Object builder = null;    // TODO change this line to use the query parameter, and generate dynamically the builder
        // Depuis Java 9 on ne peut pas faire Class.forName.newInstance
        // Pour créer une nouvelle Instance a partir d'une class il faut d'abord récupérer le constructeur de cette meme classe
        // Ensuite je peux invoquer la methode statique  de la class "Class" newInstance(); Ssi la classe en question
        // a un constructeur par defaut sans parametre
        try {
            builder = Class.forName("be.vinci.api.instances" + builderClassname).getConstructor().newInstance();
        } catch (InstantiationException  | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Utilisé Invoke avec methodeRecherchee et objet "builder"
        Method methodeRecherchee = builder.getClass().getMethod("initInstanceGraph");
        Object instanceGraph = builder.initInstanceGraph();   // TODO change this line to avoid calling initInstanceGraph() directly
        InstancesAnalyzer analyzer = new InstancesAnalyzer(instanceGraph);
        return analyzer.getFullInfo();
    }
}
