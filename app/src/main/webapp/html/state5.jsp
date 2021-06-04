<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="pagination">
        <div class="pagination_item01">
           시/도
        </div>
        <div class="pagination_item02">
           <select id ="sido" class="gno" name='gno'></select>
        </div>
        <div class="pagination_item03">
           시/군/구
        </div>
        <div class="pagination_item04">
           <select id ="sigungu" class="cno" name='cno'></select>
        </div>
        <div class="pagination_item05">
           <input type="button" class="img-search-btn">
        </div>
    </div>

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