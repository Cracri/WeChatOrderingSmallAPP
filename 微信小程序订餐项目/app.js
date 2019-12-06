//app.js

App({
    globalData: {   
        userInfo: null,
        price:0,
        count:0,
        delProduct:[],

        //判断小程序的API，回调，参数，组件等是否在当前版本可用。
        canIUse: wx.canIUse('button.open-type.getUserInfo'),
        isHide: false
    },

    onShow:function(){
        
    },
    onLaunch: function () {
        //调用方法生成订单
        this.getOrderNumber();
    },


   

    getOrderNumber:function(){
      //得到一个订单编号并保存在storagesync
        wx.request({
            url: 'http://localhost:8080/WXdemo/getOrderCode',  //本地服务器地址
            data: {
            },
            method: 'POST',
            header: {
                'content-type': 'application/json' //默认值
            },
            success: function (res) {
                console.log("订单编号:" + res.data);
                var code = wx.getStorageSync(code);
                //将订单编号存入域中
                wx.setStorageSync("code", res.data)
            }
        })
    },

  

  

  
})