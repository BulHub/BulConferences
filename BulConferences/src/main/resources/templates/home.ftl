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

<div class="hero-slide owl-carousel site-blocks-cover">
  <div class="intro-section" style="background-image: url('./images/hero_1.jpg');">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-12 mx-auto text-center" data-aos="fade-up">
          <h1>BulConferences Presents</h1>
        </div>
      </div>
    </div>
  </div>

  <div class="intro-section" style="background-image: url('./images/hero_1.jpg');">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-12 mx-auto text-center" data-aos="fade-up">
          <h1>You can sign up for various conferences</h1>
        </div>
      </div>
    </div>
  </div>

</div>


<div></div>

<div class="site-section">
  <div class="container">
    <div class="row mb-5 justify-content-center text-center">
      <div class="col-lg-4 mb-5">
        <h2 class="section-title-underline mb-5">
          <span>Why Academics Works</span>
        </h2>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">

        <div class="feature-1 border">
          <div class="feature-1-content">
            <h2>Personalize Learning</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit morbi hendrerit elit</p>
            <p><a href="#" class="btn btn-primary px-4 rounded-0">Learn More</a></p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
        <div class="feature-1 border">
          <div class="feature-1-content">
            <h2>Trusted Conferences</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit morbi hendrerit elit</p>
            <p><a href="#" class="btn btn-primary px-4 rounded-0">Learn More</a></p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
        <div class="feature-1 border">
          <div class="feature-1-content">
            <h2>Tools for Students</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit morbi hendrerit elit</p>
            <p><a href="#" class="btn btn-primary px-4 rounded-0">Learn More</a></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<div class="site-section">
  <div class="container">


    <div class="row mb-5 justify-content-center text-center">
      <div class="col-lg-6 mb-5">
        <h2 class="section-title-underline mb-3">
          <span>Popular Conferences</span>
        </h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Officia, id?</p>
      </div>
    </div>

    <div class="row">
      <div class="col-12">
        <div class="owl-slide-3 owl-carousel">
          <div class="course-1-item">
            <figure class="thumnail">
              <a href="${rc.getContextPath()}/course/java"><img src="${rc.getContextPath()}/images/course_1.jpg" alt="Image" class="img-fluid"></a>
              <div class="price">$99.00</div>
              <div class="category"><h3>Java</h3></div>
            </figure>
            <div class="course-1-content pb-4">
              <h2>Java Junior Developer</h2>
              <p class="desc mb-4">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Similique accusantium ipsam.</p>
              <p><a href="${rc.getContextPath()}/course/java" class="btn btn-primary rounded-0 px-4">Enroll In This Course</a></p>
            </div>
          </div>

          <div class="course-1-item">
            <figure class="thumnail">
              <a href="${rc.getContextPath()}/course/php"><img src="${rc.getContextPath()}/images/course_2.jpg" alt="Image" class="img-fluid"></a>
              <div class="price">$99.00</div>
              <div class="category"><h3>PHP</h3></div>
            </figure>
            <div class="course-1-content pb-4">
              <h2>PHP Junior Developer</h2>
              <p class="desc mb-4">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Similique accusantium ipsam.</p>
              <p><a href="${rc.getContextPath()}/course/php" class="btn btn-primary rounded-0 px-4">Enroll In This Course</a></p>
            </div>
          </div>

          <div class="course-1-item">
            <figure class="thumnail">
              <a href="${rc.getContextPath()}/course/python"><img src="${rc.getContextPath()}/images/course_3.jpg" alt="Image" class="img-fluid"></a>
              <div class="price">$99.00</div>
              <div class="category"><h3>Python</h3></div>
            </figure>
            <div class="course-1-content pb-4">
              <h2>Python Junior Developer</h2>
              <p class="desc mb-4">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Similique accusantium ipsam.</p>
              <p><a href="${rc.getContextPath()}/course/python" class="btn btn-primary rounded-0 px-4">Enroll In This Course</a></p>
            </div>
          </div>

          <div class="course-1-item">
            <figure class="thumnail">
              <a href="${rc.getContextPath()}/course/iOs"><img src="${rc.getContextPath()}/images/course_4.jpg" alt="Image" class="img-fluid"></a>
              <div class="price">$99.00</div>
              <div class="category"><h3>iOS</h3></div>
            </figure>
            <div class="course-1-content pb-4">
              <h2>iOS Junior Developer</h2>
              <p class="desc mb-4">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Similique accusantium ipsam.</p>
              <p><a href="${rc.getContextPath()}/course/iOs" class="btn btn-primary rounded-0 px-4">Enroll In This Course</a></p>
            </div>
          </div>

          <div class="course-1-item">
            <figure class="thumnail">
              <a href="${rc.getContextPath()}/course/net"><img src="${rc.getContextPath()}/images/course_5.jpg" alt="Image" class="img-fluid"></a>
              <div class="price">$99.00</div>
              <div class="category"><h3>.NET</h3></div>
            </figure>
            <div class="course-1-content pb-4">
              <h2>.NET Junior Developer</h2>
              <p class="desc mb-4">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Similique accusantium ipsam.</p>
              <p><a href="${rc.getContextPath()}/course/net" class="btn btn-primary rounded-0 px-4">Enroll In This Course</a></p>
            </div>
          </div>

          <div class="course-1-item">
            <figure class="thumnail">
              <a href="${rc.getContextPath()}/course/database"><img src="${rc.getContextPath()}/images/course_6.jpg" alt="Image" class="img-fluid"></a>
              <div class="price">$99.00</div>
              <div class="category"><h3>Database</h3></div>
            </figure>
            <div class="course-1-content pb-4">
              <h2>Database Junior Developer</h2>
              <p class="desc mb-4">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Similique accusantium ipsam.</p>
              <p><a href="${rc.getContextPath()}/course/database" class="btn btn-primary rounded-0 px-4">Enroll In This Course</a></p>
            </div>
          </div>

        </div>

      </div>
    </div>



  </div>
</div>




<div class="section-bg style-1" style="background-image: url('./images/about_1.jpg');">
  <div class="container">
    <div class="row">
      <div class="col-lg-4">
        <h2 class="section-title-underline style-2">
          <span>About Our University</span>
        </h2>
      </div>
      <div class="col-lg-8">
        <p class="lead">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Rem nesciunt quaerat ad reiciendis perferendis voluptate fugiat sunt fuga error totam.</p>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus assumenda omnis tempora ullam alias amet eveniet voluptas, incidunt quasi aut officiis porro ad, expedita saepe necessitatibus rem debitis architecto dolore? Nam omnis sapiente placeat blanditiis voluptas dignissimos, itaque fugit a laudantium adipisci dolorem enim ipsum cum molestias? Quod quae molestias modi fugiat quisquam. Eligendi recusandae officiis debitis quas beatae aliquam?</p>
        <p><a href="#">Read more</a></p>
      </div>
    </div>
  </div>
</div>

<!-- // 05 - Block -->
<div class="site-section">
  <div class="container">
    <div class="row mb-5">
      <div class="col-lg-4">
        <h2 class="section-title-underline">
          <span>Testimonials</span>
        </h2>
      </div>
    </div>


    <div class="owl-slide owl-carousel">

      <div class="ftco-testimonial-1">
        <div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
          <img src="${rc.getContextPath()}/images/person_1.jpg" alt="Image" class="img-fluid mr-3">
          <div>
            <h3>Allison Holmes</h3>
            <span>Designer</span>
          </div>
        </div>
        <div>
          <p>&ldquo;Lorem ipsum dolor sit, amet consectetur adipisicing elit. Neque, mollitia. Possimus mollitia nobis libero quidem aut tempore dolore iure maiores, perferendis, provident numquam illum nisi amet necessitatibus. A, provident aperiam!&rdquo;</p>
        </div>
      </div>

      <div class="ftco-testimonial-1">
        <div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
          <img src="${rc.getContextPath()}/images/person_2.jpg" alt="Image" class="img-fluid mr-3">
          <div>
            <h3>Allison Holmes</h3>
            <span>Designer</span>
          </div>
        </div>
        <div>
          <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Neque, mollitia. Possimus mollitia nobis libero quidem aut tempore dolore iure maiores, perferendis, provident numquam illum nisi amet necessitatibus. A, provident aperiam!</p>
        </div>
      </div>

      <div class="ftco-testimonial-1">
        <div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
          <img src="${rc.getContextPath()}/images/person_4.jpg" alt="Image" class="img-fluid mr-3">
          <div>
            <h3>Allison Holmes</h3>
            <span>Designer</span>
          </div>
        </div>
        <div>
          <p>&ldquo;Lorem ipsum dolor sit, amet consectetur adipisicing elit. Neque, mollitia. Possimus mollitia nobis libero quidem aut tempore dolore iure maiores, perferendis, provident numquam illum nisi amet necessitatibus. A, provident aperiam!&rdquo;</p>
        </div>
      </div>

      <div class="ftco-testimonial-1">
        <div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
          <img src="${rc.getContextPath()}/images/person_3.jpg" alt="Image" class="img-fluid mr-3">
          <div>
            <h3>Allison Holmes</h3>
            <span>Designer</span>
          </div>
        </div>
        <div>
          <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Neque, mollitia. Possimus mollitia nobis libero quidem aut tempore dolore iure maiores, perferendis, provident numquam illum nisi amet necessitatibus. A, provident aperiam!</p>
        </div>
      </div>

      <div class="ftco-testimonial-1">
        <div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
          <img src="${rc.getContextPath()}/images/person_2.jpg" alt="Image" class="img-fluid mr-3">
          <div>
            <h3>Allison Holmes</h3>
            <span>Designer</span>
          </div>
        </div>
        <div>
          <p>&ldquo;Lorem ipsum dolor sit, amet consectetur adipisicing elit. Neque, mollitia. Possimus mollitia nobis libero quidem aut tempore dolore iure maiores, perferendis, provident numquam illum nisi amet necessitatibus. A, provident aperiam!&rdquo;</p>
        </div>
      </div>

      <div class="ftco-testimonial-1">
        <div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
          <img src="${rc.getContextPath()}/images/person_4.jpg" alt="Image" class="img-fluid mr-3">
          <div>
            <h3>Allison Holmes</h3>
            <span>Designer</span>
          </div>
        </div>
        <div>
          <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Neque, mollitia. Possimus mollitia nobis libero quidem aut tempore dolore iure maiores, perferendis, provident numquam illum nisi amet necessitatibus. A, provident aperiam!</p>
        </div>
      </div>

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

<div class="news-updates">
  <div class="container">

    <div class="row">
      <div class="col-lg-9">
        <div class="section-heading">
          <h2 class="text-black">News &amp; Updates</h2>
          <a href="#">Read All News</a>
        </div>
        <div class="row">
          <div class="col-lg-6">
            <div class="post-entry-big">
              <a href="news-single.html" class="img-link"><img src="${rc.getContextPath()}/images/blog_large_1.jpg" alt="Image" class="img-fluid"></a>
              <div class="post-content">
                <div class="post-meta">
                  <a href="#">June 6, 2019</a>
                  <span class="mx-1">/</span>
                  <a href="#">Admission</a>, <a href="#">Updates</a>
                </div>
                <h3 class="post-heading"><a href="news-single.html">Campus Camping and Learning Session</a></h3>
              </div>
            </div>
          </div>
          <div class="col-lg-6">
            <div class="post-entry-big horizontal d-flex mb-4">
              <a href="news-single.html" class="img-link mr-4"><img src="${rc.getContextPath()}/images/blog_1.jpg" alt="Image" class="img-fluid"></a>
              <div class="post-content">
                <div class="post-meta">
                  <a href="#">June 6, 2019</a>
                  <span class="mx-1">/</span>
                  <a href="#">Admission</a>, <a href="#">Updates</a>
                </div>
                <h3 class="post-heading"><a href="news-single.html">Campus Camping and Learning Session</a></h3>
              </div>
            </div>

            <div class="post-entry-big horizontal d-flex mb-4">
              <a href="news-single.html" class="img-link mr-4"><img src="${rc.getContextPath()}/images/blog_2.jpg" alt="Image" class="img-fluid"></a>
              <div class="post-content">
                <div class="post-meta">
                  <a href="#">June 6, 2019</a>
                  <span class="mx-1">/</span>
                  <a href="#">Admission</a>, <a href="#">Updates</a>
                </div>
                <h3 class="post-heading"><a href="news-single.html">Campus Camping and Learning Session</a></h3>
              </div>
            </div>

            <div class="post-entry-big horizontal d-flex mb-4">
              <a href="news-single.html" class="img-link mr-4"><img src="${rc.getContextPath()}/images/blog_1.jpg" alt="Image" class="img-fluid"></a>
              <div class="post-content">
                <div class="post-meta">
                  <a href="#">June 6, 2019</a>
                  <span class="mx-1">/</span>
                  <a href="#">Admission</a>, <a href="#">Updates</a>
                </div>
                <h3 class="post-heading"><a href="news-single.html">Campus Camping and Learning Session</a></h3>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-3">
        <div class="section-heading">
          <h2 class="text-black">Campus Videos</h2>
          <a href="#">View All Videos</a>
        </div>
        <a href="https://vimeo.com/45830194" class="video-1 mb-4" data-fancybox="" data-ratio="2">
              <span class="play">
                <span class="icon-play"></span>
              </span>
          <img src="${rc.getContextPath()}/images/course_5.jpg" alt="Image" class="img-fluid">
        </a>
        <a href="https://vimeo.com/45830194" class="video-1 mb-4" data-fancybox="" data-ratio="2">
                <span class="play">
                  <span class="icon-play"></span>
                </span>
          <img src="${rc.getContextPath()}/images/course_5.jpg" alt="Image" class="img-fluid">
        </a>
      </div>
    </div>
  </div>
</div>

<div class="site-section ftco-subscribe-1" style="background-image: url('./images/bg_1.jpg')">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-lg-7">
        <h2>Subscribe to us!</h2>
        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,</p>
      </div>
      <div class="col-lg-5">
        <form action="" class="d-flex">
          <input type="text" class="rounded form-control mr-2 py-3" placeholder="Enter your email">
          <button class="btn btn-primary rounded py-3 px-4" type="submit">Send</button>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- loader -->
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

<@main name="Home &mdash; Website by BulConferences" nameCSS="developers.css"/>
