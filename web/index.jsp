<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <title>შესვლის გვერდი</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="public/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"> </script>
    <script type="text/javascript" src="index.js"></script>
</head>
<body class="indexPageBody"> 
    <div class="login-page">
        <div class="form">
            <form  class="register-form" action="RegisterServlet" name="registerForm" method="post">
                <input type="text" placeholder="სახელი" name="firstname"/> <br>
                <input type="text" placeholder="გვარი" name="lastname" /> <br>
                <input type="text" placeholder="მომხ.სახელი" name="username" /> <br>
                <input type="text" placeholder="ელ.ფოსტა" name="email" /> <br>
                <input type="password" placeholder="პაროლი" name="password" /> <br>
                <button type="submit">დასრულება</button>
                <p class="message">უკვე რეგისტრირებული ხარ?<a href="#">გაიარე ავტორიზაცია</a> </p>
            </form>
            <form class="login-form" action="LoginServlet" method="post">
                <input type="text" placeholder="მომხ.სახელი" name="username"/>
                <input type="password" placeholder="პაროლი" name="password"/>
                <button type="submit">შესვლა</button>
                <p class="message">არ ხართ რეგისტრირებული?<a href="#">რეგისტრაცია</a></p>
            </form>
        </div>
    </div>
</body>
</html>
