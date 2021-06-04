<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>키워드로 장소검색하기</title>
    
</head>
<body>
<input type="hidden" id="stateName" value="${stateName}"> 
<input type="hidden" id="cityName" value="${cityName}">
<div id="map" style="width:100%;height:350px;"></div>
<!-- <table id="hospital-table" class="table table-hover">
  <thead>
	  <tr>
	    <th> 번호 </th>
	    <th> &nbsp;&nbsp;&nbsp; &nbsp;  이름 </th>
	    <th> &nbsp;&nbsp;&nbsp;&nbsp;전화 번호 </th>
	    <th> &nbsp;&nbsp;&nbsp;&nbsp; 주소 </th>
	    <th>  평점 </th>
	    <th> 즐겨찾기 </th>
	  </tr>
  </thead>
  <tbody>
  </tbody>
</table> -->

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2793f88bea0d7a6546285f048e073074&libraries=services"></script>
<script>
var stateName = document.getElementById('stateName').value;
var cityName = document.getElementById('cityName').value;
var address = stateName + cityName;
console.log(stateName);
console.log(cityName);
console.log(address);
var hospitalTableTbody = document.querySelector('#hospital-table > tbody');
// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 10 // 지도의 확대 레벨 
}; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 
var lat,lon;

//HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
            console.log("===>" ,lat,lon)
        
        locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
        
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
            
       // 키워드로 장소를 검색합니다
        ps.keywordSearch(address+ '동물 병원', placesSearchCB, {
            location: new kakao.maps.LatLng(lat, lon)
           
        });
            
      });
    
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
     locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
        message = 'geolocation을 사용할수 없어요..'
        
    displayMarker(locPosition, message);
}

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}    

console.log(address);
// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

    	  console.log(data);
        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

            console.log(address);
        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
            /* var tr = "<tr>" 
            + "<td>"+ i +"</td>"
            + "<td><a href=detail?a=" + address + "&h="+ data[i].place_name + ">" + data[i].place_name + "</a>" + "</td>"
            + "<td>"+ data[i].phone +"</td>"
            + "<td>"+ data[i].address_name +"</td>"
            + "<td> &nbsp;&nbsp;"+ i +"</td>"
            + "<td> &nbsp;&nbsp;"+ i +"</td>"
          +"</tr>";
            hospitalTableTbody.innerHTML = hospitalTableTbody.innerHTML + tr; */
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
        // 인서트문 만들기
        var sql = "";
        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
            
            var sql = sql + "insert into pet_hp(cno, name, tel, addr, stime, etime, vet, park) values"
            	+ "( 1, '"+ data[i].place_name + "'" + "," 
            			+ "'" + data[i].phone + "' ," 
            			+ "'" + data[i].address_name + "',"
            			+ "10, 22, 2, 0);\n";
        } 
        
        console.log(sql);
        //
    } 
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}
</script>
</body>
</html>