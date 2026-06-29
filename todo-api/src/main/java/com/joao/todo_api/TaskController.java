package com.joao.todo_api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public Task criar(@RequestBody Task task) {
		return taskService.criar(task);
	}
	
	@GetMapping
	public List<Task> listarTodas() {
		return taskService.listarTodas();
	}
	
	@GetMapping("/{id}")
	public Task bucarPorId(@PathVariable Long id) {
		return taskService.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	public Task atualizar(@PathVariable Long id, @RequestBody Task task) {
		return taskService.atualizar(id, task);
	}
	
	@PatchMapping("/{id}/concluir")
	public Task concluir(@PathVariable Long id) {
		return taskService.marcarComoConcluida(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		taskService.deletar(id);
	}
}
