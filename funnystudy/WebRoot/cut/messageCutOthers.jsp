<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	
	<body>
		<a href="ShowStudy.action?currentPage2=1">首页</a>&nbsp;&nbsp;&nbsp;
		
		<!-- 首先是 <<和 < -->
		<c:choose>
			<c:when test="${showStudyMessagePage2.currentPage>5}">
				<a href="ShowStudy.action?currentPage2=${showStudyMessagePage2.currentPage-5 }">&lt;&lt;</a>
			</c:when>
			<c:otherwise>
				<a href="ShowStudy.action?currentPage2=1">&lt;&lt;</a>
			</c:otherwise>
		</c:choose>
			&nbsp;&nbsp;&nbsp;
		<c:choose>
			<c:when test="${showStudyMessagePage2.currentPage>1}">
				<a href="ShowStudy.action?currentPage2=${showStudyMessagePage2.currentPage-1 }">&lt;</a>
			</c:when>
			<c:otherwise>
				<a href="ShowStudy.action?currentPage2=1">&lt;</a>
			</c:otherwise>
		</c:choose>
			&nbsp;&nbsp;&nbsp;
			
			
		<!-- 以下分别是 if当前页数小于等于5   小于4  大于总页数减1 -->
		<c:choose>
			<c:when test="${showStudyMessagePage2.totalPage<=5}">
				<c:forEach var="x" begin="1" end="5">
					<c:choose>
						<c:when test="${x==showStudyMessagePage2.currentPage}">
							<a href="ShowStudy.action?currentPage2=${x}" id="c1">${x}</a>
						</c:when>
						<c:otherwise>
							<a href="ShowStudy.action?currentPage2=${x}">${x}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:when>
			<c:when test="${showStudyMessagePage2.currentPage<4}">
				<c:forEach var="x" begin="1" end="5">
					<c:choose>
						<c:when test="${x==showStudyMessagePage2.currentPage}">
							<a href="ShowStudy.action?currentPage2=${x}" id="c1">${x}</a>
						</c:when>
						<c:otherwise>
							<a href="ShowStudy.action?currentPage2=${x}">${x}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:when>
			<c:when test="${showStudyMessagePage2.currentPage+1>=showStudyMessagePage2.totalPage}">
				<c:forEach var="x" begin="${showStudyMessagePage2.totalPage-4}" end="${showStudyMessagePage2.totalPage}">
					<c:choose>
						<c:when test="${x==showStudyMessagePage2.currentPage}">
							<a href="ShowStudy.action?currentPage2=${x}" id="c1">${x}</a>
						</c:when>
						<c:otherwise>
							<a href="ShowStudy.action?currentPage2=${x}">${x}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach var="x" begin="${showStudyMessagePage2.currentPage-2}" end="${showStudyMessagePage2.currentPage+2}">
					<c:choose>
						<c:when test="${x==showStudyMessagePage2.currentPage}">
							<a href="ShowStudy.action?currentPage2=${x}" id="c1">${x}</a>
						</c:when>
						<c:otherwise>
							<a href="ShowStudy.action?currentPage2=${x}">${x}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:otherwise>
		</c:choose>	
			&nbsp;&nbsp;&nbsp;
			
			
		<!-- 当前页数小于总页数时  >可以使得页数+1  否则无效 -->	
		<c:choose>
			<c:when test="${showStudyMessagePage2.currentPage<showStudyMessagePage2.totalPage}">
				<a href="ShowStudy.action?currentPage2=${showStudyMessagePage2.currentPage+1 }">&gt;</a>
			</c:when>
			<c:otherwise>
				<a href="ShowStudy.action?currentPage2=${showStudyMessagePage2.totalPage }">&gt;</a>
			</c:otherwise>
		</c:choose>
			&nbsp;&nbsp;&nbsp;
			
		<!-- 当前页数+5<=总页数时  可以页数+5 否则无效（例如 5页可以到10页  6页不能） -->
		<c:choose>
			<c:when test="${showStudyMessagePage2.currentPage+5<=showStudyMessagePage2.totalPage}">
				<a href="ShowStudy.action?currentPage2=${showStudyMessagePage2.currentPage+5 }">&gt;&gt;</a>
			</c:when>
			<c:otherwise>
				<a href="ShowStudy.action?currentPage2=${showStudyMessagePage2.totalPage}">&gt;&gt;</a>
			</c:otherwise>
		</c:choose>
			&nbsp;&nbsp;&nbsp;
				
		<a href="ShowStudy.action?currentPage2=${showStudyMessagePage2.totalPage}">末页</a>
	</body>
</html>