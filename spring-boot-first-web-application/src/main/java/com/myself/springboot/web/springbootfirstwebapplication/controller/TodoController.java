package com.myself.springboot.web.springbootfirstwebapplication.controller;


import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myself.springboot.web.springbootfirstwebapplication.model.Todo;
import com.myself.springboot.web.springbootfirstwebapplication.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model, String name) {
		String user = (String) model.get("name");
		model.addAttribute("todos", service.retrieveTodos(user));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0,(String) model.get("name"), "" , new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo= service.retrieveTodos(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		todo.setUser((String) model.get("name"));
		
		 service.updateTodo(todo);
		
		 return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		service.addTodo((String) model.get("name"), todo.getDesc(), new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	}
	

