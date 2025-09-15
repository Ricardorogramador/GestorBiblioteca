import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class PersistenciaTXT implements IPersistencia{
    @Override
    public void guardar(ArrayList<?> lista, String archivo) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            for (Object obj : lista){
                bw.write(obj.toString());
                bw.newLine();
            }
        }
    }
    @Override
    public ArrayList<?> cargar(String archivo) throws IOException {
        ArrayList<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null){
                lista.add(line);
            }
        }
        return lista;
    }
}
