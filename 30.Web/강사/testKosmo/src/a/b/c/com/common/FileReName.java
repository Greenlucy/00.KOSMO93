package a.b.c.com.common;

import java.io.File;
import java.io.IOException;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileReName implements FileRenamePolicy {

	public FileReName(){
		
	}
	
	@Override
	public File rename(File sf) {
		// TODO Auto-generated method stub
		if (createNewFile(sf)){
			return sf;
		}
		
		String f = sf.getName();
		System.out.println("fileName >>> : " + f);
		
		try {
			String t = f;
			
			for (int i=0; sf.exists(); i++){
				int lt = t.lastIndexOf(".");
				String t1 = t.substring(0, lt);
				String t2 = t.substring(lt);
				String ft = "_[" + i + "]";
				f = t1 + ft + t2;
				sf = new File(sf.getParent(), f);
			}
			
		}catch(Exception e){
			System.out.println(" FileReName.rename() ===> : " + e);
		}
		
		return sf;
		
//		String body = null;
//	    String ext = null;
//
//	    int dot = f.lastIndexOf(".");
//	    if (dot != -1) {
//	      body = f.substring(0, dot);
//	      ext = f.substring(dot);  // includes "."
//	    }
//	    else {
//	      body = f;
//	      ext = "";
//	    }
//	    
//	    
//	    int count = 0;
//	    while (!createNewFile(sf) && count < 9999) {
//	      count++;
//	      String newName = body + count + ext;
//	      sf = new File(sf.getParent(), newName + "_["+count+"]");
//	    }
//
//	    return sf;
	}
	
	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		}
		catch (IOException ignored) {
			return false;
		}
	}
}

