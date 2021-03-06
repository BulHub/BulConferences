<#include "main-template.ftl"/>

<#macro content>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${rc.getContextPath()}/static/fonts/icomoon/style.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/jquery-ui.css">
        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/owl.theme.default.min.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/jquery.fancybox.min.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/bootstrap-datepicker.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/static/fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/aos.css">
        <link href="${rc.getContextPath()}/static/css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="${rc.getContextPath()}/static/css/style.css">



    </head>

    <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

    <div class="site-wrap">

        <div class="site-mobile-menu site-navbar-target">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close mt-3">
                    <span class="icon-close2 js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div>


        <div class="py-2 bg-light">
        </div>

        <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('..//templates/images/bg_1.jpg')">
            <div class="container">
                <div class="row align-items-end">
                    <div class="col-lg-7">
                        <h2 class="mb-0">Java Junior Developer</h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing.</p>
                    </div>
                </div>
            </div>
        </div>


        <div class="custom-breadcrumns border-bottom">
            <div class="container">
                <a href="${rc.getContextPath()}/home">Home</a>
                <span class="mx-3 icon-keyboard_arrow_right"></span>
                <a href="${rc.getContextPath()}/courses">Courses</a>
                <span class="mx-3 icon-keyboard_arrow_right"></span>
                <span class="current">Course</span>
            </div>
        </div>

        <div class="site-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 mb-4">
                        <p>
                            <img src="${rc.getContextPath()}/static/images/course_5.jpg" alt="Image" class="img-fluid">
                        </p>
                    </div>
                    <div class="col-lg-5 ml-auto align-self-center">
                        <h2 class="section-title-underline mb-5">
                            <span>Course Details</span>
                        </h2>

                        <p><strong class="text-black d-block">Teacher:</strong> Craig Daniel</p>
                        <p class="mb-5"><strong class="text-black d-block">Hours:</strong> 8:00 am &mdash; 9:30am</p>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. At itaque dolore libero corrupti! Itaque, delectus?</p>
                        <p>Modi sit dolor repellat esse! Sed necessitatibus itaque libero odit placeat nesciunt, voluptatum totam facere.</p>

                        <ul>
                            <li>Lorem ipsum dolor sit amet consectetur</li>
                            <li>consectetur adipisicing  </li>
                            <li>Sit dolor repellat esse</li>
                            <li>Necessitatibus</li>
                            <li>Sed necessitatibus itaque </li>
                        </ul>

                        <form name="form" method="post">
                        <p>

                            <button type="submit" onclick="return f()" class="btn btn-primary rounded-0 btn-lg px-5">${something}</button>
                        </p>
                        </form>
                        <p>
                            <a href="#" class="btn btn-primary rounded-0 btn-lg px-5">Show all registered users</a>
                        </p>

                    </div>
                </div>
            </div>
        </div>
        <script>
            function f() {
                let form = document.getElementById("form");
                form.submit();
            }
        </script>

        <div class="section-bg style-1" style="background-image: url('.//templates/images/hero_1.jpg');">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                        <h3>Our Philosphy</h3>
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea? Dolore, amet reprehenderit.</p>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                        <h3>Academics Principle</h3>
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea?
                            Dolore, amet reprehenderit.</p>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                        <h3>Key of Success</h3>
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea?
                            Dolore, amet reprehenderit.</p>
                    </div>
                </div>
            </div>
        </div>



    </div>


    <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#51be78"/></svg></div>

    <script src="${rc.getContextPath()}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/jquery-migrate-3.0.1.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/jquery-ui.js"></script>
    <script src="${rc.getContextPath()}/static/js/popper.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/bootstrap.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/owl.carousel.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/jquery.stellar.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/jquery.countdown.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/bootstrap-datepicker.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/jquery.easing.1.3.js"></script>
    <script src="${rc.getContextPath()}/static/js/aos.js"></script>
    <script src="${rc.getContextPath()}/static/js/jquery.fancybox.min.js"></script>
    <script src="${rc.getContextPath()}/static/js/jquery.sticky.js"></script>
    <script src="${rc.getContextPath()}/static/js/jquery.mb.YTPlayer.min.js"></script>

    <script src="${rc.getContextPath()}/static/js/main.js"></script>
</#macro>

<@main name="Academics &mdash; Website by BulSchool" nameCSS="developers.css"/>