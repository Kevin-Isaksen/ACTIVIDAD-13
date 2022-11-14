import java.util.Comparator;

public class OrdenarLongitud implements Comparator<String> {
    @Override
    public int compare(String f1, String f2) {

        if (f1.length() > f2.length()) {
            return 1;
        } else if (f1.length() < f2.length()) {
            return -1;
        }
        return 0;
    }
}
