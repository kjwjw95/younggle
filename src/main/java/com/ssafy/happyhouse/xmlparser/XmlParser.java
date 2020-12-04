package com.ssafy.happyhouse.xmlparser;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseDealsDto;

@Service
public class XmlParser {
	@Autowired
	XmlparsingDao dao;
    // tag값의 정보를 가져오는 메소드
	public String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
//	public static void main(String[] args) {
//		String code = "11110";
//		String Dealymd="20200101";
//		Parsing(code, Dealymd);
//	
//	}
	 public void Parsing(String code, String Dealymd) {
		int page = 1;	// 페이지 초기값 
		List<HouseDealsDto> houses= new ArrayList<HouseDealsDto>();
		try{
			while(page<12){
				// parsing할 url 지정(API 키 포함해서)
				String key ="Jb%2B98eBK4jZhuaGEAPQeYi%2FXIHbf99SBcVg3CO3abtJ11Ga6UtcEnWtk84AC6vd%2F%2Fc05E%2BsCdadGQxxPyKRiRQ%3D%3D";
				//String code="11110";
				String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?LAWD_CD="+code+"&DEAL_YMD=202001&serviceKey="+key;
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						String dong = getTagValue("법정동", eElement);
						String aptName = getTagValue("아파트", eElement);
						String codes = getTagValue("지역코드", eElement);
						String dealAmount = getTagValue("거래금액", eElement);
						String buildYear = getTagValue("건축년도", eElement);
						String dealYear = getTagValue("년", eElement);
						String dealMonth = getTagValue("월", eElement);
						String dealDay = getTagValue("일", eElement);
						String area = getTagValue("전용면적", eElement);
						String floor = getTagValue("층", eElement);
						String jibun = getTagValue("지번", eElement);
						houses.add(new HouseDealsDto(dong, aptName, codes, dealAmount, buildYear, dealYear, dealMonth, dealDay, area, floor, jibun, "매매"));
//						System.out.println("######################");
						//System.out.println(eElement.getTextContent());
//						System.out.println("도로명  : " + getTagValue("도로명", eElement));
						//System.out.println("도로명건물본번호코드  : " + getTagValue("도로명건물본번호코드", eElement));
//						System.out.println("법정동 : " + getTagValue("법정동", eElement));
//						System.out.println("전용면적  : " + getTagValue("전용면적", eElement));
//						System.out.println("지역코드  : " + getTagValue("지역코드", eElement));
					}	// for end
				}	// if end
				
				page += 1;
				System.out.println("page number : "+page);
//				if(page > 12){
//					break;
//				}
			}	// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		dao.insert(houses);
//		for(int i=0;i<houses.size();i++) {
//			HouseDealDto apart = houses.get(i);
//			System.out.println(apart.getAptName());
//			session.insert("ssafy.member.inserthouse", apart);
//		}
		//return houses;
	}	// main end
}	// class end

