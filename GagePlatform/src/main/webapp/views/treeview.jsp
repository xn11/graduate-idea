
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<jsp:include page="header.jsp"></jsp:include>
</head>

<body>
    <section id="main-wrapper" class="theme-default">
        <header id="header">
            <!--logo start-->
            <div class="brand">
                <a href="index.html" class="logo">
                    <i class="icon-layers"></i>
                    <span>NEU</span>BOARD</a>
            </div>
            <!--logo end-->
            <ul class="nav navbar-nav navbar-left">
                <li class="toggle-navigation toggle-left">
                    <button class="sidebar-toggle" id="toggle-left">
                        <i class="fa fa-bars"></i>
                    </button>
                </li>
                <li class="toggle-profile hidden-xs">
                    <button type="button" class="btn btn-default" id="toggle-profile">
                        <i class="icon-user"></i>
                    </button>
                </li>
               <li class="hidden-xs hidden-sm">
                    <input type="text" class="search" placeholder="Search project...">
                    <button type="submit" class="btn btn-sm btn-search"><i class="fa fa-search"></i>
                    </button>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <!--<li class="dropdown profile hidden-xs">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="meta">
                            <span class="avatar">
                                <img src="assets/img/profile.jpg" class="img-circle" alt="">
                            </span>
                        <span class="text">Mike Adams</span>
                        <span class="caret"></span>
                        </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight" role="menu">
                        <li>
                            <span class="arrow top"></span>
                            <h5>
                                <span>80%</span>
                                <small class="text-muted">Profile complete</small>
                            </h5>
                            <div class="progress progress-xs">
                                <div class="progress-bar progress-bar" style="width: 80%">
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-user"></i>
                                </span>My Account</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-envelope"></i>
                                </span>Messages</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-cog"></i>
                                </span>Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-sign-out"></i>
                                </span>Logout</a>
                        </li>
                    </ul>
                </li>-->
                <li class="toggle-fullscreen hidden-xs">
                    <button type="button" class="btn btn-default expand" id="toggle-fullscreen">
                        <i class="fa fa-expand"></i>
                    </button>
                </li>
                <li class="toggle-navigation toggle-right">
                    <button class="sidebar-toggle" id="toggle-right">
                        <i class="fa fa-indent"></i>
                    </button>
                </li>
            </ul>
        </header>
        <!--sidebar left start-->
        <aside class="sidebar sidebar-left">
            <!--<div class="sidebar-profile">
                <div class="avatar">
                    <img class="img-circle profile-image" src="assets/img/profile.jpg" alt="profile">
                    <i class="on border-dark animated bounceIn"></i>
                </div>
                <div class="profile-body dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><h4>Mike Adams <span class="caret"></span></h4></a>
                    <small class="title">Front-end Developer</small>
                    <ul class="dropdown-menu animated fadeInRight" role="menu">
                        <li class="profile-progress">
                            <h5>
                                <span>80%</span>
                                <small>Profile complete</small>
                            </h5>
                            <div class="progress progress-xs">
                                <div class="progress-bar progress-bar-primary" style="width: 80%">
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-user"></i>
                                </span>My Account</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-envelope"></i>
                                </span>Messages</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-cog"></i>
                                </span>Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-sign-out"></i>
                                </span>Logout</a>
                        </li>
                    </ul>
                </div>
            </div>-->
            <nav>
                <h5 class="sidebar-header">Navigation</h5>
                <ul class="nav nav-pills nav-stacked">
                    <li>
                        <a href="index.html" title="Dashboard">
                            <i class="fa  fa-fw fa-tachometer"></i> Dashboard
                        </a>
                    </li>
                    <li class="nav-dropdown">
                        <a href="#" title="UI Elements">
                            <i class="fa  fa-fw fa-cogs"></i> UI Elements
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="ui-buttons.html" title="Buttons">
                                     Buttons
                                </a>
                            </li>
                            <li>
                                <a href="ui-sliders-progress.html" title="Sliders &amp; Progress">
                                     Sliders &amp; Progress
                                </a>
                            </li>
                            <li>
                                <a href="ui-modals-popus.html" title="Modals &amp; Popups">
                                     Modals &amp; Popups
                                </a>
                            </li>
                            <li>
                                <a href="ui-tabs-accordions.html" title="Tabs &amp; Accordions">
                                     Tabs &amp; Accordions
                                </a>
                            </li>

                            <li>
                                <a href="ui-alerts-notifications.html" title="Alerts &amp; Notifications">
                                     Alerts &amp; Notifications
                                </a>
                            </li>
                            <li>
                                <a href="ui-nestable-lists.html" title=" Nestable Lists">
                                     Nestable Lists
                                </a>
                            </li>
                            <li>
                                <a href="ui-panels.html" title="Panels">
                                     Panels
                                </a>
                            </li>
                            <li>
                                <a href="ui-icons.html" title="Icons">
                                     Icons
                                </a>
                            </li>
                            <li>
                                <a href="ui-typography.html" title="Typography">
                                     Typography
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-dropdown">
                        <a href="#" title="Forms">
                            <i class="fa  fa-fw fa-edit"></i> Forms
                        </a>
                        <ul class="nav-sub">
                            <li><a href="forms-components.html" title="Components">Components</a>
                            </li>
                            <li><a href="forms-validation.html" title="Validation">Validation</a>
                            </li>
                            <li><a href="forms-mask.html" title="Mask">Mask</a>
                            </li>
                            <li><a href="forms-wizard.html" title="Wizard">Wizard</a>
                            </li>
                            <li><a href="forms-multiple-file.html" title="Multiple File Upload">Multiple File Upload</a>
                            </li>
                            <li><a href="forms-wysiwyg.html" title="WYSIWYG Editor">WYSIWYG Editor</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-dropdown  open active">
                        <a href="#" title="Tables">
                            <i class="fa  fa-fw fa-th-list"></i> Tables
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="tables-basic-tables.html" title="Basic Tables">
                                     Basic Tables
                                </a>
                            </li>
                            <li class="active">
                                <a href="tables-data-tables.html" title="Data Tables">
                                     Data Tables
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-dropdown">
                        <a href="#" title="Charts">
                            <i class="fa  fa-fw fa-bar-chart-o"></i> Charts
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="charts-chartjs.html" title="Chartjs">
                                    Chartjs
                                </a>
                            </li>
                            <li>
                                <a href="charts-c3.html" title="C3 Charts">
                                     C3 Charts
                                </a>
                            </li>
                            <li>
                                <a href="charts-morris.html" title="Morris.js Charts">
                                     Morris.js Charts
                                </a>
                            </li>
                            <li>
                                <a href="charts-sparkline.html" title="Sparkline Charts">
                                     Sparkline Charts
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-dropdown">
                        <a href="#" title="Mail">
                            <i class="fa fa-fw fa-envelope-o"></i> Mail
                            <span class="label label-primary label-circle pull-right">8</span>
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="mail-inbox.html" title="Mail Inbox">
                                    Inbox
                                </a>
                            </li>
                            <li>
                                <a href="mail-compose.html" title="Mail Compose">
                                     Compose Mail
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-dropdown">
                        <a href="#" title="Maps">
                            <i class="fa  fa-fw fa-map-marker"></i> Maps
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="maps-google.html" title="Google Maps">
                                     Google Maps
                                </a>
                            </li>
                            <li>
                                <a href="maps-vector.html" title="Vector Maps">
                                     Vector Maps
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="Frontend/index.html" title="Frontend">
                            <i class="fa  fa-fw fa-desktop"></i> Front-end Theme
                            <span class="pull-right badge badge-danger">new</span>
                        </a>
                    </li>
                    <li class="nav-dropdown">
                        <a href="#" title="Pages">
                            <i class="fa  fa-fw fa-file-text"></i> Pages
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="pages-blank-page.html" title="Blank Page">
                                     Blank Page
                                </a>
                            </li>

                            <li>
                                <a href="pages-profile.html" title="Profile">
                                     Profile
                                </a>
                            </li>
                            <li>
                                <a href="pages-sign-in.html" title="Sign In">
                                     Sign In
                                </a>
                            </li>
                            <li>
                                <a href="pages-sign-up.html" title="Sign Up">
                                     Sign Up
                                </a>
                            </li>
                            <li>
                                <a href="pages-locked-screen.html" title="Locked Screen">
                                     Locked Screen
                                </a>
                            </li>
                            <li>
                                <a href="pages-404.html" title="404 Page">
                                     404 Page
                                </a>
                            </li>
                            <li>
                                <a href="pages-500.html" title="500 Page">
                                     500 Page
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-dropdown">
                        <a href="#" title="Menu Levels">
                            <i class="fa  fa-fw fa-folder-open"></i> Menu Levels
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="javascript:;" title="Level 2.1">
                                    <i class="fa fa-fw fa-file"></i> Level 1.1
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;" title="Level 2.2">
                                    <i class="fa fa-fw fa-file"></i> Level 1.2
                                </a>
                            </li>
                            <li class="nav-dropdown">
                                <a href="#" title="Level 2.3">
                                    <i class="fa fa-fw fa-folder-open"></i> Level 1.3
                                </a>
                                <ul class="nav-sub">
                                    <li>
                                        <a href="javascript:;" title="Level 3.1">
                                            <i class="fa fa-fw fa-file"></i> Level 2.1
                                        </a>
                                    </li>
                                    <li class="nav-dropdown">
                                        <a href="#" title="Level 3.2">
                                            <i class="fa fa-fw fa-folder-open"></i> Level 2.2
                                        </a>
                                        <ul class="nav-sub">
                                            <li>
                                                <a href="javascript:;" title="Level 4.1">
                                                    <i class="fa fa-fw fa-file"></i> Level 3.1
                                                </a>
                                            </li>
                                            <li class="nav-dropdown">
                                                <a href="#" title="Level 4.2">
                                                    <i class="fa fa-fw fa-folder-open"></i> Level 3.2
                                                </a>
                                                <ul class="nav-sub">
                                                    <li class="nav-dropdown">
                                                        <a href="#" title="Level 5.1">
                                                            <i class="fa fa-fw fa-folder-open"></i> Level 4.1
                                                        </a>
                                                        <ul class="nav-sub">
                                                            <li>
                                                                <a href="javascript:;" title="Level 6.1">
                                                                    <i class="fa fa-fw fa-file"></i> Level 5.1
                                                                </a>
                                                            </li>
                                                            <li>
                                                                <a href="javascript:;" title="Level 6.2">
                                                                    <i class="fa fa-fw fa-file"></i> Level 5.2
                                                                </a>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li>
                                                        <a href="javascript:;" title="Level 5.2">
                                                            <i class="fa fa-fw fa-file"></i> Level 4.2
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="javascript:;" title="Level 5.3">
                                                            <i class="fa fa-fw fa-file"></i> Level 4.3
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>

                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="animations.html" title="CSS Animations">
                            <i class="fa  fa-fw fa-magic"></i> CSS Animations
                        </a>
                    </li>
                </ul>
            </nav>
            <h5 class="sidebar-header">Account Settings</h5>
            <div class="setting-list">
                <div class="row">
                    <div class="col-xs-8">
                        <label for="check1" class="control-label">Share your status</label>
                    </div>
                    <div class="col-xs-4">
                        <input type="checkbox" class="js-switch" checked id="check1" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <label for="check2" class="control-label">Push Notifications</label>
                    </div>
                    <div class="col-xs-4">
                        <input type="checkbox" class="js-switch" id="check2" />
                    </div>
                </div>
            </div>
        </aside>
        <!--sidebar left end-->
        <!--main content start-->
        <section class="main-content-wrapper">
            <div class="pageheader">
                <h1>Data Tables</h1>
                <div class="breadcrumb-wrapper hidden-xs">
                    <span class="label">You are here:</span>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Dashboard</a>
                        </li>
                        <li>Tables</li>
                        <li class="active">Data Tables</li>
                    </ol>
                </div>
            </div>
            <section id="main-content" class="animated fadeInUp">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Data Tables</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">

                                <div id="tree" class="col-lg-10"></div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </section>
        <!--main content end-->
    </section>

    <jsp:include page="footer.jsp"></jsp:include>
    <!--Page Leve JS -->
    <script src="/assets/plugins/treeview/bootstrap-treeview.js"></script>

<script>

        $.ajax({
            url: "http://localhost:8080/test/json",
            method: "post",
            success(data){
                $('#tree').treeview(
                    {
                        data: data,
                        levels: 4,
//                        nodeIcon: "fa-circle-thin",
                        expandIcon: "fa fa-chevron-righ",
                        collapseIcon: "fa fa-chevron-down",
                        showBorder: false,
                        showTags: true
                    });
            },
            error(XMLHttpRequest, textStatus, errorThrown){
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
            }
        });

//    $('#tree').treeview({data: getTree()});

</script>
       
</body>

</html>
