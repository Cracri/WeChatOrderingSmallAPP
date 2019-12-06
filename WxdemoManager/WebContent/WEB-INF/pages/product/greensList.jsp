<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
<style type="text/css">
  .layui-table-cell {
       height: auto;
       line-height: 28px;
   }
   
   .img{
   	width:30px;
   	height:30px;
   }
</style>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/jquery-v3.3.1.js"></script>
<body>
<form class="layui-form" action="" method="post" style="margin-top:8px;margin-left:17px;">
	<div class="layui-form-item">
	    <div class="layui-input-inline">
	      <input type="text" name="productName" id="productName" placeholder="搜索菜名或类型" 
	      			autocomplete="off" class="layui-input" value="">
	    </div>
	    <input type="button" id="submit" class="layui-btn layui-btn-normal" value="搜索"/>
  	</div>
</form>

<table class="layui-hide" id="test" lay-filter="test"></table>
 
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
 	<button type="button" class="layui-btn layui-btn-normal" lay-event="addProduct">添加商品</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<!--  序号的模板   -->
<script type="text/html" id="serialTemplet">
  {{d.LAY_TABLE_INDEX+1}}
</script>

<!-- 商品类型的模板 -->
<script type="text/html" id="productTypeTemplet">
{{# if(d.type == 1) { }}
<span>川菜</span>
{{# }else if(d.type == 2){ }}
<span>粤菜</span>
{{# }else if(d.type == 3){ }}
<span>苏菜</span>
{{# }else if(d.type == 4){ }}
<span>鲁菜</span>
{{# }}}
</script>

<!-- 价格模板 -->
<script type="text/html" id="priceTemplet">
	{{ d.productPrice +' 元'}}
</script>

<!-- 状态选择  模板 -->
<script type="text/html" id="isfinishTemplet">
  <input type="checkbox" name="isFinish" value="{{d.id}}" 
		 lay-skin="switch" 	lay-text="上架|下架"  	lay-filter="stateTpl"  {{ d.isFinish == 1 ? 'checked' : '' }}>
</script>
              
<!-- 如果要显示图片 需要配置图片的路径 -->
<script>
layui.use(['table','form'], function(){
  var table = layui.table;
  var form = layui.form;
  
  var tableIns = table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/greens/findGreens.do'
    ,toolbar: '#toolbarDemo'
    ,title: '用户数据表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'id', title:'ID', width:80,style:'display:none'}
      ,{field:'serial', title:'序号', width:60,templet:'#serialTemplet'}
      ,{field:'productName', title:'商品名称', width:120}
      ,{field:'productId', title:'商品Id', width:80}
      ,{field:'productPrice', title:'商品价格', width:140,templet:'#priceTemplet'}
      ,{field:'discount', title:'折扣', width:70}
      ,{field:'productPic', title:'图片',width:70,
    	templet:function(d){
    		return '<div><img class="img" src=../greensImages/'+d.productPic+'></div>'
    	}  
      }
      ,{field:'type', title:'商品类型',width:120,templet:"#productTypeTemplet"}
      ,{field:'isFinish', title:'是否上架',width:110,templet:"#isfinishTemplet"}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]
    ,page: true
    ,done:function(){
    	$("[data-field='id']").css('display','none');			//找到field 为 id  的 隐藏
    }
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'addProduct':
    	  	layer.open({
        	  type: 2, 
        	  title:"新增商品",
        	  area:['800px','450px'],
        	  maxmin:true,
        	  content: '${pageContext.request.contextPath }/greens/returnAddProduct.do' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: [http://sentsin.com', 'no']
        	})
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
    	var id = data.id;
    	var productId = data.productId;
    	var type = data.type;
    	
        var isConfirm = confirm("确定删除吗？");
        if(isConfirm){
    	  $.ajax({
    		  url:'${pageContext.request.contextPath}/greens/delProductByProductId.do',
    		  data:{"productId":productId,"type":type},
    		  type:'post',
    		  dataType:'text',
    		  success:function(data){
    			  if(data == "ok"){
    				  window.parent.location.reload();		//刷新页面
    			  }
    		  }
    	  })
        }
    } else if(obj.event === 'edit'){
    	var id = data.id;
    	layer.open({
      	  type: 2, 
      	  title:"编辑商品",
      	  area:['800px','450px'],
      	  maxmin:true,
      	  content: '${pageContext.request.contextPath }/greens/returnEditProduct.do?id='+id //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: [http://sentsin.com', 'no']
      	 })
    }
  });
  
  
	//添加搜索条件（重新加载页面）
	$("#submit").click(function(){
		//这里以搜索为例
		 tableIns.reload({
		   where: { 	//设定异步数据接口的额外参数，任意设
			  productName:$("#productName").val()
		   }
		   ,page: {
		     curr: 1 //重新从第 1 页开始
		   }
		 });
	 });
	
	
	//监听状态state
  	form.on('switch(stateTpl)', function(data){
	  console.log(data.elem.checked); //开关是否开启，true或者false
	  //console.log(data.checked); //开关是否开启，true或者false
	  console.log(data.value); //开关value值，也可以通过data.elem.value得到
	  
	  updateProductGreens(data.value,data.elem.checked);
	  
	});
	
	
});

function updateProductGreens(id,isFinish){
	$.ajax({
		url:"${pageContext.request.contextPath }/greens/updateProductIsFinish.do",
		data:{"id":id,"flag":isFinish},
		type:"post",
		dataType:"text",
		success:function(data){
			if(data == "ok"){
				alert("yes");
			}
		}
	})
}


</script>

</body>
</html>