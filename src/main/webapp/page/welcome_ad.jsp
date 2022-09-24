<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>体育馆管理系统 | 我的首页</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <link rel="stylesheet" href="../css/all.min.css">
  <link rel="stylesheet" href="../css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="../css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="../css/buttons.bootstrap4.min.css">
  <link rel="stylesheet" href="../css/adminlte.min.css">
  <link rel="stylesheet" href="../css/welcome.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper" >
  <!-- 头部 -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- 头部左侧按钮 -->
    <ul class="navbar-nav">
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">返回首页</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="../page/login.jsp" class="nav-link">退出登录</a>
      </li>
    </ul>
  </nav>

  <!-- 侧边栏容器 -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- 侧边栏logo -->
    <a href="#" class="brand-link">
      <img src="../img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">体育馆管理系统</span>
    </a>

    <!-- 用户信息 -->
    <%

    %>
    <div class="sidebar">
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="../img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">管理员</a>
        </div>
      </div>


      <!-- 侧边导航栏 -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <a href="#" class="nav-link">
              <p>
                账号管理
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../servlet/CountController" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>所有账号</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <p>
                订单管理
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../servlet/OrderController_ad" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>所有订单</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../page/administrator/order/exam.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>审核订单</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../page/administrator/order/hurry.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>催促订单</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <p>
                商品管理
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../page/administrator/shop/equipment.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>器材管理</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../page/administrator/shop/venue.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>场地管理</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
    </div>
  </aside>

  <div class="content-wrapper">

    <!-- 主要内容 -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">
              <!-- 表格头 -->
              <div class="welcome">
                <p class="p_welcome">管理员，<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎使用本系统！</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
  <!-- /.主题内容底部-->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.2.0
    </div>
  </footer>
</div>

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.bundle.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>
<script src="../js/dataTables.bootstrap4.min.js"></script>
<script src="../js/dataTables.responsive.min.js"></script>
<script src="../js/responsive.bootstrap4.min.js"></script>
<script src="../js/dataTables.buttons.min.js"></script>
<script src="../js/buttons.bootstrap4.min.js"></script>
<script src="../js/jszip.min.js"></script>
<script src="../js/pdfmake.min.js"></script>
<script src="../js/vfs_fonts.js"></script>
<script src="../js/buttons.html5.min.js"></script>
<script src="../js/buttons.print.min.js"></script>
<script src="../js/buttons.colVis.min.js"></script>
<script src="../js/adminlte.min.js"></script>
<script src="../js/demo.js"></script>
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>
</body>
</html>
