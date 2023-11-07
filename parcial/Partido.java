import java.time.LocalDate;

public class Partido 
{
    private Equipo local;
    private Equipo visitante;
    private int golesLocal;
    private int golesVisitante;
    private LocalDate fecha;

    public Partido(Equipo local, Equipo visitante, LocalDate fecha)
    {
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
    }

    public void jugarPartido(int golesLocal, int golesVisitante)
    {
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;

        local.cargarPartido(golesLocal, golesVisitante);
        visitante.cargarPartido(golesVisitante, golesLocal);
    }

    @Override
    public String toString()
    {
        return "Fecha: " + fecha + ", " + 
            local.getNombre() + "(" + golesLocal + ") - " + 
            visitante.getNombre() + "(" + golesVisitante + ")"; 
    }
}
