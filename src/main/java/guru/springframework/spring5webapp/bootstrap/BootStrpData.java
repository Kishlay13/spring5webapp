package guru.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Address;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AddressRepository;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrpData implements CommandLineRunner {

	@Autowired
	private final AuthorRepository authoRepository;

	@Autowired
	private final BookRepository bookRepository;

	@Autowired
	private final PublisherRepository publisherRepository;

	@Autowired
	private final AddressRepository addressRepository;;

	public BootStrpData(AuthorRepository authoRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository, AddressRepository addressRepository) {
		super();
		this.authoRepository = authoRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
		this.addressRepository = addressRepository;

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Publisher publisher = new Publisher("winsden");

		Address address = new Address("a", "Pune", "MH", "411089");
		publisher.setAddress(address);
		addressRepository.save(address);
		publisherRepository.save(publisher);
		System.out.println("Count of Publishers is " + publisherRepository.count());

		Author amish = new Author("Amish", "Tripathi");
		Book shivaTriology = new Book("Shiva Triology", "1234");

		amish.getBooks().add(shivaTriology);
		shivaTriology.getAuthors().add(amish);
		shivaTriology.setPublisher(publisher);
		publisher.getBooks().add(shivaTriology);

		authoRepository.save(amish);
		bookRepository.save(shivaTriology);
		publisherRepository.save(publisher);

		Author shashi = new Author("shahsi", "tharoor");
		Book india = new Book("India 5050", "657");
		india.setPublisher(publisher);
		publisher.getBooks().add(india);
		shashi.getBooks().add(india);
		india.getAuthors().add(shashi);
		// india.setPublisher(publisher);

		authoRepository.save(shashi);
		bookRepository.save(india);
		// addressRepository.save(address);
		publisherRepository.save(publisher);

		System.out.println("Bootstarping application");
		System.out.println("Count of Books is " + bookRepository.count());

	}

}
