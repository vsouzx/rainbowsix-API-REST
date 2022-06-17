package br.com.vitor.rainbowsix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vitor.rainbowsix.modelo.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByUsername(String username);

}
