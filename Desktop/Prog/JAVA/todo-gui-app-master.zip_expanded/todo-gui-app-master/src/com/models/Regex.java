package com.models;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
	public final static boolean REGEX_EMAIL_VALIDO(String email) {
		Pattern email_valido = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,8}$");
		Matcher email_matcher = email_valido.matcher(email);
		return email_matcher.matches();
	}
	
	public final static boolean REGEX_SENHA_VALIDA(String senha) {		
		Pattern senha_valida = Pattern.compile("^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*\\d.*\\d).{8,}$");
		Matcher senha_matcher = senha_valida.matcher(senha);
		return senha_matcher.matches();
	}
}
