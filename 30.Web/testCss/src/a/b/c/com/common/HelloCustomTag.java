package a.b.c.com.common;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloCustomTag extends SimpleTagSupport{
	
	public void doTag() throws IOException{
		JspWriter out = getJspContext().getOut();
		out.println("<font color=red>");
		out.println("Hello My Custom Tag !!!! >>>>>>>>>>>>");
		out.println("</font>");
	}
}
