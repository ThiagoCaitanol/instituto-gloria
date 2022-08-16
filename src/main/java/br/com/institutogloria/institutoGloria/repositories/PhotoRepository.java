package br.com.institutogloria.institutoGloria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.institutogloria.institutoGloria.models.PhotosModel;

@Repository
public interface PhotoRepository extends JpaRepository<PhotosModel, Integer>{

	@Query(value = "select u from photo u where upper(trim(u.link)) like %?1%")
	List<PhotosModel> getLink(String name);
}