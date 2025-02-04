package org.example.repositories;

import org.example.entity.empresa.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository; // Asegúrate de importar JpaRepository
import org.springframework.stereotype.Repository;

@Repository
public interface usuariosRepositories extends JpaRepository<Usuarios, Integer> { // Cambié 'Usuarios.Integer' por 'Usuarios, Integer'
}

