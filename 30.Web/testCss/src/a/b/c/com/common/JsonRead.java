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
			// 파일 경로 연결
			String jsonFilePath = CommonJSON.JSON_FILE_PATH;
			File jsonFile = new File(jsonFilePath + "/JsonRead.json");
			
			// 파싱 > 형변환
			Object obj = parser.parse(new FileReader(jsonFile));
			JSONObject jsonObject = (JSONObject)obj;
			
			// [String 데이터형]
			// key = name 의 value 가져와서 출력하기
			String name = (String)jsonObject.get("name");
			System.out.println("name >>> : " + name);
			
			// [long 데이터형]
			// key = id 의 value 가져와서 출력하기
			long id = (Long)jsonObject.get("id");
			System.out.println("id >>> : " + id);
			
			// [배열 형태]
			// iterator가 뭘까..
			JSONArray phoneNum = (JSONArray)jsonObject.get("phoneNumbers");
			Iterator iter = phoneNum.iterator();
			// 커서 함수 while() 안에서 돌리기
			while (iter.hasNext()){
				System.out.println("phoneNum >>> : " + iter.next());
			}
			
			// [배열 형태]
			// key = address 가져와서 크기만큼 for() 반복문 돌려서 출력하기. 
			// key = zipcode도 가져와서 출력하기
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
