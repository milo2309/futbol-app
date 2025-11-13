package com.futbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InicioController {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private AsociacionRepository asociacionRepository;

    @Autowired
    private CompeticionRepository competicionRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    // --- Mostrar datos ---
    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Club> clubes = clubRepository.findAll();
        List<Entrenador> entrenadores = entrenadorRepository.findAll();
        List<Asociacion> asociaciones = asociacionRepository.findAll();
        List<Competicion> competiciones = competicionRepository.findAll();
        List<Jugador> jugadores = jugadorRepository.findAll();

        model.addAttribute("clubes", clubes);
        model.addAttribute("entrenadores", entrenadores);
        model.addAttribute("asociaciones", asociaciones);
        model.addAttribute("competiciones", competiciones);
        model.addAttribute("jugadores", jugadores);

        // Creamos objetos vacíos para los formularios
        model.addAttribute("nuevoClub", new Club());
        model.addAttribute("nuevoEntrenador", new Entrenador());
        model.addAttribute("nuevaAsociacion", new Asociacion());
        model.addAttribute("nuevaCompeticion", new Competicion());
        model.addAttribute("nuevoJugador", new Jugador());

        return "inicio";
    }

    // --- Guardar un nuevo Club ---
    @PostMapping("/guardarClub")
    public String guardarClub(@ModelAttribute Club club) {
        clubRepository.save(club);
        return "redirect:/inicio";
    }

    // --- Guardar un nuevo Entrenador ---
    @PostMapping("/guardarEntrenador")
    public String guardarEntrenador(@ModelAttribute Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
        return "redirect:/inicio";
    }

    // --- Guardar una nueva Asociación ---
    @PostMapping("/guardarAsociacion")
    public String guardarAsociacion(@ModelAttribute Asociacion asociacion) {
        asociacionRepository.save(asociacion);
        return "redirect:/inicio";
    }

    // --- Guardar una nueva Competición ---
    @PostMapping("/guardarCompeticion")
    public String guardarCompeticion(@ModelAttribute Competicion competicion) {
        competicionRepository.save(competicion);
        return "redirect:/inicio";
    }

    // --- Guardar un nuevo Jugador ---
    @PostMapping("/guardarJugador")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/inicio";
    }

    // --- Eliminar un Club ---
    @GetMapping("/eliminarClub/{id}")
    public String eliminarClub(@PathVariable Long id) {
        clubRepository.deleteById(id);
        return "redirect:/inicio";
    }

    // --- Eliminar un Entrenador ---
    @GetMapping("/eliminarEntrenador/{id}")
    public String eliminarEntrenador(@PathVariable Long id) {
        entrenadorRepository.deleteById(id);
        return "redirect:/inicio";
    }

    // --- Eliminar una Asociación ---
    @GetMapping("/eliminarAsociacion/{id}")
    public String eliminarAsociacion(@PathVariable Long id) {
        asociacionRepository.deleteById(id);
        return "redirect:/inicio";
    }

    // --- Eliminar una Competición ---
    @GetMapping("/eliminarCompeticion/{id}")
    public String eliminarCompeticion(@PathVariable Long id) {
        competicionRepository.deleteById(id);
        return "redirect:/inicio";
    }

    // --- Eliminar un Jugador ---
    @GetMapping("/eliminarJugador/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorRepository.deleteById(id);
        return "redirect:/inicio";
    }

    // --- Editar un Club (formulario de edición) ---
    @GetMapping("/editarClub/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Club club = clubRepository.findById(id).orElse(null);
        List<Entrenador> entrenadores = entrenadorRepository.findAll();

        model.addAttribute("club", club);
        model.addAttribute("entrenadores", entrenadores);
        return "editarClub";
    }

    // --- Guardar los cambios de un Club editado ---
    @PostMapping("/editarClub")
    public String actualizarClub(@ModelAttribute Club club) {
        clubRepository.save(club);
        return "redirect:/inicio";
    }

    // --- Editar un Entrenador (formulario de edición) ---
    @GetMapping("/editarEntrenador/{id}")
    public String mostrarFormularioEdicionEntrenador(@PathVariable Long id, Model model) {
        Entrenador entrenador = entrenadorRepository.findById(id).orElse(null);
        model.addAttribute("entrenador", entrenador);
        return "editarEntrenador";
    }

    // --- Guardar los cambios de un Entrenador editado ---
    @PostMapping("/editarEntrenador")
    public String actualizarEntrenador(@ModelAttribute Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
        return "redirect:/inicio";
    }

    // --- Editar una Asociación (formulario de edición) ---
    @GetMapping("/editarAsociacion/{id}")
    public String mostrarFormularioEdicionAsociacion(@PathVariable Long id, Model model) {
        Asociacion asociacion = asociacionRepository.findById(id).orElse(null);
        model.addAttribute("asociacion", asociacion);
        return "editarAsociacion";
    }

    // --- Guardar los cambios de una Asociación editada ---
    @PostMapping("/editarAsociacion")
    public String actualizarAsociacion(@ModelAttribute Asociacion asociacion) {
        asociacionRepository.save(asociacion);
        return "redirect:/inicio";
    }

    // --- Editar una Competición (formulario de edición) ---
    @GetMapping("/editarCompeticion/{id}")
    public String mostrarFormularioEdicionCompeticion(@PathVariable Long id, Model model) {
        Competicion competicion = competicionRepository.findById(id).orElse(null);
        model.addAttribute("competicion", competicion);
        return "editarCompeticion";
    }

    // --- Guardar los cambios de una Competición editada ---
    @PostMapping("/editarCompeticion")
    public String actualizarCompeticion(@ModelAttribute Competicion competicion) {
        competicionRepository.save(competicion);
        return "redirect:/inicio";
    }

    // --- Editar un Jugador (formulario de edición) ---
    @GetMapping("/editarJugador/{id}")
    public String mostrarFormularioEdicionJugador(@PathVariable Long id, Model model) {
        Jugador jugador = jugadorRepository.findById(id).orElse(null);
        List<Club> clubes = clubRepository.findAll();
        model.addAttribute("jugador", jugador);
        model.addAttribute("clubes", clubes);
        return "editarJugador";
    }

    // --- Guardar los cambios de un Jugador editado ---
    @PostMapping("/editarJugador")
    public String actualizarJugador(@ModelAttribute Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/inicio";
    }
}