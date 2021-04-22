<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="navbar-container" id="navbar-container">
		<button type="button" class="navbar-toggle menu-toggler pull-left"
			id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<div class="navbar-header pull-left">
			<a href="index.html" class="navbar-brand"> <small> <i
					class="fa fa-leaf"></i> Ace Admin
			</small>
			</a>
		</div>

		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">


				<li class="purple"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#" aria-expanded="false"> <i
						class="ace-icon fa fa-bell"></i> <span
						class="badge badge-important">8</span>
				</a>

					<ul
						class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close"
						style="">
						<li class="dropdown-header"><i
							class="ace-icon fa fa-exclamation-triangle"></i> 8 Notifications
						</li>

						<li class="dropdown-content ace-scroll"
							style="position: relative;"><div class="scroll-track"
								style="display: none;">
								<div class="scroll-bar"></div>
							</div>
							<div class="scroll-content" style="max-height: 200px;">
								<div class="scroll-track scroll-hover" style="display: none;">
									<div class="scroll-bar"></div>
								</div>
								<div class="scroll-content" style="">
									<ul class="dropdown-menu dropdown-navbar navbar-pink">
										<li><a href="#">
												<div class="clearfix">
													<span class="pull-left"> <i
														class="btn btn-xs no-hover btn-pink fa fa-comment"></i>
														New Comments
													</span> <span class="pull-right badge badge-info">+12</span>
												</div>
										</a></li>

										<li></li>

										<li></li>

										<li><a href="#"> </a></li>
									</ul>
								</div>
							</div></li>

						<li class="dropdown-footer"><a href="#"> See all
								notifications <i class="ace-icon fa fa-arrow-right"></i>
						</a></li>
					</ul></li>



				<li class="light-blue"><a data-toggle="dropdown" href="#"
					class="dropdown-toggle"> <img class="nav-user-photo"
						src="<c:url value= '/template/admin/avatars/user.jpg' />"
						alt="Jason's Photo"> <span class="user-info"> <small>Welcome,</small>
							Jason
					</span> <i class="ace-icon fa fa-caret-down"></i>
				</a>

					<ul
						class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a href="#"> <i class="ace-icon fa fa-cog"></i>
								Settings
						</a></li>

						<li><a href="profile.html"> <i
								class="ace-icon fa fa-user"></i> Profile
						</a></li>

						<li class="divider"></li>

						<li><a href="#"> <i class="ace-icon fa fa-power-off"></i>
								Logout
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- /.navbar-container -->
</div>