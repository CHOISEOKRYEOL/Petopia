<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action='list' method='get'>
 <select id="sido" class="col-md-4" name='gno'>
        <option value=''>시/도</option>
        <option value='${hospital.bigAddress.no}' ${hospital.bigAddress.no == hospital.bigAddress.no ? "selected" : ""}>${hospital.bigAddress.name}</option>
      </select>
      <select id="sigungu" class="col-md-4" name='cno'>
        <option value=''>시/군/구</option>
        <option value='${hospital.smallAddress.no}' ${hospital.smallAddress.no == hospital.smallAddress.no ? "selected" : ""}>${hospital.smallAddress.name}</option>
 </select>
</form>

<script>
"use strict"

var sidoList;

$.getJSON('/web/app/mytown/city', function(result) {
    sidoList = result;
    for (var sido of result) {
        $('<option>').attr('value', sido.no).html(sido.name).appendTo('#sido'); 
    }
    
    for (var sigungu of result[0].sigungu) {
        $("<option>").attr('value', sigungu.no).html(sigungu.name).appendTo('#sigungu');
    }

/*    var sql = '';
    for (var sido of result) {
      sql = sql + "insert into pet_state(gno, gname) values('" + sido.no + "', '" + sido.name + "');\n";
      
      for (var sigungu of sido.sigungu) {
        sql = sql + "insert into pet_city(gno, cname) values('" + sido.no + "', '" + sigungu.name + "');\n";
      }
    }
    console.log(sql); */
    
  }).fail(function(xhr, textStatus, error) {
      console.log(error);
  });
 
$('#sido').change(function() {
  $('#sigungu').html('');
  for (var sigungu of sidoList[this.value - 1].sigungu) {
      $("<option>").attr('value', sigungu.no).html(sigungu.name).appendTo('#sigungu');
  }
});

    
</script>