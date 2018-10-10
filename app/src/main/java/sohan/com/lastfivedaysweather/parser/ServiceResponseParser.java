package sohan.com.lastfivedaysweather.parser;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import sohan.com.lastfivedaysweather.dto.ResponseDetailsDto;

public class ServiceResponseParser {

	public static <T> ResponseDetailsDto getResponse(TypeToken<ResponseDetailsDto> typeToken, Object result) {
		ResponseDetailsDto response = new ResponseDetailsDto();
		try {
			if (result != null && result instanceof String) {
				String res = result.toString();
				if (!TextUtils.isEmpty(res)) {
					response = new Gson().fromJson(res, typeToken.getType());
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
