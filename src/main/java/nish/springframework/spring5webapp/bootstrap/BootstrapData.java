package nish.springframework.spring5webapp.bootstrap;

import nish.springframework.spring5webapp.domain.Author;
import nish.springframework.spring5webapp.domain.Book;
import nish.springframework.spring5webapp.domain.Publisher;
import nish.springframework.spring5webapp.repositories.AuthorRepository;
import nish.springframework.spring5webapp.repositories.BookRepository;
import nish.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("aasdad");
        publisher.setCity("r");
        publisher.setState("c");

        publisherRepository.save(publisher);

        Author eric = new Author("eric","evans");
        Book ddd = new Book("ddd","123123");

        eric.getBooks().add(ddd);

        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","johnson");
        Book noEJB = new Book("J2ee","888");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("number of boks" + bookRepository.count());
        System.out.println("number of books for publisher" + publisherRepository.count());




    }
}
