package com.proyectos.sena.appwebmueble.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectos.sena.appwebmueble.models.MuebleModel;
import com.proyectos.sena.appwebmueble.repositories.MuebleRepository;

@Service
public class MuebleService {
    @Autowired
    MuebleRepository muebleRepository;

    public ArrayList<MuebleModel> obtenerMuebles(){
        return (ArrayList<MuebleModel>) muebleRepository.findAll();
    }

    public MuebleModel guardarMueble( MuebleModel mueble){
        return muebleRepository.save(mueble);
    }

    public Optional<MuebleModel> obtenerPorId(Long id){
        return muebleRepository.findById(id);
    }
    public ArrayList<MuebleModel> obtenerPorCategoria(String categoria){
        return muebleRepository.findByCategoria(categoria);
    }

    public boolean eliminarMueble(Long id){
        try{
            muebleRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    } 
}
