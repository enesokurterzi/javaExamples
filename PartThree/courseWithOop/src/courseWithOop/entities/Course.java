package courseWithOop.entities;

public class Course {
	private String teacherNameandSurname;
	private String courseName;
	private String catagory;
	private Integer coursePrice;
	
	
	public Course(String teacherNameandSurname, String courseName, String catagory, Integer coursePrice) {
		this.teacherNameandSurname = teacherNameandSurname;
		this.courseName = courseName;
		this.catagory = catagory;
		this.coursePrice = coursePrice;
	}

	public String getTeacherNameandSurname() {
		return teacherNameandSurname;
	}

	public void setTeacherNameandSurname(String teacherNameandSurname) {
		this.teacherNameandSurname = teacherNameandSurname;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public Integer getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Integer coursePrice) {
		this.coursePrice = coursePrice;
	}
	
}
