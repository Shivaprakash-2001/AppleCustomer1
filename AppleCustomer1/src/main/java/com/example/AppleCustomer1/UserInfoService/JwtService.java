package com.example.AppleCustomer1.UserInfoService;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	public String generateToken(String username) {

		Map<String, Object> claims = new HashMap<>();

		return createToken(claims, username);

	}

	private String createToken(Map<String, Object> claims, String username) {

		return Jwts.builder()

				.setClaims(claims)

				.setSubject(username)

				.setIssuedAt(new Date(System.currentTimeMillis()))

				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))

				.signWith(getSecKey(), SignatureAlgorithm.HS256).compact();

	}

	private Key getSecKey() {

		byte[] keybytes = Decoders.BASE64.decode("2e057c49a7af580c0a84a6333d44b5de8f7535ff13db4b2e1fd182b2a8178aab");

		return Keys.hmacShaKeyFor(keybytes);

	}

	public String extractUsername(String token) {

		return extractClaim(token, Claims::getSubject);

	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);

		return claimsResolver.apply(claims);

	}

	private Claims extractAllClaims(String token) {

		return Jwts

				.parserBuilder()

				.setSigningKey(getSecKey())

				.build()

				.parseClaimsJws(token)

				.getBody();

	}

	public Boolean validateToken(String token, UserDetails userDetails) {

		final String username = extractUsername(token);

		boolean flag = username.equals(userDetails.getUsername()) && !isTokenExpired(token);

		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

	}

	private Boolean isTokenExpired(String token) {

		return extractExpiration(token).before(new Date());

	}

	public Date extractExpiration(String token) {

		return extractClaim(token, Claims::getExpiration);

	}

}