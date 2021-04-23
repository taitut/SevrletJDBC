<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Danh sach bai viet</title>
</head>

<body>
	<div class="main-content">
	<form action="<c:url value ='/admin-new'/>" id ="formSubmit" method="get">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>
					<li class="active">News</li>
				</ul>

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon"> <input type="text" placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off"> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div>
				<!-- /.nav-search -->
			</div>

			<div class="page-content">
				<%@ include file="/views/admin/toppage.jsp"%>

				<div class="page-header">
					<h1>
						News <small> <i class="ace-icon fa fa-angle-double-right"></i>
							News List
						</small>
					</h1>
				</div>
				<!-- /.page-header -->
				<div class="table-responsive">
					<div class="dt-buttons btn-overlap btn-group text-center">
						<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
							data-toggle="tooltip" title='Thêm bài viết' href='<c:url value="/admin-new?type=edit"/>'>
							<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
							</span>
						</a>
						
					</div>
					<table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable" role="grid" aria-describedby="dynamic-table_info">
						<thead>
							<tr>
								<th scope="col" id= "title">Title</th>
								<th scope="col">Content</th>
								<th scope="col">shortDescription</th>
								<th scope="col">thumbnail</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${model.list}">
								<tr>
									<td>${item.title }</td>
									<td>${item.content }</td>
									<td>${item.shortDescription }</td>
									<td>${item.thumbnail }</td>
									<td class = "text-center"><a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
											title="Cập nhật bài viết" href='${editURL}'><i class="fa fa-pencil-square-o"
												aria-hidden="true"></i> </a> &emsp;&emsp;
										<button id="btnDelete" type="button"
							class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip"
							title='Xóa bài viết'>
							<span> <i class="fa fa-trash-o bigger-110 pink"></i>
							</span>
						</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>

				</div>
				<ul class="pagination" id="pagination"></ul>
				<input type="hidden"value="" id="page" name= "page">
				<input type="hidden"value=""id="maxPageItem" name = "maxPageItem">
				<input type="hidden"value="" id="sortName" name= "sortName">
				<input type="hidden"value="" id="sortBy" name= "sortBy">
			</div>
			<!-- /.page-content -->
		</div>
		</form>
	</div>
	<script type="text/javascript">
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 5;
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 5,
				startPage : currentPage,
			
				onPageClick: function (event, page) {
					if (currentPage != page) {
					$('#maxPageItem').val(limit);
					$('#page').val(page);
					$('#sortName').val("title");
					$('#sortBy').val("asc");
					$('#formSubmit').submit();
					}
					$("#title").click(function () {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val("title");
						$('#sortName').val("title");
						$('#sortBy').val("desc");
						console.log("aa");
						$('#formSubmit').submit();
					    });
				}
			}).on('page', function (event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script>
</body>

</html>