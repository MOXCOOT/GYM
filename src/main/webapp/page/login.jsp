<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<script>
  //取出传回来的参数error并与yes比较
  var error ='<%=request.getParameter("error")%>';
  if(error=='yes0'){
    alert("注册成功!");
    window.location.href = "/GYM_manage_war_exploded/page/login.jsp";
  }
  if(error=='yes1'){
    alert("输入两次密码不一致");
    window.location.href = "/GYM_manage_war_exploded/page/login.jsp";
  }
  if(error=='yes2'){
    alert("输入不能为空");
    window.location.href = "/GYM_manage_war_exploded/page/login.jsp";
  }
  if(error=='yes3'){
    alert("手机号错误或已被注册");
    window.location.href = "/GYM_manage_war_exploded/page/login.jsp";
  }
</script>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="../css/login.css">
  <title>体育馆管理系统 | 登录</title>
</head>
<body>
<div class="container right-panel-active">
  <div class="container_from container--signin">
    <form action="../servlet/LoginController" class="from">
      <h2 class="from_title">欢迎登录</h2>
      <input name="name" type="text" placeholder="手机或用户名" class="input">
      <input name="pwd" type="password" placeholder="密码" class="input">
      <input type="submit" name="login" class="btn" value="登录">
    </form>
  </div>

  <div class="container_from container--signup">
    <form action="../servlet/LoginController" class="from" >
      <h2 class="from_title">注册账号</h2>
      <input name="name_sub" type="text" placeholder="姓名" class="input">
      <input name="phone" type="text" placeholder="手机号" class="input">
      <input name="pwd1" type="password" placeholder="密码" class="input">
      <input name="pwd2" type="password" placeholder="确认密码" class="input">
      <input type="submit" name="sub" class="btn" value="点击注册">
    </form>
  </div>

  <div class="container_overlay">
    <div class="overlay">
      <div class="overlay_panel overlay--left">
        <button class="btn" id="signin">已有账号，直接登陆</button>
      </div>

      <div class="overlay_panel overlay--right">
        <button class="btn" id="signup">没有账号，点击注册</button>
      </div>
    </div>
  </div>

</div>
<script src="../js/login.js"></script>
</body>
</html>
