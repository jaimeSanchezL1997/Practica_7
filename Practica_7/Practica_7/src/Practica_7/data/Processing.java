package data;
import templates.Persona;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Processing {
    public void mostrarPersona(ArrayList<Persona> personas) {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(
                    personas.get(i).getId() + " " +
                    personas.get(i).getNombre() + " " +
                            personas.get(i).getEdad() + " " +
                            personas.get(i).getEstatura() + " " +
                            personas.get(i).getPeso() + " "
            ); } }
    public void guardarPersonasEnArchivo(ArrayList<Persona> personas, String nombreArchivo) {
        File fout = new File(nombreArchivo);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fout); } catch (FileNotFoundException e) {
            e.printStackTrace(); }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        try {
            for (int i = 0; i < personas.size(); i++) {
                bufferedWriter.write(
                        "(" + personas.get(i).getId() + ")" +
                        "(" + personas.get(i).getNombre() + ")" +
                                "(" + personas.get(i).getEdad() + ")" +
                                "(" + personas.get(i).getEstatura() + ")" +
                                "(" + personas.get(i).getPeso() + ")\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace(); } }
    public ArrayList<Persona> leerPersonasDeArchivo(String nombreArchivo){
        ArrayList<Persona> outPersona = new ArrayList<>();
        File fin = new File(nombreArchivo);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fin);
        } catch (IOException e) {
            e.printStackTrace(); }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String thisLine = null;
            try {
                while ((thisLine = bufferedReader.readLine()) != null){
//                    \\(([^)]+)\\)
                    String pattern = "\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)";
                    Matcher matcher = Pattern.compile(pattern).matcher(thisLine);
                    if (matcher.find()){
                        outPersona.add( new Persona(
                                Long.parseLong( matcher.group(1) ),
                                matcher.group(2),
                                Integer.parseInt( matcher.group(3) ),
                                Double.parseDouble( matcher.group(4) ),
                                Integer.parseInt( matcher.group(5) )
                        )); } } catch (IOException e) {
                e.printStackTrace(); }
        return outPersona; }
}
