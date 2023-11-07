import java.util.Objects;

public class Equipo implements Comparable<Equipo>
{
    private String nombre;
    private int cantidadFans;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesFavor;
    private int golesContra;

    public Equipo(String nombre, int cantidadFans)
    {
        this.nombre = nombre;
        this.cantidadFans = cantidadFans;
        partidosJugados = 0;
        partidosGanados = 0;
        partidosEmpatados = 0;
        partidosPerdidos = 0;
        golesFavor = 0;
        golesContra = 0;
    }

    public void cargarPartido(int golesFavor, int golesContra)
    {
        this.golesFavor += golesFavor;
        this.golesContra += golesContra;

        this.partidosJugados++;
        
        if(golesFavor > golesContra)
            this.partidosGanados++;
        else if(golesFavor < golesContra)
            this.partidosPerdidos++;
        else    
            this.partidosEmpatados++;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getPuntos()
    {
        return partidosGanados * 3 + partidosEmpatados;
    }

    public int getDiferenciaGoles()
    {
        return golesFavor - golesContra;
    }

    public int getCantidadFans()
    {
        return cantidadFans;
    }

    @Override
    public int compareTo(Equipo o) {
        int val = this.getPuntos() - o.getPuntos();

        if(val == 0)
        {
            val = this.getDiferenciaGoles() - o.getDiferenciaGoles();
        }

        return val;
    }

    @Override
    public String toString()
    {
        String sep = " | ";
        return nombre + sep + partidosJugados + sep + getPuntos() + sep + partidosGanados + 
            sep + partidosEmpatados + sep + partidosPerdidos + sep + golesFavor + sep + 
            golesContra + sep + getDiferenciaGoles();
    }

    @Override
    public boolean equals(Object otro)
    {
        if(this == otro)
            return true;
        
        if(otro == null)
            return false;

        if(this.getClass() != otro.getClass())
            return false;

        Equipo otroEquipo = (Equipo) otro;

        return this.nombre == otroEquipo.nombre;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(nombre);
    }
}