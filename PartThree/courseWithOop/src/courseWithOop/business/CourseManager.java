package courseWithOop.business;

import courseWithOop.core.logging.Logger;
import courseWithOop.dataAccess.CourseDao;
import courseWithOop.entities.Course;



public class CourseManager {
	String coursNames[] = {"java", "Python"};
	String catagoryNames[] = {"Yazılım", "Donanım"};
	private CourseDao courseDao;
	private Logger[] loggers;
	
	public CourseManager(CourseDao courseDao, Logger[] loggers) {
		this.courseDao = courseDao;
		this.loggers = loggers;
	}
	
	
	public void add(Course course) throws Exception {
		if (course.getCoursePrice() < 0) {
			throw new Exception("Kurs fiyatı 0'dan küçük olamaz");
		}
		
		for (int i = 0; i < coursNames.length ; i++) {
			if (course.getCourseName().equalsIgnoreCase(coursNames[i])) {
				throw new Exception("Kurs ismi aynı olamaz");	
			}
		}
		
		for (int i = 0; i < coursNames.length ; i++) {
			if (course.getCatagory() == catagoryNames[i]) {
				throw new Exception("Katagori ismi aynı olamaz");
			}
		}
		
		courseDao.add(course);
		
		for (Logger logger : loggers) {
			logger.log(course.getCourseName());
		}
	}

}
