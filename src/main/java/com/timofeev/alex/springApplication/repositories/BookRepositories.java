package com.timofeev.alex.springApplication.repositories;

import com.timofeev.alex.springApplication.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepositories extends CrudRepository<Book, Long> {
}
