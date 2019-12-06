<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.layui-form{
		margin-left: 50px;
		margin-top:30px;
	}
	#btn{
		text-align: center;
	}
</style>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/jquery-v3.3.1.js"></script>
<body>

<form class="layui-form layui-form-pane">
		<div class="layui-form-item">
			<div class="layui-inline">
	    	<label class="layui-form-label">菜品名称</label>
		    <div class="layui-input-inline">
		      	<input type="text" name="productName" id="productName" autocomplete="off" class="layui-input">
		    </div>
	    	</div>
  		</div>
  		
  		<div class="layui-form-item">
    		<label class="layui-form-label">菜品序号</label>
	    	<div class="layui-input-inline">
	      		<input type="text" name="productId" id="productId" autocomplete="off" class="layui-input">
	    		<div id="result" style="font-size:14px;"></div>
	    	</div>
  		</div>
  		
  		<div class="layui-form-item">
    	<label class="layui-form-label">菜品价格</label>
	    	<div class="layui-input-inline">
	      		<input type="text" name="productPrice" id="productPrice" autocomplete="off" class="layui-input">
	    	</div>
  		</div>
  		
  		<div class="layui-form-item">
    	<label class="layui-form-label">菜品折扣</label>
	    	<div class="layui-input-inline">
	      		<input type="text" name="discount" id="discount"  autocomplete="off" class="layui-input">
	    	</div>
  		</div>
  		
	  	<div class="layui-inline">
	      <label class="layui-form-label">菜品类型</label>
	      <div class="layui-input-inline">
	        <select name="type" id="type">
	          <option value="">请选择类型</option>
	          <option value="1">川菜</option>
	          <option value="2">粤菜</option>
	          <option value="3">苏菜</option>
	          <option value="4">鲁菜</option>
	        </select>
	      </div>
	    </div>
	    
	    <div class="layui-upload" style="margin-top:20px;">
		  <button type="button" class="layui-btn" id="image">上传图片</button>
		  <div class="layui-upload-list">
		    <img class="layui-upload-img" width="200" height="200" id="demo1">
		    <p id="demoText"></p>
		    <!-- 图片上传f -->
    		<input type="hidden" name="productPic" id="productPic" value=""  />
		  </div>
		</div>  
		
		<div class="layui-form-item" >
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit="" lay-filter="demo1" style="margin-left:200px;">立即提交</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
</form>


<script type="text/javascript">
layui.use(['form', 'layedit', 'laydate','upload'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  
	  var upload = layui.upload;
	  
	  
	  //当输入菜品序号后.判断该序号是否可用
	  $('#productId').bind('input propertychange', function() {
		 if($('#productId').val() == ""){
			 $("#result").text("");
		 }else{
			 var productId = $('#productId').val();
			 
			 $.ajax({
		    	 url:'${pageContext.request.contextPath}/greens/judgeProductIdWithData.do',
		    	 data:{"productId":productId},
		    	 type:'post',
		    	 dataType:'text',
		    	 success:function(data){
		    		 if(data == "yes"){
		    			 $("#result").text("恭喜您,该序号可用").css("color","green");
		    		 }else{
		    			 $("#result").text("对不起,该序号已经存在").css("color","red");
		    		 }
		    	 }
		     })
		 }
	  });
	  
	  
	  
	  //普通图片上传
	  var uploadInst = upload.render({
	    elem: '#image'
	    ,url: '${pageContext.request.contextPath}/upload/toUpload.do'
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	        $('#demo1').attr('src', result); //图片链接（base64）
	      });
	    }
	    ,done: function(res){
	      //如果上传失败
	      if(res.code > 0){
	        return layer.msg('上传失败');
	      }
	      //上传成功
	      $("#productPic").val(res.data);
	    }
	   });
	  
	  
	  
	  
		//监听提交
	  	form.on('submit(demo1)', function(data){
	  		//判断是否为空 
	  		var productName = $("#productName").val();
	  		var productId = $("#productId").val();
	  		var productPrice = $("#productPrice").val();
	  		var discount = $("#discount").val();
	  		var type = $("#type").find("option:selected").val();
	  		var productPic = $("#productPic").val();
	  		
	  		console.log(productName+"---"+productId+"---"+productPrice+"--"+discount+"---"+type+"---"+productPic)
	  		if(productName == "" || productName == null){
	  			alert("请输入菜品名");
	  			return false;
	  		}else if(productId == "" || productId == null){
	  			alert("请输入菜品序号");
	  			return false;
	  		}else if(productPrice == "" || productPrice == null){
	  			alert("请输入菜品价格");
	  			return false;
	  		}else if(type == "" || type == null){
	  			alert("请选择菜品类型");
	  			return false;
	  		}else if(productPic == "" || productPic == null){
	  			alert("请上传菜品图片");
	  			return false;
	  		}
	  		
			//var isNumber = /^[0-9]+.?[0-9]*/;     正则 判断是否为 数值
			var productPrice = $("#productPrice").val();
			if(isNaN(productPrice)){
				alert("请为价格输入数字");
			}
			
			//判断输入的 菜品序号 是否满足条件
			var result = $("#result").html();
			if(result == "对不起,该序号已经存在"){
				alert("请重新填写菜品序号");
			}
			
			//得到表单信息
	  		var productinfo = data.field;
			//将信息转换为 json 字符串
			var productInfo = JSON.stringify(productinfo);
			
			//提交信息
			$.ajax({
	  	    	  url:"${pageContext.request.contextPath}/greens/saveProductInfo.do",
	  	    	  contentType:"application/json;charset=UTF-8",			//设置发送给 服务器的格式（json）
	  	    	  data:productInfo,
	  	    	  type:"post",
	  	    	  dataType:"text",
	  	    	  success:function(data){
	  	    		  if(data=="ok"){
	  	    			window.parent.location.reload();		//刷新页面
	  	    		  }
	  	    	  }
	  	      })
		  
	    	return false;
	  	});
	
	  
	  
	});
</script>
    

</body>
</html>