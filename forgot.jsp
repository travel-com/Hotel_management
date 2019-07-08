<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Bootstrap Snippet: Login Form</title>
  
  
  <link rel='stylesheet' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>

      <link rel="stylesheet" href="./css/styleforForgot.css">

  
</head>

<body>

    <div class="wrapper">
    <form class="form-signin" action="ForgotPasswordControllerUrl" method="post">       
      <h2 class="form-signin-heading">Please enter email,UserName</h2>
      <input type="text" class="form-control" name="email" placeholder="Email Address" required="" autofocus="" />      
      <label></label>
      <input type="text" class="form-control" name="username" placeholder="User Name" required="" autofocus="" /> 
      <label></label>     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Send Otp</button>   
    </form>
  </div>
  
  

</body>

</html>
