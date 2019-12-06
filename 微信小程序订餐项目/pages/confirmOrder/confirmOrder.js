var app = getApp()
Page({
    data: {
        winWidth: 0,
        winHeight: 0,
        currentTab: 0,
    },

    onLoad: function () {
        var that = this;
        // 获取系统信息
        wx.getSystemInfo({
            success: function (res) {
                that.setData({
                    winWidth: res.windowWidth,
                    winHeight: res.windowHeight
                });
            }
        });

        //获取用户的信息，并且存在该页面数据中
        var userInfo = wx.getStorageSync('userInfo');
        that.setData({
            userInfo: userInfo
        })
    },

    onShow:function(){
        var that = this;
        var username = this.data.userInfo.nickName;

        //查询用户已经付的订单
        wx.request({
            url: 'http://localhost:8080/WXdemo/findUserOrder',
            data: { username: username},
            header: { 'content-type': 'application/x-www-form-urlencoded'},
            method: 'post',
            dataType: 'json',
            success:function(res){
                console.log(res)
                //保存已经支付的总订单  和 详情订单
                that.setData({
                    payOrder:res.data,
                })
            }
        })

        //查询未付款的订单
        wx.request({
            url: 'http://localhost:8080/WXdemo/findUserNoPayOrder',
            data: { username: username },
            header: { 'content-type': 'application/x-www-form-urlencoded' },
            method: 'post',
            dataType: 'json',
            success: function (res) {
                //保存已经支付的总订单  和 详情订单
                that.setData({
                    noPayOrder: res.data,
                })
            }
        })
    },

    // 滑动切换tab
    bindChange: function (e) {
        var that = this;
        that.setData({ currentTab: e.detail.current });
    },

    // 点击tab切换
    swichNav: function (e) {
        var that = this;
        if (this.data.currentTab === e.target.dataset.current) {
            return false;
        } else {
            that.setData({
                currentTab: e.target.dataset.current
            })
        }
    },




    //删除支付的订单
    delOrder: function (e) {
        var that = this;
        //得到 购买订单的 下标
        var index = e.target.dataset.index;
        //通过下标得到订单号
        var orderNumber = this.data.payOrder[index].orderNumber;
        
        wx.showModal({
            title: '提示',
            content: '确定删除吗？',
            success:function(res){
                //如果确定
                if(res.confirm){
                    //请求删除订单
                    wx.request({
                        url: 'http://localhost:8080/WXdemo/delPayOrderByOrderNumber',
                        data: { orderNumber: orderNumber },
                        header: { 'content-type': 'application/x-www-form-urlencoded' },
                        method: 'post',
                        dataType: 'text',
                        success: function (res) {
                            if (res.data === "ok") {
                                //刷新数据
                                that.onShow();
                            } else if (res.data === "error") {
                                wx.showToast({
                                    title: '您的订单还未完成，无法删除',
                                })
                                return false;
                            } else {
                                console.log("删除失败");
                            }
                        }
                    })
                }
            }
        })
    },


    //删除未支付的订单
    delNoPayOrder:function(e){
        var that = this;
        //得到未支付订单的 下标
        var index = e.target.dataset.index;
        //通过下标得到订单号
        var orderNumber = this.data.noPayOrder[index].orderNumber;

        wx.showModal({
            title: '提示',
            content: '确定删除吗？',
            success: function (res) {
                //如果确定
                if (res.confirm) {
                    //请求删除订单
                    wx.request({
                        url: 'http://localhost:8080/WXdemo/delNoPayOrderByOrderNumbers',
                        data: { orderNumber: orderNumber },
                        header: { 'content-type': 'application/x-www-form-urlencoded' },
                        method: 'post',
                        dataType: 'text',
                        success: function (res) {
                            if (res.data === "ok") {
                                //刷新数据
                                that.onShow();
                            } else{
                                console.log("删除失败");
                            }
                        }
                    })
                }
            }
        })
    },


    //支付未付款的订单
    payOrder:function(e){

    }
})