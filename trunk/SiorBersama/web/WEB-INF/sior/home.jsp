<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home of Sior</title>
<meta name="keywords" content="Free CSS Template, Website Templates, Music Websites" />
<meta name="description" content="Free CSS Template for Music Websites" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script src="http://gsgd.co.uk/sandbox/jquery/easing/jquery.easing.1.3.js"></script>
<script src="C:\Users\ntonk\Documents\Unnamed Site 2\coba template sior\js\slides.min.jquery.js"></script>
<script>
		$(function(){
			$('#slides').slides({
				preload: true,
				preloadImage: 'img/loading.gif',
				play: 5000,
				pause: 2500,
				hoverPause: true
			});
		});
	
  	   $(function(){
  		   $("#slides").slides({
				generateNextPrev: true
  			});
		});
</script>

<style type="text/css">
#templatemo_container #example #slides .slides_container div p {
	font-size: 36px;
}
#apDiv1 {
	position:absolute;
	left:475px;
	top:436px;
	width:617px;
	height:229px;
	z-index:101;
}
#apDiv1 p {
	font-size: 36px;
}
#apDiv2 {
	position:absolute;
	left:429px;
	top:128px;
	width:516px;
	height:177px;
	z-index:102;
}
</style>
</head>
<body>

<div id="apDiv1">
  <p>SELAMAT DATANG DI SIOR!!</p>
  <h3>SiOR (Sistem Administrasi Online RT/RW -- Aplikasi Pengelolaan Hunian RT/RW)
    SiOR merupakan salah satu aplikasi ciptaan mahasiswa ITS Surabaya. Aplikasi SiOR ini memiliki fungsi dalam mengelola data-data penting dalam lingkungan RT/RW, khususnya berhubungan dengan warga penghuni RT/RW tertentu. Oleh karena itu, aplikasi ini membantu pengurus RT/RW dalam menata dan menyimpan data hunian, warga yang tinggal di wilayah RT/RW-nya </h3>
</div>
<div id="apDiv2"><img src="banner sior copy.png" width="549" height="180" /></div>
<div id="templatemo_container">

	<div id="templatemo_header">
	  <div id="templatemo_login">
       	  <form method="get" action="#"><input class="inputfield" name="keyword" type="text" id="keyword"/>
                <input class="button" type="submit" name="Search" value="Cari" />
          </form>
        </div>
  </div>

<div id="templatemo_banner"></div>
  <div id="example">
    
	      <div id="templatemo_menu">
	        <ul>
	          <li><a href="index.html" class="current">Halaman Utama</a></li>
	          <li><a href="subpage.html">Menu Keuangan</a></li>
	          <li><a href="subpage.html">Menu Hunian</a></li>
	          <li><a href="subpage.html">Menu Warga</a></li>
	          <li><a href="subpage.html">FAQ's</a></li>
	          <li><a href="subpage.html" class="lastmenu">Keterangan RT / RWt</a></li>
    </ul>
  </div>
	      <div id="templatemo_content">
	        <div id="templatemo_left_column">
	          <h2>Login</h2>
	          <div class="left_col_box">
	             <p>${error}</p>
        <form method="POST" action="administrator?page=login">
            <fieldset>
                <p>Username : <input type="text" name="username" /></p>
                <p>Password : <input type="text" name="password"/></p>
                <p><input type="Submit" value="Log In" /></p>
                <p><input type="Submit" value="Register" /></p>
            </fieldset>
        </form>
              </div>
	          <h2>Data Updated</h2>
	          <div class="left_col_box">
	            <div class="blog_box">
	              <h3><a href="#">Gaji Tukang Sampah periode 1</a></h3>
	              .<br />
	              Posted by <a href="#"><span>Admin</span></a> in <a href="#"><span>Menu Keuangan</span></a><br />
	              14 Januari 2012</div>
	            <div class="blog_box">
	              <h3><a href="#">Pembayaran Iuran </a></h3>
	              .<br />
	              Posted by <a href="#"><span>Admin</span></a> in <a href="#"><span>Menu Keuangan</span></a><br />
	              4 Januari 2012</div>
	            <div class="more_button"><a href="#">View All</a></div>
              </div>
            </div>
           
</div>
	      <!--  Designed by w w w . t e m p l a t e m o . c o m  -->
    <div id="templatemo_footer">	        Copyright © 2012<strong> SIOR(Sistem Administrasi Online RT/RW)</strong>| <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">CSS Templates</a> </div>
</div>
</div>
</div></body>
</html>