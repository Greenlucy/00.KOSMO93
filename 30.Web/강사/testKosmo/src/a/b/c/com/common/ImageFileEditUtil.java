package a.b.c.com.common;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;

public class ImageFileEditUtil {
	
	public static String makeThumbnail(	String filePath, String thumnaillPath, 
			 							String fileName, String fileExt, 
			 							HttpServletRequest req) throws Exception{
		
//		ServletContext context = req.getSession().getServletContext();
//		String thumnaillPath = context.getRealPath("editImages");
		
		System.out.println("thumnaillPath >>> " + thumnaillPath);
		
		// 원본 이미지로 객체 생성
		BufferedImage srcImg = ImageIO.read(new File(filePath));
		
		// 생성할 썸네일 이미지 너비와 높이 지정
		int dw = 300, dh = 400;
		
		// 원본 이미지 너비와 높이 가져오기
		int ow = srcImg.getWidth();
		int oh = srcImg.getHeight();
		
		// 원본 사이즈 '너비'를 기준으로 썸네일 비율 계산 (세로사진일 때?)
		int nw = ow;
		int nh = (ow * dh)/dw;
		
		// 계산된 높이가 원본보다 높을 때 (가로 사진일 때  말하는건가)
		// 원본 사이즈 '높이'를 기준으로 썸네일 비율 계산
		if(nh > oh) {
			nw = (oh*dw)/dw;
			nh = oh;
		}
		
		// 계산된 크기를 바탕으로 원본 이미지를 가운데서 크롭
		BufferedImage cropImag = Scalr.crop(srcImg,(ow-nw)/2,(oh-nh)/2,nw,nh);
		
		// 크롭된 이미지로 썸네일 생성
		BufferedImage destImg = Scalr.resize(cropImag, dw, dh);
		// 썸네일 저장 파일명 정해주기
		String editFile = "Thumb_"+fileName;
		System.out.println("쎔네일 이미지 >>> : " + editFile);
		
		// 썸네일 저장
		// mac.
//		String thumbName = thumnaillPath+"//Thumb_"+fileName;

		// window.
		String thumbName = thumnaillPath+"\\Thumb_"+fileName;
		File thumbFile = new File(thumbName);
		
		System.out.println("섬네일 저장 경로 thumbName >>> : " + thumbName);
		System.out.println("섬네일 파일명 thumbFile >>> : " + thumbFile);
		
		// fileExt 확장자 변경.
		if(fileExt !=null && fileExt.toUpperCase().equals("JFIF")) {
			fileExt="jpg";
		}
		ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
		
		System.out.println("섬네일 이미지 생성 성공!");
		
		// 리턴
		return editFile;
	}
}
