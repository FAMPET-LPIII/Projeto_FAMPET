//package com.example.scvet.api.controller;
//
//import com.example.scvet.model.entity.Pessoa;
//import com.example.scvet.service.PessoaService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/pessoas")
//@RequiredArgsConstructor
//
//public class PessoaController {
//    @GetMapping()
//    public ResponseEntity get(){
//        List<Pessoa> pessoas = service.getPessoas();
//        return ResponseEntity.ok(pessoas);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity get(@PathVariable("id") Long id){
//        Optional<Pessoa> pessoa = service.getPessoaById(id);
//        return ResponseEntity.ok(pessoa);
//    }
//}
