package destinos.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import destinos.edu.pe.modelo.Origen;
import destinos.edu.pe.servicios.OrigenServicios;

@Controller
@RequestMapping("/Origen")
public class OrigenController {
	
	@Autowired
	private OrigenServicios servicio;
	
	
	@RequestMapping("/listarTodo")
	public String listarOrigen(Model model) {
		List<Origen> listaOrigen = servicio.buscarTodo();
		System.out.println("LISTA DE ORIGEN : " + listaOrigen);
		model.addAttribute("listaOrigen", listaOrigen);
		return "/moduloOrigen/listarTodo";
		
	}
	
	@RequestMapping("/nuevo")
	public String nuevoOrigen(Model model) {
		Origen Origen = new Origen();
		model.addAttribute("Origen", Origen);
		return "/moduloOrigen/nuevoOrigen";
	}
	
	@RequestMapping(value= "/guardar", method = RequestMethod.POST)
	public String crearOrigen(@ModelAttribute("Origen") Origen Origen) {
		servicio.crear(Origen);
		return "redirect:/Origen/listarTodo";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarOrigen(@PathVariable(name="id") int id) {
		ModelAndView mav= new ModelAndView("/moduloOrigen/editarOrigen");
		Origen Origen = servicio.buscarPorId(id);
		mav.addObject("Origen", Origen);
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarOrigen(@PathVariable(name ="id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/Origen/listarTodo";
	}
	

}
