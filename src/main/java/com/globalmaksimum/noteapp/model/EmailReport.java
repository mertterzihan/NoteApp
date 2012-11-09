package com.globalmaksimum.noteapp.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;

public class EmailReport implements ReportingService {

	private SimpleMailMessage message;
	private MailSender mailSender;
	private UserRepository userRepository;
	private NoteRepository noteRepository;

	@Override
	@Scheduled(cron = "0 0 * * * *")
	public void generateAndSendReport() throws SQLException,
			ClassNotFoundException {
		List<Note> list = noteRepository.retrieveNotesByDate(new Date());
		User user = userRepository.retrieveUser("admin");

		SimpleMailMessage msg = new SimpleMailMessage(this.message);
		msg.setTo(user.getEmail());
		String text = "Dear " + user.getName() + " " + user.getSurname()
				+ ",\n" + "You have the following note(s) for today:\n";
		Iterator<Note> iter = list.iterator();
		Integer i = 0;
		while (iter.hasNext()) {
			Note temp = iter.next();
			i++;
			text += i.toString() + ". " + temp.getNote() + " with priority "
					+ temp.getPriority() + "\n";
		}
		msg.setText(text);
		try {
			mailSender.send(msg);
		} catch (MailException ex) {
			// log it and go on
			System.err.println(ex.getMessage());
		}

	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public SimpleMailMessage getMessage() {
		return message;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public NoteRepository getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

}
