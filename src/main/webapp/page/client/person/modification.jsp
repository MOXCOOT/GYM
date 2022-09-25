<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import=""@%>--%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>体育馆管理系统 | 我的首页</title>
    <link rel="stylesheet" href="../css/all.min.css">
    <link rel="stylesheet" href=" ../css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href=" ../css/responsive.bootstrap4.min.css">
    <link rel="stylesheet" href=" ../css/buttons.bootstrap4.min.css">
    <link rel="stylesheet" href=" ../css/adminlte.min.css">
    <link rel="stylesheet" href=" ../css/mo.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper" >
    <!-- 头部 -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- 头部左侧按钮 -->
        <ul class="navbar-nav">
            <li class="nav-item d-none d-sm-inline-block">
                <a href="../page/welcome.jsp" class="nav-link">返回首页</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="../page/login.jsp" class="nav-link">退出登录</a>
            </li>
        </ul>
    </nav>

    <!-- 侧边栏容器 -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- 侧边栏logo -->
        <a href="../page/welcome.jsp" class="brand-link">
            <img src=" ../img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">体育馆管理系统</span>
        </a>

        <!-- 用户信息 -->
        <%

        %>
        <div class="sidebar">
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src=" ../img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">张少威</a>
                </div>
            </div>


            <!-- 侧边导航栏 -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <p>
                                我的账号
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href=" ../page/client/person/message.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>收信箱</p>
                                </a>
                            </li>
                        </ul>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href=" ../page/client/person/modification.jsp" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>修改信息</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <p>
                                租借
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item active">
                                <a href=" ../page/client/shop/equipment.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>租借器材</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href=" ../page/client/shop/venue.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>租借场地</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <p>
                                订单
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href=" ../page/client/order/client_order.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>所有订单</p>
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
                            <div class="modify1">
                                <div class="modify2">
                                        <form action="#" class="mo_form">
                                            <br><br>
                                            <h2 class="from_title">我的信息</h2><br>
                                            <h5>用户名： cs</h5><br>
                                            <h5>我的名称： 张少威</h5><br>
                                            <h5>手机号： 13713713713</h5><br>
                                            <input id="p" name="p1" type="submit" class="btn btn-primary" value="修改信息" data-dismiss="modal" data-toggle="modal" data-target="#myModal9">
                                        </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="myModal9" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="modal-title" id="myModalLabel">修改信息</h2>
                        </div>
                        <div class="modal-body">
                            <form action="#" >
                                <h5>用户名： sc</h5><br>
                                <h5>我的名称：</h5>
                                <input type="text" id="name" placeholder="张少威">
                                <br><br>
                                <h5>手机号：</h5>
                                <input type="text" id="numm" placeholder="13713713713">
                                <br><br>
                                <h5>修改密码：</h5>
                                <input type="password" id="pwd1" placeholder="请输入新密码">
                                <br><br>
                                <h5>确认密码：</h5>
                                <input type="password" id="pwd2" placeholder="请重复新密码">
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <input id="p" name="p1" type="submit" class="btn btn-primary" value="确定" data-dismiss="modal" data-toggle="modal" data-target="#myModal1">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="modal-title" id="myModalLabel">修改信息成功！</h2>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
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

<script src=" ../js/jquery.min.js"></script>
<script src=" ../js/bootstrap.bundle.min.js"></script>
<script src=" ../js/jquery.dataTables.min.js"></script>
<script src=" ../js/dataTables.bootstrap4.min.js"></script>
<script src=" ../js/dataTables.responsive.min.js"></script>
<script src=" ../js/responsive.bootstrap4.min.js"></script>
<script src=" ../js/dataTables.buttons.min.js"></script>
<script src=" ../js/buttons.bootstrap4.min.js"></script>
<script src=" ../js/jszip.min.js"></script>
<script src=" ../js/pdfmake.min.js"></script>
<script src=" ../js/vfs_fonts.js"></script>
<script src=" ../js/buttons.html5.min.js"></script>
<script src=" ../js/buttons.print.min.js"></script>
<script src=" ../js/buttons.colVis.min.js"></script>
<script src=" ../js/adminlte.min.js"></script>
<script src=" ../js/demo.js"></script>
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
