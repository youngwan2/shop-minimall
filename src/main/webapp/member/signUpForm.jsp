<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<div class="container">
    <form class="row g-3 m-4" id="register-form">
    	<!-- 아이디 확인 -->
		  <div class="row mb-3">
		    <label for="userid" class="col-sm-2 col-form-label">*아이디</label>
		    <div class="col-auto">
		      <input type="text" class="form-control" id="userid" name="userid">
		    </div>
		    <div class="col-auto">
			    <button type="button" class="btn btn-primary mb-3" id="idDupulicatedcheck">아이디중복</button>
  			</div>
  			<div class="col-sm-3">
		         <span id="idcheck" class="fs-5"></span>
		        </div>
		  </div>
		  
		  <!-- 비밀번호 확인 -->
		 <div class="row mb-3">
		    <label for="password" class="col-sm-2 col-form-label">*비밀번호</label>
		    <div class="col-auto">
		      <input type="password" class="form-control" name="passwd" id="passwd">
		    </div>
		  </div>
		  
		  <!-- 비밀번호 재확인 -->
		  <div class="row mb-3">
		    <label for="passwd2" class="col-sm-2 col-form-label">비밀번호확인</label>
		    <div class="col-sm-5">
		      <input type="password" class="form-control" name="passwd2" id="passwd2">
		    </div>
		    <div class="col-sm-3">
		      <span id="pwdcheck" class="fs-5"></span>
		    </div>
		  </div>
		  
		  <!-- 이름 -->
		  <div class="row mb-3">
		    <label for="username" class="col-sm-2 col-form-label">이름</label>
		    <div class="col-auto">
		      <input type="text" class="form-control" name="username" id="username">
		    </div>
		  </div>
		  <hr>
		  
		  <!-- 우편 -->
		  <div class="row mb-3">
		      <div class="col-auto">
			    <label for="sample4_postcode" class="visually-hidden">post</label>
			    <input type="text" name="post" class="form-control" id="sample4_postcode" placeholder="우편번호">
			  </div>
			  <div class="col-auto">
			    <button type="button" class="btn btn-primary mb-3" onclick="sample4_execDaumPostcode()">우편번호 찾기</button>
  			  </div>
		  </div>
		  <!-- 도로명 -->
		   <div class="row mb-3">
		      <div class="col-sm-5">
			    <label for="sample4_roadAddress" class="visually-hidden">도로명주소</label>
			    <input type="text"  name="addr1" class="form-control" id="sample4_roadAddress" placeholder="도로명주소">
			  </div>
			<!-- 지번주소 -->
			 <div class="col-sm-5">
			    <label for="sample4_jibunAddress" class="visually-hidden">지번주소</label>
			    <input type="text" name="addr2" class="form-control" id="sample4_jibunAddress" placeholder="지번주소">
			    <span id="guide" style="color:#999"></span>
			  </div>
		  </div>
		  <hr>
		  
		  <!-- 전화번호 -->
		  <div class="row mb-3">
		      <label for="phone1" class="col-sm-2 col-form-label">전화번호</label>
		     <div class="col-auto">
		      <select name="phone1" class="form-control" id="phone1">
				 <option value="010">010</option>
				 <option value="011">011</option>
				</select>
			   </div>
		   <!-- 전화번호2 -->	
			<div class="col-auto">
			  <label for="phone2" class="visually-hidden">전화번호2</label>
			  <input type="text" name="phone2" class="form-control" id="phone2">
			</div>
			
			<!-- 전화번호3 -->
			<div class="col-auto">
			  <label for="phone3" class="visually-hidden">전화번호3</label> 
			  <input type="text" name="phone3" class="form-control" id="phone3">
			</div>
		  </div>
		  
		  <!-- 이메일 -->
		  <div class="row mb-3">
			  <label for="email1" class="col-sm-2 col-form-label">이메일:</label>
		    <div class="col-auto">
			  <input type="text" name="email1" class="form-control" id="email1">
			</div>
			<div class="col-auto">
			  <label for="xxx" class="visually-hidden">@</label>
			  <span>@</span>
			</div>
			
			<!-- 이메일2 -->
			<div class="col-auto">
			  <label for="email2" class="visually-hidden">이메일2</label>
			  <input type="text" name="email2" class="form-control" id="email2" placeholder="직접입력">
			</div>
			<label for="email3" class="visually-hidden">이메일2</label>
		     <div class="col-auto">
		      <select name="email3" class="form-control" id="email3">
				  <option value="daum.net">daum.net</option>
	 			  <option value="google.com">google.com</option>
	              <option value="naver.com">naver.com</option>
				</select>
			   </div>	
		  </div>
		  
		  <!-- 버튼 -->
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">Sign in</button>
		    <button type="reset" class="btn btn-primary">cancel</button>
		  </div>
 </form>
	
</div>

<script>
	const idCheckButton = document.querySelector("#idDupulicatedcheck");
	const registerForm = document.querySelector("#register-form");
	const useridInput = document.querySelector("#userid");

	
	
	idCheckButton.addEventListener("click", checkEmail) // 유저 중복 확인
	registerForm.addEventListener("submit", registerMember)
	
	
	
	
	
	// 이메일 중복 확인
	async function checkEmail(e){
		e.preventDefault(); 
		
		const url = "/shop/id-check"
		const body = {
				userId: useridInput.value
		}
		const config = {
			     method: 'POST',
			     headers: {
			            'Content-Type': 'application/json'
			        },
			     body: JSON.stringify(body)
		}
		const response = await fetch(url, config);
		
		const data= await response.json();
		alert(data.meg);
	}
	
	// 회원가입 처리
	async function registerMember(e){
		e.preventDefault();
		const formData = new URLSearchParams(new FormData(registerForm)).toString();
		const url = "/shop/register"
			const body = {
				userId: useridInput.value
		}
		const config = {
			     method: 'POST',
			     headers: {
			    	   'Content-Type': 'application/x-www-form-urlencoded',
			        },
			     body: formData
		}
		const response = await fetch(url, config);
		
		const data= await response.json();
		
		alert(data.meg)
		if(response.ok){
			console.log(response.status)
			location.href="/shop"
		}			
	}
</script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>