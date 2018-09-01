package top.whattowatch.wtw.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope("singleton")
public class TokenManager {

	public static Map<String, Map<String, Object>> allToken = new HashMap<>();


	public String createToken(String id) {
		String token = createToken();
		// <'time',><'userId',>
		Map<String, Object> tokenMap = new ConcurrentHashMap<>();
		tokenMap.put("id", id);
		tokenMap.put("time", System.currentTimeMillis());
		allToken.put(token, tokenMap);
		return token;
	}

	/**
	 *
	 * @param token
	 * @param id
	 * @return
	 */
	public Integer verifyToken(String token, String id) {

		Map<String, Object> map = new HashMap<>();

		Map<String, Object> tokenMap = allToken.get(token);
		if (tokenMap == null) {
			return null;
		}
		long time = (long) tokenMap.get("time");


		long nowTime = System.currentTimeMillis();
		System.out.println("time:" + time);
		System.out.println("nowTime:" + nowTime);

		int timeSize=2*60;

		long residualTime=(time + timeSize*60 * 1000 - nowTime);

		//System.out.println("" +residualTime /1000+"");
		if (residualTime < 0) {
			allToken.remove(token);
			return null;
		}
		if (!tokenMap.get("id").equals(id)) {
			return null;
		}
		return 1;
	}

	public synchronized String createToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}