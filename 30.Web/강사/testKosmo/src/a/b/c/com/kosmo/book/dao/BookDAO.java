package a.b.c.com.kosmo.book.dao;

import java.util.ArrayList;

import a.b.c.com.kosmo.book.vo.BookVO;

public interface BookDAO {

	public ArrayList<BookVO> bookSelectAll();
	public ArrayList<BookVO> bookSelect(BookVO bvo);	
	public int bookInsert(BookVO bvo);
	public int bookUpdate(BookVO bvo);
	public int bookDelete(BookVO bvo);
}
