package com.cokkies.app.cokiesController;

import java.net.http.HttpRequest;
import java.util.Date;

import javax.crypto.SecretKey;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class CokiesController {
	private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	
	@GetMapping("/genrate")
	public String genrateCokies(@RequestParam String username, @RequestParam String role,HttpServletResponse res) {
		String token = genrateToken(username, role);
		Cookie cookie = new Cookie(username, token);
		cookie.setMaxAge(36000);
		cookie.setSecure(false);
		cookie.setPath("/");
		res.addCookie(cookie);
		return "cookie added successfully go and check it ";
	}

	public String genrateToken(String username,  String role) {
		String token = Jwts.builder().setSubject(username).claim("ROLE", role).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 3600000)).signWith(key).compact();
		return token;
	}
	 // ================= READ COOKIE & TOKEN =================
    @GetMapping("/read")
    public String getCookies(jakarta.servlet.http.HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return "No cookies found";
        }

        for (Cookie cookie : cookies) {
            if ("authToken".equals(cookie.getName())) {

                String token = cookie.getValue();

                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                String username = claims.getSubject();
                String role = claims.get("role", String.class);

                return "Username = " + username + ", Role = " + role;
            }
        }

        return "Auth token cookie not found";
    }
}
