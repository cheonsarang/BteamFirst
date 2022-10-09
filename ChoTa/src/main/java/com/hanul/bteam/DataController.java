package com.hanul.bteam;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import chotamember.MemberDAO;
import common.CommonService;
import school.SchoolMealsVO;
import school.TimeTableVO;

@RestController
public class DataController {
	
	@Autowired private CommonService common;
	@Autowired private MemberDAO dao;
	Gson gson = new Gson();
	
	//기본인자
	//필수 변수
	/*
	KEY		STRING(필수)	  인증키	  기본값 : sample key
  	Type	STRING(필수)	  호출 문서(xml, json)	  기본값 : xml
  	pIndex	INTEGER(필수)	  페이지 위치	  기본값 : 1(sample key는 1 고정)
  	pSize	INTEGER(필수)	  페이지 당 신청 숫자	  기본값 : 100(sample key는 5 고정)
	 */
	
	//신청인자 - 급식
	/*
    office_code	ATPT_OFCDC_SC_CODE	     STRING(필수)	    시도교육청코드
    school_id	SD_SCHUL_CODE	     STRING(필수)	    표준학교코드
    school_name	SCHUL_NM	    학교명
    dish_date	MLSV_YMD	     STRING(선택)	    급식일자
    dish_name	DDISH_NM	    요리명
    or_info		ORPLC_INFO	    원산지정보
    cal_info	CAL_INFO	    칼로리정보
    ntr_info	NTR_INFO	    영양정보
	 */
	
	//신청인자 - 초등학교시간표
	/*
	office_code	ATPT_OFCDC_SC_CODE	     STRING(필수)	    시도교육청코드
    school_id	SD_SCHUL_CODE	     STRING(필수)	    표준학교코드
    school_name	SCHUL_NM	    학교명
    year		AY	     STRING(선택)	    학년도
    sem			SEM	     STRING(선택)	    학기
    ymd		    ALL_TI_YMD	     STRING(선택)	    시간표일자
    grade		GRADE	     STRING(선택)	    학년
    class_nm	CLASS_NM	     STRING(선택)	    반명
    period		PERIO	     STRING(선택)	    교시
    subject		ITRT_CNTNT	    수업내용    
	 */	
	
	//통합 기본 key, neisURL
	private String key
	="186463ee9f79470cb15f198ad2d52830";
	private String neisURL = "https://open.neis.go.kr/hub/";
	//https://open.neis.go.kr/hub/mealServiceDietInfo?KEY=186463ee9f79470cb15f198ad2d52830&Type=json&pIndex=1&pSize=100&ATPT_OFCDC_SC_CODE=F10&SD_SCHUL_CODE=7401189
	//https://open.neis.go.kr/hub/elsTimetable?KEY=186463ee9f79470cb15f198ad2d52830&Type=json&pIndex=1&pSize=100&ATPT_OFCDC_SC_CODE=F10&SD_SCHUL_CODE=7401189

	//학교별 급식 목록 조회 요청
	@RequestMapping(value = "/schoolmealslist", produces = "text/html;charset=utf-8")
	public Object schoolmeals_list(String office_code, String school_id) {
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		
//		map.put("school_id", school_id);
//		map.put("office_code", office_code);
		
		if(office_code == null || office_code == "B10") {
			school_id = "7401189";
			office_code = "F10";
		}

		
//		office_code = "F10";
//		school_id = "7401189";
		
		StringBuffer url
		= new StringBuffer( neisURL + "mealServiceDietInfo" );
		url.append("?KEY=").append(key);
		url.append("&Type=json");
		url.append("&pIndex=1");
		url.append("&pSize=1000");
		url.append("&ATPT_OFCDC_SC_CODE=").append(office_code);
		url.append("&SD_SCHUL_CODE=").append(school_id);

		JSONObject json = new JSONObject(common.requestAPI(url));
		JSONArray jarr = json.getJSONArray("mealServiceDietInfo");
		json = jarr.getJSONObject(1);
		jarr = json.getJSONArray("row");
		
		ArrayList<SchoolMealsVO> list = new ArrayList<SchoolMealsVO>();
		for (int i = 0; i < jarr.length(); i++) {
			list.add(new SchoolMealsVO());
			JSONObject tempObj = (JSONObject)jarr.get(i);
			list.get(i).setOffice_code(tempObj.get("ATPT_OFCDC_SC_CODE")+"");
			list.get(i).setSchool_id(tempObj.get("SD_SCHUL_CODE")+"");
			list.get(i).setSchool_name(tempObj.get("SCHUL_NM")+"");
			list.get(i).setDish_date(tempObj.get("MLSV_YMD")+"");
			list.get(i).setDish_name(tempObj.get("DDISH_NM")+"");
			list.get(i).setOr_info(tempObj.get("ORPLC_INFO")+"");
			list.get(i).setCal_info(tempObj.get("CAL_INFO")+"");
			list.get(i).setNtr_info(tempObj.get("NTR_INFO")+"");
		}
		System.out.println(list.get(10).getDish_name());
		return gson.toJson(list);
	}
	
	//초등학교시간표 조회 요청
	@RequestMapping(value = "/timetable", produces = "text/html;charset=utf-8")
	public Object timetable_list(String office_code, String school_id, String grade, String class_nm ) {
		
		//2개만 활용 예정
		//광주 계수초등학교 4학년 2반 김찬웅 선생님
		//office_code = "F10"; school_id = "7401189";
		
		//서울 용산초등학교 1학년 1반 김영문 선생님 → 정보바꿔야할 듯
		//office_code = "B10"; school_id = "7061074";		

		
//		office_code = "F10";
//		school_id = "7401189";
//		grade = "6";
//		class_nm = "2";
		
		if(office_code == null || office_code == "B10") {
			school_id = "7401189";
			office_code = "F10";
			grade = "4";
			class_nm = "2";
		}
				
		
		StringBuffer url
		= new StringBuffer( neisURL + "elsTimetable");
		url.append("?KEY=").append(key);
		url.append("&Type=json");
		url.append("&pIndex=1");
		url.append("&pSize=1000");
		url.append("&ATPT_OFCDC_SC_CODE=").append(office_code);
		url.append("&SD_SCHUL_CODE=").append(school_id);
		url.append("&AY=").append("2022");
		url.append("&SEM=").append("2");
		url.append("&GRADE=").append(grade);
		url.append("&CLASS_NM=").append(class_nm);
		
		JSONObject json = new JSONObject(common.requestAPI(url));
		JSONArray jarr = json.getJSONArray("elsTimetable");
		json = jarr.getJSONObject(1);
		jarr = json.getJSONArray("row");
		
		ArrayList<TimeTableVO> list = new ArrayList<TimeTableVO>();
		for (int i = 0; i < jarr.length(); i++) {
			list.add(new TimeTableVO());
			JSONObject tempObj = (JSONObject)jarr.get(i);
			list.get(i).setOffice_code(tempObj.get("ATPT_OFCDC_SC_CODE")+"");
			list.get(i).setSchool_name(tempObj.get("SD_SCHUL_CODE")+"");
			list.get(i).setSchool_name(tempObj.get("SCHUL_NM")+"");
			list.get(i).setYear(tempObj.get("AY")+"");
			list.get(i).setSem(tempObj.get("SEM")+"");
			list.get(i).setYmd(tempObj.get("ALL_TI_YMD")+"");
			list.get(i).setGrade(tempObj.get("GRADE")+"");
			list.get(i).setClass_nm(tempObj.get("CLASS_NM")+"");
			list.get(i).setPeriod(tempObj.get("PERIO")+"");
			list.get(i).setSubject(tempObj.get("ITRT_CNTNT")+"");
			
		}
		System.out.println(list.get(10).getSubject());
		return gson.toJson(list);
	}
	
	
	
}
