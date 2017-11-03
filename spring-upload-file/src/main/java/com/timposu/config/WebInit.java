package com.timposu.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	private final int MAX_SIZE_FILE = 5 * 1024 * 1024;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		File uploadDir = new File(System.getProperty("java.io.tmpdir"));
		
		MultipartConfigElement multipartConfigElement =
				new MultipartConfigElement(uploadDir.getAbsolutePath(),
						MAX_SIZE_FILE, MAX_SIZE_FILE * 2, MAX_SIZE_FILE / 2);
		
		registration.setMultipartConfig(multipartConfigElement);
	}
}
