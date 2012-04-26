package com.aman.librarymangementsystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.domain.Book;
import com.aman.service.BookService;

/**
 * Servlet implementation class BookEntry
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// to do
	// populate the bean object with the values entered --> Call the service -->
	// view
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);

	}

	private void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		populateBook(request, book);
		BookService bookService = new BookService();
		bookService.create(book);
		List<Book> books = bookService.getList();
		request.setAttribute("bookDetail", books);
		RequestDispatcher view = request
				.getRequestDispatcher("BookUserScreen.jsp");
		view.forward(request, response);
	}

	private void populateBook(HttpServletRequest request, Book book) {
		book.setAuthor(request.getParameter("author"));
		book.setTitle(request.getParameter("title"));
		book.setCopies(Integer.parseInt(request.getParameter("copies")));
		book.setDescription(request.getParameter("description"));
		book.setGenre(request.getParameter("genre"));
		book.setPublisher(request.getParameter("publisher"));
	}

}