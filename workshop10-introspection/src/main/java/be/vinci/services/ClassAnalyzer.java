package be.vinci.services;

import jakarta.json.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * Class analyzer. It saves a class into attribute, from a constructor, and
 * gives a lot of convenient methods to transform this into a JSON object
 * to print the UML diagram.
 */
public class ClassAnalyzer {

    private Class aClass;
    private JsonObjectBuilder objectBuilder;

    public ClassAnalyzer(Class aClass) {
        this.aClass = aClass;
    }

    public JsonObject getFullInfo() {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("name", aClass.getSimpleName());
        objectBuilder.add("fields", getFields());
        objectBuilder.add("methods", getMethods());
        return objectBuilder.build();
    }

    public JsonArray getMethods() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method: methods){
            arrayBuilder.add(getMethod(method));
        }
        // TODO Add all fields descriptions to array (use the getField() method above)
        return arrayBuilder.build();
    }

    /**
     * Get a method, and create a Json Object with all method data.
     * Example :
     * {
     *  name: "setFirstName",
     *  returnType: null,
     *  parameters: ["String"]
     *  visibility : "public" // public, private, protected, package
     *  isStatic: false,
     *  isAbstract: false
     * }
     */
    public JsonObject getMethod(Method m) {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("name", m.getName());
        objectBuilder.add("returnType", m.getReturnType().getSimpleName());
        objectBuilder.add("parameters", getParametersFromMethod(m));
        objectBuilder.add("visibility", getMethodVisibility(m));
        objectBuilder.add("isStatic", isMethodStatic(m));
        objectBuilder.add("isAbstract", isMethodAbstract(m));
        return objectBuilder.build();
    }

    /**
     * Get method visibility in a string form
     *
     * @param m the method to check
     * @return the visibility (public, private, protected, package)
     */
    private String getMethodVisibility(Method m) {
        if(Modifier.isProtected(m.getModifiers())){
            return "protected";
        }else if (Modifier.isPrivate(m.getModifiers())){
            return "private";
        }else if (Modifier.isPublic(m.getModifiers())){
            return "public";
        }else{
            return "package";
        }
    }

    private JsonArray getParametersFromMethod(Method m) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Class<?>[] parameters = m.getParameterTypes();
        for (Class<?> param: parameters) {
            arrayBuilder.add(param.getSimpleName());
        }
        return arrayBuilder.build();
    }

    /**
     * Get a field, and create a Json Object with all field data.
     * Example :
     * {
     * name: "firstname",
     * type: "String",
     * visibility : "private"  // public, private, protected, package
     * isStatic: false,
     * }
     */
    public JsonObject getField(Field f) {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("name", f.getName());
        objectBuilder.add("type", f.getType().getSimpleName());
        objectBuilder.add("visibility", getFieldVisibility(f));
        objectBuilder.add("isStatic", isFieldStatic(f));

        return objectBuilder.build();
    }

    /**
     * Get fields, and create a Json Array with all fields data.
     * Example :
     * [ {}, {} ]
     */
    public JsonArray getFields() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field: fields){
            arrayBuilder.add(getField(field));
        }
        // TODO Add all fields descriptions to array (use the getField() method above)
        return arrayBuilder.build();
    }

    /**
     * Return whether a field is static or not
     *
     * @param f the field to check
     * @return true if the field is static, false else
     */
    private boolean isFieldStatic(Field f) {
        return Modifier.isStatic(f.getModifiers());
    }

    /**
     * Return whether a method is static or not
     *
     * @param m the method to check
     * @return true if the method is static, false else
     */
    private boolean isMethodStatic(Method m) {
        return Modifier.isStatic(m.getModifiers());
    }

    /**
     * Return whether a method is static or not
     *
     * @param m the method to check
     * @return true if the method is static, false else
     */
    private boolean isMethodAbstract(Method m) {
        return Modifier.isAbstract(m.getModifiers());
    }

    /**
     * Get field visibility in a string form
     *
     * @param f the field to check
     * @return the visibility (public, private, protected, package)
     */
    private String getFieldVisibility(Field f) {
        // if protected -> return protected
        // ...
        if(Modifier.isProtected(f.getModifiers())){
            return "protected";
        }else if (Modifier.isPrivate(f.getModifiers())){
            return "private";
        }else if (Modifier.isPublic(f.getModifiers())){
            return "public";
        }else{
            return "package";
        }
    }

}
