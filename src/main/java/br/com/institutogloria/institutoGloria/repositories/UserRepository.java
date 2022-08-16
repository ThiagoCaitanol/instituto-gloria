package br.com.institutogloria.institutoGloria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.institutogloria.institutoGloria.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

	@Query(value = "select u from Collaborators u where upper(trim(u.name)) like %?1%")
	List<UserModel> getUserrByName(String name);
}
