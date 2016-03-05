<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Lemmatizer</title>
</head>
<body>

	<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Lemmatizer Service| Portal to get lemma of words from
	given text</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript" src="./resources/js/jquery-1.10.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="./resources/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/customcss.css" />

<script type="text/javascript"
	src="./resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">

		<div class="page-header">
			<h1>
				Lemmatizer Service <small>Portal to get lemma of words from
					given text</small>
			</h1>
		</div>

		<!-- Collapsible Panels - START -->
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title"></h3>
							<span class="pull-right clickable"><i
								class="glyphicon glyphicon-chevron-up"></i></span>
						</div>
						<div class="panel-body">

							<form class="form-horizontal" role="form" id="submitTextForm"
								method="post" action="./getlemma">

								<div class="alert alert-success" id="result">
									<label id="result_success">Success</label>
								</div>

								<div class="form-group">
									 <label class="control-label col-sm-2" for="textName">Text:</label>
									<div class="col-sm-20">
										<textarea class="lemmatextarea" rows="4" id="lemmaText" placeholder="Enter Text"></textarea>
									</div>
								</div>

								<div class="form-group">
									 <label class="control-label col-sm-2"
										for="responseName">Response:</label>
									<div class="col-sm-20">
										<textarea class="lemmatextarea" rows="15" id="responseText" placeholder="check response here"></textarea>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">Get
											Lemma</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>
	<style>
.panel-heading span {
	margin-top: -20px;
	font-size: 15px;
}

.row {
	margin-top: 40px;
	padding: 0 10px;
}

.clickable {
	cursor: pointer;
}

.btn-file {
	position: relative;
	overflow: hidden;
}

.btn-file input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	min-width: 100%;
	min-height: 100%;
	font-size: 100px;
	text-align: right;
	filter: alpha(opacity = 0);
	opacity: 0;
	outline: none;
	background: white;
	cursor: inherit;
	display: block;
}
</style>

	<script type="text/javascript">
		jQuery(function($) {
			$('.panel-heading span.clickable').on(
					"click",
					function(e) {
						if ($(this).hasClass('panel-collapsed')) {
							// expand the panel
							$(this).parents('.panel').find('.panel-body')
									.slideDown();
							$(this).removeClass('panel-collapsed');
							$(this).find('i').removeClass(
									'glyphicon-chevron-down').addClass(
									'glyphicon-chevron-up');
						} else {
							// collapse the panel
							$(this).parents('.panel').find('.panel-body')
									.slideUp();
							$(this).addClass('panel-collapsed');
							$(this).find('i').removeClass(
									'glyphicon-chevron-up').addClass(
									'glyphicon-chevron-down');
						}
					});
		});
	</script>

	<script type="text/javascript">
		$(window).load(function() {
			$("#result").hide();
		});

		$("#submitTextForm").submit(function(event) {
			// cancels the form submission
			event.preventDefault();
			submitForm();
		});

	/* 	$("#submitTextForm").submit(function(event) {
			// cancels the form submission
			event.preventDefault();
			getStatus();
		}); */

		function submitForm() {
			// Initiate Variables With Form Content
			
			var text = $("#lemmaText").val();

			$.ajax({
				type : "POST",
				url : "./getlemma",
				contentType : "application/json",
				data : text,
				success : function(response) {
					if (response.success) {
						$('#responseText').val(response.message);
					}
				}
			});

		}

		function formSuccess(message) {
			$("#result_success").text(message)
			$("#result").show();
			window.setTimeout(function() {
				$("#result").slideUp(500, function() {
					$("#result").hide();
				});
			}, 10000);
		}

	</script>
	<!-- Collapsible Panels - END -->
	</div>
</body>
</html>

</body>
</html>
