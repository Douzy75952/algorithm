package com.thinkjoy.base.utils;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonUtils {
	public static String javaToString(Object obj) {
		String json = "";

		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public static <T> T jsonToObject(String json, Class<T> T) {
		ObjectMapper mapper = new ObjectMapper();
		T result = null;
		try {
			result = mapper.readValue(json, T);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}

	public static void main(String[] args) {
//		Image image = new Image();
//		image.setUrl("htsdkfd://1231232");
//		String json = javaToString(image);
//		System.out.println(json);
//		Image image2 = jsonToObject(json, Image.class);
//		System.out.println(image2);

		
		List propertyMap= JsonUtils.jsonToObject("[{\"propertyId\":\"0911a83ec0264bcf885c7c7c31f040ef\",\"propertyName\":\"面层工艺\",\"properValueId\":\"14311025074045f5b147513ddfb7d0b3\",\"propertyValueName\":\"毛面\"},{\"propertyId\":\"3f6d85d126e84641aef5d6e152f2861c\",\"propertyName\":\"有无图案\",\"properValueId\":\"3c471db3711a4c03b788bfd24df30ced\",\"propertyValueName\":\"无图案\"},{\"propertyId\":\"8b46daee9aa6493783b7c1a939e18f5d\",\"propertyName\":\"墙纸规格\",\"properValueId\":\"151f653a51f54c05911dabcaee906c59\",\"propertyValueName\":\"7m^2 /卷\"},{\"propertyId\":\"8bd240d125244777bb903cf98a2f3a95\",\"propertyName\":\"适用范围\",\"properValueId\":\"a8a116721df341b4ae497bf356bf3e7c\",\"propertyValueName\":\"背景墙(大型壁画)\"},{\"propertyId\":\"b2510f6fb7f549fabd42dbd4d4aa5096\",\"propertyName\":\"同城服务\",\"properValueId\":\"200763ebcd104deeaefc7689597a5a58\",\"propertyValueName\":\"同城买家上门提货\"},{\"propertyId\":\"d99df421bb8a4faf8b220cdaf6857a02\",\"propertyName\":\"风格\",\"properValueId\":\"902affc1121347be859e04d577216704\",\"propertyValueName\":\"复古怀旧/老家具\"}]",List.class);
		Map map=(Map)propertyMap.get(0);
		System.out.println("propertyMap="+map.get("propertyName"));
	
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> readValue(String jsonString, JavaType javaType)
			throws JsonParseException {
		ObjectMapper mapper = new ObjectMapper();
		List<T> list = null;
		try {
			list = (List<T>) mapper.readValue(jsonString, javaType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
