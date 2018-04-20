<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<div class="well well-md" style="margin:5px;margin-top:0px">
		<p>
			<label>${login_id }님 안녕하세요.</label>
		</p>
		<P>
			<label>권한 : </label>${member_right }
		</P>
		<P>
			<label>접속 IP : </label>${access_ip }
		</P>
		<P>
			<label>접속 시간 : </label>${access_time } 
		</P>
	</div>
	<div class="well well-md" style="margin:5px">
		<form>
			<div class="checkbox">
				<label class="checkbox-inline">
			      <input type="checkbox" value="member">회원 검색
			    </label>
			    <label class="checkbox-inline">
			      <input type="checkbox" value="consult">상담 검색
			    </label>
			</div>
			<div class="form-group">
				<select class="form-control">
					<option value="#">아이디</option>
					<option value="#">이름</option>
					<option value="#">회원번호</option>
					<option value="#">이메일</option>
					<option value="#">전화번호</option>
				</select>
			</div>
			<div class="form-group form-inline">
				<input type="text" class="form-control" placeholder="검색어 입력" style="width:77%">
				<button class="btn btn-default" type="submit" style="width:20%">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</div>
		</form>
	</div>
	<div id="accordion">
		<ul class="list-group">
			<li class="list-group-item">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse_cs">
					<span class="glyphicon glyphicon-earphone"></span>
						 고객센터 관리
					<span class="glyphicon glyphicon-chevron-left" style="float:right"></span>
				</a>
				<div id="collapse_cs" class="collapse">
					<ul class="sub-list-group">
						<li class="sub-list-group-item">
							<a href="/consult_list">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">상담 게시판</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/consult_template">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">템플릿 관리</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/consult_category">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">상담 카테고리 관리(준비중)</span>
							</a>
						</li>
					</ul>
				</div>
			</li>
			<li class="list-group-item">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse_member">
					<span class="glyphicon glyphicon-list-alt"></span>
						 회원 관리
					<span class="glyphicon glyphicon-chevron-left" style="float:right"></span>
				</a>
				<div id="collapse_member" class="collapse">
					<ul class="sub-list-group">
						<li class="sub-list-group-item">
							<a href="/member_list">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">회원 전체 보기</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/member_detail">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">회원 상세 정보</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/member_level_point">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">등급/포인트 관리</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/member_drop_list">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">탈퇴 회원 관리</span>
							</a>
						</li>
					</ul>
				</div>
			</li>
			<li class="list-group-item">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse_recommend">
					<span class="glyphicon glyphicon-thumbs-up"></span>
						추천 관리
					<span class="glyphicon glyphicon-chevron-left" style="float:right"></span>
				</a>
				<div id="collapse_recommend" class="collapse">
					<ul class="sub-list-group">
						<li class="sub-list-group-item">
							<a href="#">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">회원 전체 보기</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="#">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">회원 상세 정보</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="#">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">포인트 관리</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="#">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">탈퇴 회원 관리</span>
							</a>
						</li>
					</ul>
				</div>
			</li>
			<li class="list-group-item">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse_shop">
					<span class="glyphicon glyphicon-shopping-cart"></span>
						쇼핑몰 관리
					<span class="glyphicon glyphicon-chevron-left" style="float:right"></span>
				</a>
				<div id="collapse_shop" class="collapse">
					<ul class="sub-list-group">
						<li class="sub-list-group-item">
							<a href="/shop_category">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">상품 카테고리 관리</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a data-toggle="collapse" data-parent="#accordion" href="#collapse_shop_manage">
								<span class="glyphicon glyphicon-plus"></span>
								<span class="sub-list-text">상품 상세 관리</span>
							</a>
							<div id="collapse_shop_manage" class="collapse" style="background-color:blue">
								<ul class="sub-list-group">
									<li class="sub-list-group-item">
										<a href="/shop_list">
											<span class="glyphicon glyphicon-minus"></span>
											<span class="sub-list-text">전체 상품 보기</span>
										</a>
									</li>
									<li class="sub-list-group-item">
										<a href="/shop_inventory">
											<span class="glyphicon glyphicon-minus"></span>
											<span class="sub-list-text">재고 관리</span>
										</a>
									</li>
									<li class="sub-list-group-item">
										<a href="/shop_insert">
											<span class="glyphicon glyphicon-minus"></span>
											<span class="sub-list-text">상품 등록</span>
										</a>
									</li>
									<li class="sub-list-group-item">
										<a href="/shop_update">
											<span class="glyphicon glyphicon-minus"></span>
											<span class="sub-list-text">상품 정보 수정</span>
										</a>
									</li>
									<li class="sub-list-group-item">
										<a href="#">
											<span class="glyphicon glyphicon-minus"></span>
											<span class="sub-list-text">찜/리뷰 관리</span>
										</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="sub-list-group-item">
							<a href="/shop_order_delivery">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">주문/배송/취소/반품 관리</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/shop_payment">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">결제 관리</span>
							</a>
						</li>
					</ul>
				</div>
			</li>
			<li class="list-group-item">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse_gonggu">
					<span class="glyphicon glyphicon-gift"></span>
						공동구매 관리
					<span class="glyphicon glyphicon-chevron-left" style="float:right"></span>
				</a>
				<div id="collapse_gonggu" class="collapse">
					<ul class="sub-list-group">
						<li class="sub-list-group-item">
							<a href="#">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">회원 전체 보기</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="#">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">회원 상세 정보</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="#">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">포인트 관리</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="#">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">탈퇴 회원 관리</span>
							</a>
						</li>
					</ul>
				</div>
			</li>
			<li class="list-group-item">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse_stats">
					<span class="glyphicon glyphicon-stats"></span>
						통계
					<span class="glyphicon glyphicon-chevron-left" style="float:right"></span>
				</a>
				<div id="collapse_stats" class="collapse">
					<ul class="sub-list-group">
						<li class="sub-list-group-item">
							<a href="/site_stats">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">사이트 통계</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/shop_stats">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">쇼핑 통계</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/menu_stats">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">메뉴 통계</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/consult_stats">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">상담 통계</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/member_stats">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">회원 통계</span>
							</a>
						</li>
					</ul>
				</div>
			</li>
			<li class="list-group-item">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse_admin">
					<span class="glyphicon glyphicon-wrench"></span>
						Admin 관리
					<span class="glyphicon glyphicon-chevron-left" style="float:right"></span>
				</a>
				<div id="collapse_admin" class="collapse">
					<ul class="sub-list-group">
						<li class="sub-list-group-item">
							<a href="/admin_list">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">Admin 게정 관리</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/admin_authority">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">Admin 권한 관리</span>
							</a>
						</li>
						<li class="sub-list-group-item">
							<a href="/admin_log">
								<span class="glyphicon glyphicon-minus"></span>
								<span class="sub-list-text">로그 관리</span>
							</a>
						</li>
					</ul>
				</div>
			</li>
		</ul>
	</div>
</div>
	