package com.example.orders.controller;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.dto.OrderResponseDTO;
import com.example.orders.entity.OrderEntity;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")

public class OrderController {
	
	@Autowired
	private OrderService service;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@Valid @RequestBody OrderRequestDTO request) {
    	OrderEntity o =  service.createOrder(request);
    	OrderResponseDTO e = OrderMapper.toResponseDTO(o);
       return new ResponseEntity<>(e,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getById(@PathVariable Long id) {
    	OrderEntity o =  service.getOrderById(id);
    	OrderResponseDTO e = OrderMapper.toResponseDTO(o);
    	return new ResponseEntity<>(e,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
    	service.deleteOrder(id);
    	return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
    }
}
