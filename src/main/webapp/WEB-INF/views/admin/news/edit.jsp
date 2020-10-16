<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url var="newsListURL" value="/admin-news/list" />
<c:url var="editNewsURL" value="/admin-news/edit"/>
<c:url var="apiURL" value="/api/news" />

<html>

<head>
	<title>Edit news</title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a></li>
					<li><a href="#">Forms</a></li>
					<li class="active">Form Elements</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">
  								<strong>${message}</strong>
							</div>
						</c:if>
					
						<!-- modelAttribute="model" matching với biến model trong controller -> matching các field thông qua thuộc tính name -->
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
						
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="categoryCode">Category</label>
								<div class="col-sm-9">
									<form:select path="categoryCode" id="categoryCode">
										<form:option value="" label="-- Choose Category --" />
										<form:options items="${categories}" itemValue="code" itemLabel="name" />
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Title
								</label>

								<div class="col-sm-9">
									<%-- <input type="text" class="col-xs-10 col-sm-5" id="title" name="title" value="${model.title}" /> --%>
									
									<!-- path chứa cả name và value, matching đúng với các field trong DTO -->
									<form:input path="title" cssClass="col-xs-10 col-sm-5" />
									
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Thumbnail
								</label>

								<div class="col-sm-9">
									<input type="file" class="col-xs-10 col-sm-5" id="thumbnail" name="thumbnail" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="shortDescription">Short
									Description</label>
								<div class="col-sm-9">
									<textarea class="form-control" rows="5" cols="10" id="shortDescription"
										name="shortDescription">${model.shortDescription}</textarea>
									<%-- <form:textarea path="shortDescription" cssClass="form-control" rows="5" cols="10" id="shortDescription"/> --%>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="content">Content</label>
								<div class="col-sm-9">
									<textarea class="form-control" rows="5" cols="10" id="content"
										name="content">${model.content}</textarea>
								</div>
							</div>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Update News
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Create News
										</button>
									</c:if>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										Cancel
									</button>
								</div>
							</div>
							<form:hidden path="id" id="id"/>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$('#btnAddOrUpdateNew').click(function (e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function (i, v) {
				data[""+v.name+""] = v.value;
			});
			var id = $('#id').val();
			if (id == "") {
				createNews(data);
			} else {
				updateNews(data);
			}
		});
		
		function createNews(data) {
			$.ajax({
				url: '${apiURL}',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${editNewsURL}?id=" + result.id + "&message=insert_success";
	            },
				error: function (error) {
					window.location.href = "${newsListURL}?page=1&limit=5&message=error_system";
				}
			});
		}
		
		function updateNews(data) {
			$.ajax({
				url: '${apiURL}',
				type: 'PUT',
				contentType: 'application/json',
				data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${editNewsURL}?id=" + result.id + "&message=update_success";
	            },
				error: function (error) {
					window.location.href = "${editNewsURL}?id=" + result.id + "&message=error_system";
				}
			});
		}
	</script>

</body>

</html>