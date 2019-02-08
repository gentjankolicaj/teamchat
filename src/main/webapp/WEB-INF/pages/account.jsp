<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>

<link href="<c:url value="/css/style.css" />" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<div id="header"></div>

	<div id="account-body" style="background-color: #ffc266; margin: 50px;">

		<div style="width: 30%; float: left; background-color: #ffc266;">

			<div class="panel" style="border: 1px solid white; height: 700px;">

			
				<h3 style="margin:5px;"><a href="signout">signout</a></h3>
				
				<h3 style="margin:5px;"><a href="home">back</a></h3>
				


				<div class="members" style="color: white">
					<h3>Members</h3>
					<ul style="list-style: none">
						<li>john doe</li>
						<li>jane</li>
						<li>jim</li>
						<li>tim</li>
						<li>toni</li>
					</ul>
				</div>
			</div>

		</div>

		<div style="width: 70%; float: right; background-color: #fff5e6;">

			<div class="message-div"
				style="border: 1px solid white; height: 700px;">

				<div class="submit-message">

					<form action="account" method="get">
						<table>
						<tr>
							<td><label for="name"> <span>receiver id</span></label></td>
							<td> <input type="text" name="receiverId" id="name"></td>
							
						<tr>
						<td></label> <label for="email"> <span>message</span></label></td>
						<td>  <textarea name="message" rows="5" cols="30"> </textarea></td>
						</tr>
						<tr><td><input type="submit" value="Send"></td></tr>
					</table>
					</form>
				</div>



				<div class="messsages" style="border: 1px solid white; height: 550px; background-color:#fff5e6;">
					<ul style="list-style: none">
						<li><span>[ sender </span><span>,date ] :</span><span> message</span></li>

					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>