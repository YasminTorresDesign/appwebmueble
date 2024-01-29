package com.proyectos.sena.appwebmueble.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectos.sena.appwebmueble.models.MuebleModel;

@Repository
public interface MuebleRepository extends  JpaRepository <MuebleModel , Long>{
    public abstract ArrayList<MuebleModel> findByCategoria(String categoria);
}
