<%@ page import="cn.njust.entity.User" %>
<%@ page import="cn.njust.entity.Equipment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import=""@%>--%>
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
                <a href="welcome.jsp" class="nav-link">返回首页</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="login.jsp" class="nav-link">退出登录</a>
            </li>
        </ul>
    </nav>

    <!-- 侧边栏容器 -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- 侧边栏logo -->
        <a href="welcome.jsp" class="brand-link">
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
                                <a href="../page/client/person/message.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>收信箱</p>
                                </a>
                            </li>
                        </ul>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../page/client/person/modification.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>修改信息</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <p>
                                租借
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item active">
                                <a href="#" class="nav-link active">
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
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <p>
                                订单
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../servlet/OrderController" class="nav-link">
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
                        <h1>所有器材</h1>
                    </div>
                </div>
            </div>
        </section>

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
                                        <th>器材编号</th>
                                        <th>器材名称</th>
                                        <th>单价</th>
                                        <th>余量</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <!-- 此处插入c标签 -->
                                    <%
                                        List<Equipment> listEquip=(List<Equipment>) request.getAttribute("equipList");
//                                        System.out.println("fedsaf");
                                        System.out.println(listEquip);
                                        if(listEquip!=null)
                                        {
                                            for(Equipment i:listEquip)
                                            {

                                    %>
                                    <tr>
                                        <td><%=i.getId()%></td>
                                        <td><%=i.getName()%></td>
                                        <td><%=i.getPrice()%>元/小时</td>
                                        <td><%=i.getNumber()%></td>
                                        <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal<%=i.getId()%>">租赁</button></td>
                                        <div class="modal fade" id="myModal<%=i.getId()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-body">
                                                        <form action="../servlet/EquipmentController">
                                                            <h2 class="from_title" >确认订单</h2>
                                                            <h3>器材编号： <input  name="equipment_id" type="text" readonly unselectable="on" value="<%=i.getId()%>" style= "background-color:transparent;border:0;width: 50px"></h3>
                                                            <h3>器材名称： <input  name="equipment_name" type="text" readonly unselectable="on" value="<%=i.getName()%>" style= "background-color:transparent;border:0;width: 120px"></h3>
                                                            <h3>租赁时长： <select name="hours">
                                                                <option>1</option>
                                                                <option>2</option>
                                                                <option>3</option>
                                                                <option>4</option>
                                                            </select></h3>
<%--                                                        </form>--%>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                                        </button>
                                                        <input id="p" name="p" type="submit" class="btn btn-primary" value="确定" data-dismiss="modal" data-toggle="modal" data-target="#myModal<%=i.getId()%>myModal">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal fade" id="myModal<%=i.getId()%>myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-body">
                                                        <h2 class="from_title" >下单成功！请等待管理员审核。</h2>
                                                        <div class="modal-footer">
                                                            <input name="ok2" type="submit" class="btn btn-primary" value="确定" >
                                                        </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>



<%--                                    <tr>--%>
<%--                                        <td>12138</td>--%>
<%--                                        <td>羽毛球拍一副</td>--%>
<%--                                        <td>20元/小时</td>--%>
<%--                                        <td>100</td>--%>
<%--                                        <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal">租赁</button></td>--%>
<%--                                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
<%--                                            <div class="modal-dialog">--%>
<%--                                                <div class="modal-content">--%>
<%--                                                    <div class="modal-body">--%>
<%--                                                        <form action="#">--%>
<%--                                                            <h2 class="from_title">确认订单</h2>--%>
<%--                                                            <h3>器材编号： 12138</h3>--%>
<%--                                                            <h3>器材名称： 羽毛球拍一副</h3>--%>
<%--                                                            <h3>租赁数量： <input type="text" placeholder="1" class="input"></h3>--%>
<%--                                                        </form>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="modal-footer">--%>
<%--                                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消--%>
<%--                                                        </button>--%>
<%--                                                        <button type="button" class="btn btn-primary">--%>
<%--                                                            确定--%>
<%--                                                        </button>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </tr>--%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>器材编号</th>
                                        <th>器材名称</th>
                                        <th>单价</th>
                                        <th>余量</th>
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
