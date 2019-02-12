<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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

		<div style="width: 30%; float: left; background-color: #fff5e6;">

			<div class="panel" style="height: 700px;">


				<h3 style="margin: 5px;">
					<a href="/signout">signout</a>
				</h3>

				<h3 style="margin: 5px;">
					<a href="/home">back</a>
				</h3>



				<div class="members" style="color: white;">


					<div class="div2" style="width: 80%; float: left; border: none;">

						<table
							style="border: 1px solid black; border-collapse: collapse; width: 100%;">
							<caption>Members</caption>
							<thead>
								<tr
									style="padding: 5px; text-align: left; border: 1px solid black; border-collapse: collapse;">
									<th>Id</th>
									<th>first name</th>
									<th>last name</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="user" items="${uList}">
									<tr
										style="padding: 5px; text-align: left; border: 1px solid black; border-collapse: collapse;">
										<td><c:out value="${user.id}" /></td>
										<td><c:out value="${user.firstName}" /></td>
										<td><c:out value="${user.lastName}" /></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>

		</div>

		<div style="width: 70%; float: right; background-color: #fff5e6;">
			<div class="message-div"
				style="border: 1px solid white; height: 700px;">

				<div class="submit-message">

					<form action="sent" method="get">
						<table>

							<tr>

								
									<td><label for="name"> <span>receiver id</span></label></td>
									<td><input type="text" id="name"
										name="receiverId"></td>
										
								
							</tr>

							<tr>

									<td> <label for="email"> <span>message</span></label></td>
									<td><textarea rows="5" cols="30"
											name="message"> </textarea></td>
								

							</tr>
							<tr>
								<td><input type="submit" value="Send"></td>
							</tr>
						</table>
					</form>
				</div>



				<div class="messsages"
					style="border: 1px solid white; height: 550px; background-color: #fff5e6;">

					<div class="sent" style="width: 50%; float: left;">
						<h3>Sent</h3>
						<ul style="list-style: none">
						 <c:forEach var="sentMessage" items="${sentMessages}">
						 <li>To- [ <span>${sentMessage.receiver.firstName}  ${sentMessage.receiver.lastName}</span> ] <span>:  ${sentMessage.message}</span></li>
						 </c:forEach>
							

						</ul>

					</div>

					<div class="received" style="width: 50%; float: right;">
						<h3>Received</h3>
						<ul style="list-style: none">
					   <c:forEach var="receivedMessage" items="${receivedMessages}">
						 <li>From- [ <span>${receivedMessage.sender.firstName} ${receivedMessage.sender.lastName}</span> ] <span>:  ${receivedMessage.message}</span></li>
						 </c:forEach>

						</ul>

					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>