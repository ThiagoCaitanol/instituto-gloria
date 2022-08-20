package br.com.institutogloria.institutoGloria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.institutogloria.institutoGloria.models.SponsorModel;

public interface SponsorRepository extends PagingAndSortingRepository<SponsorModel, Integer>{

	@Query(value = "select u from Sponsors u where upper(trim(u.name)) like %?1%")
	List<SponsorModel> getSponsorByName(String name);
}
