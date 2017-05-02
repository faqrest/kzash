package com.nixsolutions.service.ServiceApi;

import java.sql.SQLException;

import com.nixsolutions.dto.AuthorDTO;
import com.nixsolutions.dto.BookDTO;
import com.nixsolutions.dto.GenreDTO;
import com.nixsolutions.dto.LanguageDTO;
import com.nixsolutions.dto.PlaceDTO;
import com.nixsolutions.dto.PublishingHouseDTO;
import com.nixsolutions.entity.Book;

public interface BookService extends GeneralService<Book> {

	Book getBookByName(String name);

	Book createBook(BookDTO bookDTO, AuthorDTO authorDto, PublishingHouseDTO houseDto, GenreDTO genreDto,
			PlaceDTO placeDto, LanguageDTO languageDto) throws SQLException;

	Book update(BookDTO bookDTO, AuthorDTO authorDto, GenreDTO genreDto, LanguageDTO languageDto, PlaceDTO placeDto,
			PublishingHouseDTO houseDto) throws SQLException;
}
