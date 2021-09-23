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
		
		// ���� �̹����� ��ü ����
		BufferedImage srcImg = ImageIO.read(new File(filePath));
		
		// ������ ����� �̹��� �ʺ�� ���� ����
		int dw = 300, dh = 400;
		
		// ���� �̹��� �ʺ�� ���� ��������
		int ow = srcImg.getWidth();
		int oh = srcImg.getHeight();
		
		// ���� ������ '�ʺ�'�� �������� ����� ���� ��� (���λ����� ��?)
		int nw = ow;
		int nh = (ow * dh)/dw;
		
		// ���� ���̰� �������� ���� �� (���� ������ ��  ���ϴ°ǰ�)
		// ���� ������ '����'�� �������� ����� ���� ���
		if(nh > oh) {
			nw = (oh*dw)/dw;
			nh = oh;
		}
		
		// ���� ũ�⸦ �������� ���� �̹����� ����� ũ��
		BufferedImage cropImag = Scalr.crop(srcImg,(ow-nw)/2,(oh-nh)/2,nw,nh);
		
		// ũ�ӵ� �̹����� ����� ����
		BufferedImage destImg = Scalr.resize(cropImag, dw, dh);
		// ����� ���� ���ϸ� �����ֱ�
		String editFile = "Thumb_"+fileName;
		System.out.println("������ �̹��� >>> : " + editFile);
		
		// ����� ����
		// mac.
//		String thumbName = thumnaillPath+"//Thumb_"+fileName;

		// window.
		String thumbName = thumnaillPath+"\\Thumb_"+fileName;
		File thumbFile = new File(thumbName);
		
		System.out.println("������ ���� ��� thumbName >>> : " + thumbName);
		System.out.println("������ ���ϸ� thumbFile >>> : " + thumbFile);
		
		// fileExt Ȯ���� ����.
		if(fileExt !=null && fileExt.toUpperCase().equals("JFIF")) {
			fileExt="jpg";
		}
		ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
		
		System.out.println("������ �̹��� ���� ����!");
		
		// ����
		return editFile;
	}
}
