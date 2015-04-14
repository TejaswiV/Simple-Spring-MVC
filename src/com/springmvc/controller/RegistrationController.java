package com.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.bean.User;
import com.springmvc.dao.RegistrationDAO;
import com.springmvc.exceptions.ImageUploadException;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	@Qualifier("registrationDAO")
	RegistrationDAO dao;

	@RequestMapping(method = RequestMethod.POST)
	public String registerUser(
			@ModelAttribute("user") @Valid User user,
			BindingResult result,
			@RequestParam(value = "image", required = false) MultipartFile image,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "home";
		}
		boolean success = dao.saveUser(user);

		try {
			if (!image.isEmpty()) {
				validateImage(image);
				String path = request.getServletContext().getRealPath("/");
				
				saveImage(image.getOriginalFilename(), image, path);
			}
		} catch (ImageUploadException e) {
			result.reject(e.getMessage());
			System.out.println("ImageUploadException ::: " + e.getMessage());
			return "home";
		}

		if (success)
			return "Success";
		else
			return "Failure";
	}

	private void validateImage(MultipartFile image) {

		if (!(image.getContentType().equals("image/jpeg")
				|| image.getContentType().equals("image/png") || image
				.getContentType().equals("application/pdf"))) {
			throw new ImageUploadException(
					"Only jpeg,png images or pdf files are uploaded");
		}
	}

	private void saveImage(String filename, MultipartFile image, String path) {
		
		try {
			File file = new File(path + "/resources/ImageOrPdf/" + filename);
			//File file = new File("/Users/tejaswivenupalli/Eclipse Workspace/Spring/SpringMVCSimpleApp/resources/ImageOrPdf/" + filename);
			if (image.getContentType().equals("application/pdf")) {
				System.out.println("saving pdf at ::::    "+file.getPath());
				IOUtils.copy(image.getInputStream(), new FileOutputStream(file));
			} else {
				System.out.println("saving image  at ::::    "+file.getPath());
				FileUtils.writeByteArrayToFile(file, image.getBytes());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ImageUploadException("unable to save image");
		}

	}

}
