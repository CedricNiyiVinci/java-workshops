package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda {

    /**
     * Retourne une liste contenant uniquement les Integer qui correspondent
     * au predicat match
     * @param list La liste d'Integer originale
     * @param match le predicat à respecter
     * @return une liste contenant les integer qui respectent match
     */
    public static <E> List<E> allMatches(List<E> list, Predicate<E> match) {
        List<E> listDElement = new ArrayList<E>();
        for (E unElement: list) {
            if (match.test(unElement)){
                listDElement.add(unElement);
            }
        }
        return listDElement;
    }

    /**
     * Retourne une liste contenant tous les éléments de la liste originale, transformés
     * par la fonction transform
     * @param list La liste d'Integer originale
     * @param transform la fonction à appliquer aux éléments
     * @return une liste contenant les integer transformés par transform
     */
    public static <E, T> List<T> transformAll(List<E> list, Function<E, T> transform) {
        List<T> listDElement = new ArrayList<T>();
        for (int i = 0; i < list.size(); i++) {
            listDElement.add(transform.apply(list.get(i)));
        }
        return listDElement;
    }

    public static <E> List<E> filter(List<E> list, Predicate<E> match){
        return list.stream().filter(match).toList() ;//collect(Collectors.toList());
    }

    public static <E, T> List<T> map (List<E> list, Function<E, T> transform) {
        return list.stream().map(transform).toList();
    }
}
