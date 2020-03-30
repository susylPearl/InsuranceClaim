/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javra.medical.insurance.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailController {

	@Autowired
	private JavaMailSender mailhtmlSender;

	public void sendHtmlMailReject(String to, String subject, String empname, String remarks) {
		try {

			MimeMessage mimeMessage = mailhtmlSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
			StringBuilder sb = new StringBuilder();
			sb.append("<label>Dear\t</label>");
			sb.append(empname);
			sb.append(",");
			sb.append("<p><label>");
			sb.append("\t\t\t<label><b>Comment \t\t</b></label>\t\t\t\t").append("(").append(remarks).append(")");
			sb.append(
					"<p>Please Click <a href=\"http://10.0.1.213:8080/Spring-MVC-LoginForm-1.0.0-BUILD-SNAPSHOT/login\"> here </a>for approval</p>");
			sb.append("</body></html>");
			helper.setTo("abishkar.bhattarai@javra.com");
			helper.setSubject(subject);
			mimeMessage.setContent(sb.toString(), "text/html");
			mailhtmlSender.send(mimeMessage);

		} catch (MessagingException ex) {
			Logger.getLogger(SendMailController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void sendHtmlMailApprove(String e1, String e2, String name, String message) {

		try {

			MimeMessage mimeMessage = mailhtmlSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");

			StringBuilder sb = new StringBuilder();
			sb.append("<label>Dear\t</label>");
			sb.append(name);
			sb.append("<p></p>");
			sb.append(message);
			
			sb.append("</body></html>");
			helper.setTo("abishkar.bhattarai@javra.com");
			helper.setSubject("Claim Approval");
			helper.setFrom("abishkar.bhattarai@javra.com");
			mimeMessage.setContent(sb.toString(), "text/html");

			mailhtmlSender.send(mimeMessage);

		} catch (MessagingException ex) {
			Logger.getLogger(SendMailController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void sendHtmlMailFinance(String e1, String e2, String name, String message) {

		try {

			MimeMessage mimeMessage = mailhtmlSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");

			StringBuilder sb = new StringBuilder();
			sb.append("<label>Dear\t</label>");
			sb.append(name);
			sb.append("<p></p>");
			sb.append(message);
			sb.append("<p>Please Click <a href=\"http://10.0.1.213:8080/Spring-MVC-LoginForm-1.0.0-BUILD-SNAPSHOT/login\"> here </a>for approval</p>");
			sb.append("</body></html>");
			helper.setTo(e1);
			helper.setSubject("Claim for Approval");
			helper.setFrom(e1);
			mimeMessage.setContent(sb.toString(), "text/html");

			mailhtmlSender.send(mimeMessage);

		} catch (MessagingException ex) {
			Logger.getLogger(SendMailController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
