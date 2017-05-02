package com.nixsolutions.dao.hibernateImpl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.Book;
import com.nixsolutions.dao.DAOApi.BookDAO;

@Repository
@Transactional
public class HibernateBookDAO extends GeneralDAO<Book> implements BookDAO {

	public HibernateBookDAO() {
		super(Book.class);
	}

	@Override
	public Book getBookByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class)
				.add(Restrictions.eq("name", name));
		Book book = (Book) criteria.uniqueResult();
		return book;
	}

}
