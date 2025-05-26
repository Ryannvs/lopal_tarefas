package br.dev.marcos.tarefas.utils;

import java.util.UUID;

public class Utils {
	public static String gerarUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidstr = uuid.toString().substring(0,8);
		
		return uuidstr;
	}
}
