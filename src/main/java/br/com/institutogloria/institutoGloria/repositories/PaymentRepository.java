package br.com.institutogloria.institutoGloria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.institutogloria.institutoGloria.models.PaymentModel;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<PaymentModel, Integer> {

	@Query(value = "select u from payments u where upper(trim(u.name)) like %?1%")
	List<PaymentModel> getPaymentsByName(String name);
}
