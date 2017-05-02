package com.nixsolutions.service.ServiceImpl;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.AuthorDAO;
import com.nixsolutions.dao.DAOApi.BookDAO;
import com.nixsolutions.dao.DAOApi.GenreDAO;
import com.nixsolutions.dao.DAOApi.LanguageDAO;
import com.nixsolutions.dao.DAOApi.PlaceDAO;
import com.nixsolutions.dao.DAOApi.PublishingHouseDAO;
import com.nixsolutions.dto.AuthorDTO;
import com.nixsolutions.dto.BookDTO;
import com.nixsolutions.dto.GenreDTO;
import com.nixsolutions.dto.LanguageDTO;
import com.nixsolutions.dto.PlaceDTO;
import com.nixsolutions.dto.PublishingHouseDTO;
import com.nixsolutions.entity.Author;
import com.nixsolutions.entity.Book;
import com.nixsolutions.entity.Genre;
import com.nixsolutions.entity.Language;
import com.nixsolutions.entity.Place;
import com.nixsolutions.entity.PublishingHouse;
import com.nixsolutions.entity.Role;
import com.nixsolutions.entity.User;
import com.nixsolutions.service.ServiceApi.BookService;

@Service
@Transactional
public class BookServiceImpl extends GeneralServiceImpl<Book> implements BookService {

	private BookDAO bookDao;
	private GenreDAO genreDao;
	private LanguageDAO languageDao;
	private PublishingHouseDAO houseDao;
	private PlaceDAO placeDao;
	private AuthorDAO authorDao;

	@Autowired
	public BookServiceImpl(BookDAO bookDao, GenreDAO genreDAO, LanguageDAO languageDao, PublishingHouseDAO houseDao,
			PlaceDAO placeDao, AuthorDAO authorDao) {
		super(bookDao);
		this.bookDao = bookDao;
		this.genreDao = genreDAO;
		this.houseDao = houseDao;
		this.authorDao = authorDao;
		this.languageDao = languageDao;
		this.placeDao = placeDao;
	}

	@Override
	@Transactional
	public Book getBookByName(String name) {
		return bookDao.getBookByName(name);
	}

	@Override
	public Book createBook(BookDTO bookDTO, AuthorDTO authorDto, PublishingHouseDTO houseDto, GenreDTO genreDto,
			PlaceDTO placeDto, LanguageDTO languageDto) throws SQLException {

		Author author = new Author(0, authorDto.getFirstName(), authorDto.getLastName());
		authorDao.save(author);
		PublishingHouse house = new PublishingHouse();
		houseDao.save(house);
		Genre genre = new Genre();
		genreDao.save(genre);
		Place place = new Place(0, placeDto.getShelfCode());
		placeDao.save(place);
		Language lang = new Language(0, "English");
		languageDao.save(lang);

		Book book = new Book(0, bookDTO.getName(), author, house, genre, 0.0, bookDTO.getTotalCount(),
				bookDTO.getCurrentCount(), place, bookDTO.getDescription(), bookDTO.getReadCount(), lang);

		bookDao.save(book);
		return book;
	}

	@Override
	public  Book update(BookDTO bookDTO, AuthorDTO authorDto, GenreDTO genreDto, LanguageDTO languageDto,
			PlaceDTO placeDto, PublishingHouseDTO houseDto) throws SQLException {

		Book persistentBook = bookDao.getById(bookDTO.getId());
		Author author = new Author(0, authorDto.getFirstName(), authorDto.getLastName());
		authorDao.save(author);
		Place place = new Place(0, placeDto.getShelfCode());
		placeDao.save(place);
		
		persistentBook.setName(bookDTO.getName());
		persistentBook.setAuthor(author);
		persistentBook.setCurrentCount(bookDTO.getCurrentCount());
		persistentBook.setDescription(bookDTO.getDescription());
		persistentBook.setPlace(place);
		persistentBook.setReadCount(bookDTO.getReadCount());
		persistentBook.setTotalCount(bookDTO.getTotalCount());
		bookDao.update(persistentBook);
		
		return persistentBook;

	}

}
