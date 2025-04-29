package mylab.notification.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class, loader=AnnotationConfigContextLoader.class)
public class NotificationConfigTest {
	@Autowired
	EmailNotificationService emailService;
	
	@Autowired
	SmsNotificationService smsService;
	
	@Autowired
	NotificationManager notiManager;
	
	@Test
	void NotificationTest() {
		assertNotNull(notiManager);
		smsService.sendNotification("테스트에용");
		assertEquals("SKT", smsService.getProvider());
		
		emailService.sendNotification("테스트2에용");
		assertEquals("smtp.gmail.com", emailService.getSmtpServer());
		assertEquals(587, emailService.getPort());
	}

}
