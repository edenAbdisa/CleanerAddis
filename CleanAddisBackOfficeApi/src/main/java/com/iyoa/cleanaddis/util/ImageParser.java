package com.iyoa.cleanaddis.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageParser {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ImageParser.class);
	private static final String folderPath = "C:\\Users\\Abdisa Gurmessa\\Desktop\\Eden\\CleanAddisBackOfficeApi\\src\\main\\resources\\templates\\static\\";
	private final String success = "Successfully Added!";
	private boolean isAdded = true;
	public String saveToDisk(MultipartFile file
			) throws IOException {
		File convertedFile = new File(folderPath+file.getOriginalFilename());
		convertedFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertedFile);
		fout.write(file.getBytes());
		fout.close();
		return folderPath+file.getOriginalFilename();	
	}

	private static void getImages(String imgLink) throws IOException {
		int indexname = imgLink.lastIndexOf("/");
		if (indexname == imgLink.length()) {
			imgLink = imgLink.substring(1, indexname);
		}

		indexname = imgLink.lastIndexOf("/");
		String name = imgLink.substring(indexname, imgLink.length());

		URL url = new URL(imgLink);
		try (InputStream in = url.openStream();
				OutputStream out =
						new BufferedOutputStream(new FileOutputStream(folderPath + name))) {
			for (int b; (b = in.read()) != -1;) {
				out.write(b);
			}
		} catch (IOException e) {
			LOGGER.info("IOException: ", e);
		}

	}
	
}
