<%@ page import="com.klef.ep.models.*" %>
<%@ page import="com.klef.ep.services.StudentServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ include file="studenthome.jsp" %> 

<%
    StudentServiceImpl service = new StudentServiceImpl();
    List<JobProfile> jlist = service.viewalljobs();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Jobs</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif; /* Using a more visible font */
        }
        .card {
            margin-bottom: 20px;
        }
        .card-title {
            font-size: 1.25em;
            font-weight: bold;
        }
        .card-text {
            font-size: 1em;
        }
        .card-img-top {
            width: 100%;
            height: 150px; /* Adjust height as needed */
            object-fit: contain; /* Ensure the image fits within the dimensions */
        }
        .btn-apply {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn-apply:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h3 class="text-center my-4">View All Jobs</h3>
    <div class="row">
        <%
            for(JobProfile j : jlist) {
        %>
        <div class="col-md-4">
            <div class="card">
                <img src="viewjobbyid.jsp?jid=<%= j.getJid() %>" class="card-img-top" alt="Job Image">
                <div class="card-body">
                    <h5 class="card-title"><%= j.getJtitle() %></h5>
                    <p class="card-text"><strong>Company:</strong> <%= j.getCname() %></p>
                    <p class="card-text"><strong>Location:</strong> <%= j.getJloc() %></p>
                    <p class="card-text"><strong>Type:</strong> <%= j.getJtype() %></p>
                    <p class="card-text"><strong>Description:</strong> <%= j.getJdes() %></p>
                    <a href="<%= j.getJlink() %>" class="btn btn-apply">Apply</a>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
