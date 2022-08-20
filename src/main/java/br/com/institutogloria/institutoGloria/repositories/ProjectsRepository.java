package br.com.institutogloria.institutoGloria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.institutogloria.institutoGloria.models.ProjectsModel;

public interface ProjectsRepository extends PagingAndSortingRepository<ProjectsModel, Integer>{

	@Query(value = "select u from Projects u where upper(trim(u.title)) like %?1%")
	List<ProjectsModel> getProjectsByName(String title);
}
