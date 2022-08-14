package com.sample.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.controller.service.OutputStreamSample;

/** サンプルコントローラー */
@RestController
public class HelloController {

	/** ファイル作成処理サンプル */
	@Autowired
	OutputStreamSample outputStreamSample;

	private final String message = "ファイルが作成されました(ﾟ∀ﾟ)";

	/**
	 * getメソッドで処理を実行(http://localhost:8080/api)
	 *
	 * @throws IOException
	 * @return 表示メッセージ
	 */
	@GetMapping("api")
	public String hello() throws IOException {

		// ここにファイル作成処理を実行する。
		outputStreamSample.createFile();

		return message;
	}
}
