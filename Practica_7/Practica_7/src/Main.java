import data.Processing;
import java.io.File;
import java.io.IOException;
import templates.Persona;
import org.apache.commons.io.input.ReversedLinesFileReader;
import java.lang.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) throws IOException {

    ArrayList<Persona> personas = new ArrayList<>();
    ArrayList<Persona> outPersonas = new ArrayList<>();
        personas.add(new Persona(
                1,
                "pedro pica",
                20,
                1.60,
                58
        ));personas.add(new Persona(
                2,
                "jaime sanchez",
                19,
                1.78,
                80));
        personas.add(new Persona(
                3,
                "miguel angel ",
                20,
                1.78,
                67
        ));
        Processing processing = new Processing();
        processing.guardarPersonasEnArchivo(personas, "personas.txt");
        outPersonas = processing.leerPersonasDeArchivo("personas.txt");
        for (int i=0; i< outPersonas.size(); i++){
            System.out.println(
                    outPersonas.get(i).getId() + " | " +
                    outPersonas.get(i).getNombre() + " | " +
                            outPersonas.get(i).getEdad() + " | " +
                            outPersonas.get(i).getEstatura() + " | " +
                            outPersonas.get(i).getPeso() + " | "
            );
        }
        
        File file = new File("personas.txt");
        ReversedLinesFileReader object = new ReversedLinesFileReader(file);
        String line = object.readLine();
        System.out.println(line);
        String pattern = "\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)";
        Matcher matcher = Pattern.compile(pattern).matcher(line);
        Persona personaUltima = null;
        if (matcher.find()) {
            personaUltima = new Persona(
                                Long.parseLong(matcher.group(1)),
                                matcher.group(2),
                                Integer.parseInt( matcher.group(3) ),
                                Double.parseDouble( matcher.group(4) ),
                                Integer.parseInt( matcher.group(5) )
                        );
        }
        System.out.println(personaUltima.toString());
        long ultimoid = personaUltima.getId();
        personas.add(new Persona(
                ultimoid+1,
                "123456",
                59,
                1.50,
                60
        ));
        personas.add(new Persona(
                ultimoid+2,
                "78910",
                34,
                1.52,
                45
        ));
        processing.guardarPersonasEnArchivo(personas, "personas.txt");
        outPersonas = processing.leerPersonasDeArchivo("personas.txt");
        for (int i=0; i< outPersonas.size(); i++){
            System.out.println(
                    outPersonas.get(i).getId() + " | " +
                    outPersonas.get(i).getNombre() + " | " +
                            outPersonas.get(i).getEdad() + " | " +
                            outPersonas.get(i).getEstatura() + " | " +
                            outPersonas.get(i).getPeso() + " | "
            );
        }
        

    }
}
