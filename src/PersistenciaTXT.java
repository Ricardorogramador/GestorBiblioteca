import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class PersistenciaTXT implements IPersistencia{
    @Override
    public void guardar(ArrayList<?> lista, String archivo) throws IOException {
        File file = new File(archivo);

            if (!file.exists()){
                file.createNewFile();
                System.out.println("Archivo creado: " + archivo);
            }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            for (Object obj : lista){
                bw.write(obj.toString());
                bw.newLine();
            }
        }
    }
    @Override
    public ArrayList<?> cargar(String archivo) throws IOException {
        File file = new File(archivo);
        ArrayList<String> lista = new ArrayList<>();
        if (!file.exists()){
            System.out.println("El archivo no existe, devolviendo lista vacia");
            return lista;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null){
                lista.add(line);
            }
        }
        return lista;
    }
}
