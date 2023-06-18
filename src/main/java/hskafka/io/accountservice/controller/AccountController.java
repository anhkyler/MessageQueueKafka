package hskafka.io.accountservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hskafka.io.accountservice.model.AccountDTO;
import hskafka.io.accountservice.model.MessageDTO;
import hskafka.io.accountservice.model.StatisticDTO;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	@PostMapping("/new")
	public AccountDTO create(@RequestBody AccountDTO account) {
		StatisticDTO statisticDTO = new StatisticDTO("Account"+account.getEmail()+"is created", (new Date()).toString());
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setTo(account.getEmail());
		messageDTO.setToName(account.getName());
		messageDTO.setSubject("Welcome to HS learning case");
		messageDTO.setContent("learning basic on kafka");
		
		kafkaTemplate.send("notification", messageDTO);
		kafkaTemplate.send("statistic", statisticDTO);
		return account;
	}
}
