package com.carmanager.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.junit.Test;

public final class DataUtils {

	 private DataUtils() {
	
	 }

	@Test
	public static String stringCode() {
		String rand = null;
		for (int i = 0; i < 4; i++) {
			int randomNum = new Random().nextInt(10);
			if (rand == null) {
				rand = String.valueOf(randomNum);
			} else {
				rand = rand + randomNum;
			}
		}
		System.out.println(md5(rand));
		return md5(rand);
	}

	/**
	 * MD5加密
	 */
	public static String md5(String str) {
		try {
			StringBuffer buffer = new StringBuffer();
			char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'A', 'B', 'C', 'D', 'E', 'F' };
			byte[] bytes = str.getBytes();
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] targ = digest.digest(bytes);
			for (byte b : targ) {
				buffer.append(chars[b >> 4 & 0x0F]);
				buffer.append(b & 0x0F);
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 深度复制
	 */
	public static Serializable deeplyCopy(Serializable serializable) {

		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					byteArrayOutputStream);
			objectOutputStream.writeObject(serializable);
			objectOutputStream.close();
			byteArrayOutputStream.close();

			byte[] bytes = byteArrayOutputStream.toByteArray();
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					bytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(
					byteArrayInputStream);
			Serializable copy = (Serializable) objectInputStream.readObject();
			objectInputStream.close();
			byteArrayInputStream.close();

			return copy;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
