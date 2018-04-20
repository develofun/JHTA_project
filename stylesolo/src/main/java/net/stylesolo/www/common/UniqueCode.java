package net.stylesolo.www.common;

import java.util.UUID;

public class UniqueCode {
	
	public static String createCode(){
		return UUID.randomUUID().toString().split("-")[0];
	}
}
