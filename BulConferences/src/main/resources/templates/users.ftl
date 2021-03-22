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
         style="background-image: url('/images/bg_1.jpg')">
        <div class="container">
            <div class="row align-items-end">
                <div class="col-lg-7">
                    <h2 class="mb-0">Users</h2>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing.</p>
                </div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Conference</th>
                </tr>
                </thead>
                <tbody>
                <#list userDtos as userDto>
                    <tr>
                        <td>${userDto.id}</td>
                        <td>${userDto.nickname}</td>
                        <td>${userDto.email}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>

    <form id="form4" autocomplete="off" method="post" action="/admin/users">
        <div class="site-section">
            <div class="container">
                <h3>Promoted to Presenter:</h3>
                <p></p>
                <p></p>
                <p></p>
                <div class="row">
                    <div class="col-md-6 form-group">
                        <label for="email">Emails</label>
                        <select id="email" name="email" class="form-control form-control-lg">
                            <#list userDtos as userDto>
                                <option value="${userDto.email}">${userDto.email}</option>
                            <#else>
                                <p>No users found to display</p>
                            </#list>
                        </select>
                    </div>
                    <div class="col-md-6 form-group">
                        <label for="role">Role</label>
                        <input type="role" id="role" name="role"
                               class="form-control form-control-lg" readonly="readonly" value="Presenter">
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <input type="submit" onclick="return validateForm4()" value="Enter"
                               class="btn btn-primary btn-lg px-5">
                    </div>
                </div>
            </div>
        </div>
    </form>

    <form id="form5" autocomplete="off" method="post" action="/admin/delete">
        <div class="site-section">
            <div class="container">
                <h3>Delete: </h3>
                <p></p>
                <p></p>
                <p></p>
                <div class="row">
                    <div class="col-md-6 form-group">
                        <label for="email">Emails</label>
                        <select id="email" name="email" class="form-control form-control-lg">
                            <#list userDtos as userDto>
                                <option value="${userDto.email}">${userDto.email}</option>
                            <#else>
                                <p>No users found to display</p>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <input type="submit" value="Delete"
                               class="btn btn-primary btn-lg px-5">
                    </div>
                </div>
            </div>
        </div>
    </form>


    <script>
        function validateForm4() {
            let role = document.getElementById('role');
            let error = '';
            if(role.value !== "Presenter"){
                error+='Are you the smartest or what?';
            }
            if (error !== '') {
                swal("Oops", error, "error");
                return false;
            } else {
                let form = document.getElementById("form4");
                form.submit();
            }
        }
    </script>

    <div class="section-bg style-1" style="background-image: url('/images/hero_1.jpg');">
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

<@main name="Users &mdash; Website by BulConferences" nameCSS="developers.css"/>
