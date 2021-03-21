<#include "admin_user.ftl"/>

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
        <link href="${rc.getContextPath()}/css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet"
              type="text/css">

        <link rel="stylesheet" href="${rc.getContextPath()}/css/style.css">


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

        <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
             style="background-image: url('./images/bg_1.jpg')">
            <div class="container">
                <div class="row align-items-end">
                    <div class="col-lg-7">
                        <h2 class="mb-0">Creature </h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing.</p>
                    </div>
                </div>
            </div>
        </div>

        <form id="form3" autocomplete="off" method="post">
            <div class="site-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label for="nickname">Nickname</label>
                            <input type="text" id="nickname" name="nickname" class="form-control form-control-lg">
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="lastName">Email</label>
                            <input type="text" id="email" name="email" class="form-control form-control-lg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label for="email">Password</label>
                            <input type="password" id="password" name="password" class="form-control form-control-lg">
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="email">Role</label>
                            <select id="role1" name="role1" class="form-control form-control-lg">
                                <#list roles as role>
                                    <option value="${role.name}">${role.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <input type="submit" onclick="return validateForm()" value="Send Message"
                                   class="btn btn-primary btn-lg px-5">
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <script>
            function validateForm() {
                let password1 = document.getElementById('password');
                let email = document.getElementById('email');
                let nickname = document.getElementById('nickname');
                let error = '';
                let email_regexp = /[0-9a-zа-я_A-ZА-Я]+@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}/i;
                if (!email_regexp.test(email.value)) {
                    error += 'Email is entered incorrectly! \n';
                }
                if (password1.value.length < 6 || password1.value.length > 30) {
                    error += 'Password must be between 6 and 30 characters! \n';
                }
                if (nickname.value.length < 6 || nickname.value.length > 30) {
                    error += 'Nickname must be between 6 and 30 characters! \n';
                }
                if (error !== '') {
                    swal("Oops", error, "error");
                    return false;
                } else {
                    let form = document.getElementById("form");
                    form.submit();
                }
            }
        </script>

        <div class="section-bg style-1" style="background-image: url('./images/hero_1.jpg');">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                        <h3>Our Philosphy</h3>
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat
                            quis delectus ea? Dolore, amet reprehenderit.</p>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                        <h3>Academics Principle</h3>
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat
                            quis delectus ea?
                            Dolore, amet reprehenderit.</p>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                        <h3>Key of Success</h3>
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat
                            quis delectus ea?
                            Dolore, amet reprehenderit.</p>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <div id="loader" class="show fullscreen">
        <svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                    stroke="#51be78"/>
        </svg>
    </div>

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

<@main name="Creature &mdash; Website by BulConferences" nameCSS="developers.css"/>