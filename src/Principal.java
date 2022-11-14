import java.util.ArrayList;
import java.util.List;

interface ordenarAlf {
    void metodoOrdenarAlf();
}

interface ordenarLong {
    void metodoOrdenarLong();
}

interface metodoReferencia {
    void ordenamiento (List<String> food);
}

class ordenamiento {

    void ordenamientoAlf (List<String> food) {
        food.sort(new OrdenarAlfabeticamente());
        System.out.println("Ordenamiento alfabetico con método de referencia");
        for (String alf : food) {
            System.out.println(alf);
        }
        System.out.println();
    }

    void ordenamientoLong (List<String> food) {
        food.sort(new OrdenarLongitud());
        System.out.println("Ordenamiento por longitud con método de referencia");
        for (String longi : food) {
            System.out.println(longi);
        }
        System.out.println();
    }
}

public class Principal {

    static List<String> food = new ArrayList<>();

    public static void main(String[] args) {
        Principal principal = new Principal();
        food.add ("Carne");
        food.add ("Pizza");
        food.add ("Hambuerguesa");
        food.add ("Boneless");
        food.add ("Tacos");
        food.add ("Pescado");
        food.add ("Nachos");
        food.add ("Pastel");
        food.add ("Lasaña");
        food.add ("Helado");

        ordenarAlf Alf = new ordenarAlf() { // Clase anonima ordenar alfabeticamente
            @Override
            public void metodoOrdenarAlf() {
                food.sort(new OrdenarAlfabeticamente());
                System.out.println("Ordenamiento alfabetico con clase anonima");
                for (String alf : food) {
                    System.out.println(alf);
                }
                System.out.println();
            }
        };

        ordenarLong Long = new ordenarLong() { // Clase anonima ordenar por longitud
            @Override
            public void metodoOrdenarLong() {
                food.sort(new OrdenarLongitud());
                System.out.println("Ordenamiento por longitud con clase anonima");
                for (String longi : food) {
                    System.out.println(longi);
                }
                System.out.println();
            }
        };

        Alf.metodoOrdenarAlf(); // Alfabeticamente (Clase anonima)
        Long.metodoOrdenarLong(); // Longitud (Clase anonima)

        System.out.println("Ordenamiento alfabetico con expresión Lambda");
        principal.imprimirLista(principal.ordenAlfLambda()); // Alfabeticamente (Lambda)
        System.out.println();
        System.out.println("Ordenamiento por lomgitud con expresión Lambda");
        principal.imprimirLista(principal.ordenLongLambda()); // Longitud (Lambda)
        System.out.println();

        ordenamiento orden = new ordenamiento();
        metodoReferencia ordenAlf = orden::ordenamientoAlf;
        metodoReferencia ordenLong = orden::ordenamientoLong;
        ordenAlf.ordenamiento(food); // Alfabeticamente (Método de referencia)
        ordenLong.ordenamiento(food); // Longitud (Método de referencia)
    }

    public List<String> ordenAlfLambda() { // Lambda ordenar alfabeticamente
        List<String> food = Principal.food;
        food.sort((f1, f2) -> f1.compareToIgnoreCase(f2));
        return food;
    }

    public List<String> ordenLongLambda() { // Lambda ordenar por longitud
        List<String> food = Principal.food;
        food.sort((str1, str2) -> str1.length() - str2.length());
        return food;
    }

    public void imprimirLista(List<String> food){
        food.forEach(System.out::println);
    }
}