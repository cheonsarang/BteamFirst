<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>채팅하기</h3>
</body>
<script type="module">
  // Import the functions you need from the SDKs you need
  import { initializeApp } from "https://www.gstatic.com/firebasejs/9.10.0/firebase-app.js";
  import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.10.0/firebase-analytics.js";
  // TODO: Add SDKs for Firebase products that you want to use
  // https://firebase.google.com/docs/web/setup#available-libraries

  // Your web app's Firebase configuration
  // For Firebase JS SDK v7.20.0 and later, measurementId is optional
  const firebaseConfig = {
    apiKey: "AIzaSyAp9zXyu9mIv76NQy8-9a5l_8KQANibMEA",
    authDomain: "chatapp-57272.firebaseapp.com",
    databaseURL: "https://chatapp-57272-default-rtdb.firebaseio.com",
    projectId: "chatapp-57272",
    storageBucket: "chatapp-57272.appspot.com",
    messagingSenderId: "88658011339",
    appId: "1:88658011339:web:bc9548a1d0013d566ee74e",
    measurementId: "G-15MZPG7MM8"
  };

  // Initialize Firebase
  const app = initializeApp(firebaseConfig);
  const analytics = getAnalytics(app);
</script>
</html>