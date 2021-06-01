<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
<style>
.star-input>.input,
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('../../images/grade_img.png')no-repeat;}
.star-input{display:inline-block; white-space:nowrap;width:180px;height:40px;padding:25px;line-height:30px;}
.star-input>.input{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}
.star-input>.input>input{position:absolute;width:1px;height:1px;opacity:0;}
.star-input>.input.focus{outline:1px dotted #ddd;}
.star-input>.input>label{width:30px;height:0;padding:28px 0 0 0;overflow: hidden;float:left;cursor: pointer;position: absolute;top: 0;left: 0;}
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{background-size: 150px;background-position: 0 bottom;}
.star-input>.input>label:hover~label{background-image: none;}
.star-input>.input>label[for="p1"]{width:30px;z-index:5;}
.star-input>.input>label[for="p2"]{width:60px;z-index:4;}
.star-input>.input>label[for="p3"]{width:90px;z-index:3;}
.star-input>.input>label[for="p4"]{width:120px;z-index:2;}
.star-input>.input>label[for="p5"]{width:150px;z-index:1;}
.star-input>output{display:inline-block;width:60px; font-size:18px;text-align:right; vertical-align:middle;}


.second-star-input>.input,
.second-star-input>.input>label:hover,
.second-star-input>.input>input:focus+label,
.second-star-input>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('../../images/grade_img.png')no-repeat;}
.second-star-input{display:inline-block; white-space:nowrap;width:180px;height:40px;padding:25px;line-height:30px;}
.second-star-input>.input{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}
.second-star-input>.input>input{position:absolute;width:1px;height:1px;opacity:0;}
.second-star-input>.input.focus{outline:1px dotted #ddd;}
.second-star-input>.input>label{width:30px;height:0;padding:28px 0 0 0;overflow: hidden;float:left;cursor: pointer;position: absolute;top: 0;left: 0;}
.second-star-input>.input>label:hover,
.second-star-input>.input>input:focus+label,
.second-star-input>.input>input:checked+label{background-size: 150px;background-position: 0 bottom;}
.second-star-input>.input>label:hover~label{background-image: none;}
.second-star-input>.input>label[for="p6"]{width:30px;z-index:5;}
.second-star-input>.input>label[for="p7"]{width:60px;z-index:4;}
.second-star-input>.input>label[for="p8"]{width:90px;z-index:3;}
.second-star-input>.input>label[for="p9"]{width:120px;z-index:2;}
.second-star-input>.input>label[for="p10"]{width:150px;z-index:1;}
.second-star-input>output{display:inline-block;width:60px; font-size:18px;text-align:right; vertical-align:middle;}



.third-star-input>.input,
.third-star-input>.input>label:hover,
.third-star-input>.input>input:focus+label,
.third-star-input>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('../../images/grade_img.png')no-repeat;}
.third-star-input{display:inline-block; white-space:nowrap;width:180px;height:40px;padding:25px;line-height:30px;}
.third-star-input>.input{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}
.third-star-input>.input>input{position:absolute;width:1px;height:1px;opacity:0;}
.third-star-input>.input.focus{outline:1px dotted #ddd;}
.third-star-input>.input>label{width:30px;height:0;padding:28px 0 0 0;overflow: hidden;float:left;cursor: pointer;position: absolute;top: 0;left: 0;}
.third-star-input>.input>label:hover,
.third-star-input>.input>input:focus+label,
.third-star-input>.input>input:checked+label{background-size: 150px;background-position: 0 bottom;}
.third-star-input>.input>label:hover~label{background-image: none;}
.third-star-input>.input>label[for="p11"]{width:30px;z-index:5;}
.third-star-input>.input>label[for="p12"]{width:60px;z-index:4;}
.third-star-input>.input>label[for="p13"]{width:90px;z-index:3;}
.third-star-input>.input>label[for="p14"]{width:120px;z-index:2;}
.third-star-input>.input>label[for="p15"]{width:150px;z-index:1;}
.third-star-input>output{display:inline-block;width:60px; font-size:18px;text-align:right; vertical-align:middle;}
</style>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
  crossorigin="anonymous">
<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
  integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
  crossorigin="anonymous"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script type="text/javascript" src="../../js/stars.js"></script>
</head>
<body>
	<h1>리뷰 등록</h1>
	<form method="post" enctype="multipart/form-data">
	
	
	
	<span class="star-input">
  <div>서비스</div>
  <span class="input">
      <input type="radio" name="star-input" value="1" id="p1" checked>
      <label for="p1">1</label>
      <input type="radio" name="star-input" value="2" id="p2">
      <label for="p2">2</label>
      <input type="radio" name="star-input" value="3" id="p3">
      <label for="p3">3</label>
      <input type="radio" name="star-input" value="4" id="p4">
      <label for="p4">4</label>
      <input type="radio" name="star-input" value="5" id="p5">
      <label for="p5">5</label>
    </span>
</span>

  <span class="second-star-input">
  <div>청결도</div>
  <span class="input">
      <input type="radio" name="second-star-input" value="1" id="p6" checked>
      <label for="p6">1</label>
      <input type="radio" name="second-star-input" value="2" id="p7">
      <label for="p7">2</label>
      <input type="radio" name="second-star-input" value="3" id="p8">
      <label for="p8">3</label>
      <input type="radio" name="second-star-input" value="4" id="p9">
      <label for="p9">4</label>
      <input type="radio" name="second-star-input" value="5" id="p10">
      <label for="p10">5</label>
    </span>
</span>

  <span class="third-star-input">
  <div>비용</div>
  <span class="input">
      <input type="radio" name="third-star-input" value="1" id="p11" checked>
      <label for="p11">1</label>
      <input type="radio" name="third-star-input" value="2" id="p12">
      <label for="p12">2</label>
      <input type="radio" name="third-star-input" value="3" id="p13">
      <label for="p13">3</label>
      <input type="radio" name="third-star-input" value="4" id="p14">
      <label for="p14">4</label>
      <input type="radio" name="third-star-input" value="5" id="p15">
      <label for="p15">5</label>
    </span>
</span>
	
	
		<br> <br> 내용 : <br>
		<textarea name="comment" rows='10' cols='60'></textarea>
		<br> 영수증 : <input type="file" name="photoFile" accept="image/*"><br>
		<input type="hidden" name="no" value="${num}"> <input type="submit" value="등록하기">
	</form>
	<form action="../main">
		<input type="submit" value="뒤로가기">
	</form>
	 
	<script>
	var starRating = function(){
		var $star = $(".star-input"),
		    $result = $star.find("output>b");
		  
		    $(document)
		  .on("focusin", ".star-input>.input", 
		    function(){
		       $(this).addClass("focus");
		  })
		     
		    .on("focusout", ".star-input>.input", function(){
		      var $this = $(this);
		      setTimeout(function(){
		          if($this.find(":focus").length === 0){
		            $this.removeClass("focus");
		        }
		      }, 100);
		   })
		  
		    .on("change", ".star-input :radio", function(){
		      $result.text($(this).next().text());
		    })
		    .on("mouseover", ".star-input label", function(){
		      $result.text($(this).text());
		    })
		    .on("mouseleave", ".star-input>.input", function(){
		      var $checked = $star.find(":checked");
		        if($checked.length === 0){
		          $result.text("0");
		        } else {
		          $result.text($checked.next().text());
		        }
		    });
		};
		starRating();
		
		var secondStarRating = function(){
		    var $star = $(".second-star-input"),
		        $result = $star.find("output>b");
		      
		        $(document)
		      .on("focusin", ".star-input>.input", 
		        function(){
		           $(this).addClass("focus");
		      })
		         
		        .on("focusout", ".second-star-input>.input", function(){
		          var $this = $(this);
		          setTimeout(function(){
		              if($this.find(":focus").length === 0){
		                $this.removeClass("focus");
		            }
		          }, 100);
		       })
		      
		        .on("change", ".second-star-input :radio", function(){
		          $result.text($(this).next().text());
		        })
		        .on("mouseover", ".second-star-input label", function(){
		          $result.text($(this).text());
		        })
		        .on("mouseleave", ".second-star-input>.input", function(){
		          var $checked = $star.find(":checked");
		            if($checked.length === 0){
		              $result.text("0");
		            } else {
		              $result.text($checked.next().text());
		            }
		        });
		    };
		    secondStarRating();
		    
		    var thirdStarRating = function(){
		        var $star = $(".third-star-input"),
		            $result = $star.find("output>b");
		          
		            $(document)
		          .on("focusin", ".third-star-input>.input", 
		            function(){
		               $(this).addClass("focus");
		          })
		             
		            .on("focusout", ".third-star-input>.input", function(){
		              var $this = $(this);
		              setTimeout(function(){
		                  if($this.find(":focus").length === 0){
		                    $this.removeClass("focus");
		                }
		              }, 100);
		           })
		          
		            .on("change", ".third-star-input :radio", function(){
		              $result.text($(this).next().text());
		            })
		            .on("mouseover", ".third-star-input label", function(){
		              $result.text($(this).text());
		            })
		            .on("mouseleave", ".third-star-input>.input", function(){
		              var $checked = $star.find(":checked");
		                if($checked.length === 0){
		                  $result.text("0");
		                } else {
		                  $result.text($checked.next().text());
		                }
		            });
		        };
		        thirdStarRating();
	</script>
</body>
</html>