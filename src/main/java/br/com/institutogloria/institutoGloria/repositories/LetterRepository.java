package br.com.institutogloria.institutoGloria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.institutogloria.institutoGloria.models.LetterModel;

public interface LetterRepository extends PagingAndSortingRepository<LetterModel, Integer>{

	@Query(value = "select u from Letter u where upper(trim(u.titleLetter)) like %?1%")
	List<LetterModel> getByTitle(String name);
}
