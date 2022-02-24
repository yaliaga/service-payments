package pe.com.service.payments.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.service.payments.model.Payments;


@Repository
public interface PaymentsRepository extends ReactiveMongoRepository<Payments, String>{

}
