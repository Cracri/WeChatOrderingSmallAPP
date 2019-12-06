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
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/jquery-v3.3.1.js"></script>
<body>

<div class="layui-input-inline">
        <input type="text" name="email" id="refrshTime" autocomplete="off" class="layui-input" placeholder="请输入刷新数据的时间">	
</div>
<button type="button" id="submitTime" class="layui-btn layui-btn-normal">提交</button>

<table class="layui-hide" id="idTest" lay-filter="test" ></table>


 
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="refrsh">获取选中行数据</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="findOrderDetails">查看详情菜单</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
              
<script type="text/html" id="serialTemplet">
  {{d.LAY_TABLE_INDEX+1}}
</script>

<script type="text/html" id="isAcpetTemplet">
	<input  type="checkbox" name="isAcept" value="{{d.id}}" 
		 	lay-skin="switch" 	lay-text="接受|未接受"  	lay-filter="stateTpl"  
			{{ d.isAcept == 1 ? 'checked' : '' }}
	>
</script>

<!-- 价格模板 -->
<script type="text/html" id="priceTemplet">
	{{ d.totalPrice +' 元'}}
</script>
 
<script>


layui.use(['table','form'], function(){
	
  var table = layui.table;
  var form = layui.form;
  
  var tableIns = table.render({
    elem: '#idTest'
    ,url:'${pageContext.request.contextPath }/order/getOrderList.do'
    ,toolbar: '#toolbarDemo'
    ,title: '用户数据表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'id', title:'ID', width:80,style:'display:none'}
      ,{field:'serial', title:'序号', width:60,templet:'#serialTemplet'}
      ,{field:'orderNumber', title:'订单号', width:100}
      ,{field:'orderState', title:'状态', width:100}
      ,{field:'totalCount', title:'订单总数', width:100}
      ,{field:'totalPrice', title:'订单总价',width:100,templet:'#priceTemplet'}
      ,{field:'orderDeskNumber', title:'桌号', width:80}
      ,{field:'address', title:'地址',width:200}
      ,{field:'remark', title:'备注',width:200}
      ,{field:'isAcept', title:'是否接受', width:120,templet:'#isAcpetTemplet'}
      ,{field:'orderConsignee', title:'订单人',width:70}
      ,{fixed: 'right', title:'操作', toolbar:'#barDemo', width:150}
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
      case 'refrsh':
    	  console.log("!");
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'findOrderDetails'){
    	//获取到该订单的id
    	OrderId = data.id;
    	console.log(data)
    	console.log(OrderId)
    	
    	layer.open({
      	  type: 2, 
      	  title:data.id+"单详情菜品",
      	  area:['580px','320px'],
      	  maxmin:true,
      	  content:'${pageContext.request.contextPath }/order/returnGetOrderDetails.do?OrderId='+OrderId,
      	})
    }
  });
  
  
	  //监听是否接受订单
	  form.on('switch(stateTpl)', function(data){
		  console.log(data.elem.checked); //开关是否开启，true或者false
		  //console.log(data.checked); //开关是否开启，true或者false
		  console.log(data.value); //开关value值，也可以通过data.elem.value得到
		  
		  updateOrderIsAccpet(data.value,data.elem.checked);
		  
	  });
	  
	  
	  
	  
	  var refrshTime = 30000;
	  
	  //控制刷新数据的时间
	  $("#submitTime").click(function(){
		  
		  //先判断，输入的时间是否合法（必须为分钟的证书）
		  var NewrefrshTime =  $("#refrshTime").val();
		  
		  if(parseInt(NewrefrshTime) % 15000 != 0 || parseInt(NewrefrshTime) % 30000 != 0){
			  console.log(parseInt(NewrefrshTime));
			  alert("您必须输入15秒或者30秒的倍数");
			  return false;
		  }
		  
		  if(NewrefrshTime === ""){
			  
		  }else{
			  refrshTime  = NewrefrshTime;
		  }
		  console.log(refrshTime);
	  })
	  
	  //刷新订单数据(语音提示:新增的订单信息)
	  window.reloadView = function () {
          window.location.reload();
      }
	
      
      
	  
  
});

	function updateOrderIsAccpet(id,flag){
		$.ajax({
			url:'${pageContext.request.contextPath }/order/updateOrderIsAccpet.do',
			data:{"id":id,"flag":flag}, 
			type:'post',
			dataType:'text',
			success:function(data){
				alert()
			}
		})
	}
	
	
	
	

</script>

</body>
</html>