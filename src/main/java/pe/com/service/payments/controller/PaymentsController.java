package pe.com.service.payments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.service.payments.model.Payments;
import pe.com.service.payments.service.Impl.PaymentsServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentsController {
	//@Autowired
		private final PaymentsServiceImpl paymentsServiceImpl ;
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public void createPayments(@RequestBody Payments payments) {
			paymentsServiceImpl.createPayments(payments);
		}

		@GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
		@ResponseBody
		public Flux<Payments> findAll() {
			return paymentsServiceImpl.findAllPayments();
		}

		@GetMapping("/{id}")
		public ResponseEntity<Mono<Payments>> findPaymentsById(@PathVariable("id") String id) {
			Mono<Payments> payments = paymentsServiceImpl.findByPaymentsId(id);
			return new ResponseEntity<Mono<Payments>>(payments, payments != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		}
		@PutMapping
		@ResponseStatus(HttpStatus.OK)
		public Mono<Payments> update(@RequestBody Payments payments) {
			return paymentsServiceImpl.updatePayments(payments);
		}

		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		public void delete(@PathVariable("id") String id) {
			paymentsServiceImpl.deletePayments(id).subscribe();
		}
	
	

}