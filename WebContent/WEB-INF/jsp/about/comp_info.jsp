<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>公司介绍</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
<%@include file="/header/bpm-workspace.jsp"%>
	<div class="row-fluid">
<%@include file="/menu/bpm-workspace.jsp"%>
		<!-- start of main -->
		<section id="m-main" class="span10" style="float:right">
		<div class="row-fluid">
			<div class="page-header">
				<h3>公司详情</h3>
			</div>
			<div class="well span10">
				<h4>公司名称：</h4>
				<p>浙江韩通汽车有限公司</p>
				<h4>公司介绍：</h4>
				 <p>浙江韩通汽车有限公司隶属于世界500强企业－浙江物产集团公司，浙江物产集团是浙江省国资委直接监管的15家省属国有企业之一，经营范围涉及国内外贸易、实业加工、现代物流、金融投资4大领域，并已形成了钢铁、汽车、能源、化工销售与物流、地产、金融等6大业务板块。截止2010年底，物产集团拥有各类全资、控股成员企业300余家，员工1.7万余人，资产总额456亿元。<br />
<br />
浙江韩通汽车有限公司成立于2002年12月，注册资本1000万元人民币，主要经营北京现代品牌汽车。提供包括整车销售、配件供应、维修服务及信息反馈为一体的4S服务。目前，韩通汽车已建立一流、完善的4S汽车服务平台，形成了汽车销售、维修、配件、二手车、装璜、保险、俱乐部服务为一体的现代化企业。<br />
<br />
位于杭州市艮山东路196号的浙江韩通，占地近13000多平米，建筑面积达3400多平方米，拥有540平方米的汽车展示厅和3000多平米的现代化汽车维修车间，具有达到现代汽车维修标准的先进维修设备，并拥有一批优秀的工程师及中级以上专业技术人员,可提供优良的售前、售中、售后服务。<br />
<br />
作为北京现代汽车在浙江省的首批标准4S店，浙江韩通在北京现代全国的销售业绩年年领先，截止2011年6月，浙江韩通累计销售北京现代汽车超40000台，销售额近50亿元。在杭州市场，浙江韩通占有了本区域近50%的销售市场份额，成为北京现代全国超过400家特约店中最为优秀的特约店之一。2010年，浙江韩通勇夺北京现代全国销售冠军！<br />
<br />
同样，伴随着销售业绩的遥遥领先，浙江韩通以“真心伴全程”为理念的售后服务也在不断崛起。作为一类汽车维修企业，曾在杭州市汽车维修技能大赛中勇夺团体第一名，并且包缆现代系列车型个人前四名，强大的技术力量保证了维修质量，也是杭州市汽车维修行业联合会“两街一路”特色服务店之一、中国人民财产保险股份有限公司事故车辆推荐修理厂、中国平安保险直赔中心。浙江韩通主办的“现代家园”汽车俱乐部曾被评为“杭州市年度最佳汽车俱乐部”称号。<br />
<br />
浙江韩通正以它独特的服务，创造一个富有活力的上升品牌，并且连续获得全区域，全国的行业性最佳荣誉，连续被北京现代厂家授予“北京现代全国最佳特约店”称号。</p>
				<h4>联系方式：</h4>
				<p>地址：浙江省杭州市江干区艮山东路196号</p>
				<p>咨询电话：0571-86015999</p>
				<h4>公司地图：</h4>
				<p><!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="百度地图,百度地图API，百度地图自定义工具，百度地图所见即所得工具" />
    <meta name="description" content="百度地图API自定义地图，帮助用户在可视化操作下生成百度地图" />
    <title>百度地图API自定义地图</title>
    <!--引用百度地图API-->
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xISi7B3dPAec57SE9gBmNkCi"></script>
  </head>
  
  <body>
    <!--百度地图容器-->
    <div style="width:500px;height:350px;border:#ccc solid 1px;font-size:12px" id="map"></div>
  </body>
  <script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
      createMap();//创建地图
      setMapEvent();//设置地图事件
      addMapControl();//向地图添加控件
      addMapOverlay();//向地图添加覆盖物
    }
    function createMap(){ 
      map = new BMap.Map("map"); 
      map.centerAndZoom(new BMap.Point(120.248551,30.295407),19);
    }
    function setMapEvent(){
      map.enableScrollWheelZoom();
      map.enableKeyboard();
      map.enableDragging();
      map.enableDoubleClickZoom()
    }
    function addClickHandler(target,window){
      target.addEventListener("click",function(){
        target.openInfoWindow(window);
      });
    }
    function addMapOverlay(){
      var markers = [
        {content:"",title:"在这里",imageOffset: {width:-46,height:-21},position:{lat:30.295594,lng:120.248322}}
      ];
      for(var index = 0; index < markers.length; index++ ){
        var point = new BMap.Point(markers[index].position.lng,markers[index].position.lat);
        var marker = new BMap.Marker(point,{icon:new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png",new BMap.Size(20,25),{
          imageOffset: new BMap.Size(markers[index].imageOffset.width,markers[index].imageOffset.height)
        })});
        var label = new BMap.Label(markers[index].title,{offset: new BMap.Size(25,5)});
        var opts = {
          width: 200,
          title: markers[index].title,
          enableMessage: false
        };
        var infoWindow = new BMap.InfoWindow(markers[index].content,opts);
        marker.setLabel(label);
        addClickHandler(marker,infoWindow);
        map.addOverlay(marker);
      };
    }
    //向地图添加控件
    function addMapControl(){
      var scaleControl = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
      scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
      map.addControl(scaleControl);
      var navControl = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
      map.addControl(navControl);
      var overviewControl = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:true});
      map.addControl(overviewControl);
    }
    var map;
      initMap();
  </script>
</html></p>
		
		<h4>销售代表：</h4>
			<div>
				<div>
				<ul>
				<li style="float: left;padding-left: 0px;list-style-type:none;">
					<img width="60" height="74" src="http://icon.xgo-img.com.cn/dealer/201207/front/noavatar.png" alt="朱佳铭">
					<p>朱佳铭</p>
					<p>销售顾问</p>
					<p>13656717269</p>
				</li>
				<li style="float: left;padding-left: 50px;list-style-type:none;">
					<img width="60" height="74" src="http://icon.xgo-img.com.cn/dealer/201207/front/noavatar.png" alt="傅爱玲">
					<p>傅爱玲</p>
					<p>销售顾问</p>
					<p>13567116705</p>
				</li>
				<li style="float: left;padding-left: 50px;list-style-type:none;">
					<img width="60" height="74" src="http://icon.xgo-img.com.cn/dealer/201207/front/noavatar.png" alt="汪光辉">
					<p>汪光辉</p>
					<p>销售顾问</p>
					<p>15990179521</p>
				</li>
				<li style="float: left;padding-left: 50px;list-style-type:none;">
					<img width="60" height="74" src="http://icon.xgo-img.com.cn/dealer/201207/front/noavatar.png" alt="干灵倩">
					<p>干灵倩</p>
					<p>销售顾问</p>
					<p>15924121324</p>
				</li>
				</ul>
				</div>
             </div> 

			</div>

		</div>
		</section>
	</div>
</body>
</html>