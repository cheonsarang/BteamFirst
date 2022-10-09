package chotamember;


public class ScheduleVO {
	private int grade_class_code, school_id;
	private String context, category;
	private String ymd;
	private String writer;

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getGrade_class_code() {
		return grade_class_code;
	}
	public void setGrade_class_code(int grade_class_code) {
		this.grade_class_code = grade_class_code;
	}
	public int getSchool_id() {
		return school_id;
	}
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getYmd() {
		return ymd;
	}
	public void setYmd(String ymd) {
		this.ymd = ymd;
	}
	
	
	
	
	
	
}
