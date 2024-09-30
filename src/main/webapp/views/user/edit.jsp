<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Application</title>
<style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        table td,
        table th {
            padding: 8px;
            border: 0px solid #ddd;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="url"],
        textarea {
            width: 100%;
            padding: 8px;
            margin: 4px 0;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #315A9D;
            color: white;
            border: none;
            cursor: pointer;
        }

        h1 {
            text-align: center;
        }

        form {
            width: 50%;
            margin: 0 auto;
            box-shadow: 0 0 15px 5px #888888;
        }
    </style>
</head>
<body>
	<div align="center">
		<h1>User Management</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/users?action=new">Add
				New User</a> &nbsp;&nbsp;&nbsp; <a
				href="${pageContext.request.contextPath}/users">List All Users</a>
		</h2>

		<h2>Edit User</h2>
		<form action="users?action=update" method="post">
		<c:if test="${errors != null}">
		<table>
			<tr>
				<td><div style="white-space:pre; text-align: left; color:red;"><c:out value="${errors}" escapeXml="false"></c:out></div></td>
			</tr>
		</table>
		</c:if>
		<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
		<table border="1">
			<tr>
				<th>First Name:</th>
				<td>
					<input type="text" name="firstName" maxlength="50" size="50" value="<c:out value='${user.firstName}' />" />
				</td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td>
					<input type="text" name="lastName" maxlength="50" size="50" value="<c:out value='${user.lastName}' />" />
				</td>
			</tr>
			<tr>
				<th>Email:</th>
				<td>
					<input type="text" name="email" maxlength="50" size="50" value="<c:out value='${user.email}' />" />
				</td>
			</tr>
			<tr>
				<th>Password:</th>
				<td>
					<input type="text" name="password" maxlength="20" size="15" value="<c:out value='${user.password}' />" />
				</td>
			</tr>
			<tr>
				<th>Birthday:</th>
				<td><select name="day" id="" required>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                    <select name="month" id="" required>
                        <option value="01">January</option>
                        <option value="02">February</option>
                        <option value="03">March</option>
                        <option value="04">April</option>
                        <option value="05">May</option>
                        <option value="06">June</option>
                        <option value="07">July</option>
                        <option value="08">August</option>
                        <option value="09">September</option>
                        <option value="10">October</option>
                        <option value="11">November</option>
                        <option value="12">December</option>
                    </select>
                    <select name="year" id="" required>
                        <option value="2000">2000</option>
                        <option value="2001">2001</option>
                        <option value="2002">2002</option>
                        <option value="2003">2003</option>
                        <option value="2004">2004</option>
                        <option value="2005">2005</option>
                        <option value="2006">2006</option>
                        <option value="2007">2007</option>
                        <option value="2008">2008</option>
                    </select>
				</td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td>
				<input type="radio" name="gender" id="gender-male" value="MALE" required>
                    <label for="gender-male">Male</label>
                    <input type="radio" name="gender" id="gender-female" value="FEMALE">
                    <label for="gender-female">Female</label>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save" />
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>