package a.b.c.com.common;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonRead {
	
	public static void main(String[] args){
		JSONParser parser = new JSONParser();
		
		try {
			// ���� ��� ����
			String jsonFilePath = CommonJSON.JSON_FILE_PATH;
			File jsonFile = new File(jsonFilePath + "/JsonRead.json");
			
			// �Ľ� > ����ȯ
			Object obj = parser.parse(new FileReader(jsonFile));
			JSONObject jsonObject = (JSONObject)obj;
			
			// [String ��������]
			// key = name �� value �����ͼ� ����ϱ�
			String name = (String)jsonObject.get("name");
			System.out.println("name >>> : " + name);
			
			// [long ��������]
			// key = id �� value �����ͼ� ����ϱ�
			long id = (Long)jsonObject.get("id");
			System.out.println("id >>> : " + id);
			
			// [�迭 ����]
			// iterator�� ����..
			JSONArray phoneNum = (JSONArray)jsonObject.get("phoneNumbers");
			Iterator iter = phoneNum.iterator();
			// Ŀ�� �Լ� while() �ȿ��� ������
			while (iter.hasNext()){
				System.out.println("phoneNum >>> : " + iter.next());
			}
			
			// [�迭 ����]
			// key = address �����ͼ� ũ�⸸ŭ for() �ݺ��� ������ ����ϱ�. 
			// key = zipcode�� �����ͼ� ����ϱ�
			JSONArray array = (JSONArray)jsonObject.get("address");
			for(int i=0; i < array.size(); i++){
				JSONObject result = (JSONObject)array.get(i);
				System.out.println("street >>> : " + result.get("street"));
				System.out.println("city >>> : " + result.get("city"));
				System.out.println("address >>> : " + result.get("zipcode"));
			}
			
			String role = (String)jsonObject.get("role");
			System.out.println("role >>> : " + role);
		}catch(Exception e){
			
		}
	}
}
