<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="api-admin-new"/>
<html>
<head>
    <c:if test="${not empty model.id}">
        <title>Edit News</title>
    </c:if>
    <c:if test="${empty model.id}">
        <title>ADD News</title>
    </c:if>
</head>
<body>
<div class="main-content">
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
                    <c:if test="${not empty model.id}">
                        Edit News
                    </c:if>
                    <c:if test="${empty model.id}">
                        ADD News
                    </c:if>
                </small>
                </h1>
            </div>
            <!-- /.page-header -->
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-${alert}">
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form id="formSubmit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="categoryCode" name="categoryCode">
                                    <c:if test="${empty model.categoryCode}">
                                        <option value="">Select Category</option>
                                        <c:forEach var="item" items="${categories}">
                                            <option value="${item.code}">${item.name}</option>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty model.categoryCode}">
                                        <option value="">Select Category</option>
                                        <c:forEach var="item" items="${categories}">
                                            <option value="${item.code}"
                                                    <c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
                                                    ${item.name}
                                            </option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="thumbnail" name="thumbnail"
                                       value="${model.thumbnail}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="shortDescription" name="shortDescription"
                                       value="${model.shortDescription}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                            <div class="col-sm-9">
                                <textarea rows="" cols="" id="content" name="content"
                                          style="width: 820px;height: 175px">${model.content}</textarea>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Update News"
                                           id="btnAddOrUpdateNew"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Add News"
                                           id="btnAddOrUpdateNew"/>
                                </c:if>
                                &nbsp <input type="button" class="btn btn-white btn-warning btn-bold" value="Cancel"
                                             id="btnCancel"/>

                            </div>
                        </div>
                        <input type="hidden" value="${model.id}" id="id" name="id"/>
                    </form>
                </div>
            </div>
        </div>
        <!-- /.page-content -->
    </div>
</div>
<script type="text/javascript">
    $('#btnCancel').click(function () {
        window.history.back();
    })
   $('#btnAddOrUpdateNew').click(function (e) {
       e.preventDefault();
       var data ={};
        var formData    = $('#formSubmit').serializeArray();
        $(formData).each(function (i,v) {
            data[""+v.name+""] = v.value;
        });
        var id  = $('#id').val()
       if (id == ""){
           addNew(data);
       }else{
           updateNew( data);
       }
   });
    function addNew(data) {
        $.ajax({
            url:'${APIurl}',
            type:'POST',
            contentType:'application/json',
            data:JSON.stringify(data),
            dataType:'json',
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                console.log(error);
            }
        })
    }
    function updateNew(data) {
        $.ajax({
            url:'${APIurl}',
            type:'PUT',
            contentType:'application/json',
            data:JSON.stringify(data),
            dataType:'json',
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                console.log(error);
            }
        })
    }
</script>
</body>
</html>
