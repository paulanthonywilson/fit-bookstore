package bookshop.web;

import bookshop.BookStoreApplication;
import bookshop.Book;
import static bookshop.Pounds.inPounds;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ApplicationFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (null == request.getSession().getAttribute("application")) {
            request.getSession().setAttribute("application", createBookStoreApplication());
        }
        filterChain.doFilter(request, servletResponse);
        filterConfig.getServletContext().getRequestDispatcher("/WEB-INF/application_layout.jsp").forward(request, servletResponse);

    }

    public void destroy() {
    }


    private BookStoreApplication createBookStoreApplication() {
        BookStoreApplication result = new BookStoreApplication();
        result.addBook(new Book()
                .withTitle("Twenty Thousand Leagues Under The Sea")
                .withAuthor("Jules Verne")
                .withDescription("Twenty Thousand Leagues Under the Sea (French: Vingt mille lieues sous les mers) is a classic science fiction novel by French writer Jules Verne published in 1870. It tells the story of Captain Nemo and his submarine Nautilus as seen from the perspective of his passenger Professor Pierre Aronnax. The first illustrated edition (not the original edition which had no illustrations) was published by Hetzel and contains a number of illustrations by Alphonse de Neuville and Edouard Riou.")
                .atPrice(inPounds(7.19)));
        result.addBook(new Book()
                .withTitle("Around the World in Eighty Days")
                .withAuthor("Jules Verne")
                .withDescription("Around the World in Eighty Days (French: Le tour du monde en quatre-vingts jours) is a classic adventure novel by the French writer Jules Verne, first published in 1873. In the story, Phileas Fogg of London and his newly employed French valet Passepartout attempt to circumnavigate the world in 80 days on a £20,000 wager set by his friends at the Reform Club.")
                .atPrice(inPounds(5.99)));
        result.addBook(new Book()
                .withTitle("Harry Potter and the Philosopher's Stone")
                .withAuthor("J. K. Rowling")
                .withDescription("Harry Potter and the Philosopher's Stone (published in the United States as Harry Potter and the Sorcerer's Stone) is the first novel in the Harry Potter series written by J. K. Rowling and featuring Harry Potter, a young wizard. It was published 30 June 1997 by Bloomsbury in London, and has been made into a feature-length film of the same name. This is also the most popular of the books in terms of number sold — an estimated 120 million copies worldwide. As of January 2008, the book is number twelve on the best selling book list of all time, and is the third best-selling non-religious, non-political work of fiction of all time.")
                .atPrice(inPounds(4.14)));
        result.addBook(new Book()
                .withTitle("Harry Potter and the Chamber of Secrets")
                .withAuthor("J. K. Rowling")
                .withDescription("Harry Potter and the Chamber of Secrets, is the second novel in the Harry Potter series written by J. K. Rowling. The book was published on 2 July 1998.")
                .atPrice(inPounds(4.89)));
        result.addBook(new Book()
                .withTitle("Harry Potter and the Prisoner of Azkaban")
                .withAuthor("J. K. Rowling")
                .withDescription("Harry Potter and the Prisoner of Azkaban is the third novel in the Harry Potter series written by J. K. Rowling. The book was published on 8 July 1999. The novel won both the 1999 Costa Book Awards and the Bram Stoker Award, and was short-listed for other awards, placing it among the most-honoured works of fantasy in recent history.[1] A film based on the book was released on 31 May 2004, in the United Kingdom and 4 June 2004 in the U.S. and many other countries.")
                 .atPrice(inPounds(4.49)));
        result.addBook(new Book()
                .withTitle("Harry Potter and the Goblet of Fire")
                .withAuthor("J. K. Rowling")
                .withDescription("Harry Potter and the Goblet of Fire is the fourth novel in the Harry Potter series written by J. K. Rowling. Published on 8 July 2000, the release of this book was surrounded by more hype than any other book in recent times[citation needed]—outdone only by its successors, Harry Potter and the Order of the Phoenix, Harry Potter and the Half-Blood Prince and Harry Potter and the Deathly Hallows. The book attracted additional attention because of a pre-publication warning from J. K. Rowling that one of the characters would be murdered in the book."));
        result.addBook(new Book()
                .withTitle("Harry Potter and the Order of the Phoenix")
                .withAuthor("J. K. Rowling")
                .withDescription("Harry Potter and the Order of the Phoenix is the fifth novel in the Harry Potter series written by J. K. Rowling. It is the longest book in the series, and was released on 21 June 2003. The novel features Harry's struggles through his fifth year at Hogwarts, including the surreptitious return of Harry's nemesis Lord Voldemort, O.W.L. exams, awkward teenage love and an obstructive Ministry of Magic. The book has been made into a film, which was released in 2007.")
                .atPrice(inPounds(5.99)));
        result.addBook(new Book()
                .withTitle("Harry Potter and the Half-Blood Prince")
                .withAuthor("J. K. Rowling")
                .withDescription("Harry Potter and the Half-Blood Prince, released on 16 July 2005, is the sixth of seven novels in J. K. Rowling's popular Harry Potter series. Set during Harry Potter's sixth year at Hogwarts, the novel explores Lord Voldemort's past, and Harry's preparations for the final battle amidst emerging romantic relationships and the emotional confusions and conflict resolutions characteristic of mid-adolescence.")
                .atPrice(inPounds(6.29)));
        result.addBook(new Book()
                    .withTitle("Harry Potter and the Deathly Hallows")
                    .withAuthor("J. K. Rowling")
                    .withDescription("arry Potter and the Deathly Hallows is the seventh and final of the Harry Potter novels written by British author J. K. Rowling. The book was released on 21 July 2007, ending the series that began in 1997 with the publication of Harry Potter and the Philosopher's Stone. This book chronicles the events directly following Harry Potter and the Half-Blood Prince (2005), and leads to the long-awaited final confrontation between Harry Potter and Lord Voldemort.")
                    .atPrice(inPounds(5.99)));
            return result;
    }
}
