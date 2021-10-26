package a.b.c.com.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.board.service.SpringBoardService;
import a.b.c.com.board.vo.SpringBoardVO;
import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.service.ChabunService;

@Controller
public class SpringBoardController {
	private Logger logger = Logger.getLogger(SpringBoardController.class);
	
	// 서비스 연결 
	private SpringBoardService springBoardService;
	private ChabunService chabunService;
	
	// 생성자 Autowired
	@Autowired(required=false)
	public SpringBoardController( SpringBoardService springBoardService,
								  ChabunService chabunService) {
		this.springBoardService = springBoardService;
		this.chabunService = chabunService;
	}
	
	// 게시판 글 입력 폼
	@RequestMapping(value="boardForm", method=RequestMethod.GET)
	public String boardForm() {
		return "board/springBoardForm";
	}
	
	// 글쓰기
	@RequestMapping(value="boardInsert", method=RequestMethod.POST)
	public String boardInsert(HttpServletRequest req) {
		logger.info("SpringBoardController boardInsert() 함수 진입 >>> : ");
		
		// 채번 구하기	>> ?? VO가 리턴형이넴. 공부하기
		System.out.println("채번 구하기 체크 >>> : " + ChabunUtil.getBoardChabun("M", chabunService.getBoardChabun().getSbnum()));
		String sbnum = ChabunUtil.getBoardChabun("M", chabunService.getBoardChabun().getSbnum());
		logger.info("BoardController boardInsert sbnum >>> : " + sbnum);
		
		// 이미지 업로드
		FileUploadUtil fu = new FileUploadUtil();	// 흠...
		// 이미지 파일 원본 사이즈
		// boolean bool = fu.imgfileUpload(req);
		// 이미지 파일 원본 사이즈 크기 조절하기
		/* 많은 파일들을 (생성하고) 거쳐서 돌아옴 */
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("BoardController boardInsert bool >>> : " + bool);
		
		// 채번, 이미지 업로드 성공하면 VO 세팅하기
		SpringBoardVO _bvo = null;
		_bvo = new SpringBoardVO();
		
		_bvo.setSbnum(sbnum);
		_bvo.setSbsubject(fu.getParameter("sbsubject"));	// MultipartRequest.getParameter(Stirng)
		_bvo.setSbname(fu.getParameter("sbpw"));
		_bvo.setSbpw(fu.getParameter("sbcontent"));
		_bvo.setSbfile(fu.getFileName("sbfile"));
		
		logger.info("SpringBoardController boardInsert _bvo.getSbnum() >>> : " + _bvo.getSbnum());
		logger.info("SpringBoardController boardInsert _bvo.getSbcontent() >>> : " + _bvo.getSbcontent());
		logger.info("SpringBoardController boardInsert _bvo.getSbfile() >>> : " + _bvo.getSbfile());
		int nCnt = springBoardService.boardInsert(_bvo);
		logger.info("SpringBoardController boardInsert nCnt >>> : " + nCnt);
		
		if(nCnt > 0) {
			return "board/springBoardInsert";
		}
		
		return "board/springBoardForm";
	} // end of boardInsert()
	
	// 글 목록 조회
	@RequestMapping(value="boardSelectAll", method=RequestMethod.GET)
	public String boardSelectAll(SpringBoardVO bvo, Model model) {
		logger.info("SpringBoardController boardSelectAll() 함수 진입 >>> : ");
		
		// 검색 구분자 및 검색어에 대한 vo의 get함수 호출 및 콘솔 출력
		logger.info("SpringBoardController boardSelectAll bvo.getKeyfilter() >>> : " + bvo.getKeyfilter());
		logger.info("SpringBoardController boardSelectAll bvo.getKeyword() >>> : " + bvo.getKeyword());
		logger.info("SpringBoardController boardSelectAll bvo.getStartdate() >>> : " + bvo.getStartdate());
		logger.info("SpringBoardController boardSelectAll bvo.getEnddate() >>> : " + bvo.getEnddate());
		
		// 서비스 불러오기
		List<SpringBoardVO> listAll = springBoardService.boardSelectAll(bvo);
		logger.info("SpringBoardController boardSelectAll listAll.size() >>> : " + listAll.size());
		
		if (listAll.size() > 0) {						// 요번에 이거 확실히..
			model.addAttribute("listAll", listAll);
			return "board/springBoardSelectAll";
		}
		return "board/springBoardForm";
	}
	
	// 게시글 수정/삭제 글 조회
	
	// 글 수정하기
	
	// 글 삭제하기
	
	// 비밀번호 체크하기
}
