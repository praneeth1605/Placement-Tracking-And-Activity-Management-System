<%@ page language="java" %>
<%@ include file="irp_home.jsp" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Placement Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS for animations -->
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Roboto', sans-serif; 
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            background-color: #ffffff;
        }
        .form-title {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            color: #007bff; /* Blue color for the title */
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-control {
            border-radius: 4px;
        }
        .btn-submit {
            background-color: #17a2b8; /* Aqua color for the button */
            color: #ffffff;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn-submit:hover {
            background-color: #138496; /* Darker shade on hover */
        }
        label {
            font-weight: bold; /* Make labels thicker */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2 class="form-title">Job Placement Form</h2>
            <form method="post" action="insertjobprofile" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="companyName">Company Name</label>
                    <input type="text" class="form-control" id="companyName" placeholder="Enter Company Name" name="cname" required>
                </div>
                <div class="form-group">
                    <label for="jobTitle">Job Title</label>
                    <input type="text" class="form-control" id="jobTitle" placeholder="Enter Job Title" name="jtitle" required>
                </div>
                <div class="form-group">
                    <label for="jobLocation">Job Location</label>
                    <select class="form-control" id="jobLocation" name="jobloc" required>
                        <option selected disabled>Select Location</option>
                        <option value="Bengaluru">Bengaluru</option>
                        <option value="Chennai">Chennai</option>
                           <option value="Delhi">Delhi</option>
                        <option value="Hyderabad">Hyderabad</option>
                        <option value="Mumbai">Mumbai</option>
                        <option value="Pune" >Pune</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="jobType">Job Type</label>
                    <select class="form-control" id="jobType" name="jtype" required>
                        <option selected disabled>Select Job Type</option>
                        <option value="FULL-TIME">Full-Time</option>
                        <option value="PART-TIME">Part-Time</option>
                        <option value="INTERNSHIP">Internship</option>
                        <option value="CONTRACT">Contract</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="jobTitle">Job Link</label>
                    <input type="text" class="form-control" id="jobTitle" placeholder="Enter Job Link" name="jlink" required>
                </div>
                <div class="form-group">
                    <label for="jobDescription">Job Description</label>
                    <textarea class="form-control" id="jobDescription" rows="5" placeholder="Enter Job Description" name="jdes" required></textarea>
                </div>
                <div class="form-group">
                 <label for="jimage">Upload Image</label><br>
                <input type="file" name="jimage" required>
                </div>
                <button type="submit" class="btn btn-submit">Submit</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>