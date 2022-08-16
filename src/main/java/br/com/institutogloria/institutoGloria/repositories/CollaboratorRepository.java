package br.com.institutogloria.institutoGloria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.institutogloria.institutoGloria.models.CollaboratorModel;

@Repository
public interface CollaboratorRepository extends JpaRepository<CollaboratorModel, Integer>{

	@Query(value = "select u from Collaborators u where upper(trim(u.name)) like %?1%")
	List<CollaboratorModel> getCollaboratorByName(String name);
}
