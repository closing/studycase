package com.zyx.bwf.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zyx.bwf.common.exception.ResourceNotFoundException;
import com.zyx.bwf.repository.User;
import com.zyx.bwf.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resouce not found")
	@ExceptionHandler(ResourceNotFoundException.class)
	public void notFound() {

	}

	@GetMapping("")
	public Flux<User> list() {
		return this.userService.list();

	}

	@GetMapping("/{id}")
	public Mono<User> getById(@PathVariable("id") final String id) {
		return this.userService.getById(id);
	}

	@PostMapping()
	public Mono<User> create(@RequestBody User user) {
		return this.userService.createOrUpdate(user);

	}

	@PutMapping("/{id}")
	public Mono<User> update(@PathVariable("id") final String id, @RequestBody final User user) {
		Objects.requireNonNull(user);
		user.setId(id);
		return this.userService.createOrUpdate(user);

	}

	@DeleteMapping("/{id}")
	public Mono<User> delete(@PathVariable("id") final String id) {
		return this.userService.delete(id);
	}
}
