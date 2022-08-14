package com.sample.app.controller.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

//import org.apache.commons.io.IOUtils;

/** ファイル作成処理サンプル */
@Service
public class OutputStreamSample {
	/**
	 * ファイル作成処理
	 * 
	 * @throws IOException
	 */
	public void createFile() throws IOException {
		// ファイルの中身を記載
		String exampleString = "HelloWorld\nようこそSpringBootの世界へ\nこれが作成されたファイルの内容だよ\n⊂⌒~⊃｡Д｡)⊃";
		// ライブラリ「org.apache.commons.io」を利用して String → InputStream を作成
		// toInputStream(InputStream, 文字コードの指定);
		InputStream inputStream = IOUtils.toInputStream(exampleString, StandardCharsets.UTF_8);
		// ファイル生成
		String resourcesPath = "src/main/resources/output/";
		FileOutputStream outputStream = new FileOutputStream(new File(resourcesPath + "samplefile.txt"));
		// ファイル書き込み処理
		int mojiIndex;
		while ((mojiIndex = inputStream.read()) != -1) {
			char getSingleChar = (char) mojiIndex;
			outputStream.write(getSingleChar);
		}
	}
}
