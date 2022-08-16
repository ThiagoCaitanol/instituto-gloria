package br.com.institutogloria.institutoGloria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.institutogloria.institutoGloria.models.AdminModel;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Integer>{

	@Query(value = "select u from admin u where upper(trim(u.name)) like %?1%")
	List<AdminModel> getAdminByName(String name);
}