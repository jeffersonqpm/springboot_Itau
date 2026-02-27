package controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.dto.TransactionRequest;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.service.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao") // endpoint

public class TransactionController {

    private final TransactionService transactionService;

    // construtor
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping //sem endpoint (Deve retornar sem nenhum corpo)
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request){
        if(request.getDataHora().isAfter(OffsetDateTime.now())){// se a transição ocorrer no futuro (data e hora da maquina errada)
            return ResponseEntity.unprocessableEntity().build();

        }

        transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora())){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @DeleteMapping
        public ResponseEntity<Void> clearTransactions(){
            transactionService.clearTransactions();
            return ResponseEntity.ok().build();
        }

    }

}
