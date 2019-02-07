<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div id="header">

		<div class="navigation">
			<ul>
				<li class="selected"><a href="home">home</a></li>

				<li><a href="about">about</a></li>
				<li><a href="contact">contact</a></li>

				<li class="booking"><a href="signin">signin</a></li>
				<li class="booking"><a href="signup">signup</a></li>
			</ul>
		</div>

	</div>
	<div id="body">
		<div class="content">
			<div class="section">
				<div class="booking">
					<h2>Create a chatspace</h2>
					<h3>Please fill in details below :</h3>
					<form action="signup">

						
						<div class="form1">
							<label for="fname"> <span>first name</span> <input
								type="text" name="fname" id="fname">
							</label> <label for="lname"> <span>last name</span> <input
								type="text" name="lname" id="lname">
							</label> <label for="email3"> <span>email</span> <input
								type="text" name="email3" id="email3">
							</label> <label for="phone"> <span>phone number</span> <input
								type="text" name="phone" id="phone">
							</label> <label for="address1"> <span>address 1</span> <input
								type="text" name="address1" id="address1">
							</label> <label for="email"> <span>city</span> <input type="text"
								name="city" id="email">
							</label> <label for="phone"> <span>zipcode</span> <input
								type="text" name="zip" id="phone">
							</label> <br>

							<div>
							    <label for="state" style="margin-left:40px;"><span>Country</span>
								<select	name="state" id="state">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
								</select>
								</label>
								
							</div>



						</div>

						<div class="form2">
							<div>
								<label for="brand"> <span>organization</span> <input
									type="text" name="organization" id="brand">
								</label> <label for="model"> <span>Organization email</span> <input
									type="text" name="orgemail" id="model">
								</label> <label for="year"> <span>tel</span> <input type="text"
									name="tel" id="year">
								</label> <label for="mileage"> <span>cel</span> <input
									type="text" name="cel" id="mileage">
								</label>
							</div>

							<label for="message2"> <span>description</span> <textarea
									name="message2" id="message2" cols="30" rows="10"></textarea>
							</label>
						</div>
						<br>
						<div id="div-submit">
							<button type="button" id="button-submit2">Sigup</button>
						</div>
					</form>
				</div>
			</div>
			<div class="sidebar">
				<div class="contact">
				
				</div>
				<div class="featured">
					<h3>features</h3>
					<ul>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div id="footer">
		<div>
			<div class="contact">
				<h3>contact information</h3>
				<ul>
					<li><b>address:</b> <span>426 London UK,Doe Palace</span></li>
					<li><b>phone:</b> <span>101</span></li>
					<li><b>fax:</b> <span>202</span></li>
					<li><b>email:</b> <span>johndoe@email.com</span></li>
				</ul>
			</div>
			<div class="connect">
				<h3>stay in touch</h3>
				<p>Social media</p>
				<ul>
					<li id="facebook"><a href="http://www.facebook.com">facebook</a>
					</li>
					<li id="twitter"><a href="http://www.twitter.com">twitter</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="section">
			<p>&copy; Copyright</p>
			<ul>
				<li class="selected"><a href="home">home</a></li>

				<li><a href="about">about</a></li>
				<li><a href="contact">contact</a></li>

				<li class="booking"><a href="signin">signin</a></li>
				<li class="booking"><a href="signup">signup</a></li>
			</ul>

		</div>
	</div>
</body>
</html>