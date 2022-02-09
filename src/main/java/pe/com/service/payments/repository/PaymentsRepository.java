package pe.com.service.payments.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import pe.com.service.payments.model.Payments;



public interface PaymentsRepository extends ReactiveMongoRepository<Payments, String>{

}
