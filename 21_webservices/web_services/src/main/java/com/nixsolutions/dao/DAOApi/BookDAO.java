package com.nixsolutions.dao.DAOApi;

import com.nixsolutions.entity.Book;

public interface BookDAO extends GeneralDAOApi<Book> {
	
	Book getBookByName(String name);
}
