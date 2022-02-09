package pe.com.service.payments.service;


import pe.com.service.payments.model.Payments;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentsService {
void createPayments(Payments payments);
    
    Mono<Payments> findByPaymentsId(String id);
 
    Flux<Payments> findAllPayments();
 
    Mono<Payments> updatePayments(Payments payments);
 
    Mono<Void> deletePayments(String id);
}
