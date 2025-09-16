import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;

public class PersistenciaTXT<T> implements IPersistencia<T>{
    private int a = 1;
    @Override
    public void guardar(ArrayList<T> lista, String archivo) throws IOException {
        File file = new File(archivo);

            if (!file.exists()){
                int a = 1;
                file.createNewFile();
                System.out.println("Archivo creado: " + archivo);
            }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))){
            for (T obj : lista){
                bw.append(obj.toString());
                bw.newLine();
            }
        }
    }
    @Override
    public ArrayList<T> cargar(String archivo, Function<String, T> reconstructor) throws IOException {
        File file = new File(archivo);
        ArrayList<T> lista = new ArrayList<>();

        if (!file.exists()){
            System.out.println("El archivo no existe, devolviendo lista vacia");
            return lista;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null){
                try {
                    lista.add(reconstructor.apply(line));
                } catch (Exception e){

                }
            }
        }
        System.out.println(lista.toString());
        return lista;
    }
}
