<#include "main-template.ftl"/>

<#macro content>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="${rc.getContextPath()}/fonts/icomoon/style.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${rc.getContextPath()}/css/jquery-ui.css">
        <link rel="stylesheet" href="${rc.getContextPath()}/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${rc.getContextPath()}/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="${rc.getContextPath()}/css/owl.theme.default.min.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/css/jquery.fancybox.min.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/css/bootstrap-datepicker.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="${rc.getContextPath()}/css/aos.css">
        <link href="${rc.getContextPath()}/css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="${rc.getContextPath()}/css/style.css">

    </head>

    <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

    <div class="site-wrap">
        <div class="py-2 bg-light">
            <div class="container">
                <div class="row align-items-center">
                </div>
            </div>
        </div>



        <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('./images/bg_1.jpg')">
            <div class="container">
                <div class="row align-items-end">
                    <div class="col-lg-7">
                        <h2 class="mb-0">Conferences</h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing.</p>
                    </div>
                </div>
            </div>
        </div>


        <div class="custom-breadcrumns border-bottom">
            <div class="container">
                <a href="${rc.getContextPath()}/home">Home</a>
                <span class="mx-3 icon-keyboard_arrow_right"></span>
                <span class="current">Conferences</span>
            </div>
        </div>

        <div class="site-section">
            <div class="container">
                <div class="row">

                    <#list conferencesDtoNotReg as confernceDto>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="course-1-item">
                            <figure class="thumnail">
                                <a href="${rc.getContextPath()}/conference/${confernceDto.name}"><img src="${rc.getContextPath()}/images/course_2.jpg" id="image" alt="Image" class="img-fluid"></a>
                                <div class="price">$99.00</div>
                                <div class="category"><h3>Conference</h3></div>
                            </figure>
                            <div class="course-1-content pb-4">
                                <h2>${confernceDto.name}</h2>
                                <p class="desc mb-4">${confernceDto.description}</p>
                                <p><a href="${rc.getContextPath()}/conference/${confernceDto.name}" class="btn btn-primary rounded-0 px-4">Enroll In This Conference</a></p>
                            </div>
                        </div>
                    </div>
                    </#list>

                    <#list conferencesDtoReg as confernceDto>
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="course-1-item">
                                <figure class="thumnail">
                                    <a href="#"><img src="${rc.getContextPath()}/images/course_2.jpg" id="image" alt="Image" class="img-fluid"></a>
                                    <div class="price">$99.00</div>
                                    <div class="category"><h3>Conference</h3></div>
                                </figure>
                                <div class="course-1-content pb-4">
                                    <h2>${confernceDto.name}</h2>
                                    <p class="desc mb-4">${confernceDto.description}</p>
                                    <p><a href="#" class="btn btn-dark rounded-0 px-4">Are you registered</a></p>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>

        <div class="section-bg style-1" style="background-image: url('./images/hero_1.jpg');">
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

    <script src="${rc.getContextPath()}/js/jquery-3.3.1.min.js"></script>
    <script src="${rc.getContextPath()}/js/jquery-migrate-3.0.1.min.js"></script>
    <script src="${rc.getContextPath()}/js/jquery-ui.js"></script>
    <script src="${rc.getContextPath()}/js/popper.min.js"></script>
    <script src="${rc.getContextPath()}/js/bootstrap.min.js"></script>
    <script src="${rc.getContextPath()}/js/owl.carousel.min.js"></script>
    <script src="${rc.getContextPath()}/js/jquery.stellar.min.js"></script>
    <script src="${rc.getContextPath()}/js/jquery.countdown.min.js"></script>
    <script src="${rc.getContextPath()}/js/bootstrap-datepicker.min.js"></script>
    <script src="${rc.getContextPath()}/js/jquery.easing.1.3.js"></script>
    <script src="${rc.getContextPath()}/js/aos.js"></script>
    <script src="${rc.getContextPath()}/js/jquery.fancybox.min.js"></script>
    <script src="${rc.getContextPath()}/js/jquery.sticky.js"></script>
    <script src="${rc.getContextPath()}/js/jquery.mb.YTPlayer.min.js"></script>




    <script src="${rc.getContextPath()}/js/main.js"></script>

</#macro>

<@main name="Conferences &mdash; Website by BulConferences" nameCSS="developers.css"/>


