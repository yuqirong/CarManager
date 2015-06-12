package com.carmanager.test;

import java.io.IOException;

import org.junit.Test;

public class TestClass {
	
	@Test
	public void sendMsg(){
		try {
			SenderMessgeUtils.sendMessage("15757176636", "你好");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
