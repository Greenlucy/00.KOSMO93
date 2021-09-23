package a.b.c.com.kosmo.book.service;

import java.util.ArrayList;

import a.b.c.com.kosmo.book.dao.BookDAO;
import a.b.c.com.kosmo.book.dao.BookDAOImpl;
import a.b.c.com.kosmo.book.vo.BookVO;

public class BookServiceImpl implements BookService {

	@Override
	public ArrayList<BookVO> bookSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl bookSelectAll() 함수 진입 >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookSelectAll();
	}

	@Override
	public ArrayList<BookVO> bookSelect(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl bookSelect() 함수 진입 >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookSelect(bvo);
	}

	@Override
	public int bookInsert(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl bookInsert() 함수 진입 >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookInsert(bvo);
	}

	@Override
	public int bookUpdate(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl bookUpdate() 함수 진입 >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookUpdate(bvo);
	}

	@Override
	public int bookDelete(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl bookDelete() 함수 진입 >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookDelete(bvo);
	}
}
