<%@include file="dept_home.jsp" %>
<%
String qname = request.getParameter("qname");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Create a Quiz</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2, h3 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
            font-weight: bold;
        }
        label {
            font-weight: bold;
            color: #343a40;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ced4da;
            border-radius: 5px;
        }
        input[type="radio"] {
            margin-right: 10px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Create a Quiz</h2>
        <form action="get_quiz.jsp" method="post">
            <div class="form-group">
                <label for="name">Quiz Name</label>
                <input type="text" id="name" name="qname" value="<%=qname%>" class="form-control" required />
            </div>
            
            <div class="form-group">
                <label for="question">Question</label>
                <textarea id="question" name="question" rows="4" class="form-control" required></textarea>
            </div>
            
            <div class="form-group">
                <label for="option1">Option 1</label>
                <input type="text" id="option1" name="option1" class="form-control" required />
            </div>
            
            <div class="form-group">
                <label for="option2">Option 2</label>
                <input type="text" id="option2" name="option2" class="form-control" required />
            </div>
            
            <div class="form-group">
                <label for="option3">Option 3</label>
                <input type="text" id="option3" name="option3" class="form-control" required />
            </div>
            
            <div class="form-group">
                <label for="option4">Option 4</label>
                <input type="text" id="option4" name="option4" class="form-control" required />
            </div>
            
            <h3>Correct Answer</h3>
            <div class="form-check form-check-inline">
                <input type="radio" id="answer1" value="1" name="crtanswer" class="form-check-input" required />
                <label for="answer1" class="form-check-label">1</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" id="answer2" value="2" name="crtanswer" class="form-check-input" required />
                <label for="answer2" class="form-check-label">2</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" id="answer3" value="3" name="crtanswer" class="form-check-input" required />
                <label for="answer3" class="form-check-label">3</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" id="answer4" value="4" name="crtanswer" class="form-check-input" required />
                <label for="answer4" class="form-check-label">4</label>
            </div>
            
            <br><br>
            <button type="submit" class="btn btn-primary btn-block">Add Question</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
