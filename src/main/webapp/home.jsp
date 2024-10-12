<!DOCTYPE html>
<html>
<head>
    <title>Placement Portal Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            padding: 1em;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            padding: 0.5em 1em;
        }
        .navbar a:hover {
            background-color: #575757;
            border-radius: 4px;
        }
        .navbar .logo {
            font-size: 1.5em;
            font-weight: bold;
            color: white;
        }
        .navbar form {
            display: inline;
        }
    </style>
</head>
<body>
    <center>
        <img src="logo.jpg" alt="TalentSpot Logo" />
        <h2>TalentSpot Placements</h2>
    </center>
    <div class="navbar">
        <div class="logo">Placement Portal</div>
        <div>
            <form action="irp_login.jsp" method="post" style="display: inline;">
                <button type="submit" style="background: none; border: none; color: white; padding: 0.5em 1em; cursor: pointer;">IRP</button>
            </form>
            <form action="studentlogin.jsp" method="post" style="display: inline;">
                <button type="submit" style="background: none; border: none; color: white; padding: 0.5em 1em; cursor: pointer;">Student</button>
            </form>
            <form action="dept_login.jsp" method="post" style="display: inline;">
                <button type="submit" style="background: none; border: none; color: white; padding: 0.5em 1em; cursor: pointer;">Department</button>
            </form>
            <form action="faculty_login.jsp" method="post" style="display: inline;">
                <button type="submit" style="background: none; border: none; color: white; padding: 0.5em 1em; cursor: pointer;">Faculty</button>
            </form>
        </div>
    </div>
</body>
</html>