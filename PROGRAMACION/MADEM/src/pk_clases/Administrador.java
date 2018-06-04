package pk_clases;

public class Administrador extends Trabajador{
    int JornadaSemanal;
    int Jornada;

    public Administrador(String codigo, String nombre, String apellido, String password, int tipo, int JornadaSemanal) {
        super(codigo, nombre, apellido, password, tipo);
        this.JornadaSemanal = JornadaSemanal;
        
        if(tipo==1) Jornada = 24;
        if(tipo==2) Jornada = 48;
    }

    public int getJornadaSemanal() {
        return JornadaSemanal;
    }

    public void setJornadaSemanal(int JornadaSemanal) {
        this.JornadaSemanal = JornadaSemanal;
    }
    
    public double PagoPorSemana(int JornadaSemanal){
        if(JornadaSemanal > Jornada){
            return (JornadaSemanal - Jornada)*5;
        }
        return 0;
    }
    
    public String toString(){
        return codigo + " " + nombre + " " + apellido + " "  + password + " "  + tipo + " "  + JornadaSemanal + " "  + PagoPorSemana(JornadaSemanal);
    }
    
    
}
