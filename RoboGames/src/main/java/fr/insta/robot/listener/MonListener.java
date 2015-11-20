package fr.insta.robot.listener;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.context.ContextLoaderListener;

public class MonListener extends ContextLoaderListener {

	public MonListener() {
		super();
		System.out.println("salut");
		Timer monTimer = new Timer();
		TimerTask taskAExec = new TimerTask(){
			public void run(){
				System.out.println("coucou");
			}
		};
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.NOVEMBER, 1);
		monTimer.schedule(taskAExec, c.getTime(), 2592000000L);
	}
	
}
