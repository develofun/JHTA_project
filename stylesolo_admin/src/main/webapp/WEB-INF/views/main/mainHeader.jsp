<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 로고 클릭 시 메인 화면으로 이동 -->

<div>
	<div>
		<div>
			<div style="float:left;margin-left:20px;font-size:2.0em;text-decoration:none">
				<!-- 임시로 텍스트 설정 > 나중에 이미지로 변경 -->
				<label><a href="/admin_login">StyleSolo Admin</a></label>
			</div>			
		</div>
		<div style="float:right;margin-right:10px">			
			<button class="btn btn-default" type="submit" onClick="javascript:location.href='/'">
				<span class="glyphicon glyphicon-user"></span> MyInfo
			</button>
			<button class="btn btn-default" type="submit" onClick="javascript:location.href='/'">
				<span class="glyphicon glyphicon-list"></span> MyLog
			</button>
			<button class="btn btn-default" type="submit" onClick="javascript:location.href='/'">
				<span class="glyphicon glyphicon-cog"></span>
			</button>
			<button class="btn btn-default" type="submit" onClick="javascript:location.href='/'">
				<span class="glyphicon glyphicon-off"></span>
			</button>
		</div>
	</div>
</div>