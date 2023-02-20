
package entity;

public class Linea {
   //atributos
    private int idlinea;
    private String nombre;
    private String fecha;
    //constructor

    public Linea() {
    }

    public Linea(int idlinea, String nombre, String fecha) {
        this.idlinea = idlinea;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public int getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(int idlinea) {
        this.idlinea = idlinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   
    
    
    
}
