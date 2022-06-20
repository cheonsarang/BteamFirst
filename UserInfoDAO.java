package pack05.ojdbc2;

public class UserInfoDAO extends StudentDAO{

	//현 StudentDAO 상속받아서 썼다면 나중에는 접속객체를 초기화 접속객체닫기 등등을 하나의 공동 클래스로 몰아넣기(재사용이 편함)
	//공통으로 사용되는 로직은 commons, common 등등 공통이라는 패키지를 별도로 두고 프로젝트 인원들이 같이 사용하도록 유도
	
	
	//로그인
	public UserInfoDTO getLogin(){
		conn = getConn();
		return null;
	}
	
	//회원가입
	public boolean joinUser() {
		
		return false;
	}
	
	
	
	
	
}
