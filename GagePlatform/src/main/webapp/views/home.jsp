<%--
  Created by IntelliJ IDEA.
  User: xn
  Date: 2017/3/27
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>主页</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li class="active">主页</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                <div class="panel">
                    <div class="panel-body">
                        <div class="calendar-block ">
                            <div class="cal1">

                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                <div class="panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">天气</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>
                    <div class="panel-body widget-weather">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <h3 class="text-center title">今日</h3>
                                <div class="text-center">
                                    <canvas id="clear-day" width="75" height="75"></canvas>
                                    <div class="temp">14~26°C</div>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <h3 class="text-center title">今晚</h3>
                                <div class="text-center">
                                    <canvas id="partly-cloudy-night" width="75" height="75"></canvas>
                                    <div class="temp">15°C</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">周一</h6>
                                <div class="text-center">
                                    <canvas id="partly-cloudy-day" width="32" height="32"></canvas>
                                    <span>20°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">周二</h6>
                                <div class="text-center">
                                    <canvas id="rain" width="32" height="32"></canvas>
                                    <span>19°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">周三</h6>
                                <div class="text-center">
                                    <canvas id="sleet" width="32" height="32"></canvas>
                                    <span>22°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">周四</h6>
                                <div class="text-center">
                                    <%--<canvas id="snow" width="32" height="32"></canvas>--%>
                                    <canvas id="snow" width="32" height="32"></canvas>
                                    <span>28°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">周五</h6>
                                <div class="text-center">
                                    <canvas id="wind" width="32" height="32"></canvas>
                                    <span>20°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">周六</h6>
                                <div class="text-center">
                                    <canvas id="fog" width="32" height="32"></canvas>
                                    <span>22°C</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </section>
</section>
<!--main content end-->
</section>

<!--header and navi end-->


<jsp:include page="footer.jsp"/>
<!--Page Level JS-->
<script src="../assets/plugins/countTo/jquery.countTo.js"></script>
<script src="../assets/plugins/weather/js/skycons.js"></script>
<script src="../assets/plugins/daterangepicker/moment.min.js"></script>
<script src="../assets/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Calendar -->
<script src="../assets/plugins/calendar/clndr.js"></script>
<script src="../assets/plugins/calendar/clndr-demo.js"></script>
<script src="../assets/plugins/calendar/underscore-min.js"></script>
<!-- Switch -->
<%--<script src="../assets/plugins/switchery/switchery.min.js"></script>--%>
<!--Load these page level functions-->
<script>
    $('#home').addClass("active");

    $(document).ready(function () {
//        $('.calendar-block').clndr();
        app.dateRangePicker();
        app.weather();
    });
</script>
