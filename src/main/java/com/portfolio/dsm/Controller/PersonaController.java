/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.dsm.Controller;

import com.portfolio.dsm.Entity.Persona;
import com.portfolio.dsm.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Davo
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
     return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletepersona(@PathVariable Long id){
     ipersonaService.deletepersona(id);
     return "La persona fue eliminada correctamente";
    }
    
    
    // URL:PUERTO/persona/editar/4/nombre & apellido & img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,  
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoimg){
     Persona persona = ipersonaService.findPersona(id);
             
             persona.setNombre(nuevoNombre);
             persona.setApellido(nuevoApellido);
             persona.setImg(nuevoimg);
        
             ipersonaService.savePersona(persona);
             return persona;
    }
            @GetMapping("/personas/traer/perfil")
            public Persona findPersona(){
             return ipersonaService.findPersona((long)1);
            }
    
    
}