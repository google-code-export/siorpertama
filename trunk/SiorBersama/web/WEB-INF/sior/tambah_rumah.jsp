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
	left:455px;
	top:438px;
	width:641px;
	height:351px;
	z-index:101;
}
#apDiv2 {	position:absolute;
	left:454px;
	top:799px;
	width:683px;
	height:79px;
	z-index:102;
	text-align: left;
}
#apDiv3 {
	position:absolute;
	left:426px;
	top:128px;
	width:516px;
	height:177px;
	z-index:102;
}
</style>
</head>
<body>

<div id="apDiv1">
  <table width="401" border="0">
    <tr>
      <td width="123">Kode Rumah </td>
      <td width="10">:</td>
      <td width="711"><input name="kode_rumah" type="text" size="30" /></td>
    </tr>
  </table>
  <p>Lengkapi data berikut : </p>
  <table width="507" border="0">
    <tr>
      <td width="120">Alamat rumah </td>
      <td width="7">:</td>
      <td width="358"><textarea name="alamat_area" cols="50" rows="4"></textarea></td>
    </tr>
    <tr>
      <td>RT Rumah</td>
      <td>:</td>
      <td><input name="rt_rumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>RW Rumah</td>
      <td>:</td>
      <td><input name="rw_rumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>Kelurahan Rumah</td>
      <td>:</td>
      <td><input name="kelurahan_rumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>Kecamatan Rumah</td>
      <td>:</td>
      <td><input name="kecamatan_rumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>Kota Rumah </td>
      <td>:</td>
      <td><input name="kota_rumah" type="text" size="30" /></td>
    </tr>
    <tr>
      <td>Provinsi Rumah </td>
      <td>:</td>
      <td><input name="provinsi_rumah" type="text" size="30" /></td>
    </tr>
  </table>
  <p></p>
</div>
<div id="templatemo_container">

	<div id="templatemo_header">
	  <div id="templatemo_login">
       	  <form method="get" action="#"><input class="inputfield" name="keyword" type="text" id="keyword"/>
                <input class="button" type="submit" name="Search" value="Cari" />
          </form>
      </div>
  </div>

<div id="templatemo_banner">
  <div></div>
</div>
  <div id="example">
    <div id="apDiv3"><img src="banner sior copy.png" alt="" width="549" height="180" /></div>
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
      <div id="apDiv2">
        <p><span style="margin: 10px;">
          <input name="Submit5" type="submit" value="&lt;&lt;" formmethod="post" formaction="keluarga/2" />
          <input name="Submit6" type="submit" value="&gt;&gt;" formmethod="post" formaction="keluarga" />
          </span>
          <input type="submit" name="Submit2" value="Simpan" />
          <a href="javascript:document.form_tambah_keluarga.reset()">
            <input type="button" name="button" value="Reset" />
          </a>
          <input type="button" name="Button" value="  Batal  " />
        </p>
      </div>
      <div id="templatemo_left_column">
        <h2>User</h2>
	          <div class="left_col_box">
	            <form method="get" action="#">
	              <p>Hi, User</p>
	              <p>
	                <!-- #BeginDate format:fcAm1a -->Wednesday, January 4, 2012 10:19 PM<!-- #EndDate -->
                  </p>
	              <p>
	                <input class="button" type="submit" name="Submit" value="Logoff" />
                  </p>
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
      <h3>Hunian &gt;&gt; Rumah &gt;&gt; Tambah Rumah</h3>
<p>&nbsp;</p>
    </div>
	      <!--  Designed by w w w . t e m p l a t e m o . c o m  -->
	      <div id="templatemo_footer">	        Copyright © 2012<strong> SIOR(Sistem Administrasi Online RT/RW)</strong>| <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">CSS Templates</a> </div>
</div>
</div>
</div>
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>