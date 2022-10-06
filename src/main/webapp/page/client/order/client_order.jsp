<%@ page import="cn.njust.entity.User" %>
<%@ page import="cn.njust.entity.Order" %>
<%@ page import="java.util.List" %>
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
        <a href="#" class="brand-link">
            <img src=" ../img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
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
                    <%
                        User u=(User) request.getSession().getAttribute("user");
                    %>

                    <a href="#" class="d-block"><%=u.getName()%></a>
                </div>
            </div>


            <!-- 侧边导航栏 -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <p>
                                我的账号
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../servlet/MessageController" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>收信箱</p>
                                </a>
                            </li>
                        </ul>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../servlet/UserController" class="nav-link">
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
                            <li class="nav-item">
                                <a href="../servlet/EquipmentController" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>租借器材</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../servlet/VenueController" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>租借场地</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <p>
                                订单
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="#" class="nav-link active">
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
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>我的订单</h1>
                    </div>
                </div>
            </div>
        </section>

        <!-- 主要内容 -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">



                        <div class="card">
                            <!-- 表格头 -->
                            <div class="card-body">
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>订单编号</th>
                                        <th>订单项目</th>
                                        <th>起始时间</th>
                                        <th>归还时间</th>
                                        <th>金额（元）</th>
                                        <th>订单状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <!-- 此处插入c标签 -->
                                    <%
                                        List<Order> listOrder=(List<Order>) request.getAttribute("orderList");
                                        System.out.println(listOrder);
                                        if(listOrder!=null)
                                        {
                                            for(Order i:listOrder)
                                            {
                                                if(i.getState().equals("已完成")==false)
                                                {
                                    %>
                                    <tr>
                                        <td><%=i.getOid()%></td>
                                        <td><%=i.getRname()%></td>
                                        <td><%=i.getOrderTime()%></td>
                                        <td><%=i.getReturnTime()%></td>
                                        <td><%=i.getSum()%></td>
                                        <td><%=i.getState()%></td>
                                        <%
                                            if(i.getState().equals("进行中")||i.getState().equals("已逾期"))
                                            {
                                        %>
                                        <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal<%=i.getOid()%>">完成订单</button></td>
                                        <%
                                            }
                                            else
                                            {
                                        %>
                                        <td>--------</td>
                                        <%
                                            }
                                        %>
                                        <div class="modal fade" id="myModal<%=i.getOid()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h2 class="modal-title" id="myModal<%=i.getOid()%>">订单详情</h2>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form action="../servlet/OrderController" >
                                                            <h5>用户ID：<input  name="user_id" type="text" readonly unselectable="on" value="<%=i.getUid()%>" style= "background-color:transparent;border:0;width: 90px"></h5><br><br>
                                                            <h5>订单编号：<input  name="order_id" type="text" readonly unselectable="on" value="<%=i.getOid()%>" style= "background-color:transparent;border:0;width: 130px"></h5><br><br>
                                                            <%--                                                        </form>--%>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <%--                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">催促归还</button>--%>
                                                        <input id="p" name="return" type="submit" class="btn btn-danger" value="确定归还">
                                                    </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>

                                    </tr>
                                    <%
                                                }
                                            }
                                        }
                                    %>


                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>订单编号</th>
                                        <th>订单项目</th>
                                        <th>起始时间</th>
                                        <th>归还时间</th>
                                        <th>金额（元）</th>
                                        <th>订单状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </tfoot>
                                </table>
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
        <%--        <strong>Copyright &copy; 2022.</strong> All rights reserved.--%>
    </footer>
</div>

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.bundle.min.js"></script>
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
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
</script>
</body>
</html>
