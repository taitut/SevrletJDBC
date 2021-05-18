<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="NewURL" value="/admin-new"/>
<c:url var="APIurl" value="api-admin-new"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>List News</title>
</head>

<body>
<div class="main-content">
    <form action="<c:url value ='/admin-new'/>" id="formSubmit" method="get">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
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
                <%@ include file="/views/admin/toppage.jsp" %>

                <div class="page-header">
                    <h1>
                        News <small> <i class="ace-icon fa fa-angle-double-right"></i>
                        News List
                    </small>
                    </h1>
                </div>
                <!-- /.page-header -->
                <div class="table-responsive">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-${alert}">
                                ${messageResponse}
                        </div>
                    </c:if>
                    <div class="pull-right tableTools-container">
                        <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                           data-toggle="tooltip" title='ADD News' href='<c:url value="/admin-new?type=edit"/>'>
							<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
							</span>
                        </a>
                        <button id="btnDelete" type="button"
                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                data-toggle="tooltip"
                                title='Delete News'>
							<span> <i class="fa fa-trash-o bigger-110 pink"></i>
							</span>
                        </button>
                        <div class="modal fade" id="myModal${item.id}" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        ${item.content}
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <table id="dynamic-table"
                           class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable"
                           role="grid" aria-describedby="dynamic-table_info">
                        <thead>
                        <tr>
                            <th><label for="checkAll"></label>&nbsp;<input type="checkbox" id="checkAll"/></th>
                            <th scope="col" id="title">Title</th>
                            <th scope="col">Content</th>
                            <th scope="col">ShortDescription</th>
                            <th scope="col">Thumbnail</th>
                            <th>Manipulation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${model.list}">
                            <tr>
                                <td><label for="checkbox_${item.id}"></label>
                                    <input type="checkbox" id="checkbox_${item.id}" value="${item.id}"/>
                                </td>
                                <td>${item.title }</td>
                                <td style="display: -webkit-box;

                           -webkit-box-orient: vertical;
                            overflow: hidden;
                            text-overflow: ellipsis;
                            white-space: normal;
                            -webkit-line-clamp: 3;
                                width: min-content;
                           " >${item.content }</td>
                                <td style="width: min-content;">${item.shortDescription }</td>
                                <td>${item.thumbnail }</td>
                                <td class="text-center">
                                    <c:url var="editURL" value="/admin-new">
                                        <c:param name="type" value="edit"/>
                                        <c:param name="id" value="${item.id}"/>
                                    </c:url>
                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                       title="Update News" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i> </a>
                                    <br/><br/>

                                        <button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" title="View Content " id="myBtn${item.id}"><i class="fa fa-search-plus" aria-hidden="true"></i></button>

                                        <!-- Modal -->
                                        <div class="modal fade" id="myModal${item.id}" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    </div>
                                                    <div class="modal-body">
                                                        ${item.content}
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    <script>
                                        $(document).ready(function () {
                                            $('#btnDelete').prop('disabled', true);
                                            $("#myBtn${item.id}").click(function(){
                                                $("#myModal${item.id}").modal();
                                            });
                                        });
                                    </script>



                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>

                </div>
                <ul class="pagination" id="pagination"></ul>
                <input type="hidden" value="" id="page" name="page">
                <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
                <input type="hidden" value="" id="sortName" name="sortName">
                <input type="hidden" value="" id="sortBy" name="sortBy">
                <input type="hidden" value="" id="type" name="type"/>
            </div>
            <!-- /.page-content -->
        </div>
    </form>
</div>
<script type="text/javascript">

    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var limit = 4;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 5,
            startPage: currentPage,

            onPageClick: function (event, page) {
                if (currentPage !== page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val("title");
                    $('#sortBy').val("asc");
                    $('#type').val("list");
                    $('#formSubmit').submit();
                }
                $("#title").click(function () {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val("title");

                    $('#type').val("list");
                    $('#sortBy').val("desc");
                    console.log("aa");
                    $('#formSubmit').submit();
                });
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
        $('#btnDelete').click(function () {
            var data = {};
            var ids = $('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            data['ids'] = ids;
            deleteNew(data);
        });

        function deleteNew(data) {
            $.ajax({
                url: '${APIurl}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "${NewURL}?type=list&page=1&maxPageItem=4&message=delete_success";
                },
                error: function (error) {
                    window.location.href = "${NewURL}?type=list&page=1&maxPageItem=4&message=error_system";
                }
            })
        }

        $("#checkAll").click(function () {
            $("input[type=checkbox]").prop("checked", $(this).prop("checked"))
            $('#btnDelete').prop('disabled', false);
        });

        $("input[type=checkbox]").click(function () {
            if (!$(this).prop("checked")) {

            }
            $('#btnDelete').prop('disabled', false);
        });
        $("input[type=checkbox]").change(function () {
            if (!$(this).prop("checked")) {
                $('#btnDelete').prop('disabled', true);
            } else {
                $('#btnDelete').prop('disabled', false);
            }

        });

    });
</script>
</body>
</html>