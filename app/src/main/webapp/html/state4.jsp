<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form class="d-flex" action='list' method='get'>
  <select id="sido" name='gno'></select>
  <select id="sigungu" name='cno'></select>
  <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
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