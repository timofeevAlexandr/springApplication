package com.timofeev.alex.springApplication.bootstrap;

import com.timofeev.alex.springApplication.model.Author;
import com.timofeev.alex.springApplication.model.Book;
import com.timofeev.alex.springApplication.repositories.AuthorRepositories;
import com.timofeev.alex.springApplication.repositories.BookRepositories;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepositories authorRepositories;
    private BookRepositories bookRepositories;

    public DevBootstrap(AuthorRepositories authorRepositories, BookRepositories bookRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driver design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepositories.save(eric);
        bookRepositories.save(ddd);

        //Rob
        Author rob = new Author("Rob", "Jonson");
        Book noEJB = new Book("J2EE Development without EJB", "1234", "HWorh");
        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);

        authorRepositories.save(rob);
        bookRepositories.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
