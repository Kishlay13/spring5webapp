package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@RequestMapping("/books")
	public String getMapping(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
	}

}
