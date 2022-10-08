package courseWithOop;

import courseWithOop.business.CourseManager;
import courseWithOop.core.logging.DatabaseLogger;
import courseWithOop.core.logging.Logger;
import courseWithOop.core.logging.MailLogger;
import courseWithOop.dataAccess.HibernateCourseDao;
import courseWithOop.entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {
		Course course1 = new Course("Enes OKURTERZİ", "Java ile veritabanı", "Programlama", 0);
		
		Logger[] loggers = {new DatabaseLogger(), new MailLogger()};
		
		CourseManager courseManager = new CourseManager(new HibernateCourseDao(), loggers);
		
		courseManager.add(course1);

	}

}
