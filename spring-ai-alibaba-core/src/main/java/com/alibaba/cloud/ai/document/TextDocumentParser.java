package com.alibaba.cloud.ai.document;

import org.springframework.ai.document.Document;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TextDocumentParser implements DocumentParser {

	private final Charset charset;

	public TextDocumentParser() {
		this(UTF_8);
	}

	public TextDocumentParser(Charset charset) {
		Assert.notNull(charset, "charset");
		this.charset = charset;
	}

	@Override
	public Document parse(InputStream inputStream) {
		try {
			String text = new String(inputStream.readAllBytes(), charset);
			if (text.isBlank()) {
				throw new Exception();
			}
			return new Document(text);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
