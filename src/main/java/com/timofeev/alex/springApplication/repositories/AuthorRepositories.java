package com.timofeev.alex.springApplication.repositories;

import com.timofeev.alex.springApplication.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author,Long> {
}
