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
            <span class="label">You are here:</span>
            <ol class="breadcrumb">
                <li class="active">主页</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12 col-lg-6">
                <div class="row">
                    <div class="col-md-6">
                        <div class="panel panel-solid-success widget-mini">
                            <div class="panel-body">
                                <i class="icon-bar-chart"></i>
                                <span class="total text-center">$3,200</span>
                                <span class="title text-center">Earnings</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel widget-mini">
                            <div class="panel-body">
                                <i class="icon-support"></i>
                                <span class="total text-center">1,230</span>
                                <span class="title text-center">Support</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel widget-mini">
                            <div class="panel-body">
                                <i class="icon-envelope-open"></i>
                                <span class="total text-center">1,680</span>
                                <span class="title text-center">Messages</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-solid-info widget-mini">
                            <div class="panel-body">
                                <i class="icon-user"></i>
                                <span class="total text-center">12,680</span>
                                <span class="title text-center">Signups</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div class="panel panel-default browser-chart">
                    <div class="panel-heading">
                        <h3 class="panel-title">BROWSER STATS</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                <ul>
                                    <li><i class="fa fa-circle success-color"></i> Chrome</li>
                                    <li><i class="fa fa-circle primary-color"></i> IE</li>
                                    <li><i class="fa fa-circle warning-color"></i> Safari</li>
                                    <li><i class="fa fa-circle info-color"></i> Firefox</li>
                                    <li><i class="fa fa-circle default-color"></i> Other</li>
                                </ul>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                <div id="doughnut-canvas-holder">
                                    <canvas id="doughnut-chart-area" width="137" height="137" style="width: 137px; height: 137px;"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Monthly Goal</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                        </div>
                    </div>
                    <div class="panel-body widget-gauge">
                        <canvas width="160" height="100" id="gauge" class=""></canvas>
                        <div class="goal-wrapper">
                            <span class="gauge-value pull-left">$</span>
                            <span id="gauge-text" class="gauge-value pull-left">3,200</span>
                            <span id="goal-text" class="goal-value pull-right">$5,000</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4">
                <div class="panel panel-default chat-widget">
                    <div class="panel-heading">
                        <h3 class="panel-title">chat</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="row wrapper animated fadeInRight">
                            <div class="col-xs-2 col-sm-2 col-md-2 ">
                                        <span class="avatar">
                                        <img src="assets/img/avatar3.png" class="img-circle" alt="">
                                        <i class="on animated bounceIn"></i>
                                    </span>
                            </div>
                            <div class="col-xs-10 col-sm-10 col-md-10">
                                <div class="post default">
                                    <span class="arrow left"></span>
                                    <p>Hey Mike...Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibut</p>
                                </div>
                            </div>
                        </div>
                        <div class="row wrapper animated fadeInLeft">
                            <div class="col-xs-10 col-sm-10 col-md-10">
                                <div class="post primary">
                                    <span class="arrow right"></span>
                                    <p>Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et.</p>
                                </div>
                            </div>
                            <div class="col-xs-2 col-sm-2 col-md-2">
                                        <span class="avatar">
                                        <img src="assets/img/profile.jpg" class="img-circle" alt="">
                                        <i class="on animated bounceIn"></i>
                                    </span>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <form>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Say something">
                                <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">SEND</button>
                                         </span>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4">
                <div class="panel">
                    <div class="panel-body">
                        <div class="calendar-block ">
                            <div class="cal1"><div class="clndr"><div class="clndr-controls"><div class="clndr-control-button"><span class="clndr-previous-button"><i class="fa fa-angle-left"></i></span></div><div class="month">April 2017</div><div class="clndr-control-button"><span class="clndr-next-button"><i class="fa fa-angle-right"></i></span></div></div><table class="clndr-table" border="0" cellspacing="0" cellpadding="0"><thead><tr class="header-days"><td class="header-day">S</td><td class="header-day">M</td><td class="header-day">T</td><td class="header-day">W</td><td class="header-day">T</td><td class="header-day">F</td><td class="header-day">S</td></tr></thead><tbody><tr><td class="day past adjacent-month last-month calendar-day-2017-03-26 calendar-dow-0"><div class="day-contents">26</div></td><td class="day past adjacent-month last-month calendar-day-2017-03-27 calendar-dow-1"><div class="day-contents">27</div></td><td class="day past adjacent-month last-month calendar-day-2017-03-28 calendar-dow-2"><div class="day-contents">28</div></td><td class="day past adjacent-month last-month calendar-day-2017-03-29 calendar-dow-3"><div class="day-contents">29</div></td><td class="day past adjacent-month last-month calendar-day-2017-03-30 calendar-dow-4"><div class="day-contents">30</div></td><td class="day past adjacent-month last-month calendar-day-2017-03-31 calendar-dow-5"><div class="day-contents">31</div></td><td class="day past calendar-day-2017-04-01 calendar-dow-6"><div class="day-contents">1</div></td></tr><tr><td class="day past calendar-day-2017-04-02 calendar-dow-0"><div class="day-contents">2</div></td><td class="day past calendar-day-2017-04-03 calendar-dow-1"><div class="day-contents">3</div></td><td class="day past calendar-day-2017-04-04 calendar-dow-2"><div class="day-contents">4</div></td><td class="day past calendar-day-2017-04-05 calendar-dow-3"><div class="day-contents">5</div></td><td class="day past calendar-day-2017-04-06 calendar-dow-4"><div class="day-contents">6</div></td><td class="day past calendar-day-2017-04-07 calendar-dow-5"><div class="day-contents">7</div></td><td class="day today calendar-day-2017-04-08 calendar-dow-6"><div class="day-contents">8</div></td></tr><tr><td class="day calendar-day-2017-04-09 calendar-dow-0"><div class="day-contents">9</div></td><td class="day event calendar-day-2017-04-10 calendar-dow-1"><div class="day-contents">10</div></td><td class="day event calendar-day-2017-04-11 calendar-dow-2"><div class="day-contents">11</div></td><td class="day event calendar-day-2017-04-12 calendar-dow-3"><div class="day-contents">12</div></td><td class="day event calendar-day-2017-04-13 calendar-dow-4"><div class="day-contents">13</div></td><td class="day event calendar-day-2017-04-14 calendar-dow-5"><div class="day-contents">14</div></td><td class="day calendar-day-2017-04-15 calendar-dow-6"><div class="day-contents">15</div></td></tr><tr><td class="day calendar-day-2017-04-16 calendar-dow-0"><div class="day-contents">16</div></td><td class="day calendar-day-2017-04-17 calendar-dow-1"><div class="day-contents">17</div></td><td class="day calendar-day-2017-04-18 calendar-dow-2"><div class="day-contents">18</div></td><td class="day calendar-day-2017-04-19 calendar-dow-3"><div class="day-contents">19</div></td><td class="day calendar-day-2017-04-20 calendar-dow-4"><div class="day-contents">20</div></td><td class="day event calendar-day-2017-04-21 calendar-dow-5"><div class="day-contents">21</div></td><td class="day event calendar-day-2017-04-22 calendar-dow-6"><div class="day-contents">22</div></td></tr><tr><td class="day event calendar-day-2017-04-23 calendar-dow-0"><div class="day-contents">23</div></td><td class="day calendar-day-2017-04-24 calendar-dow-1"><div class="day-contents">24</div></td><td class="day calendar-day-2017-04-25 calendar-dow-2"><div class="day-contents">25</div></td><td class="day calendar-day-2017-04-26 calendar-dow-3"><div class="day-contents">26</div></td><td class="day calendar-day-2017-04-27 calendar-dow-4"><div class="day-contents">27</div></td><td class="day calendar-day-2017-04-28 calendar-dow-5"><div class="day-contents">28</div></td><td class="day calendar-day-2017-04-29 calendar-dow-6"><div class="day-contents">29</div></td></tr><tr><td class="day calendar-day-2017-04-30 calendar-dow-0"><div class="day-contents">30</div></td><td class="day adjacent-month next-month calendar-day-2017-05-01 calendar-dow-1"><div class="day-contents">1</div></td><td class="day adjacent-month next-month calendar-day-2017-05-02 calendar-dow-2"><div class="day-contents">2</div></td><td class="day adjacent-month next-month calendar-day-2017-05-03 calendar-dow-3"><div class="day-contents">3</div></td><td class="day adjacent-month next-month calendar-day-2017-05-04 calendar-dow-4"><div class="day-contents">4</div></td><td class="day adjacent-month next-month calendar-day-2017-05-05 calendar-dow-5"><div class="day-contents">5</div></td><td class="day adjacent-month next-month calendar-day-2017-05-06 calendar-dow-6"><div class="day-contents">6</div></td></tr></tbody></table></div></div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4">
                <div class="panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Weather</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>
                    <div class="panel-body widget-weather">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <h3 class="text-center title">Today</h3>
                                <div class="text-center">
                                    <canvas id="clear-day" width="75" height="75"></canvas>
                                    <div class="temp">62°C</div>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <h3 class="text-center title">Tonight</h3>
                                <div class="text-center">
                                    <canvas id="partly-cloudy-night" width="75" height="75"></canvas>
                                    <div class="temp">44°C</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">Mon</h6>
                                <div class="text-center">
                                    <canvas id="partly-cloudy-day" width="32" height="32"></canvas>
                                    <span>48°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">Tue</h6>
                                <div class="text-center">
                                    <canvas id="rain" width="32" height="32"></canvas>
                                    <span>39°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">Wed</h6>
                                <div class="text-center">
                                    <canvas id="sleet" width="32" height="32"></canvas>
                                    <span>32°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">Thu</h6>
                                <div class="text-center">
                                    <canvas id="snow" width="32" height="32"></canvas>
                                    <span>28°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">Fri</h6>
                                <div class="text-center">
                                    <canvas id="wind" width="32" height="32"></canvas>
                                    <span>40°C</span>
                                </div>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-2">
                                <h6 class="text-center small-thin uppercase">Sat</h6>
                                <div class="text-center">
                                    <canvas id="fog" width="32" height="32"></canvas>
                                    <span>42°C</span>
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


<jsp:include page="footer.jsp" />

