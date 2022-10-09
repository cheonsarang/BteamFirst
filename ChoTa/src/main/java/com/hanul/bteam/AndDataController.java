package com.hanul.bteam;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import api.AcademyDAO;
import api.AcademyVO;
import api.PlayVO;
import chotamember.MemberVO;
import chotamember.ScheduleDAO;
import chotamember.ScheduleVO;
import common.CommonService;

@RestController
public class AndDataController {
	@Autowired AcademyDAO dao_aca; 
	@Autowired ScheduleDAO dao_time;
	@Autowired private CommonService common;
	Gson gson = new Gson();
	
	private int list_total_count = 0;
	private String key = "";
	
	
	//스케줄 일정 삭제
	@RequestMapping(value = "scheduledelete", produces = "text/html;charset=utf-8")
	public void schedule_delete(String data) {
		ScheduleVO vo = gson.fromJson(data, ScheduleVO.class);
		dao_time.schedule_delete(vo);
	}
	
	
	//스케줄 일정 추가
	@RequestMapping(value = "scheduleinsert", produces = "text/html;charset=utf-8")
	//public String schedule_insert(String data) {
	public void schedule_insert(String data) {
		ScheduleVO vo = gson.fromJson(data, ScheduleVO.class);
		dao_time.schedule_insert(vo);
		//return "";
	}
	
	
	//스케줄 전체 조회
	@RequestMapping(value = "scheduleall", produces = "text/html;charset=utf-8")
	public String schedule_all(String data) {
		ScheduleVO vo = gson.fromJson(data, ScheduleVO.class);
		List<ScheduleVO> list = dao_time.schedule_all(vo);
		return gson.toJson(list);
	}
	
	
	//달력 일정 수정
	@RequestMapping(value = "scheduleupdate", produces = "text/html;charset=utf-8")
	public String schedule_update(String data) {
		ScheduleVO vo = gson.fromJson(data, ScheduleVO.class);
		int result = dao_time.schedule_update(vo);
		return "";
	}
	
	
	//달력에 일정 뿌리기 / 선택한 날짜
	@RequestMapping(value = "/schedulelist", produces = "text/html;charset=utf-8")
	public String schedule_list(String data) {
		//AcademyVO vo = gson.fromJson(tempVO, AcademyVO.class);
		ScheduleVO vo = gson.fromJson(data, ScheduleVO.class);
		List<ScheduleVO> list = dao_time.schedule_list(vo);
		return gson.toJson(list);
		
	}
	
	
	//찜 목록 보여주기
	@RequestMapping(value = "/heartlist", produces = "text/html;charset=utf-8")
	public String heart_list(String userid) {
		//AcademyVO vo = new Gson().fromJson(data, AcademyVO.class);
		List<AcademyVO> list = dao_aca.heart_list(userid);
		String result = gson.toJson(list);
		return result;
		//return gson.toJson(list);
	}
	
	
	@RequestMapping(value = "/playlist", produces = "text/html;charset=utf-8")
	public String play_list() {
	//public Map<String, Object> play_list(HttpServletRequest req) {
		key = "pYovlMLFQnW2UKYv2BcEIkHSL%2BQxu06FkdzYTyK9zN3Twj%2FX3oQDzSZGwiSG8zWA03xSHXavc3zUWFKWK1la3Q%3D%3D";
		StringBuffer url = new StringBuffer("https://api.odcloud.kr/api/15091154/v1/uddi:4185d32c-181d-44c9-9b95-c67f93a72501");
		url.append("?page=1").append("&perPage=1000");
		url.append("&serviceKey=").append(key);
		//url.append("&_type=json");
		//https://api.odcloud.kr/api/15091154/v1/uddi:4185d32c-181d-44c9-9b95-c67f93a72501?page=1&perPage=10&serviceKey=pYovlMLFQnW2UKYv2BcEIkHSL%2BQxu06FkdzYTyK9zN3Twj%2FX3oQDzSZGwiSG8zWA03xSHXavc3zUWFKWK1la3Q%3D%3D&_type=json
		JSONObject job = new JSONObject(common.requestAPI(url));
		JSONArray jarr = job.getJSONArray("data");
		ArrayList<PlayVO> list = new ArrayList<PlayVO>();
		for (int i = 0; i < jarr.length(); i++) {
			list.add(new PlayVO());
			JSONObject tempObj = (JSONObject) jarr.get(i);
			list.get(i).setMojibstart(tempObj.get("모집시작")+"");
			list.get(i).setMojibend(tempObj.get("모집마감")+"");
			list.get(i).setJangso(tempObj.get("창의적 체험활동 장소")+"");
			list.get(i).setAddr(tempObj.get("주소")+"");
			list.get(i).setHwaldong(tempObj.get("창의적 체험활동 제목")+"");
		}
		return gson.toJson(list);
	}
	
	@RequestMapping(value = "/academylist", produces = "text/html;charset=utf-8")
	public String academy_list(String data, String office_code) {
		key = "b4524659c26546128ed6150a5e84d4a5";
		//https://open.neis.go.kr/hub/acaInsTiInfo
		//?KEY=b4524659c26546128ed6150a5e84d4a5
		//&Type=json&pIndex=1
		//&pSize=100
		//&ATPT_OFCDC_SC_CODE=F10
		MemberVO vo = new Gson().fromJson(data, MemberVO.class);
		office_code = vo.getOffice_code();
		StringBuffer url = new StringBuffer("https://open.neis.go.kr/hub/acaInsTiInfo");
		url.append("?KEY=").append(key);
		url.append("&Type=json");
		url.append("&pIndex=1");
		url.append("&pSize=1");
		//url.append("&ATPT_OFCDC_SC_CODE=F10");
		url.append("&ATPT_OFCDC_SC_CODE=").append(office_code);
		JSONObject json = new JSONObject(common.requestAPI(url));
		JSONArray jarr = json.getJSONArray("acaInsTiInfo");
		json = jarr.getJSONObject(0);
		jarr = json.getJSONArray("head");
		json = jarr.getJSONObject(0);
		JSONObject listnum = (JSONObject)jarr.get(0);
		list_total_count = (int) listnum.get("list_total_count");
		int temp_cnt = list_total_count/1000;
		temp_cnt +=  list_total_count% (temp_cnt*1000) > 0 ? 1 : 0;
		
		ArrayList<AcademyVO> list = new ArrayList<AcademyVO>();
		
		for (int i = 0; i <temp_cnt; i++) {
			url = new StringBuffer("https://open.neis.go.kr/hub/acaInsTiInfo");
			url.append("?KEY=").append(key);
			url.append("&Type=json");
			url.append("&pIndex=" + (i+1));
			url.append("&pSize=").append(1000);
			//url.append("&ATPT_OFCDC_SC_CODE=F10");
			url.append("&ATPT_OFCDC_SC_CODE=").append(office_code);
			json = new JSONObject(common.requestAPI(url));
			jarr = json.getJSONArray("acaInsTiInfo");
			
			json = jarr.getJSONObject(1);
			jarr = json.getJSONArray("row");
			

			for (int j = 0; j < jarr.length(); j++) {
				list.add(new AcademyVO());
				JSONObject tempObj = (JSONObject)jarr.get(j);
				list.get(j).setOffice_code(tempObj.get("ATPT_OFCDC_SC_CODE")+"");
				list.get(j).setAcademy_name(tempObj.get("ACA_NM")+"");
				list.get(j).setStatus(tempObj.get("REG_STTUS_NM")+"");
				list.get(j).setField(tempObj.get("LE_CRSE_LIST_NM")+"");
				list.get(j).setAddr(tempObj.get("FA_RDNMA")+"");
				list.get(j).setDetail_addr(tempObj.get("FA_RDNDA")+"");
			}
		}
		
		System.out.println(list);
		return gson.toJson(list);
	}
	@RequestMapping(value = "/academylike", produces = "text/html;charset=utf-8")
	public void academy_like(String tempVO) {
		
		AcademyVO vo = gson.fromJson(tempVO, AcademyVO.class);
		System.out.println(vo);
		dao_aca.data_insert(vo);
		// vo=>
		//
		//INSERT INTO "BTEAM"."EDU_ACADEMY" (USERID, ACADEMY_NAME, STATUS, FIELD, ADDR, DETAIL_ADDR, HEART_ACA, OFFICE_CODE) VALUES ('2', '3', '4', '5', '6', '7', '8', '9')

		//return gson.toJson(0);
	}
	
	@RequestMapping(value = "/academydelike", produces = "text/html;charset=utf-8")
	public String academy_delike(String tempVO) {
		
		AcademyVO vo = gson.fromJson(tempVO, AcademyVO.class);
		dao_aca.data_delete(vo);
		// vo=>
		//
		//INSERT INTO "BTEAM"."EDU_ACADEMY" (USERID, ACADEMY_NAME, STATUS, FIELD, ADDR, DETAIL_ADDR, HEART_ACA, OFFICE_CODE) VALUES ('2', '3', '4', '5', '6', '7', '8', '9')

		return gson.toJson(0);
	}
	
	
}
