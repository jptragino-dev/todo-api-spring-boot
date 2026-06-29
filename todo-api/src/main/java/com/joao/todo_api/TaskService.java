package com.joao.todo_api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> listarTodas(){
		return taskRepository.findAll();
	}
	
	public Task buscarPorId(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
	}
	
	public Task criar(Task task) {
		if (task.getTitulo() == null || task.getTitulo().isBlank()) {
			throw new RuntimeException("O título da tarefa não pode ser vazio");
		}
		return taskRepository.save(task);
	}
	
	public Task atualizar(Long id, Task dadosAtualizados) {
		Task task = buscarPorId(id);
		task.setTitulo(dadosAtualizados.getTitulo());
		task.setDescricao(dadosAtualizados.getDescricao());
		task.setConcluida(dadosAtualizados.isConcluida());
		return taskRepository.save(task);		
	}
	
	public Task marcarComoConcluida(Long id) {
		Task task = buscarPorId(id);
		task.setConcluida(true);
		return taskRepository.save(task);
	}
	
	public void deletar(long id) {
		Task task = buscarPorId(id);
		taskRepository.delete(task);
	}
}
