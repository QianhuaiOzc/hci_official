package org.scauhci.official.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpSession;

public class TokenUtil {
	public static String create(HttpSession session) {

		@SuppressWarnings("unchecked")
		Set<String> tokens = (Set<String>) session.getAttribute("TOKEN");
		if (tokens == null) {
			tokens = new HashSet<String>();
			session.setAttribute("TOKEN", tokens);
		}

		String token = bornToken();
		while (tokens.contains(token)) {
			token = bornToken();
		}

		tokens.add(token);

		return token;
	}

	private static String bornToken() {

		String token = "";
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			String rand = String.valueOf(random.nextInt(10));
			token += rand;

		}

		return token;
	}
}
