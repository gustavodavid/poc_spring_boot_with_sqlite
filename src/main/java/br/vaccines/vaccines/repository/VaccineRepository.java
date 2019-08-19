package br.vaccines.vaccines.repository;

import org.springframework.data.repository.CrudRepository;

import br.vaccines.vaccines.models.Vaccine;

public interface VaccineRepository extends CrudRepository<Vaccine, String> {
	Vaccine findById(long id);
}
