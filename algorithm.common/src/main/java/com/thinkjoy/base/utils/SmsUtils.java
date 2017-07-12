package com.thinkjoy.base.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SmsUtils {
	private static Logger logger = LogManager.getLogger("FileUtil");
	public static Integer postSms(String smsUrl,String phone,String content,Integer messageType) throws IOException {

		Integer result = 0;
		String response = null;
		try {
			response = HttpUtil.executeGet(smsUrl+"?messageType="+messageType+"&phone="+phone+"&content="+content,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(response);
		Map json = JsonUtils.jsonToObject(response, HashMap.class);
		if (json !=null &&json.containsKey("result"))

			result = (Integer) json.get("result");

		// ImageUtils.GenerateImage(base64Str, "/Users/larry/test.png");

		return result;
	}


}
