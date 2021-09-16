package a.b.c.com.jso.book.service;

import java.util.ArrayList;

import a.b.c.com.jso.book.vo.BookVO;

public interface BookService {

	public ArrayList<BookVO> bookSelectAll();
	public ArrayList<BookVO> bookSelect(BookVO bvo);
	public int bookInsert(BookVO bvo);
	public int bookUpdate(BookVO bvo);
	public int bookDelete(BookVO bvo);
}
