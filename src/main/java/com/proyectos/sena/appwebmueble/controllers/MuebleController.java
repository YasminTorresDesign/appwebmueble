package com.proyectos.sena.appwebmueble.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.sena.appwebmueble.models.MuebleModel;
import com.proyectos.sena.appwebmueble.services.MuebleService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/mueble")
public class MuebleController {
    @Autowired
    MuebleService muebleService;

    @GetMapping()
    public ArrayList<MuebleModel> obtenerMueble(){
        return muebleService.obtenerMuebles();
    }
    
    @PostMapping()
    public MuebleModel guardarMueble(@RequestBody MuebleModel mueble){
        return this.muebleService.guardarMueble(mueble);
    }

   @GetMapping(path = "/{id}")
   public Optional<MuebleModel> obtenerMueblePorId(@PathVariable("id") Long id){
       return this.muebleService.obtenerPorId(id);
   }

   @GetMapping("/query")
   public ArrayList<MuebleModel> obtenerMueblePorCategoria(@RequestParam("categoria") String categoria){
       return this.muebleService.obtenerPorCategoria(categoria);
    
   }

   @DeleteMapping(path = "/{id}")
   public String eliminarPorId(@PathVariable("id") Long id){
       boolean ok = this.muebleService.eliminarMueble(id);
       if (ok){
           return "Se eliminó el mueble con id: "+id;
       }else{
           return "No se pudo eliminar el mueble con id: "+id;
       }
   }
}
