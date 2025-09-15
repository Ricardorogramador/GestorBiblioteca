import java.io.IOException;
import java.util.ArrayList;

public interface IPersistencia {
    void guardar(ArrayList<?> lista, String archivo) throws IOException;
    ArrayList<?> cargar(String archivo) throws IOException;
}
