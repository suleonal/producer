package tr.com.argela.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.argela.producer.kafka.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
public class ProduceController {

	@Autowired
	private final KafkaProducerService producerService;

	@Autowired
	public ProduceController(KafkaProducerService producerService) {
		this.producerService = producerService;
	}

	@GetMapping(value = "/message")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producerService.sendMessage(message);
	}

}
