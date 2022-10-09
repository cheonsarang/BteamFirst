package chotamember;

public class EventVO {
    private String member_id, success_day;
	private int succcess_cnt;


	public String getSuccess_day() {
		return success_day;
	}
	public void setSuccess_day(String success_day) {
		this.success_day = success_day;
	}
    public String getMember_id() {
        return member_id;
    }
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
    public int getSucccess_cnt() {
        return succcess_cnt;
    }
    public void setSucccess_cnt(int succcess_cnt) {
        this.succcess_cnt = succcess_cnt;
    }

}
