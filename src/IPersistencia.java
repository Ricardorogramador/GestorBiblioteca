import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;

public interface IPersistencia<T> {
    void guardar(ArrayList<T> lista, String archivo) throws IOException;
    ArrayList<T> cargar(String archivo, Function<String, T> reconstructor) throws IOException;
}
