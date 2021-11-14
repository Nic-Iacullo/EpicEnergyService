package it.epicode.beservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.beservice.security.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Page<User> findAll(Pageable pageable);
	
	/* Sort */
    // Formula: findBy + OrderBy + NomeColonna + Ordinamento(Asc/Desc)
    List<User> findByOrderByNomeAsc();
    
    Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
