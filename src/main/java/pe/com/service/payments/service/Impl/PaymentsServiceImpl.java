package pe.com.service.payments.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.service.payments.model.Payments;
import pe.com.service.payments.repository.PaymentsRepository;
import pe.com.service.payments.service.PaymentsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentsServiceImpl implements PaymentsService{
	
	@Autowired
	PaymentsRepository paymentsRepository;

	@Override
	public void createPayments(Payments payments) {
		paymentsRepository.save(payments).subscribe();

	}

	@Override
	public Mono<Payments> findByPaymentsId(String id) {
		return paymentsRepository.findById(id);
	}

	@Override
	public Flux<Payments> findAllPayments() {
		return paymentsRepository.findAll();
	}

	@Override
	public Mono<Payments> updatePayments(Payments payments) {
		return paymentsRepository.save(payments);
	}

	@Override
	public Mono<Void> deletePayments(String id) {
		return paymentsRepository.deleteById(id);
	}

}