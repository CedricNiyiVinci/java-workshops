package be.vinci.api;
// Import au moment de la compilation va se faire
import be.vinci.services.ClassAnalyzer;
import be.vinci.classes.User;
import jakarta.json.JsonStructure;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

/**
 * Send class data to make class diagrams
 * The class name must be given, and present into the "classes" package
 */
@Path("classes")
public class Classes {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonStructure getClassInfo(@QueryParam("classname") String classname) {
        ClassAnalyzer analyzer = null;
        try {
            //Recherche au moment de l'execution, il faut oublier la notion de directory
            analyzer = new ClassAnalyzer(Class.forName("be.vinci.classes." + classname));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return analyzer.getFullInfo();
    }
}
