package com.nixsolutions.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.dto.AuthorDTO;
import com.nixsolutions.dto.BookDTO;
import com.nixsolutions.dto.GenreDTO;
import com.nixsolutions.dto.LanguageDTO;
import com.nixsolutions.dto.PlaceDTO;
import com.nixsolutions.dto.PublishingHouseDTO;
import com.nixsolutions.entity.Author;
import com.nixsolutions.entity.Book;
import com.nixsolutions.entity.Orders;
import com.nixsolutions.entity.Place;
import com.nixsolutions.entity.Rate;
import com.nixsolutions.service.ServiceApi.AuthorService;
import com.nixsolutions.service.ServiceApi.BookService;
import com.nixsolutions.service.ServiceApi.OrdersService;
import com.nixsolutions.service.ServiceApi.PlaceService;
import com.nixsolutions.service.ServiceApi.PublishingHouseService;
import com.nixsolutions.service.ServiceApi.RateService;

@Controller
@RequestMapping("/book")
public class BookController {
	private BookService bookService;
	private OrdersService orderService;
	private RateService rateService;
	private PublishingHouseService publishingHouseService;
	private AuthorService authorService;
	private PlaceService placeService;

	@Autowired
	public BookController(BookService bookService, RateService rateService,
			PublishingHouseService publishingHouseService, AuthorService authorService, 
			OrdersService orderService, PlaceService placeService) {
		this.bookService = bookService;
		this.rateService = rateService;
		this.publishingHouseService = publishingHouseService;
		this.authorService = authorService;
		this.orderService = orderService;
		this.placeService = placeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String printAllBooks(Model model) {
		List<Book> books = bookService.getAll();
		model.addAttribute("books", books);
		return "books/books";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String printBookInfo(Model model, @PathVariable int id) throws SQLException {
		Book book = bookService.getById(id);
		model.addAttribute("book", book);
		return "books/infoBook";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(Model model, @PathVariable("id") int id) throws Exception {
		for (Orders order : orderService.getAll()) {
			if (order.getBook().getId() == id) {
				orderService.delete(order.getOrdersId());
			}
		}

		for (Rate rate : rateService.getAll()) {
			if (rate.getBook().getId() == id) {
				rateService.delete(rate.getId());
			}
		}

		bookService.delete(id);
		model.addAttribute("title", "Book was deleted!");
		return "redirect:/book";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String printBookForm() {
		return "books/bookAdd";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createUser(Model model, @ModelAttribute BookDTO bookDTO, @ModelAttribute AuthorDTO authorDto,
			@ModelAttribute PublishingHouseDTO houseDto, @ModelAttribute GenreDTO genreDto,
			@ModelAttribute PlaceDTO placeDto, @ModelAttribute LanguageDTO languageDto)
			throws IOException, ServletException, SQLException {
		model.addAttribute("book", bookDTO);
		model.addAttribute("author", authorDto);
		model.addAttribute("place", placeDto);
		model.addAttribute("house", houseDto);
		model.addAttribute("genre", genreDto);
		model.addAttribute("language", languageDto);
		Book book = bookService.createBook(bookDTO, authorDto, houseDto, genreDto, placeDto, languageDto);
		return "redirect:/book";
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	  public String printUpdateUserForm(Model model,  @PathVariable("id") int id) throws SQLException {
	   Book book = bookService.getById(id);
	   Author author = authorService.getById(book.getAuthor().getId());
	   Place place = placeService.getById(book.getPlace().getPlaceId());
       model.addAttribute("book", book);
       model.addAttribute("place", place);
       model.addAttribute("author", author);
	   return "books/bookEdit";
	}
	
	 @RequestMapping(value = "/edit", method = RequestMethod.POST)
	   public String udpateUser(Model model, @ModelAttribute BookDTO bookDTO, @ModelAttribute AuthorDTO authorDto,
				@ModelAttribute PublishingHouseDTO houseDto, @ModelAttribute GenreDTO genreDto,
				@ModelAttribute PlaceDTO placeDto, @ModelAttribute LanguageDTO languageDto) throws IOException, ServletException, SQLException {
	       bookService.update(bookDTO, authorDto, genreDto, languageDto, placeDto, houseDto);   
	     model.addAttribute("title", "User updated!");
	     return "redirect:/book";
	   }	
}
