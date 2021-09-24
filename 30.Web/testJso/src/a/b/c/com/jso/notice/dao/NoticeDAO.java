package a.b.c.com.jso.notice.dao;

import java.util.ArrayList;

import a.b.c.com.jso.notice.vo.NoticeVO;

public interface NoticeDAO {
	
	public ArrayList<NoticeVO> noticeSelectAll();
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo);
	public int noticeInsert(NoticeVO nvo);
	public int noticeUpdate(NoticeVO nvo);
	public int noticeDelete(NoticeVO nvo);
}
