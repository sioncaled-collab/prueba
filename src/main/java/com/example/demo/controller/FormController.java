package com.example.demo.controller;
import java.util.List;
import com.example.demo.model.usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @GetMapping("/")
    public String mostrarMenu() {
        return "menu"; 
    }

    @GetMapping("/formulario")
    public String registrarUsuarios() {
        return "form"; 
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
            usuario persona = new usuario();
            List<String[]> lista = persona.ConsultaGeneral(); 
            model.addAttribute("usuarios", lista);
            return "usuariosGeneral"; 
    }

    @PostMapping("/mensaje")
    public String procesarFormulario(@RequestParam String nombre,
                                        @RequestParam String correo,
                                        @RequestParam String telefono,
                                        @RequestParam String edad,
                                        Model model) {
        
        String confirmacion=null;

        usuario persona = new usuario();
        String res = persona.Registrar(nombre,correo,telefono,edad);
    
        if(res == "1")
        {     
            confirmacion = "Registrado correctamente";
        } 
        else
        {
            confirmacion = "Error de registro, servidor fuera de línea, intente más tarde";
        }
            
        model.addAttribute("nombre", nombre);
        model.addAttribute("correo", correo);
        model.addAttribute("telefono", telefono);
        model.addAttribute("edad", edad);
        model.addAttribute("respuesta", confirmacion);

        return "resultado";
    }   
}