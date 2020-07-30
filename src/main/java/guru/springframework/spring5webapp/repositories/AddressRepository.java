package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
