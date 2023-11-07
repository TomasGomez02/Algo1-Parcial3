import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;

public class Torneo 
{
    private Map<String, Equipo> equipos;
    private Map<LocalDate, List<Partido>> fechas;

    public Torneo()
    {
        equipos = new HashMap<>();
        fechas = new HashMap<>();
    }

    public void cargarEquipo(String nombreEquipo, int cantidadFans)
    {
        if(equipos.containsKey(nombreEquipo))
            throw new RuntimeException("Equipo " + nombreEquipo + " ya existe!");

        Equipo equipo = new Equipo(nombreEquipo, cantidadFans);
        equipos.put(nombreEquipo, equipo);
    }

    public void cargarPartido(String local, String visitante, LocalDate fecha, int golesLocal, int golesVisitante)
    {
        if(!fechas.containsKey(fecha))
        {
            fechas.put(fecha, new ArrayList<Partido>());
        }

        List<Partido> partidosFecha = fechas.get(fecha);

        Partido partido = new Partido(equipos.get(local), equipos.get(visitante), fecha);
        partido.jugarPartido(golesLocal, golesVisitante);

        partidosFecha.add(partido);
    }

    public void mostrarPartidosFecha(LocalDate fecha)
    {
        if(!fechas.containsKey(fecha))
        {
            System.out.println("No hay partidos registrados para la fecha " + fecha);
            return;
        }

        List<Partido> partidosFecha = fechas.get(fecha);
        for(Partido partido: partidosFecha)
        {
            System.out.println(partido);
        }
    }

    public void mostrarTabla()
    {
        List<Equipo> listaEquipos = new ArrayList<>(equipos.values());
        listaEquipos.sort(Comparator.reverseOrder());

        System.out.println("Equipo | Ju | Pu | Ga | Em | Pe | GF | GC | DG");

        for(Equipo equipo: listaEquipos)
        {
            System.out.println(equipo);
        }
    }

    public int getCantidadFans(String equipo)
    {
        if(!equipos.containsKey(equipo))
        {
            throw new RuntimeException("Equipo " + equipo + " no registrado.");
        }
        return equipos.get(equipo).getCantidadFans();
    }
}
