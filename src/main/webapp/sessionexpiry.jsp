<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Session Expired</title>
   
    <style>
        body, h1, p, a, img {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background: #f3f4f6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
            width: 100%;
        }

        .card {
            background: #ffffff;
            padding: 2rem;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        .card img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
            margin-bottom: 1rem;
        }

        .card h1 {
            font-size: 2rem;
            color: #333333;
            margin-bottom: 1rem;
        }

        .card p {
            color: #666666;
            margin-bottom: 2rem;
        }

        .btn {
            background: #007bff;
            color: #ffffff;
            text-decoration: none;
            padding: 0.75rem 1.5rem;
            border-radius: 4px;
            transition: background 0.3s ease;
        }

        .btn:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <img alt="Session Expired" src="expired-account.gif">
            <h1>Session Expired</h1>
            <p>Your session has expired due to inactivity. Please log in again to continue.</p>
            <a href="home.jsf" class="btn">Log In</a>
        </div>
    </div>
</body>
</html>