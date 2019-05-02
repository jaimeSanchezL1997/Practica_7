package templates;
public class Persona {
    private long id;
    private String nombre;
    private int edad;
    private double estatura;
    private int peso;
    public Persona(long id, String nombre, int edad, double estatura, int peso){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso; }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getEstatura() {
        return estatura;
    }
    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", estatura=" + estatura + ", peso=" + peso + '}';
    }
    
    
}
