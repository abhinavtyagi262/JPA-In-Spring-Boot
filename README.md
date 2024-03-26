# JPA-In-Spring-Boot
Student Registration Microservice (studentCreateUpdate API, studentDetailsRetrieve API, and studentListingRetrieve API)

studentCreateUpdate API
------------------------
------------------------

Local URL (POST)
-----------------
http://localhost:9080/abhinav/studentCreateUpdate


Request Body
-------------
{
    "studentId": "1",
    "studentName": "studentName1",
    "studentMobile": "9999999999",
    "studentDob": "1991-12-05",
    "username": "username1"
}


Response Body
--------------
{
    "result": {
        "studentId": "1"
    },
    "errors": null
}


studentDetailsRetrieve API
---------------------------
---------------------------

Local URL (POST)
-----------------
http://localhost:9080/abhinav/studentDetailsRetrieve


Request Body
-------------
{
    "studentId": "1"
}


Response Body
--------------
{
    "result": {
        "studentId": "1",
        "studentName": "studentName1",
        "studentMobile": "9999999999",
        "studentDob": "05-12-1991",
        "registrationDate": "17-01-2023",
        "registrationStatus": "Registered",
        "createdBy": "username1",
        "updatedBy": "username1",
        "createdOn": "2023-01-17T19:35:41",
        "updatedOn": "2023-01-17T19:40:48"
    },
    "errors": null
}


studentListingRetrieve API
---------------------------
---------------------------

Local URL (POST)
-----------------
http://localhost:9080/abhinav/studentListingRetrieve


Request Body
-------------
{
    "studentName": "studentName1"
}


Response Body
--------------
{
    "result": [
        {
            "studentId": "1",
            "studentName": "studentName1",
            "studentMobile": "9999999999",
            "studentDob": "05-12-1991",
            "registrationDate": "17-01-2023",
            "registrationStatus": "Registered",
            "createdBy": "username1",
            "updatedBy": "username1",
            "createdOn": "2023-01-17T19:35:41",
            "updatedOn": "2023-01-17T19:40:48"
        },
        {
            "studentId": "2",
            "studentName": "studentName1",
            "studentMobile": "8888888888",
            "studentDob": "04-10-1990",
            "registrationDate": "17-01-2023",
            "registrationStatus": "Registered",
            "createdBy": "username1",
            "updatedBy": "username2",
            "createdOn": "2023-01-17T19:41:47",
            "updatedOn": "2023-01-17T19:45:48"
        }
    ],
    "errors": null
}


getStudentDetails API
----------------------
----------------------

Local URL (GET)
----------------
http://localhost:9080/abhinav/getStudentDetails?studentId=1


Request Param
--------------
studentId: 1


Response Body
--------------
{
    "result": {
        "studentId": "1",
        "studentName": "studentName1",
        "studentMobile": "9999999999",
        "studentDob": "05-12-1991",
        "registrationDate": "17-01-2023",
        "registrationStatus": "Registered",
        "createdBy": "username1",
        "updatedBy": "username1",
        "createdOn": "2023-01-17T19:35:41",
        "updatedOn": "2023-01-17T19:40:48"
    },
    "errors": null
}


getStudentDetails2 API
-----------------------
-----------------------

Local URL (GET)
----------------
http://localhost:9080/abhinav/getStudentDetails2?studentId=1


Request Param
--------------
studentId: 1


Response Body
--------------
{
    "result": {
        "studentId": "1",
        "studentName": "studentName1",
        "studentMobile": "9999999999",
        "studentDob": "05-12-1991",
        "registrationDate": "17-01-2023",
        "registrationStatus": "Registered",
        "createdBy": "username1",
        "updatedBy": "username1",
        "createdOn": "2023-01-17T19:35:41",
        "updatedOn": "2023-01-17T19:40:48"
    },
    "errors": null
}
